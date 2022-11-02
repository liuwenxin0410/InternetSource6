package et.song.ctrl;

import java.util.Timer;
import java.util.TimerTask;

import et.song.data.AirData;
import et.song.data.KeyData;
import et.song.data.KnownLib;
import et.song.value.Value;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class OptionActivity extends Activity implements OnItemSelectedListener,
		OnClickListener {

	private EffectThread mThread = null;
	private Spinner deviceSp = null;
	private Spinner typeSp = null;
	private int mRows = 0;
	private int mCount = 0;
	private int mCurrentCount = 0;
	private boolean isAll = true;
	private TextView mDeviceCount = null;
	private TextView mRemainCount = null;
	private int mType = Value.DeviceType.TYPE_TV;
	private KnownLib mKnownLib = new KnownLib();
	private int mI = 0;
	private boolean mTmpIsKnown = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_options);

		typeSp = (Spinner) findViewById(R.id.typeSp);
		ArrayAdapter<CharSequence> type_adapter = ArrayAdapter
				.createFromResource(this, R.array.type_array,
						R.layout.option_item);
		typeSp.setAdapter(type_adapter);
		typeSp.setOnItemSelectedListener(this);
		deviceSp = (Spinner) findViewById(R.id.nameSp);
		ArrayAdapter<CharSequence> device_adapter = ArrayAdapter
				.createFromResource(this, R.array.tv_array,
						R.layout.option_item);
		deviceSp.setAdapter(device_adapter);
		deviceSp.setOnItemSelectedListener(this);

		mDeviceCount = (TextView) findViewById(R.id.count_text);
		mRemainCount = (TextView) findViewById(R.id.remain_count);
		mType = Value.DeviceType.TYPE_TV;
		mRows = device_adapter.getCount();
		for (int i = 0; i < mRows - 1; i++) {
			try {
				mCount += mKnownLib.GetTVCount(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mDeviceCount.setText("(" + String.valueOf(mCount) + ")");
		Button autoButton = (Button) findViewById(R.id.str_auto);
		autoButton.setOnClickListener(this);
		autoButton.setEnabled(false);
		Button stopButton = (Button) findViewById(R.id.str_stop);
		stopButton.setOnClickListener(this);
		stopButton.setEnabled(false);
		Button saveButton = (Button) findViewById(R.id.str_save);
		saveButton.setOnClickListener(this);
		Button upButton = (Button) findViewById(R.id.str_up);
		upButton.setOnClickListener(this);
		upButton.setEnabled(false);
		Button downButton = (Button) findViewById(R.id.str_down);
		downButton.setOnClickListener(this);
		downButton.setEnabled(false);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mThread != null) {
			mThread.cancel();
		}
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		if (arg0 == typeSp) {
			findViewById(R.id.str_auto).setEnabled(true);
			findViewById(R.id.str_stop).setEnabled(false);
			findViewById(R.id.str_save).setEnabled(true);
			findViewById(R.id.str_up).setEnabled(false);
			findViewById(R.id.str_down).setEnabled(false);
			switch (arg2) {
			case 0:
				ArrayAdapter<CharSequence> tv_adapter = ArrayAdapter
						.createFromResource(this, R.array.tv_array,
								R.layout.option_item);
				deviceSp.setAdapter(tv_adapter);
				mType = Value.DeviceType.TYPE_TV;
				mRows = tv_adapter.getCount();
				mCount = 0;
				mCurrentCount = 0;
				for (int i = 0; i < mRows - 1; i++) {
					try {
						mCount += mKnownLib.GetTVCount(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				mDeviceCount.setText("(" + String.valueOf(mCount) + ")");
				mTmpIsKnown = KeyData.mTVIsKnown;
				KeyData.mTVIsKnown = true;
				return;
			case 1:
				ArrayAdapter<CharSequence> dvd_adapter = ArrayAdapter
						.createFromResource(this, R.array.dvd_array,
								R.layout.option_item);
				deviceSp.setAdapter(dvd_adapter);
				mType = Value.DeviceType.TYPE_DVD;
				mRows = dvd_adapter.getCount();
				mCount = 0;
				mCurrentCount = 0;
				for (int i = 0; i < mRows - 1; i++) {
					try {
						mCount += mKnownLib.GetDVDCount(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				mDeviceCount.setText("(" + String.valueOf(mCount) + ")");
				mTmpIsKnown = KeyData.mDVDIsKnown;
				KeyData.mDVDIsKnown = true;
				return;
			case 2:
				ArrayAdapter<CharSequence> stb_adapter = ArrayAdapter
						.createFromResource(this, R.array.stb_array,
								R.layout.option_item);
				deviceSp.setAdapter(stb_adapter);
				mType = Value.DeviceType.TYPE_STB;
				mRows = stb_adapter.getCount();
				mCount = 0;
				mCurrentCount = 0;
				for (int i = 0; i < mRows - 1; i++) {
					try {
						mCount += mKnownLib.GetSTBCount(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				mDeviceCount.setText("(" + String.valueOf(mCount) + ")");
				mTmpIsKnown = KeyData.mSTBIsKnown;
				KeyData.mSTBIsKnown = true;
				return;
			case 3:
				ArrayAdapter<CharSequence> air_adapter = ArrayAdapter
						.createFromResource(this, R.array.air_array,
								R.layout.option_item);
				deviceSp.setAdapter(air_adapter);
				mType = Value.DeviceType.TYPE_AIR;
				mRows = air_adapter.getCount();
				mCount = 0;
				mCurrentCount = 0;
				for (int i = 0; i < mRows - 1; i++) {
					try {
						mCount += mKnownLib.GetAirCount(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				mDeviceCount.setText("(" + String.valueOf(mCount) + ")");
				mTmpIsKnown = KeyData.mAirIsKnown;
				KeyData.mAirIsKnown = true;
				return;
			case 4:
				ArrayAdapter<CharSequence> fans_adapter = ArrayAdapter
						.createFromResource(this, R.array.fans_array,
								R.layout.option_item);
				deviceSp.setAdapter(fans_adapter);
				mType = Value.DeviceType.TYPE_FANS;
				mRows = fans_adapter.getCount();
				mCount = 0;
				mCurrentCount = 0;
				for (int i = 0; i < mRows - 1; i++) {
					try {
						mCount += mKnownLib.GetFansCount(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				mDeviceCount.setText("(" + String.valueOf(mCount) + ")");
				mTmpIsKnown = KeyData.mFansIsKnown;
				KeyData.mFansIsKnown = true;
				return;
			case 5:
				ArrayAdapter<CharSequence> pjt_adapter = ArrayAdapter
						.createFromResource(this, R.array.pjt_array,
								R.layout.option_item);
				deviceSp.setAdapter(pjt_adapter);
				mType = Value.DeviceType.TYPE_PJT;
				mRows = pjt_adapter.getCount();
				mCount = 0;
				mCurrentCount = 0;
				for (int i = 0; i < mRows - 1; i++) {
					try {
						mCount += mKnownLib.GetPJTCount(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				mDeviceCount.setText("(" + String.valueOf(mCount) + ")");
				mTmpIsKnown = KeyData.mPJTIsKnown;
				KeyData.mPJTIsKnown = true;
				return;
			default:
				return;
			}
		}
		if (arg0 == deviceSp) {
			findViewById(R.id.str_auto).setEnabled(true);
			findViewById(R.id.str_stop).setEnabled(false);
			findViewById(R.id.str_save).setEnabled(true);
			findViewById(R.id.str_up).setEnabled(false);
			findViewById(R.id.str_down).setEnabled(false);
			if (mType == Value.DeviceType.TYPE_TV) {
				mCount = 0;
				mCurrentCount = 0;
				if (arg2 == 0) {
					for (int i = 0; i < mRows - 1; i++) {
						try {
							mCount += mKnownLib.GetTVCount(i);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					isAll = true;
				} else {
					try {
						mCount = mKnownLib.GetTVCount(arg2 - 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					isAll = false;
					KeyData.mTVRows = arg2 - 1;
				}
			}
			if (mType == Value.DeviceType.TYPE_DVD) {
				mCount = 0;
				mCurrentCount = 0;
				if (arg2 == 0) {
					for (int i = 0; i < mRows - 1; i++) {
						try {
							mCount += mKnownLib.GetDVDCount(i);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					isAll = true;
				} else {
					try {
						mCount = mKnownLib.GetDVDCount(arg2 - 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					isAll = false;
					KeyData.mDVDRows = arg2 - 1;
				}
			}
			if (mType == Value.DeviceType.TYPE_STB) {
				mCount = 0;
				mCurrentCount = 0;
				if (arg2 == 0) {
					for (int i = 0; i < mRows - 1; i++) {
						try {
							mCount += mKnownLib.GetSTBCount(i);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					isAll = true;
				} else {
					try {
						mCount = mKnownLib.GetSTBCount(arg2 - 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					isAll = false;
					KeyData.mSTBRows = arg2 - 1;
				}
			}
			if (mType == Value.DeviceType.TYPE_FANS) {
				mCount = 0;
				mCurrentCount = 0;
				if (arg2 == 0) {
					for (int i = 0; i < mRows - 1; i++) {
						try {
							mCount += mKnownLib.GetFansCount(i);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					isAll = true;
				} else {
					try {
						mCount = mKnownLib.GetFansCount(arg2 - 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					isAll = false;
					KeyData.mFansRows = arg2 - 1;
				}
			}
			if (mType == Value.DeviceType.TYPE_PJT) {
				mCount = 0;
				mCurrentCount = 0;
				if (arg2 == 0) {
					for (int i = 0; i < mRows - 1; i++) {
						try {
							mCount += mKnownLib.GetPJTCount(i);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					isAll = true;
				} else {
					try {
						mCount = mKnownLib.GetPJTCount(arg2 - 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					isAll = false;
					KeyData.mPJTRows = arg2 - 1;
				}
			}
			if (mType == Value.DeviceType.TYPE_AIR) {
				mCount = 0;
				mCurrentCount = 0;
				if (arg2 == 0) {
					for (int i = 0; i < mRows - 1; i++) {
						try {
							mCount += mKnownLib.GetAirCount(i);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					isAll = true;
				} else {
					try {
						mCount = mKnownLib.GetAirCount(arg2 - 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					isAll = false;
					KeyData.mAirRows = arg2 - 1;
				}
			}
			mDeviceCount.setText("(" + String.valueOf(mCount) + ")");
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (mType == Value.DeviceType.TYPE_TV) {
			KeyData.mTVIsKnown = mTmpIsKnown;
		}
		if (mType == Value.DeviceType.TYPE_STB) {
			KeyData.mSTBIsKnown = mTmpIsKnown;
		}
		if (mType == Value.DeviceType.TYPE_DVD) {
			KeyData.mDVDIsKnown = mTmpIsKnown;
		}
		if (mType == Value.DeviceType.TYPE_FANS) {
			KeyData.mFansIsKnown = mTmpIsKnown;
		}
		if (mType == Value.DeviceType.TYPE_PJT) {
			KeyData.mPJTIsKnown = mTmpIsKnown;
		}
		if (mType == Value.DeviceType.TYPE_AIR) {
			KeyData.mAirIsKnown = mTmpIsKnown;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.str_auto:
			if (mThread != null) {
				mThread.cancel();
				mThread = null;
			}
			findViewById(R.id.str_auto).setEnabled(false);
			findViewById(R.id.str_stop).setEnabled(true);
			findViewById(R.id.str_save).setEnabled(false);
			findViewById(R.id.str_up).setEnabled(false);
			findViewById(R.id.str_down).setEnabled(false);
			deviceSp.setEnabled(false);
			typeSp.setEnabled(false);
			mThread = new EffectThread();
			mThread.start();
			break;
		case R.id.str_stop:
			if (mThread != null) {
				mThread.cancel();
				mThread = null;
			}
			findViewById(R.id.str_auto).setEnabled(true);
			findViewById(R.id.str_stop).setEnabled(false);
			findViewById(R.id.str_save).setEnabled(true);
			findViewById(R.id.str_up).setEnabled(true);
			findViewById(R.id.str_down).setEnabled(true);
			deviceSp.setEnabled(true);
			typeSp.setEnabled(true);
			break;
		case R.id.str_save:
			KeyData.mIsStudy = false;
			KeyData.mTV20 = 0xFF;
			KeyData.mTV08 = 0xFF;
			KeyData.mTV10 = 0xFF;
			KeyData.mDVD20 = 0xFF;
			KeyData.mDVD08 = 0xFF;
			KeyData.mDVD10 = 0xFF;
			KeyData.mSTB20 = 0xFF;
			KeyData.mSTB08 = 0xFF;
			KeyData.mSTB10 = 0xFF;
			KeyData.mFans20 = 0xFF;
			KeyData.mFans08 = 0xFF;
			KeyData.mFans10 = 0xFF;
			KeyData.mPJT20 = 0xFF;
			KeyData.mPJT08 = 0xFF;
			KeyData.mPJT10 = 0xFF;
			KeyData.mTVIsKnown = mTmpIsKnown;
			if (mType == Value.DeviceType.TYPE_AIR) {
				AirData.mPower = 0x01;
				KeyData.mAirIsKnown = true;
			}
			if (mType == Value.DeviceType.TYPE_TV) {
				KeyData.mTVIsKnown = true;
			}
			if (mType == Value.DeviceType.TYPE_STB) {
				KeyData.mSTBIsKnown = true;
			}
			if (mType == Value.DeviceType.TYPE_DVD) {
				KeyData.mDVDIsKnown = true;
			}
			if (mType == Value.DeviceType.TYPE_FANS) {
				KeyData.mFansIsKnown = true;
			}
			if (mType == Value.DeviceType.TYPE_PJT) {
				KeyData.mPJTIsKnown = true;
			}
			if (mThread != null) {
				mThread.cancel();
				mThread = null;
			}
			finish();
			break;
		case R.id.str_up:
			if (mType == Value.DeviceType.TYPE_TV) {
				int count;
				try {
					count = mKnownLib.GetTVCount(KeyData.mTVRows);
					if (isAll) {
						if (KeyData.mTVCols < count - 1) {
							KeyData.mTVCols = KeyData.mTVCols + 1;
							mCurrentCount++;
						} else {
							if (KeyData.mTVRows < mKnownLib.GetTV().size()) {
								KeyData.mTVCols = 0;
								KeyData.mTVRows++;
							}
						}
					} else {
						if (KeyData.mTVCols < count - 1) {
							KeyData.mTVCols = KeyData.mTVCols + 1;
							mCurrentCount++;
						}
					}
					KeyData.Write(Value.TV.VOLADD);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();
			}
			if (mType == Value.DeviceType.TYPE_DVD) {
				int count;
				try {
					count = mKnownLib.GetDVDCount(KeyData.mDVDRows);
					if (isAll) {
						if (KeyData.mDVDCols < count - 1) {
							KeyData.mDVDCols = KeyData.mDVDCols + 1;
							mCurrentCount++;
						} else {
							if (KeyData.mDVDRows < mKnownLib.GetDVD().size()) {
								KeyData.mDVDCols = 0;
								KeyData.mDVDRows++;
							}
						}
					} else {
						if (KeyData.mDVDCols < count - 1) {
							KeyData.mDVDCols = KeyData.mDVDCols + 1;
							mCurrentCount++;
						}
					}
					KeyData.Write(Value.DVD.OPEN);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();

			}
			if (mType == Value.DeviceType.TYPE_STB) {
				int count;
				try {
					count = mKnownLib.GetSTBCount(KeyData.mSTBRows);
					if (isAll) {
						if (KeyData.mSTBCols < count - 1) {
							KeyData.mSTBCols = KeyData.mSTBCols + 1;
							mCurrentCount++;
						} else {
							if (KeyData.mSTBRows < mKnownLib.GetSTB().size()) {
								KeyData.mSTBCols = 0;
								KeyData.mSTBRows++;
							}
						}
					} else {
						if (KeyData.mSTBCols < count - 1) {
							KeyData.mSTBCols = KeyData.mSTBCols + 1;
							mCurrentCount++;
						}
					}
					KeyData.Write(Value.STB.VOLADD);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();

			}

			if (mType == Value.DeviceType.TYPE_FANS) {
				int count;
				try {
					count = mKnownLib.GetFansCount(KeyData.mFansRows);
					if (isAll) {
						if (KeyData.mFansCols < count - 1) {
							KeyData.mFansCols = KeyData.mFansCols + 1;
							mCurrentCount++;
						} else {
							if (KeyData.mFansRows < mKnownLib.GetFans().size()) {
								KeyData.mFansCols = 0;
								KeyData.mFansRows++;
							}
						}
					} else {
						if (KeyData.mFansCols < count - 1) {
							KeyData.mFansCols = KeyData.mFansCols + 1;
							mCurrentCount++;
						}
					}
					KeyData.Write(Value.FANS.POWER);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();
			}
			if (mType == Value.DeviceType.TYPE_PJT) {
				int count;
				try {
					count = mKnownLib.GetPJTCount(KeyData.mPJTRows);
					if (isAll) {
						if (KeyData.mPJTCols < count - 1) {
							KeyData.mPJTCols = KeyData.mPJTCols + 1;
							mCurrentCount++;
						} else {
							if (KeyData.mPJTRows < mKnownLib.GetPJT().size()) {
								KeyData.mPJTCols = 0;
								KeyData.mPJTRows++;
							}
						}
					} else {
						if (KeyData.mPJTCols < count - 1) {
							KeyData.mPJTCols = KeyData.mPJTCols + 1;
							mCurrentCount++;
						}
					}
					KeyData.Write(Value.PJT.POWER_OFF);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();
			}
			if (mType == Value.DeviceType.TYPE_AIR) {
				int count;
				try {
					count = mKnownLib.GetAirCount(KeyData.mAirRows);
					if (isAll) {
						if (KeyData.mAirCols < count - 1) {
							KeyData.mAirCols = KeyData.mAirCols + 1;
							mCurrentCount++;
						} else {
							if (KeyData.mAirRows < mKnownLib.GetAIR().size()) {
								KeyData.mAirCols = 0;
								KeyData.mAirRows++;
							}
						}
					} else {
						if (KeyData.mAirCols < count - 1) {
							KeyData.mAirCols = KeyData.mAirCols + 1;
							mCurrentCount++;
						}
					}
					KeyData.Write(Value.AIR.POWER);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();
			}
			break;
		case R.id.str_down:
			if (mType == Value.DeviceType.TYPE_TV) {
				try {
					if (isAll) {
						if (KeyData.mTVCols > 0) {
							KeyData.mTVCols = KeyData.mTVCols - 1;
							mCurrentCount--;
						} else {
							if (KeyData.mTVRows > 0) {
								KeyData.mTVRows--;
								KeyData.mTVCols = mKnownLib
										.GetTVCount(KeyData.mTVRows);
							}
						}
					} else {
						if (KeyData.mTVCols > 0) {
							KeyData.mTVCols = KeyData.mTVCols - 1;
							mCurrentCount--;
						}
					}
					KeyData.Write(Value.TV.VOLADD);
				} catch (Exception e) {
					e.printStackTrace();
				}
				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();
			}
			if (mType == Value.DeviceType.TYPE_DVD) {
				try {
					if (isAll) {
						if (KeyData.mDVDCols > 0) {
							KeyData.mDVDCols = KeyData.mDVDCols - 1;
							mCurrentCount--;
						} else {
							if (KeyData.mDVDRows > 0) {
								KeyData.mDVDRows--;
								KeyData.mDVDCols = mKnownLib
										.GetDVDCount(KeyData.mDVDRows);
							}
						}
					} else {
						if (KeyData.mDVDCols > 0) {
							KeyData.mDVDCols = KeyData.mDVDCols - 1;
							mCurrentCount--;
						}
					}
					KeyData.Write(Value.DVD.POWER);
				} catch (Exception e) {
					e.printStackTrace();
				}
				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();

			}
			if (mType == Value.DeviceType.TYPE_STB) {
				try {
					if (isAll) {
						if (KeyData.mSTBCols > 0) {
							KeyData.mSTBCols = KeyData.mSTBCols - 1;
							mCurrentCount--;
						} else {
							if (KeyData.mSTBRows > 0) {
								KeyData.mSTBRows--;
								KeyData.mSTBCols = mKnownLib
										.GetSTBCount(KeyData.mSTBRows);
							}
						}
					} else {
						if (KeyData.mSTBCols > 0) {
							KeyData.mSTBCols = KeyData.mSTBCols - 1;
							mCurrentCount--;
						}
					}
					KeyData.Write(Value.STB.VOLADD);
				} catch (Exception e) {
					e.printStackTrace();
				}
				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();

			}
			if (mType == Value.DeviceType.TYPE_FANS) {
				try {
					if (isAll) {
						if (KeyData.mFansCols > 0) {
							KeyData.mFansCols = KeyData.mFansCols - 1;
							mCurrentCount--;
						} else {
							if (KeyData.mFansRows > 0) {
								KeyData.mFansRows--;
								KeyData.mFansCols = mKnownLib
										.GetFansCount(KeyData.mFansRows);
							}
						}
					} else {
						if (KeyData.mFansCols > 0) {
							KeyData.mFansCols = KeyData.mFansCols - 1;
							mCurrentCount--;
						}
					}
					KeyData.Write(Value.FANS.POWER);
				} catch (Exception e) {
					e.printStackTrace();
				}
				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();

			}
			if (mType == Value.DeviceType.TYPE_PJT) {
				try {
					if (isAll) {
						if (KeyData.mPJTCols > 0) {
							KeyData.mPJTCols = KeyData.mPJTCols - 1;
							mCurrentCount--;
						} else {
							if (KeyData.mPJTRows > 0) {
								KeyData.mPJTRows--;
								KeyData.mPJTCols = mKnownLib
										.GetPJTCount(KeyData.mPJTRows);
							}
						}
					} else {
						if (KeyData.mPJTCols > 0) {
							KeyData.mPJTCols = KeyData.mPJTCols - 1;
							mCurrentCount--;
						}
					}
					KeyData.Write(Value.PJT.POWER_OFF);
				} catch (Exception e) {
					e.printStackTrace();
				}
				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();
			}
			if (mType == Value.DeviceType.TYPE_AIR) {
				try {
					if (isAll) {
						if (KeyData.mAirCols > 0) {
							KeyData.mAirCols = KeyData.mAirCols - 1;
							mCurrentCount--;
						} else {
							if (KeyData.mAirRows > 0) {
								KeyData.mAirRows--;
								KeyData.mAirCols = mKnownLib
										.GetAirCount(KeyData.mAirRows);
							}
						}
					} else {
						if (KeyData.mAirCols > 0) {
							KeyData.mAirCols = KeyData.mAirCols - 1;
							mCurrentCount--;
						}
					}
					KeyData.Write(Value.AIR.POWER);
				} catch (Exception e) {
					e.printStackTrace();
				}
				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, mCurrentCount,
						-1, null).sendToTarget();
			}
			break;
		}

	}

	private class EffectThread extends Thread {
		private boolean isRun = true;
		private int count = 0;
		private int row = 0;
		private int col = 0;

		public EffectThread() {
			count = 1;
		}

		public void cancel() {
			isRun = false;
		}

		public void run() {
			while (isRun & count < mCount + 1) {
				try {
					if (mType == Value.DeviceType.TYPE_TV) {
						if (isAll) {
							KeyData.mTVRows = row;
							KeyData.mTVCols = col;
							col++;
							int d = mKnownLib.GetTVCount(row);
							if (d == col) {
								col = 0;
								row++;
							}
						} else {
							KeyData.mTVCols = count - 1;
						}
						KeyData.Write(Value.TV.VOLADD);
					}
					if (mType == Value.DeviceType.TYPE_DVD) {
						if (isAll) {
							KeyData.mDVDRows = row;
							KeyData.mDVDCols = col;
							col++;
							int d = mKnownLib.GetDVDCount(row);
							if (d == col) {
								col = 0;
								row++;
							}
						} else {
							KeyData.mDVDCols = count - 1;
						}
						KeyData.Write(Value.DVD.OPEN);

					}
					if (mType == Value.DeviceType.TYPE_STB) {
						if (isAll) {
							KeyData.mSTBRows = row;
							KeyData.mSTBCols = col;
							col++;
							int d = mKnownLib.GetSTBCount(row);
							if (d == col) {
								col = 0;
								row++;
							}
						} else {
							KeyData.mSTBCols = count - 1;
						}
						KeyData.Write(Value.STB.VOLADD);

					}
					if (mType == Value.DeviceType.TYPE_FANS) {
						if (isAll) {
							KeyData.mFansRows = row;
							KeyData.mFansCols = col;
							col++;
							int d = mKnownLib.GetFansCount(row);
							if (d == col) {
								col = 0;
								row++;
							}
						} else {
							KeyData.mFansCols = count - 1;
						}
						KeyData.Write(Value.FANS.POWER);
					}
					if (mType == Value.DeviceType.TYPE_PJT) {
						if (isAll) {
							KeyData.mPJTRows = row;
							KeyData.mPJTCols = col;
							col++;
							int d = mKnownLib.GetPJTCount(row);
							if (d == col) {
								col = 0;
								row++;
							}
						} else {
							KeyData.mPJTCols = count - 1;
						}
						KeyData.Write(Value.PJT.POWER_ON);
					}
					if (mType == Value.DeviceType.TYPE_AIR) {
						if (isAll) {
							KeyData.mAirRows = row;
							KeyData.mAirCols = col;
							col++;
							int d = mKnownLib.GetAirCount(row);
							if (d == col) {
								col = 0;
								row++;
							}
						} else {
							KeyData.mAirCols = count - 1;
						}
						AirData.mPower = 0x00;
						KeyData.Write(Value.AIR.POWER);
					}
					mCurrentCount = count;
				} catch (Exception e) {
					e.printStackTrace();
				}
				mHandler.obtainMessage(R.id.MESSAGE_REMAINCOUNT, count, -1,
						null).sendToTarget();
				count++;
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private final Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case R.id.MESSAGE_REMAINCOUNT:
				mRemainCount.setTextSize(60);
				mRemainCount.setText(String.valueOf(msg.arg1));
				spark();
				break;
			}
		}
	};

	private void spark() {
		final Timer timer = new Timer();
		TimerTask taskcc = new TimerTask() {
			public void run() {
				runOnUiThread(new Runnable() {
					public void run() {
						if (mI == 6) {
							mI = 0;
							timer.cancel();
							return;
						}
						if (mI % 2 == 0) {
							findViewById(R.id.textSend).setBackgroundResource(
									R.drawable.send_open);
						} else {
							findViewById(R.id.textSend).setBackgroundResource(
									R.drawable.send_close);
						}
						mI++;
					}
				});
			}
		};
		timer.schedule(taskcc, 1, 100);
	}
}
