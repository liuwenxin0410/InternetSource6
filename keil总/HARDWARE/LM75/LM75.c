#include "LM75.h" 
#include "delay.h"


//初始化IIC接口
void LM75_Init(void)
{
	MPU_IIC_Init();
}
//读LM75温度寄存器的值（包括Temp、Thyst或Tos）
//ReadReg:选择寄存器  
//返回值  :读到的数据
u16 LM75_ReadTemp(u8 ReadReg)
{				  
	  u16 temp=0;  
    u16 temph, templ;	
    MPU_IIC_Start();                //开始信号 

		MPU_IIC_Send_Byte(Write_Mode);	//发送写命令+设备地址		 
	  MPU_IIC_Wait_Ack(); 
	
    MPU_IIC_Send_Byte(ReadReg);     //发送寄存器地址
	  MPU_IIC_Wait_Ack();	 
	
	  MPU_IIC_Start();  	            //重复起始信号 	   
	  MPU_IIC_Send_Byte(Read_Mode);   //发送读命令+设备地址			   
	  MPU_IIC_Wait_Ack();	 
    
	  temph=MPU_IIC_Read_Byte(1);		
    templ=MPU_IIC_Read_Byte(0);	
    MPU_IIC_Stop();                 //产生一个停止条件	 
    temp=(temph<<8)+templ;
	    	  
    if((temph>>8)>127)          //判断温度正负
        return 0;		            //温度为负  
    
		temp=(float)temp*0.00390625*10;		//计算实际温度，并将小数点后一位提到小数点前  
		return temp;                //返回温度值      
		
}
































































////在MAX30205指定地址写入一个数据
////WriteAddr  :写入数据的目的地址    
////DataToWrite:要写入的数据
//void MAX30205_WriteOneByte(u16 WriteAddr,u8 DataToWrite)
//{				   	  	    																 
//    MPU_IIC_Start();  
//	if(EE_TYPE>AT24C16)
//	{
//		MPU_IIC_Send_Byte(0XA0);	    //发送写命令
//		MPU_IIC_Wait_Ack();
//		MPU_IIC_Send_Byte(WriteAddr>>8);//发送高地址
// 	}else
//	{
//		MPU_IIC_Send_Byte(0XA0+((WriteAddr/256)<<1));   //发送器件地址0XA0,写数据 
//	}	 
//	MPU_IIC_Wait_Ack();	   
//    MPU_IIC_Send_Byte(WriteAddr%256);   //发送低地址
//	MPU_IIC_Wait_Ack(); 	 										  		   
//	MPU_IIC_Send_Byte(DataToWrite);     //发送字节							   
//	MPU_IIC_Wait_Ack();  		    	   
//    MPU_IIC_Stop();//产生一个停止条件 
//	delay_ms(10);	 
//}
////在MAX30205里面的指定地址开始写入长度为Len的数据
////该函数用于写入16bit或者32bit的数据.
////WriteAddr  :开始写入的地址  
////DataToWrite:数据数组首地址
////Len        :要写入数据的长度2,4
//void MAX30205_WriteLenByte(u16 WriteAddr,u32 DataToWrite,u8 Len)
//{  	
//	u8 t;
//	for(t=0;t<Len;t++)
//	{
//		MAX30205_WriteOneByte(WriteAddr+t,(DataToWrite>>(8*t))&0xff);
//	}												    
//}

////在MAX30205里面的指定地址开始读出长度为Len的数据
////该函数用于读出16bit或者32bit的数据.
////ReadAddr   :开始读出的地址 
////返回值     :数据
////Len        :要读出数据的长度2,4
//u32 MAX30205_ReadLenByte(u16 ReadAddr,u8 Len)
//{  	
//	u8 t;
//	u32 temp=0;
//	for(t=0;t<Len;t++)
//	{
//		temp<<=8;
//		temp+=MAX30205_ReadOneByte(ReadAddr+Len-t-1); 	 				   
//	}
//	return temp;												    
//}
////检查MAX30205是否正常
////这里用了24XX的最后一个地址(255)来存储标志字.
////如果用其他24C系列,这个地址要修改
////返回1:检测失败
////返回0:检测成功
//u8 MAX30205_Check(void)
//{
//	u8 temp;
//	temp=MAX30205_ReadOneByte(255);//避免每次开机都写MAX30205			   
//	if(temp==0X55)return 0;		   
//	else//排除第一次初始化的情况
//	{
//		MAX30205_WriteOneByte(255,0X55);
//	    temp=MAX30205_ReadOneByte(255);	  
//		if(temp==0X55)return 0;
//	}
//	return 1;											  
//}

////在MAX30205里面的指定地址开始读出指定个数的数据
////ReadAddr :开始读出的地址 对24c02为0~255
////pBuffer  :数据数组首地址
////NumToRead:要读出数据的个数
//void MAX30205_Read(u16 ReadAddr,u8 *pBuffer,u16 NumToRead)
//{
//	while(NumToRead)
//	{
//		*pBuffer++=MAX30205_ReadOneByte(ReadAddr++);	
//		NumToRead--;
//	}
//}  
////在MAX30205里面的指定地址开始写入指定个数的数据
////WriteAddr :开始写入的地址 对24c02为0~255
////pBuffer   :数据数组首地址
////NumToWrite:要写入数据的个数
//void MAX30205_Write(u16 WriteAddr,u8 *pBuffer,u16 NumToWrite)
//{
//	while(NumToWrite--)
//	{
//		MAX30205_WriteOneByte(WriteAddr,*pBuffer);
//		WriteAddr++;
//		pBuffer++;
//	}
//}

