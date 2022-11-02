#include "stm32f10x.h"
#include "key.h"
#include "delay.h"

								    
//������ʼ����������ʼ��GPIOE.1 Ϊ��������
void KEY_Init(void) //IO��ʼ��
{ 
	GPIO_InitTypeDef GPIOE_Struct;
  RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOE,ENABLE);

	GPIOE_Struct.GPIO_Mode=GPIO_Mode_IPU;
	GPIOE_Struct.GPIO_Pin=GPIO_Pin_4;
	GPIOE_Struct.GPIO_Speed=GPIO_Speed_10MHz;
	GPIO_Init(GPIOE,&GPIOE_Struct);
}

