#include "led.h"
#include "delay.h"
#include "key.h"
#include "sys.h"
#include "oled.h"
#include "usart.h"
#include "mpu6050.h"
#include "usmart.h"   
#include "inv_mpu.h"
#include "inv_mpu_dmp_motion_driver.h"
#include "LM75.h"
#include "exti.h"
#include "timer.h"
#include "date.h"
#include "hc05.h"
#include "usart3.h"			 	 
#include "string.h"	  
#include "NEW_MAX30102.H"

extern int32_t n_heart_rate;   //heart rate value
extern int32_t n_sp02;   //spo2 value
unsigned char Mode=0;      //ϵͳģʽȫ�ֱ���
unsigned int standby=0;    //�豸���ñ�־λ
u8 second=30;               //ʱ������� 
u8 minute=59;               //ʱ������� 
u8 hour=23;                //ʱ�����ʱ 
u8 day=10;                  //ʱ������� 
u8 month=7;                //ʱ������� 
u16 year=2020;             //ʱ������� 
u16 week=5;									//ʱ��������ڣ����㣩
u16 iweek=5;								//ʱ���������
u8 OLED_c;                 //��������                 

	 //��ʾATK-HC05ģ�������״̬
  void HC05_Role_Show(void)
  {
	  if(HC05_Get_Role()==1)OLED_ShowString(16,0,"Master",16);	//����
	  else OLED_ShowString(16,0,"ROLE:Slave ",16);			 		//�ӻ�
		OLED_Refresh_Gram();
  }


