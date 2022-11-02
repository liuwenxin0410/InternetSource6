package et.song.data;

import et.song.bt.BT;
import et.song.value.Value;

public class KeyData {
	public static boolean mIsStudy = false;
	public static boolean mTVIsKnown = false;
	public static int mTVRows = 0;
	public static int mTVCols = 0;
	public static boolean mSTBIsKnown = false;
	public static int mSTBRows = 0;
	public static int mSTBCols = 0;
	public static boolean mDVDIsKnown = false;
	public static int mDVDRows = 0;
	public static int mDVDCols = 0;
	public static boolean mFansIsKnown = false;
	public static int mFansRows = 0;
	public static int mFansCols = 0;
	public static boolean mPJTIsKnown = false;
	public static int mPJTRows = 0;
	public static int mPJTCols = 0;
	public static boolean mLightIsKnown = false;
	public static boolean mAirIsKnown = true;
	public static int mAirRows = 0;
	public static int mAirCols = 0;
	private static int mToken = 0;
	public static int mTV20 = 0xFF; 
	public static int mTV08 = 0xFF;
	public static int mTV10 = 0xFF;
	public static int mDVD20 = 0xFF;
	public static int mDVD08 = 0xFF;
	public static int mDVD10 = 0xFF;
	public static int mSTB20 = 0xFF;
	public static int mSTB08 = 0xFF;
	public static int mSTB10 = 0xFF;
	public static int mFans20 = 0xFF; 
	public static int mFans08 = 0xFF;
	public static int mFans10 = 0xFF;
	public static int mPJT20 = 0xFF; 
	public static int mPJT08 = 0xFF;
	public static int mPJT10 = 0xFF;
//	private static int mAir20 = 0xFF;
//	private static int mAir08 = 0xFF;
//	private static int mAir10 = 0xFF;
	private static KnownLib mKnownLib = new KnownLib();
	private static StudyLib mStudyLib = new StudyLib();
	private static byte[] KnownCode(int _type, int _keyValue) throws Exception {
		if (_type == Value.DeviceType.TYPE_TV) {
			return mKnownLib.Get(_type, mTVRows, mTVCols,
					String.valueOf(_keyValue));
		}
		if (_type == Value.DeviceType.TYPE_DVD)
		{
			return mKnownLib.Get(_type, mDVDRows, mDVDCols,
					String.valueOf(_keyValue));
		}
		if (_type == Value.DeviceType.TYPE_STB) {
			return mKnownLib.Get(_type, mSTBRows, mSTBCols,
					String.valueOf(_keyValue));
		}
		if (_type == Value.DeviceType.TYPE_FANS) {
			return mKnownLib.Get(_type, mFansRows, mFansCols,
					String.valueOf(_keyValue));
		}
		if (_type == Value.DeviceType.TYPE_PJT) {
			return mKnownLib.Get(_type, mPJTRows, mPJTCols,
					String.valueOf(_keyValue));
		}
		if (_type == Value.DeviceType.TYPE_AIR) {
			return mKnownLib.Get(_type, mAirRows, mAirCols,
					String.valueOf(_keyValue));
		}
		return null;
	}

	private static byte[] StudyCode(int _keyValue) {
		return mStudyLib.Get(String.valueOf(_keyValue));
	}

	public static void Add(byte[] _keyValue) {
		mStudyLib.Edit(String.valueOf(mToken), _keyValue);
	}
	public static void Del(int _token) {
		mStudyLib.Del(String.valueOf(_token));
	}
	public static void Add(String _token, byte[] _keyValue)
	{
		mStudyLib.Add(_token, _keyValue);
	}
	public static void Test() {
		byte[] data = StudyCode(mToken);
		BT.getInstance().write(data);
	}

	public static void Repeat() {
		byte[] data = new byte[] { 0x30, 0x10, 0x40 };
		BT.getInstance().write(data);
	}

