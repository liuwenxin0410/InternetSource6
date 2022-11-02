#ifndef __LED_H
#define __LED_H	 

#define LED0_Light GPIO_ReadOutputDataBit(GPIOB,GPIO_Pin_5);

void LED_Init(void); //³õÊ¼»¯
	
void LED_Turn(void); //LED·­×ª

#endif