int main(void)
{
   //�������岿��             
   char Steps=0;              //�Ʋ�����
   unsigned long StepsTmp=0;  //��ʱ�Ʋ�����
   int rt;                    //�Ʋ��ɹ��������Ʋ���������ֵ��
   int Distance=0;            //�н��������
	 int Calorie=0;							//���㿨·�����
   u16 temp_value;            //��ʾ�¶�ֵ����
	 int i;					//forѭ��
	 int32_t SPO2;	//����n_sp02
	 int32_t HR;		//����n_heart_rate
//	 u8 t;
//	 u8 role;
//	 u8 sendmask=0;
//	 u8 sendcnt=0;
//	 u8 sendbuf[20];	  
//	 u8 reclen=0;  	
	
	
	
   //������ʼ������ 	
	 delay_init();	    	 //��ʱ������ʼ��	  
   NVIC_PriorityGroupConfig(NVIC_PriorityGroup_2);//�����ж����ȼ�����Ϊ��2��2λ��ռ���ȼ���2λ��Ӧ���ȼ�
	 LED_Init();		  		 //��ʼ����LED���ӵ�Ӳ���ӿ�
	 OLED_Init();			   	 //��ʼ��LCD 	
	 KEY_Init();				   //������ʼ��
   EXTIX_Init();	
	
	 TIM3_Init(9999,7199); //����Ƶ��10KHz������ֵ0-9999��ÿ1S�ж�һ��
	
	 LM75_Init();			 //IIC��ʼ�� 
   uart_init(115200);                                            
   MPU_Init();          
   OLED_Clear();
	
	 //�豸��ⲿ��
   while(mpu_dmp_init())
   { 
      OLED_ShowString(0,0,"mpu err",16);
      OLED_Refresh_Gram();
   }
	
    OLED_Clear();
   	delay_ms(1000);			//�ȴ�����ģ���ϵ��ȶ�
	 reset_max30102();
	 
	 while(HC05_Init()) 		//��ʼ��ATK-HC05ģ��  
	{	
		OLED_ShowString(32,0,"HC05 Err",16); 
		OLED_Refresh_Gram();
		delay_ms(500);
	}	 										   	   
	OLED_ShowString(32,0,"HC05 Rdy",16);
	
  OLED_Refresh_Gram();  
	delay_ms(2000);
	USART3_RX_STA=0;
	HC05_Set_Cmd("AT+ROLE=0");
	HC05_Set_Cmd("AT+NAME=LIU");
	HC05_Set_Cmd("AT+PSWD=5678");
	
	//��ѭ������
	 while(1)
	 {	
		 
		 switch(Mode)
		   {
		     case 0:                                   //�ް������£������棬��ʾʱ��
					 if (OLED_c)
					 {
						 OLED_Clear();
					 	 OLED_c=0;
					 }
           DATE_show();
					 switch(week)
					 {
							case 0: OLED_ShowString(0,44,"Sunday",16); break;
							case 1: OLED_ShowString(0,44,"Monday",16); break;
							case 2: OLED_ShowString(0,44,"Tuesday",16); break;
							case 3: OLED_ShowString(0,44,"Wesday",16); break;
							case 4: OLED_ShowString(0,44,"Thursday",16); break;
							case 5: OLED_ShowString(0,44,"Friday",16); break;
							case 6: OLED_ShowString(0,44,"Saturday",16); break;
					 }
					 //u3_printf(" TIME:%d:%d:%d,%d/%d/%d\r\n",hour,minute,second,year,month,day);		//ʱ�䷢�͵�����ģ��
					 for(i=0;i<1;i++)
					{
						temp_value=LM75_ReadTemp(Temp_Reg);   //�����¶�
						
						HR=n_heart_rate;			//��������
						SPO2=n_sp02;				//����Ѫ��
						got_data();
						
						//dmp_set_pedometer_step_count(Steps);   //��������
						rt=dmp_get_pedometer_step_count(&StepsTmp);       
						if(rt == 0)
						{
							if(StepsTmp!=Steps)
							{
								Steps = StepsTmp; 
								Distance = 0.7 * Steps;
								Calorie = 0.03 * Steps;
							}
								
						}
					  //u3_printf("Steps:  %d    TEMP:  %d.%d��     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
						u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
					  //delay_ms(50);
					}
				   
				 break;				 
				 case 1:                                   //��������1�Σ���ʾ�¶�
					 if (OLED_c)
					 {
						 OLED_Clear();
					 	 OLED_c=0;
					 }
		       OLED_ShowString(0,0,"Temperature",16);
				   OLED_ShowString(0,16,"Mode:",16);
				   OLED_ShowNum(40,16,Mode,1,16);	
			   	 OLED_ShowString(0,32,"Temp:   .  C",16);				 
				   temp_value=LM75_ReadTemp(Temp_Reg);
				   if(temp_value>0)
			     {
             OLED_ShowNum(48,32,temp_value/10,2,16);
				     OLED_ShowNum(72,32,temp_value%10,1,16);
						 //OLED_ShowString(48,48,"ok",16);					 
						 OLED_Refresh_Gram();
			       delay_ms(100);
						 //u3_printf("TEMP:%d.%d C\r\n",temp_value/10,temp_value%10);		//�¶ȷ��͵�����ģ��
						 for(i=0;i<1;i++)
						{
							temp_value=LM75_ReadTemp(Temp_Reg);   //�����¶�
						
							HR=n_heart_rate;			//��������
							SPO2=n_sp02;				//����Ѫ��
							got_data();
						
							//dmp_set_pedometer_step_count(Steps);   //��������
							rt=dmp_get_pedometer_step_count(&StepsTmp);       
							if(rt == 0)
							{
								if(StepsTmp!=Steps)
								{
									Steps = StepsTmp; 
									Distance = 0.7 * Steps;
									Calorie = 0.03 * Steps;
								}
								
							}
							//u3_printf("Steps:  %d    TEMP:  %d.%d��     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
							u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
							//delay_ms(50);
						}
			     }
					 //else{OLED_ShowString(48,48,"!",16);}
					 
				 break;
				 case 2:                                   //��������2�Σ���ʾ����
					 if (OLED_c)
					 {
						 OLED_Clear();
					 	 OLED_c=0;
					 }
           OLED_ShowString(0,0,"Movement",12);
				 	 OLED_ShowString(0,12,"Mode:",12);
				   OLED_ShowNum(40,12,Mode,1,12);	
					 OLED_ShowString(0,24,"Steps: ",12);
					 OLED_ShowString(0,36,"Distance:    m",12);
					 OLED_ShowString(0,48,"Calorie:     cal",12);
				   OLED_Refresh_Gram();
				   dmp_set_pedometer_step_count(Steps);
				   while(Mode==2)
					 {
					    rt=dmp_get_pedometer_step_count(&StepsTmp);       
              if(rt == 0)
              {
                if(StepsTmp!=Steps)
                {
                   Steps = StepsTmp;                           
                   OLED_ShowNum(48,24,Steps,3,12);
									  
									 Distance = 0.7 * Steps;   
                   OLED_ShowNum(56,36,Distance,3,12);
									
									 Calorie = 0.03 * Steps;
									 OLED_ShowNum(56,48,Calorie,3,12);
									
                   OLED_Refresh_Gram();  
									 //u3_printf("Steps:%d\r\n",Steps);		//�������͵�����ģ��
									for(i=0;i<1;i++)
									{
											temp_value=LM75_ReadTemp(Temp_Reg);   //�����¶�
						
											HR=n_heart_rate;			//��������
											SPO2=n_sp02;				//����Ѫ��
											got_data();
						
											//dmp_set_pedometer_step_count(Steps);   //��������
											rt=dmp_get_pedometer_step_count(&StepsTmp);       
											if(rt == 0)
											{
												if(StepsTmp!=Steps)
												{
													Steps = StepsTmp; 
													Distance = 0.7 * Steps;
													Calorie = 0.03 * Steps;
												}
								
											}
										//u3_printf("Steps:  %d    TEMP:  %d.%d��     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
										u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
										//delay_ms(50);
									}
					      }
							}
						}
						
				 break;
				 case 3:                                //��������3�Σ���ʾ����
					 if (OLED_c)
					 {
						 OLED_Clear();
					 	 OLED_c=0;
					 }
					  OLED_ShowString(0,0,"Heart Rate",16);
						OLED_ShowString(0,16,"Mode:",16);
						OLED_ShowNum(40,16,Mode,1,16);	
						OLED_ShowString(0,32,"HR:      BPM",16);
						OLED_ShowNum(40,32,n_heart_rate,3,16);
					  //u3_printf("HR:%d\r\n",n_heart_rate);		//���ʷ��͵�����ģ��
					 for(i=0;i<1;i++)
					{
						temp_value=LM75_ReadTemp(Temp_Reg);   //�����¶�
						
						HR=n_heart_rate;			//��������
						SPO2=n_sp02;				//����Ѫ��
						got_data();
						
						//dmp_set_pedometer_step_count(Steps);   //��������
						rt=dmp_get_pedometer_step_count(&StepsTmp);       
						if(rt == 0)
						{
							if(StepsTmp!=Steps)
							{
								Steps = StepsTmp; 
								Distance = 0.7 * Steps;
								Calorie = 0.03 * Steps;
							}
								
						}
					  //u3_printf("Steps:  %d    TEMP:  %d.%d��     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
						u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
					  //delay_ms(50);
					}
						OLED_Refresh_Gram();
						got_data();
					 break;
					 case 4:                                //��������4�Σ���ʾѪ��
					 if (OLED_c)
					 {
						 OLED_Clear();
					 	 OLED_c=0;
					 }
					  OLED_ShowString(0,0,"Blood Oxygen",16);
						OLED_ShowString(0,16,"Mode:",16);
						OLED_ShowNum(40,16,Mode,1,16);	
						OLED_ShowString(0,32,"SPO2:     %",16);
						OLED_ShowNum(40,32,n_sp02,3,16);
					  //u3_printf("SPO2:%d\r\n",n_sp02);		//Ѫ�����͵�����ģ��
					 for(i=0;i<1;i++)
					{
						temp_value=LM75_ReadTemp(Temp_Reg);   //�����¶�
						
						HR=n_heart_rate;			//��������
						SPO2=n_sp02;				//����Ѫ��
						got_data();
						
						//dmp_set_pedometer_step_count(Steps);   //��������
						rt=dmp_get_pedometer_step_count(&StepsTmp);       
						if(rt == 0)
						{
							if(StepsTmp!=Steps)
							{
								Steps = StepsTmp; 
								Distance = 0.7 * Steps;
								Calorie = 0.03 * Steps;
							}
								
						}
					  //u3_printf("Steps:  %d    TEMP:  %d.%d��     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
						u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
					  //delay_ms(50);
					}
						OLED_Refresh_Gram();
						got_data();
					 break;
         /* case 5:   					 //��������5�Σ�����ģ��
					OLED_Clear();
					OLED_ShowString(0,0,"Bluetooth Send",16);
					OLED_ShowString(0,16,"Mode:",16);
					OLED_ShowNum(40,16,Mode,1,16);	
					
					for(i=0;i<1;i++)
					{
						temp_value=LM75_ReadTemp(Temp_Reg);   //�����¶�
						
						HR=n_heart_rate;			//��������
						SPO2=n_sp02;				//����Ѫ��
						got_data();
						
						//dmp_set_pedometer_step_count(Steps);   //��������
						rt=dmp_get_pedometer_step_count(&StepsTmp);       
						if(rt == 0)
						{
							if(StepsTmp!=Steps)
							{
								Steps = StepsTmp; 
								Distance = 0.7 * Steps;
								Calorie = 0.3 * Steps;
							}
								
						}
					  //u3_printf("Steps:  %d    TEMP:  %d.%d��     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
						u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//�ܷ���
					  delay_ms(50);
					}
				 
					break;
				 */
		     default:                                  //�������ܴ�����
				 break;	 		 
		   }
			 
	 }

 }

 
/*---�ⲿ�ж�4�������----*/
/*����ͨ�����������ı�ģʽ*/
void EXTI4_IRQHandler(void)
{
	standby=0;   //�в������У�������ñ�־λ
	delay_ms(10);//����
	if(KEY==0)	 //����KEY1
	{	
		OLED_c=1;
    LED_Turn();		
		Mode++;
		if(Mode>4)		 
		   Mode=0;		
	}		 
	EXTI_ClearITPendingBit(EXTI_Line4);  //���LINE4�ϵ��жϱ�־λ
 
}


/*---��ʱ��3�������----*/
/*���ڼ��롢����ʱ������*/
void TIM3_IRQHandler(void)   //TIM3�ж�
{
	if (TIM_GetITStatus(TIM3, TIM_IT_Update) != RESET)  //���TIM3�����жϷ������
		{
		  second++;
      DATE_cal();
			standby++;
			if (standby>=10)      //ÿ1S�ж�һ�Σ�standbyֵ�ﵽ10���ʾ10����û�в���
			{
			  standby=0;
//				Mode=0;
				OLED_c=1;
			}
			TIM_ClearITPendingBit(TIM3, TIM_IT_Update);  //���TIMx�����жϱ�־ 

		}
}


