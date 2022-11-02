#ifndef __LM75_H
#define __LM75_H
#include "mpuiic.h"   


#define Temp_Reg 0x00
#define Thyst_Reg 0x02
#define Tos_Reg 0x03
#define Read_Mode 0x91
#define Write_Mode 0x90


u16 LM75_ReadTemp(u8 ReadReg);							//指定地址读取一个字节

void LM75_Init(void); //初始化IIC
#endif
















