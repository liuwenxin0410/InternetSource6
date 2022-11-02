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
unsigned char Mode=0;      //系统模式全局变量
unsigned int standby=0;    //设备闲置标志位
u8 second=30;               //时间变量秒 
u8 minute=59;               //时间变量分 
u8 hour=23;                //时间变量时 
u8 day=10;                  //时间变量日 
u8 month=7;                //时间变量月 
u16 year=2020;             //时间变量年 
u16 week=5;									//时间变量星期（计算）
u16 iweek=5;								//时间变量星期
u8 OLED_c;                 //清屏变量                 

	 //显示ATK-HC05模块的主从状态
  void HC05_Role_Show(void)
  {
	  if(HC05_Get_Role()==1)OLED_ShowString(16,0,"Master",16);	//主机
	  else OLED_ShowString(16,0,"ROLE:Slave ",16);			 		//从机
		OLED_Refresh_Gram();
  }


int main(void)
{
   //变量定义部分             
   char Steps=0;              //计步变量
   unsigned long StepsTmp=0;  //临时计步变量
   int rt;                    //计步成功变量（计步函数返回值）
   int Distance=0;            //行进距离变量
	 int Calorie=0;							//计算卡路里变量
   u16 temp_value;            //显示温度值变量
	 int i;					//for循环
	 int32_t SPO2;	//传输n_sp02
	 int32_t HR;		//传输n_heart_rate
//	 u8 t;
//	 u8 role;
//	 u8 sendmask=0;
//	 u8 sendcnt=0;
//	 u8 sendbuf[20];	  
//	 u8 reclen=0;  	
	
	
	
   //函数初始化部分 	
	 delay_init();	    	 //延时函数初始化	  
   NVIC_PriorityGroupConfig(NVIC_PriorityGroup_2);//设置中断优先级分组为组2：2位抢占优先级，2位响应优先级
	 LED_Init();		  		 //初始化与LED连接的硬件接口
	 OLED_Init();			   	 //初始化LCD 	
	 KEY_Init();				   //按键初始化
   EXTIX_Init();	
	
	 TIM3_Init(9999,7199); //计数频率10KHz，计数值0-9999，每1S中断一次
	
	 LM75_Init();			 //IIC初始化 
   uart_init(115200);                                            
   MPU_Init();          
   OLED_Clear();
	
	 //设备检测部分
   while(mpu_dmp_init())
   { 
      OLED_ShowString(0,0,"mpu err",16);
      OLED_Refresh_Gram();
   }
	
    OLED_Clear();
   	delay_ms(1000);			//等待蓝牙模块上电稳定
	 reset_max30102();
	 
	 while(HC05_Init()) 		//初始化ATK-HC05模块  
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
	
	//主循环部分
	 while(1)
	 {	
		 
		 switch(Mode)
		   {
		     case 0:                                   //无按键按下，主界面，显示时间
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
					 //u3_printf(" TIME:%d:%d:%d,%d/%d/%d\r\n",hour,minute,second,year,month,day);		//时间发送到蓝牙模块
					 for(i=0;i<1;i++)
					{
						temp_value=LM75_ReadTemp(Temp_Reg);   //测量温度
						
						HR=n_heart_rate;			//测量心率
						SPO2=n_sp02;				//测量血氧
						got_data();
						
						//dmp_set_pedometer_step_count(Steps);   //测量步数
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
					  //u3_printf("Steps:  %d    TEMP:  %d.%d℃     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
						u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
					  //delay_ms(50);
					}
				   
				 break;				 
				 case 1:                                   //按键按下1次，显示温度
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
						 //u3_printf("TEMP:%d.%d C\r\n",temp_value/10,temp_value%10);		//温度发送到蓝牙模块
						 for(i=0;i<1;i++)
						{
							temp_value=LM75_ReadTemp(Temp_Reg);   //测量温度
						
							HR=n_heart_rate;			//测量心率
							SPO2=n_sp02;				//测量血氧
							got_data();
						
							//dmp_set_pedometer_step_count(Steps);   //测量步数
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
							//u3_printf("Steps:  %d    TEMP:  %d.%d℃     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
							u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
							//delay_ms(50);
						}
			     }
					 //else{OLED_ShowString(48,48,"!",16);}
					 
				 break;
				 case 2:                                   //按键按下2次，显示步数
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
									 //u3_printf("Steps:%d\r\n",Steps);		//步数发送到蓝牙模块
									for(i=0;i<1;i++)
									{
											temp_value=LM75_ReadTemp(Temp_Reg);   //测量温度
						
											HR=n_heart_rate;			//测量心率
											SPO2=n_sp02;				//测量血氧
											got_data();
						
											//dmp_set_pedometer_step_count(Steps);   //测量步数
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
										//u3_printf("Steps:  %d    TEMP:  %d.%d℃     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
										u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
										//delay_ms(50);
									}
					      }
							}
						}
						
				 break;
				 case 3:                                //按键按下3次，显示心率
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
					  //u3_printf("HR:%d\r\n",n_heart_rate);		//心率发送到蓝牙模块
					 for(i=0;i<1;i++)
					{
						temp_value=LM75_ReadTemp(Temp_Reg);   //测量温度
						
						HR=n_heart_rate;			//测量心率
						SPO2=n_sp02;				//测量血氧
						got_data();
						
						//dmp_set_pedometer_step_count(Steps);   //测量步数
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
					  //u3_printf("Steps:  %d    TEMP:  %d.%d℃     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
						u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
					  //delay_ms(50);
					}
						OLED_Refresh_Gram();
						got_data();
					 break;
					 case 4:                                //按键按下4次，显示血氧
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
					  //u3_printf("SPO2:%d\r\n",n_sp02);		//血氧发送到蓝牙模块
					 for(i=0;i<1;i++)
					{
						temp_value=LM75_ReadTemp(Temp_Reg);   //测量温度
						
						HR=n_heart_rate;			//测量心率
						SPO2=n_sp02;				//测量血氧
						got_data();
						
						//dmp_set_pedometer_step_count(Steps);   //测量步数
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
					  //u3_printf("Steps:  %d    TEMP:  %d.%d℃     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
						u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
					  //delay_ms(50);
					}
						OLED_Refresh_Gram();
						got_data();
					 break;
         /* case 5:   					 //按键按下5次，蓝牙模块
					OLED_Clear();
					OLED_ShowString(0,0,"Bluetooth Send",16);
					OLED_ShowString(0,16,"Mode:",16);
					OLED_ShowNum(40,16,Mode,1,16);	
					
					for(i=0;i<1;i++)
					{
						temp_value=LM75_ReadTemp(Temp_Reg);   //测量温度
						
						HR=n_heart_rate;			//测量心率
						SPO2=n_sp02;				//测量血氧
						got_data();
						
						//dmp_set_pedometer_step_count(Steps);   //测量步数
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
					  //u3_printf("Steps:  %d    TEMP:  %d.%d℃     HR:  %d    SPO2:  %d    TIME:  %d:%d:%d,%d/%d/%d\r\n",Steps,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
						u3_printf("%d	%d	%d	%d.%d	%d	%d	%d	%d	%d	%d	%d	%d\r\n",Steps,Distance,Calorie,temp_value/10,temp_value%10,HR,SPO2,hour,minute,second,year,month,day);		//总发送
					  delay_ms(50);
					}
				 
					break;
				 */
		     default:                                  //其他功能待开发
				 break;	 		 
		   }
			 
	 }

 }

 
/*---外部中断4服务程序----*/
/*用于通过触摸按键改变模式*/
void EXTI4_IRQHandler(void)
{
	standby=0;   //有操作进行，清空闲置标志位
	delay_ms(10);//消抖
	if(KEY==0)	 //按键KEY1
	{	
		OLED_c=1;
    LED_Turn();		
		Mode++;
		if(Mode>4)		 
		   Mode=0;		
	}		 
	EXTI_ClearITPendingBit(EXTI_Line4);  //清除LINE4上的中断标志位
 
}


/*---定时器3服务程序----*/
/*用于计秒、推算时间日期*/
void TIM3_IRQHandler(void)   //TIM3中断
{
	if (TIM_GetITStatus(TIM3, TIM_IT_Update) != RESET)  //检查TIM3更新中断发生与否
		{
		  second++;
      DATE_cal();
			standby++;
			if (standby>=10)      //每1S中断一次，standby值达到10则表示10秒内没有操作
			{
			  standby=0;
//				Mode=0;
				OLED_c=1;
			}
			TIM_ClearITPendingBit(TIM3, TIM_IT_Update);  //清除TIMx更新中断标志 

		}
}