	public static void Write(int _key) throws Exception {
		if (mIsStudy) {
			mToken = _key;
			byte[] data = new byte[] { 0x30, 0x10, 0x40 };
			BT.getInstance().write(data);
		} else {
			byte[] data = null;
			int typeValue = _key & 0xFF00;
			if (typeValue == Value.DeviceType.TYPE_TV) {
				if (mTVIsKnown) {
					data = KnownCode(typeValue, _key);
					if(data[2] == 0x04) 
					{
						if (mTV20 == 0xFF)
						{
							mTV20 = data[5];
						}
						else
						{
							mTV20 ^=  0x20;
							data[5] = (byte) mTV20;
						}
					}
					else if(data[2] == 0x0a) 
					{
						if (mTV08 == 0xFF)
						{
							mTV08 = data[5];
						}
						else
						{
							mTV08 ^= 0x08;
							data[5] = (byte) mTV08;
						}
					}
					else if(data[2] == 0x21)
					{
						if (mTV10 == 0xFF)
						{
							mTV10 = data[5];
						}
						else
						{
							mTV10 ^= 0x10;
							data[5] = (byte) mTV10;
						}
					}
					data[9] = (byte) (data[0] + data[1] + data[2] + data[3] + data[4]
							+ data[5] + data[6] + data[7] + data[8]);
				} else {
					data = StudyCode(_key);
				}
			}
			if (typeValue == Value.DeviceType.TYPE_STB) {
				if (mSTBIsKnown) {
					data = KnownCode(typeValue, _key);
					if(data[2] == 0x04) 
					{
						if (mSTB20 == 0xFF)
						{
							mSTB20 = data[5];
						}
						else
						{
							mSTB20 ^=  0x20;
							data[5] = (byte) mSTB20;
						}
					}
					else if(data[2] == 0x0a) 
					{
						if (mSTB08 == 0xFF)
						{
							mSTB08 = data[5];
						}
						else
						{
							mSTB08 ^= 0x08;
							data[5] = (byte) mSTB08;
						}
					}
					else if(data[2] == 0x21)
					{
						if (mSTB10 == 0xFF)
						{
							mSTB10 = data[5];
						}
						else
						{
							mSTB10 ^= 0x10;
							data[5] = (byte) mSTB10;
						}
					}
					data[9] = (byte) (data[0] + data[1] + data[2] + data[3] + data[4]
							+ data[5] + data[6] + data[7] + data[8]);
				} else {
					data = StudyCode(_key);
				}
			}
			if (typeValue == Value.DeviceType.TYPE_DVD) {
				if (mDVDIsKnown) {
					data = KnownCode(typeValue, _key);
					if(data[2] == 0x04) 
					{
						if (mDVD20 == 0xFF)
						{
							mDVD20 = data[5];
						}
						else
						{
							mDVD20 ^=  0x20;
							data[5] = (byte) mDVD20;
						}
					}
					else if(data[2] == 0x0a) 
					{
						if (mDVD08 == 0xFF)
						{
							mDVD08 = data[5];
						}
						else
						{
							mDVD08 ^= 0x08;
							data[5] = (byte) mDVD08;
						}
					}
					else if(data[2] == 0x21)
					{
						if (mDVD10 == 0xFF)
						{
							mDVD10 = data[5];
						}
						else
						{
							mDVD10 ^= 0x10;
							data[5] = (byte) mDVD10;
						}
					}
					data[9] = (byte) (data[0] + data[1] + data[2] + data[3] + data[4]
							+ data[5] + data[6] + data[7] + data[8]);
				} else {
					data = StudyCode(_key);
				}
			}
			if (typeValue == Value.DeviceType.TYPE_FANS) {
				if (mFansIsKnown) {
					data = KnownCode(typeValue, _key);
					if(data[2] == 0x04) 
					{
						if (mFans20 == 0xFF)
						{
							mFans20 = data[5];
						}
						else
						{
							mFans20 ^=  0x20;
							data[5] = (byte) mFans20;
						}
					}
					else if(data[2] == 0x0a) 
					{
						if (mFans08 == 0xFF)
						{
							mFans08 = data[5];
						}
						else
						{
							mFans08 ^= 0x08;
							data[5] = (byte) mFans08;
						}
					}
					else if(data[2] == 0x21)
					{
						if (mFans10 == 0xFF)
						{
							mFans10 = data[5];
						}
						else
						{
							mFans10 ^= 0x10;
							data[5] = (byte) mFans10;
						}
					}
					data[9] = (byte) (data[0] + data[1] + data[2] + data[3] + data[4]
							+ data[5] + data[6] + data[7] + data[8]);
				} else {
					data = StudyCode(_key);
				}
			}
			if (typeValue == Value.DeviceType.TYPE_PJT) {
				if (mPJTIsKnown) {
					data = KnownCode(typeValue, _key);
					if(data[2] == 0x04) 
					{
						if (mPJT20 == 0xFF)
						{
							mPJT20 = data[5];
						}
						else
						{
							mPJT20 ^=  0x20;
							data[5] = (byte) mPJT20;
						}
					}
					else if(data[2] == 0x0a) 
					{
						if (mPJT08 == 0xFF)
						{
							mPJT08 = data[5];
						}
						else
						{
							mPJT08 ^= 0x08;
							data[5] = (byte) mPJT08;
						}
					}
					else if(data[2] == 0x21)
					{
						if (mPJT10 == 0xFF)
						{
							mPJT10 = data[5];
						}
						else
						{
							mPJT10 ^= 0x10;
							data[5] = (byte) mPJT10;
						}
					}
					data[9] = (byte) (data[0] + data[1] + data[2] + data[3] + data[4]
							+ data[5] + data[6] + data[7] + data[8]);
				} else {
					data = StudyCode(_key);
				}
			}
			if (typeValue == Value.DeviceType.TYPE_AIR) {
				if (mAirIsKnown) {
					data = KnownCode(typeValue, _key);		
				} else {
					data = StudyCode(_key);
				}
			}
			if (typeValue == Value.DeviceType.TYPE_LIGHT) {
				if (mLightIsKnown) {
					data = KnownCode(typeValue, _key);
				} else {
					data = StudyCode(_key);
				}
			}
			if (data != null) {
				BT.getInstance().write(data);
			}
		}
	}
	public static void Save(DB _db)
	{
		String sql =  "update stateTable set " +
			   "mIsStudy = '" + String.valueOf(mIsStudy) + "' ," +
			   "mTVIsKnown = '" + String.valueOf(mTVIsKnown) + "' ," +
			   "mTVRows = '" + String.valueOf(mTVRows) + "' ," +
			   "mTVCols = '" + String.valueOf(mTVCols) + "' ," +
			   "mSTBIsKnown = '" + String.valueOf(mSTBIsKnown) + "' ," +
			   "mSTBRows = '" + String.valueOf(mSTBRows) + "' ," +
			   "mSTBCols = '" + String.valueOf(mSTBCols) + "' ," +
			   "mDVDIsKnown = '" + String.valueOf(mDVDIsKnown) + "' ," +
			   "mDVDRows = '" + String.valueOf(mDVDRows) + "' ," +
			   "mDVDCols = '" + String.valueOf(mDVDCols) + "' ," +
			   "mFansIsKnown = '" + String.valueOf(mFansIsKnown) + "' ," +
			   "mFansRows = '" + String.valueOf(mFansRows) + "' ," +
			   "mFansCols = '" + String.valueOf(mFansCols) + "' ," +
			   "mPJTIsKnown = '" + String.valueOf(mPJTIsKnown) + "' ," +
			   "mPJTRows = '" + String.valueOf(mPJTRows) + "' ," +
			   "mPJTCols = '" + String.valueOf(mPJTCols) + "' ," +			   
			   "mAirIsKnown = '" + String.valueOf(mAirIsKnown) + "' ," +
			   "mAirRows = '" + String.valueOf(mAirRows) + "' ," +
			   "mAirCols = '" + String.valueOf(mAirCols) + "' ," +
			   "mLightIsKnown = '" + String.valueOf(mLightIsKnown) + "' " +
			   "where _id = (select _id from stateTable limit 1)";
		_db.EXE(sql);
		mStudyLib.Save(_db);
	}
}
