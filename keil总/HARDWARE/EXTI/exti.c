#include "exti.h"
#include "led.h"
#include "key.h"
#include "delay.h"
#include "stm32f10x_exti.h"
#include "misc.h"

//外部中断0服务程序
void EXTIX_Init(void)
{
  EXTI_InitTypeDef EXTI_Struct;
	NVIC_InitTypeDef NVIC_Struct;
	
	RCC_APB2PeriphClockCmd(RCC_APB2Periph_AFIO,ENABLE);//开启复用时钟
  GPIO_EXTILineConfig(GPIO_PortSourceGPIOE,GPIO_PinSource4);//IO口对应中短线，PA1
  
	EXTI_Struct.EXTI_Line=EXTI_Line4; //选择外部中断线1
	EXTI_Struct.EXTI_LineCmd=ENABLE;//打开外部中断
	EXTI_Struct.EXTI_Mode=EXTI_Mode_Interrupt;//选择模式为中断
	EXTI_Struct.EXTI_Trigger=EXTI_Trigger_Falling;//下降沿触发
	EXTI_Init(&EXTI_Struct);
	
	NVIC_Struct.NVIC_IRQChannel=EXTI4_IRQn;
	NVIC_Struct.NVIC_IRQChannelCmd=ENABLE;
	NVIC_Struct.NVIC_IRQChannelPreemptionPriority=1; //抢占优先级  0-3
	NVIC_Struct.NVIC_IRQChannelSubPriority=0;  //响应优先级   0-3
	NVIC_Init(&NVIC_Struct);
	
}




