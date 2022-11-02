#include "led.h"
#include "stm32f10x_gpio.h"//GPIO相关函数
#include "stm32f10x_rcc.h" //时钟相关函数


//并使能IO口时钟,初始化PB5初始化为推挽输出。		    
//LED IO初始化
void LED_Init(void)
{
  GPIO_InitTypeDef GPIOB_Struct;  
	RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOB,ENABLE);

	GPIOB_Struct.GPIO_Pin = GPIO_Pin_5;
	GPIOB_Struct.GPIO_Speed = GPIO_Speed_10MHz;
	GPIOB_Struct.GPIO_Mode = GPIO_Mode_Out_PP;
	GPIO_Init(GPIOB,&GPIOB_Struct);

}
	
 
void LED_Turn(void)
{
	unsigned char light;
	light=GPIO_ReadOutputDataBit(GPIOB,GPIO_Pin_5);
  if(light==0)
	{
	  GPIO_SetBits(GPIOB,GPIO_Pin_5);
	}else GPIO_ResetBits(GPIOB,GPIO_Pin_5);
	
}
