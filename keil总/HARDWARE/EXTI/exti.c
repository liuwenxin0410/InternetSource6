#include "exti.h"
#include "led.h"
#include "key.h"
#include "delay.h"
#include "stm32f10x_exti.h"
#include "misc.h"

//�ⲿ�ж�0�������
void EXTIX_Init(void)
{
  EXTI_InitTypeDef EXTI_Struct;
	NVIC_InitTypeDef NVIC_Struct;
	
	RCC_APB2PeriphClockCmd(RCC_APB2Periph_AFIO,ENABLE);//��������ʱ��
  GPIO_EXTILineConfig(GPIO_PortSourceGPIOE,GPIO_PinSource4);//IO�ڶ�Ӧ�ж��ߣ�PA1
  
	EXTI_Struct.EXTI_Line=EXTI_Line4; //ѡ���ⲿ�ж���1
	EXTI_Struct.EXTI_LineCmd=ENABLE;//���ⲿ�ж�
	EXTI_Struct.EXTI_Mode=EXTI_Mode_Interrupt;//ѡ��ģʽΪ�ж�
	EXTI_Struct.EXTI_Trigger=EXTI_Trigger_Falling;//�½��ش���
	EXTI_Init(&EXTI_Struct);
	
	NVIC_Struct.NVIC_IRQChannel=EXTI4_IRQn;
	NVIC_Struct.NVIC_IRQChannelCmd=ENABLE;
	NVIC_Struct.NVIC_IRQChannelPreemptionPriority=1; //��ռ���ȼ�  0-3
	NVIC_Struct.NVIC_IRQChannelSubPriority=0;  //��Ӧ���ȼ�   0-3
	NVIC_Init(&NVIC_Struct);
	
}




