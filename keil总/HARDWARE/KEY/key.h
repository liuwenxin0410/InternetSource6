#ifndef __KEY_H
#define __KEY_H	 


#define KEY GPIO_ReadInputDataBit(GPIOE,GPIO_Pin_4)//��ȡ���ݴ������ص�ƽ

#define KEY_PRESS 1

void KEY_Init(void);//IO��ʼ��
//unsigned char KEY_Scan(void);  	//����ɨ�躯��					    

#endif


