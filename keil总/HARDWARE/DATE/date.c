#include "date.h"
#include "sys.h"
#include "oled.h"

extern u8 second;            //时间变量秒 
extern u8 minute;            //时间变量分 
extern u8 hour;              //时间变量时 
extern u8 day;               //时间变量日 
extern u8 month;             //时间变量月 
extern u16 year;             //时间变量年 
extern u16 iweek;						 //时间变量星期（计算）
extern u16 week;						 //时间变量星期

/*日期和时间计算函数*/
void DATE_cal(void)
{
	if(second>=60)
	{
		second=0;
		minute++;
		if(minute>=60)
		{
			minute=0;
			hour++;
			if(hour>=24)
			{
				hour=0;
				day++;
				if((month==2)&&(day>=29))
				{
					day=1;
					month++;	
					if (month>=13)	
					{
						month=1;
						year++;
					}								
				}else if(((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12))&&(day>=32))
			  {
					day=1;
					month++;	
					if (month>=13)	
					{
						month=1;
						year++;
					}	
				 }else if((month%2==0)&&(day>=31))
				{
					day=1;
					month++;
					if (month>=13)	
					{
						month=1;
						year++;
					}	
				}
			}
		}
	}

	 iweek=(day+2*month+3*(month+1)/5+year+year/4-year/100+year/400)%7;				//计算星期几
    switch(iweek)
    {
			case 0: week=1; break;
			case 1: week=2; break;
			case 2: week=3; break;
			case 3: week=4; break;
			case 4: week=5; break;
			case 5: week=6; break;
			case 6: week=7; break;
    }
	}


/*显示时间和日期函数*/
void DATE_show(void)
{
	/*显示时间*/
	 if (hour<=9)
	 {
		 OLED_ShowString(0,0,"0",24);
		 OLED_ShowNum(12,0,hour,1,24);
	 }else
	 OLED_ShowNum(0,0,hour,2,24);				 
	 OLED_ShowString(24,0,":",24); 
	 if (minute<=9)
	 {
		 OLED_ShowString(36,0,"0",24);
		 OLED_ShowNum(48,0,minute,1,24);
	 }else					 
	 OLED_ShowNum(36,0,minute,2,24);	
	 OLED_ShowString(60,0,":",24);
	 if (second<=9)
	 {
		 OLED_ShowString(72,0,"0",24);
		 OLED_ShowNum(84,0,second,1,24);
	 }else					 
	 OLED_ShowNum(72,0,second,2,24);				 
	 
	/*显示日期*/	 
	 OLED_ShowNum(0,28,year,4,16);
	 OLED_ShowString(32,28,"/",16);
	 if (month<=9)
	 {
		 OLED_ShowString(40,28,"0",16);
		 OLED_ShowNum(48,28,month,1,16);
	 }else						 
	 OLED_ShowNum(40,28,month,2,16);	
	 OLED_ShowString(56,28,"/",16);
	 if (day<=9)
	 {
		 OLED_ShowString(64,28,"0",16);
		 OLED_ShowNum(72,28,day,1,16);
	 }else						 
	 OLED_ShowNum(64,28,day,2,16);				 
	 OLED_Refresh_Gram();	
 
}

