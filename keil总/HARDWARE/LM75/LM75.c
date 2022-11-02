#include "LM75.h" 
#include "delay.h"


//��ʼ��IIC�ӿ�
void LM75_Init(void)
{
	MPU_IIC_Init();
}
//��LM75�¶ȼĴ�����ֵ������Temp��Thyst��Tos��
//ReadReg:ѡ��Ĵ���  
//����ֵ  :����������
u16 LM75_ReadTemp(u8 ReadReg)
{				  
	  u16 temp=0;  
    u16 temph, templ;	
    MPU_IIC_Start();                //��ʼ�ź� 

		MPU_IIC_Send_Byte(Write_Mode);	//����д����+�豸��ַ		 
	  MPU_IIC_Wait_Ack(); 
	
    MPU_IIC_Send_Byte(ReadReg);     //���ͼĴ�����ַ
	  MPU_IIC_Wait_Ack();	 
	
	  MPU_IIC_Start();  	            //�ظ���ʼ�ź� 	   
	  MPU_IIC_Send_Byte(Read_Mode);   //���Ͷ�����+�豸��ַ			   
	  MPU_IIC_Wait_Ack();	 
    
	  temph=MPU_IIC_Read_Byte(1);		
    templ=MPU_IIC_Read_Byte(0);	
    MPU_IIC_Stop();                 //����һ��ֹͣ����	 
    temp=(temph<<8)+templ;
	    	  
    if((temph>>8)>127)          //�ж��¶�����
        return 0;		            //�¶�Ϊ��  
    
		temp=(float)temp*0.00390625*10;		//����ʵ���¶ȣ�����С�����һλ�ᵽС����ǰ  
		return temp;                //�����¶�ֵ      
		
}
































































////��MAX30205ָ����ַд��һ������
////WriteAddr  :д�����ݵ�Ŀ�ĵ�ַ    
////DataToWrite:Ҫд�������
//void MAX30205_WriteOneByte(u16 WriteAddr,u8 DataToWrite)
//{				   	  	    																 
//    MPU_IIC_Start();  
//	if(EE_TYPE>AT24C16)
//	{
//		MPU_IIC_Send_Byte(0XA0);	    //����д����
//		MPU_IIC_Wait_Ack();
//		MPU_IIC_Send_Byte(WriteAddr>>8);//���͸ߵ�ַ
// 	}else
//	{
//		MPU_IIC_Send_Byte(0XA0+((WriteAddr/256)<<1));   //����������ַ0XA0,д���� 
//	}	 
//	MPU_IIC_Wait_Ack();	   
//    MPU_IIC_Send_Byte(WriteAddr%256);   //���͵͵�ַ
//	MPU_IIC_Wait_Ack(); 	 										  		   
//	MPU_IIC_Send_Byte(DataToWrite);     //�����ֽ�							   
//	MPU_IIC_Wait_Ack();  		    	   
//    MPU_IIC_Stop();//����һ��ֹͣ���� 
//	delay_ms(10);	 
//}
////��MAX30205�����ָ����ַ��ʼд�볤��ΪLen������
////�ú�������д��16bit����32bit������.
////WriteAddr  :��ʼд��ĵ�ַ  
////DataToWrite:���������׵�ַ
////Len        :Ҫд�����ݵĳ���2,4
//void MAX30205_WriteLenByte(u16 WriteAddr,u32 DataToWrite,u8 Len)
//{  	
//	u8 t;
//	for(t=0;t<Len;t++)
//	{
//		MAX30205_WriteOneByte(WriteAddr+t,(DataToWrite>>(8*t))&0xff);
//	}												    
//}

////��MAX30205�����ָ����ַ��ʼ��������ΪLen������
////�ú������ڶ���16bit����32bit������.
////ReadAddr   :��ʼ�����ĵ�ַ 
////����ֵ     :����
////Len        :Ҫ�������ݵĳ���2,4
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
////���MAX30205�Ƿ�����
////��������24XX�����һ����ַ(255)���洢��־��.
////���������24Cϵ��,�����ַҪ�޸�
////����1:���ʧ��
////����0:���ɹ�
//u8 MAX30205_Check(void)
//{
//	u8 temp;
//	temp=MAX30205_ReadOneByte(255);//����ÿ�ο�����дMAX30205			   
//	if(temp==0X55)return 0;		   
//	else//�ų���һ�γ�ʼ�������
//	{
//		MAX30205_WriteOneByte(255,0X55);
//	    temp=MAX30205_ReadOneByte(255);	  
//		if(temp==0X55)return 0;
//	}
//	return 1;											  
//}

////��MAX30205�����ָ����ַ��ʼ����ָ������������
////ReadAddr :��ʼ�����ĵ�ַ ��24c02Ϊ0~255
////pBuffer  :���������׵�ַ
////NumToRead:Ҫ�������ݵĸ���
//void MAX30205_Read(u16 ReadAddr,u8 *pBuffer,u16 NumToRead)
//{
//	while(NumToRead)
//	{
//		*pBuffer++=MAX30205_ReadOneByte(ReadAddr++);	
//		NumToRead--;
//	}
//}  
////��MAX30205�����ָ����ַ��ʼд��ָ������������
////WriteAddr :��ʼд��ĵ�ַ ��24c02Ϊ0~255
////pBuffer   :���������׵�ַ
////NumToWrite:Ҫд�����ݵĸ���
//void MAX30205_Write(u16 WriteAddr,u8 *pBuffer,u16 NumToWrite)
//{
//	while(NumToWrite--)
//	{
//		MAX30205_WriteOneByte(WriteAddr,*pBuffer);
//		WriteAddr++;
//		pBuffer++;
//	}
//}

