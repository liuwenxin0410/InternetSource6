#include "new_max30102.h"
#include "stm32f10x.h"
#include "myiic.h"
#include "MAX30102.h"
#include "algorithm.h"
#include "usart.h"


#define MAX_BRIGHTNESS 255

uint32_t aun_ir_buffer[500]; //IR LED sensor data
int32_t n_ir_buffer_length;    //data length
uint32_t aun_red_buffer[500];    //Red LED sensor data

int32_t n_sp02; //SPO2 value
int8_t ch_spo2_valid;   //indicator to show if the SP02 calculation is valid

int32_t n_heart_rate;   //heart rate value
int8_t  ch_hr_valid;    //indicator to show if the heart rate calculation is valid
uint8_t uch_dummy;


uint32_t un_min, un_max, un_prev_data;  //variables to calculate the on-board LED brightness that reflects the heartbeats
int i;
int32_t n_brightness;
float f_temp;

int reset_max30102()
{
		  IIC_Init();
	  if(maxim_max30102_reset())//��λ MAX30102
        printf("max30102_reset failed!\r\n");
    if(maxim_max30102_read_reg(REG_INTR_STATUS_1,&uch_dummy))//read and clear status register
        printf("read_reg REG_INTR_STATUS_1 failed!\r\n");
    if(maxim_max30102_init())//��ʼ��MAX30102
        printf("max30102_init failed!\r\n");
    n_brightness=0;
    un_min=0x3FFFF;
    un_max=0;
    n_ir_buffer_length=500; //buffer length of 100 stores 5 seconds of samples running at 100sps
    printf("�ɼ�500������\r\n");
    //read the first 500 samples, and determine the signal range
    for(i=0;i<n_ir_buffer_length;i++)
    {
       while(max30102_INTPin==1);   //�ȴ�MAX30102�ж���������
        maxim_max30102_read_fifo((aun_red_buffer+i), (aun_ir_buffer+i));  //read from MAX30102 FIFO         
        if(un_min>aun_red_buffer[i])
            un_min=aun_red_buffer[i];    //update signal min
        if(un_max<aun_red_buffer[i])
            un_max=aun_red_buffer[i];    //update signal max         
        printf("red=");
        printf("%i", aun_red_buffer[i]);
        printf(", ir=");
        printf("%i\r\n", aun_ir_buffer[i]);
    }
    un_prev_data=aun_red_buffer[i];
    //calculate heart rate and SpO2 after first 500 samples (first 5 seconds of samples)
    maxim_heart_rate_and_oxygen_saturation(aun_ir_buffer, 
		n_ir_buffer_length, aun_red_buffer, &n_sp02, &ch_spo2_valid, &n_heart_rate, &ch_hr_valid); 
}

 int got_data(void)
 { 
        i=0;un_min=0x3FFFF;un_max=0;
        for(i=100;i<500;i++)
        {aun_red_buffer[i-100]=aun_red_buffer[i];aun_ir_buffer[i-100]=aun_ir_buffer[i];
         if(un_min>aun_red_buffer[i])un_min=aun_red_buffer[i];
         if(un_max<aun_red_buffer[i])un_max=aun_red_buffer[i];
        }
        for(i=400;i<500;i++)
        {un_prev_data=aun_red_buffer[i-1];
            while(max30102_INTPin==1);   //�ȴ�MAX30102�ж���������
            maxim_max30102_read_fifo((aun_red_buffer+i), (aun_ir_buffer+i));
            if(aun_red_buffer[i]>un_prev_data)//just to determine the brightness of LED according to the deviation of adjacent two AD data
            {f_temp=aun_red_buffer[i]-un_prev_data;f_temp/=(un_max-un_min);
							f_temp*=MAX_BRIGHTNESS;n_brightness-=(int)f_temp;
            if(n_brightness<0) n_brightness=0;
            }
            else{f_temp=un_prev_data-aun_red_buffer[i];f_temp/=(un_max-un_min);
							f_temp*=MAX_BRIGHTNESS;n_brightness+=(int)f_temp;
						if(n_brightness>MAX_BRIGHTNESS)n_brightness=MAX_BRIGHTNESS;}
        }
        maxim_heart_rate_and_oxygen_saturation(aun_ir_buffer, n_ir_buffer_length, 
				aun_red_buffer, &n_sp02, &ch_spo2_valid, &n_heart_rate, &ch_hr_valid); 
}
