package et.song.data;

import java.util.List;

import et.song.c.C;
import et.song.value.Value;

public class KnownLib {

	public KnownLib() {
		KnownLibTV.Init();
		KnownLibDVD.Init();
		KnownLibSTB.Init();
		KnownLibFANS.Init();
		KnownLibPJT.Init();
		KnownLibAIR.Init();
	}

	public int GetTVCount(int _index) throws Exception{
		return KnownLibTV.GetTVCount(_index);
	}

	public List<int[]> GetTV() {
		return KnownLibTV.GetTV();
	}

	public int GetDVDCount(int _index) throws Exception{
		return KnownLibDVD.GetDVDCount(_index);
	}

	public List<int[]> GetDVD() {
		return KnownLibDVD.GetDVD();
	}

	public int GetSTBCount(int _index) throws Exception{
		return KnownLibSTB.GetSTBCount(_index);
	}

	public List<int[]> GetSTB() {
		return KnownLibSTB.GetSTB();
	}

	public int GetFansCount(int _index) throws Exception{
		return KnownLibFANS.GetFansCount(_index);
	}

	public List<int[]> GetFans() {
		return KnownLibFANS.GetFans();
	}

	public int GetPJTCount(int _index) throws Exception {
		return KnownLibPJT.GetPJTCount(_index);
	}

	public List<int[]> GetPJT() {
		return KnownLibPJT.GetPJT();
	}

	public int GetAirCount(int _index) throws Exception {
		return KnownLibAIR.GetAirCount(_index);
	}

	public List<int[]> GetAIR() {
		return KnownLibAIR.GetAIR();
	}

	public byte[] Get(int _type, int _row, int _col, String _token) throws Exception {
		byte[] data = new byte[10];
		int[] index = filter(_type, _row, _col, _token);
		if (_type == Value.DeviceType.TYPE_AIR) {
			byte chkSum = 0;
			AirData.SetKey(Integer.valueOf(_token));
			int[] air_data = C.GetAirData(index[1]);
			int len = air_data.length;
			byte[] _data = new byte[len + 14];
			_data[0] = 0x30;
			chkSum += _data[0];
			_data[1] = 0x01;
			chkSum += _data[1];
			_data[2] = (byte) ((index[1] >> 8) & 0xFF);
			chkSum += _data[2];
			_data[3] = (byte) (index[1] & 0xFF);
			chkSum += _data[3];
			_data[4] = AirData.mTmp;
			chkSum += _data[4];
			_data[5] = AirData.mWindCount;
			chkSum += _data[5];
			_data[6] = AirData.mWindDir;
			chkSum += _data[6];
			_data[7] = AirData.mWindAutoDir;
			chkSum += _data[7];
			_data[8] = AirData.mPower;
			chkSum += _data[8];
			_data[9] = AirData.mKey;
			chkSum += _data[9];
			_data[10] = AirData.mMode;
			chkSum += _data[10];

			_data[11] = (byte) (len + 1);
			chkSum += _data[11];
			for (int i = 0; i < len; i++) {
				_data[12 + i] = (byte) (air_data[i]);
				chkSum += _data[12 + i];
			}
			_data[len + 12] = (byte) 0xFF;
			chkSum += _data[len + 12];
			_data[len + 13] = chkSum;
			return _data;
		} else {
			return C.GetKnownData(index[0], index[1], index[2], data);
		}
	}

	private int[] filter(int _type, int _row, int _col, String _token) throws Exception{
		int keyValue = Integer.valueOf(_token);
		int[] data = new int[3];
		if (_type == Value.DeviceType.TYPE_TV) {
			data[0] = 0;
			data[1] = KnownLibTV.GetData(_row, _col);
			data[2] = keyValue & 0x00FF;
		}
		if (_type == Value.DeviceType.TYPE_STB) {
			data[0] = 1;
			data[1] = KnownLibSTB.GetData(_row, _col);
			data[2] = keyValue & 0x00FF;
		}
		if (_type == Value.DeviceType.TYPE_DVD) {
			data[0] = 2;
			data[1] = KnownLibDVD.GetData(_row, _col);
			data[2] = keyValue & 0x00FF;
		}
		if (_type == Value.DeviceType.TYPE_FANS) {
			data[0] = 3;
			data[1] = KnownLibFANS.GetData(_row, _col);
			data[2] = keyValue & 0x00FF;
		}
		if (_type == Value.DeviceType.TYPE_AIR) {
			data[0] = 4;
			data[1] = KnownLibAIR.GetData(_row, _col);
			data[2] = keyValue & 0x00FF;
		}
		if (_type == Value.DeviceType.TYPE_PJT) {
			data[0] = 5;
			data[1] = KnownLibPJT.GetData(_row, _col);
			data[2] = keyValue & 0x00FF;
		}
		return data;
	}
}
