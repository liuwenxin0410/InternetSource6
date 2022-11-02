package et.song.data;

import et.song.value.Value;

public final class AirData {
	//0x10 0x11 0x12 0x13 0x14 0x15 0x16 0x17 0x18 0x19 0x1A 0x1B 0x1C 0x1D 0x1E
	//16   17   18   19   20   21   22   23   24   25   26   27   28   29   30
	public static byte mPower = 0x00;
	public static byte mTmp = 0x19;
	public static byte mWindCount = 0x01;	//01 02 03 04
	public static byte mWindDir = 0x02; 	//01 02 03
	public static byte mWindAutoDir = 0x01; //00
	public static byte mKey = 0x01;
	public static byte mMode = 0x01; //01 ~ 0x05
	//public static boolean mIsOpen = false;
	
	public static void SetKey(int _key)
	{
		mKey = (byte)(_key & 0x000000FF);
		if (_key == Value.AIR.POWER)
		{
			if (mPower == 0x00)
			{
				mPower = 0x01;
			}
			else
			{
				mPower = 0x00;
			}
		}
		if (_key == Value.AIR.MODE)
		{
			if (mMode == 0x05)
			{
				mMode = 0x01;
			}
			else
			{
				mMode++;
			}
		}
		if (_key == Value.AIR.TEMPADD)
		{
			if (mTmp < 30)
			{
				mTmp++;
			}
			else
			{
				mTmp = 30;
			}
		}
		if (_key == Value.AIR.TEMPSUB)
		{
			if (mTmp > 16)
			{
				mTmp--;
			}
			else
			{
				mTmp = 16;
			}
		}
		if (_key == Value.AIR.WIND_AUTO_DIR)
		{
//			if (mWindAutoDir == 0x00)
//			{
				mWindAutoDir = 0x01;
//			}
//			else
//			{
//				mWindAutoDir = 0x00;
//			}
		}
		if (_key == Value.AIR.WIND_COUNT)
		{
			if(mWindCount >= 0x04)
			{
				mWindCount = 0x01;
			}
			else
			{
				mWindCount++;
			}
		}
		if (_key == Value.AIR.WIND_DIR)
		{
			if (mWindDir >= 0x03)
			{
				mWindDir = 0x01;
			}
			else
			{
				mWindDir++;
			}
			mWindAutoDir = 0x00;
		}
	}

}
