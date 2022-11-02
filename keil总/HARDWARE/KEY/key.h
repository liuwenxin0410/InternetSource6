#ifndef __KEY_H
#define __KEY_H	 


#define KEY GPIO_ReadInputDataBit(GPIOE,GPIO_Pin_4)//读取电容触摸开关电平

#define KEY_PRESS 1

void KEY_Init(void);//IO初始化
//unsigned char KEY_Scan(void);  	//按键扫描函数					    

#endif


