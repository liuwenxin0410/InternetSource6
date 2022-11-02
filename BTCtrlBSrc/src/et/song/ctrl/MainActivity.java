package et.song.ctrl;

//import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import et.song.bt.BT;
//import et.song.bt.ClsUtils;
import et.song.c.C;
import et.song.data.DB;
import et.song.data.KeyData;
import et.song.tool.Tools;

import android.os.Bundle;
//import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
//import android.content.BroadcastReceiver;
//import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
//import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends TabActivity implements OnTouchListener,
		OnGestureListener {
	private static final int FLING_MIN_DISTANCE = 20;
	private static final int FLING_MIN_VELOCITY = 0;
	private static final String libSoName = "C";
	private TabHost tabHost;
	private HorizontalScrollView mHs;
	private GestureDetector mGestureDetector;
	private BluetoothAdapter mBtAdapter;
	private Dialog mDialogStudy = null;
	private String mAddress = null;
	private BT mBT = null;
	private DB mDB = null;
	// private boolean mIsExit = false;
	private int mI = 0;
	private byte[] mBuf;
	private byte[] mReadBuf = new byte[112];
	static {
		System.loadLibrary(libSoName);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mGestureDetector = new GestureDetector(this);
		LinearLayout line = (LinearLayout) findViewById(R.id.line);
		line.setOnTouchListener(this);
		line.setLongClickable(true);
		mHs = (HorizontalScrollView) findViewById(R.id.hs);
		// if (Environment.getExternalStorageState().equals(
		// Environment.MEDIA_MOUNTED)) {
		// File sd = Environment.getExternalStorageDirectory();
		// String path = sd.getPath() + "/BTCtrl";
		// File dirHouse = new File(path);
		// if (!dirHouse.exists()) {
		// dirHouse.mkdir();
		// }
		// mDB = new DB(getApplicationContext(), dirHouse.getPath() + "/");
		//Log.i("ET",  getApplicationContext().getFilesDir().getPath());
		mDB = new DB(getApplicationContext(), getApplicationContext().getFilesDir().getPath());
		mDB.Open();
		Load();
		// }
		mBtAdapter = BluetoothAdapter.getDefaultAdapter();
		if (mBtAdapter == null) {
			finish();
			return;
		}
		Resources res = getResources();
		tabHost = getTabHost();
		TabHost.TabSpec spec;
		tabHost.setup();
		Intent intent;
		intent = new Intent().setClass(this, TVActivity.class);
		spec = tabHost
				.newTabSpec(this.getString(R.string.tv))
				.setIndicator(this.getString(R.string.str_tv))//res.getDrawable(R.drawable.ic_tab_tv)
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, STBActivity.class);
		spec = tabHost
				.newTabSpec(this.getString(R.string.stb))
				.setIndicator(this.getString(R.string.str_stb))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, DVDActivity.class);
		spec = tabHost
				.newTabSpec(this.getString(R.string.dvd))
				.setIndicator(this.getString(R.string.str_dvd))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, PJTActivity.class);
		spec = tabHost
				.newTabSpec(this.getString(R.string.pjt))
				.setIndicator(this.getString(R.string.str_pjt))
				.setContent(intent);
		tabHost.addTab(spec);
		intent = new Intent().setClass(this, AirActivity.class);
		spec = tabHost
				.newTabSpec(this.getString(R.string.air))
				.setIndicator(this.getString(R.string.str_air))
				.setContent(intent);
		tabHost.addTab(spec);		
		
		intent = new Intent().setClass(this, FansActivity.class);
		spec = tabHost
				.newTabSpec(this.getString(R.string.fans))
				.setIndicator(this.getString(R.string.str_fans))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, LightActivity.class);
		spec = tabHost
				.newTabSpec(this.getString(R.string.light))
				.setIndicator(this.getString(R.string.str_light))
				.setContent(intent);
		tabHost.addTab(spec);
		

		
		tabHost.setCurrentTab(0);
		TabWidget tabWidget = tabHost.getTabWidget();
		int count = tabWidget.getChildCount();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;
		if (count > 4) {
			for (int i = 0; i < count; i++) {
				tabWidget.getChildTabViewAt(i).setMinimumWidth(screenWidth / 4);
			}
		}
		for (int i = 0; i < tabWidget.getChildCount(); i++) {
			tabWidget.getChildAt(i).getLayoutParams().height = (screenHeight) / 18;
			tabWidget.getChildAt(i).getLayoutParams().width = screenWidth / 4;
		}
		// String ACTION_PAIRING_REQUEST =
		// "android.bluetooth.device.action.PAIRING_REQUEST";
		// IntentFilter intent_bt = new IntentFilter();
		// intent_bt.addAction(ACTION_PAIRING_REQUEST);
		// registerReceiver(mReceiver, intent_bt);
		// String address = "00:15:83:88:00:4C";
		// Intent aa = new Intent();
		// aa.putExtra(DeviceActivity.EXTRA_DEVICE_ADDRESS, address);
		// setResult(Activity.RESULT_OK, aa);
		// startActivityForResult(aa, R.id.REQUEST_CONNECT_DEVICE);
	}

	@Override
	public void onStart() {
		super.onStart();
		if (!mBtAdapter.isEnabled()) {
			Intent enableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, R.id.REQUEST_ENABLE_BT);
		} else {
			if (mBT == null) {
				mBT = BT.getInstance();
				mBT.setContext(this);
				mBT.setHandler(mHandler);
				if (mAddress != null) {
					if (mAddress.length() > 0 && !mAddress.equals("null")) {
						BluetoothDevice device = this.mBtAdapter
								.getRemoteDevice(mAddress);
						try {
							if (mBT.getState() == BT.STATE_NONE
									|| mBT.getState() == BT.STATE_LISTEN) {
								mBT.connect(device);
							}
						} catch (Exception ex) {

						}
					}
				}
			}
		}

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// mIsExit = true;
		if (mBT != null) {
			mBT.stop();
		}
		Save();
		mDB.close();
		// this.unregisterReceiver(mReceiver);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// MenuInflater inflater = getMenuInflater();
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.scan:
			Intent serverIntent = new Intent(this, DeviceActivity.class);
			startActivityForResult(serverIntent, R.id.REQUEST_CONNECT_DEVICE);
			return true;
			// case R.id.discoverable:
			// if (mBtAdapter.getScanMode() !=
			// BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
			// Intent discoverableIntent = new Intent(
			// BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			// discoverableIntent.putExtra(
			// BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
			// startActivity(discoverableIntent);
			// }
			// return true;
		case R.id.help:
			Intent helpIntent = new Intent(this, HelpActivity.class);
			startActivity(helpIntent);
			return true;
		case R.id.study:
			KeyData.mIsStudy = true;
			Toast toast = Toast.makeText(getApplicationContext(), R.string.study_alert,
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
			toast.show();
			return true;
		case R.id.options:
			KeyData.mIsStudy = false;
			Intent optionsIntent = new Intent(this, OptionActivity.class);
			startActivityForResult(optionsIntent, R.id.REQUEST_OPTIONS);
			return true;
		case R.id.about:
			Dialog dialog = new Dialog(this);
			Window window = dialog.getWindow();
			window.setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
					WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
			dialog.setContentView(R.layout.dialog_about);
			dialog.setTitle(R.string.title_about);
			dialog.show();
			return true;
		case R.id.quit:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(getString(R.string.str_title));
			builder.setMessage(getString(R.string.str_message));
			builder.setPositiveButton(getString(R.string.str_ok),
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							finish();
						}
					});
			builder.setNeutralButton(getString(R.string.str_back),
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
			builder.show();
			return true;
		}
		return false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (event.isLongPress()) {
				openOptionsMenu();
				return true;
			}
			if (KeyData.mIsStudy == true)
			{
				KeyData.mIsStudy = false;
				Toast.makeText(getApplicationContext(),
						getString(R.string.study_exit),
						Toast.LENGTH_SHORT).show();
			}
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}

	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case R.id.REQUEST_CONNECT_DEVICE:
			if (resultCode == Activity.RESULT_OK) {
				mAddress = data.getExtras().getString(
						DeviceActivity.EXTRA_DEVICE_ADDRESS);
				if (mAddress == null)
					break;
				try {
					BluetoothDevice device = this.mBtAdapter
							.getRemoteDevice(mAddress);
					mBT = BT.getInstance();
					mBT.setContext(this);
					mBT.setHandler(mHandler);
					// if (mBT.getState() == BT.STATE_NONE
					// || mBT.getState() == BT.STATE_LISTEN) {
					mBT.connect(device);
					// }
				} catch (Exception ex) {

				}
			}
			break;
		case R.id.REQUEST_ENABLE_BT:
			if (resultCode == Activity.RESULT_OK) {
				// if (mBT == null) {
				// mBT = BT.getInstance();
				// mBT.setContext(this);
				// mBT.setHandler(mHandler);
				// }
			} else {
				Toast.makeText(this, R.string.bt_error, Toast.LENGTH_SHORT)
						.show();
				finish();
			}
			break;
		case R.id.REQUEST_OPTIONS:
			break;
		}

	}

	private final Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case R.id.MESSAGE_STATE_CHANGE:
				switch (msg.arg1) {
				case BT.STATE_CONNECTED:
					findViewById(R.id.textLink).setBackgroundResource(R.drawable.link_open);
					Toast.makeText(getApplicationContext(),
							getString(R.string.bt_connected),
							Toast.LENGTH_SHORT).show();
					break;
				case BT.STATE_CONNECTING:
					Toast.makeText(getApplicationContext(),
							getString(R.string.bt_connecting),
							Toast.LENGTH_SHORT).show();
					break;
				case BT.STATE_LISTEN:
					break;
				case BT.STATE_NONE:
					break;
				}
				break;
			case R.id.MESSAGE_WRITE:
				mBuf = (byte[]) msg.obj;
//				 String writeMessage;
//				 writeMessage = Tools.bytesToHexString(mBuf);
//				 Toast.makeText(getApplicationContext(), writeMessage,
//				 Toast.LENGTH_SHORT).show();
				spark();
				if (KeyData.mIsStudy) {
					mDialogStudy = new Dialog(MainActivity.this);
					delayDialog(10000, mDialogStudy);
					Window window = mDialogStudy.getWindow();
					window.setFlags(
							WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
							WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
					mDialogStudy.setContentView(R.layout.dialog_studying);
					mDialogStudy.setTitle(R.string.title_studying);
					mDialogStudy.show();
				}
				break;
			case R.id.MESSAGE_READ:
				mBuf = (byte[]) msg.obj;
//				 String readMessage;
//				 readMessage = Tools.bytesToHexString(mBuf);
//				 Toast.makeText(getApplicationContext(), readMessage,
//				 Toast.LENGTH_SHORT).show();
				if (mBuf[0] != 0x00) {
					break;
				}
				if (mBuf[1] == 0x00 && mBuf[2] == 0x00) {
					break;
				}
				for (int i = 0; i < 110; i++) {
					mReadBuf[i] = mBuf[i];
				}
				mReadBuf[110] = 0x00;
				mReadBuf[111] = 0x00;
				if (KeyData.mIsStudy) {
					if (mDialogStudy != null)
					{
						mDialogStudy.dismiss();
					}
					KeyData.Add(C.GetKeyCode(mReadBuf).clone());
					Save();
					Intent serverIntent = new Intent(MainActivity.this,
							StudyActivity.class);
					startActivityForResult(serverIntent,
							R.id.REQUEST_CONNECT_DEVICE);
				}
				break;
			case R.id.MESSAGE_TOAST:
				Toast.makeText(getApplicationContext(),
						msg.getData().getString(getString(R.string.toast)),
						Toast.LENGTH_SHORT).show();
				findViewById(R.id.textLink).setBackgroundResource(R.drawable.link_close);
				// if (!mIsExit)
				// {
				// if (mAddress != null) {
				// if (mAddress.length() > 0 && !mAddress.equals("null")) {
				// BluetoothDevice device = mBtAdapter
				// .getRemoteDevice(mAddress);
				// try {
				// if (mBT.getState() == BT.STATE_LISTEN) {
				// mBT.stop();
				// mBT.connect(device);
				// }
				// } catch (Exception ex) {
				//
				// }
				// }
				// }
				// }
				break;
			}
		}
	};

	private void delayDialog(long _time, final Dialog _dialog) {
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				if (_dialog != null && _dialog.isShowing()) {
					KeyData.mIsStudy = false;
					_dialog.dismiss();
				}
			}
		}, _time);
	}

	public void spark() {
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

	// private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
	// @Override
	// public void onReceive(Context context, Intent intent) {
	//
	// if (intent.getAction().equals(
	// "android.bluetooth.device.action.PAIRING_REQUEST")) {
	// BluetoothDevice btDevice = intent
	// .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	//
	// try {
	// byte[] pwd = new byte[] { '1', '2', '3', '4' };
	// ClsUtils.setPin(btDevice.getClass(), btDevice, pwd); // 手机和蓝牙采集器配对
	// // ClsUtils.createBond(btDevice.getClass(), btDevice);
	// // ClsUtils.pair(btDevice.getAddress(), "1234");
	// ClsUtils.cancelPairingUserInput(btDevice.getClass(),
	// btDevice);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	// };
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		int total = tabHost.getTabWidget().getChildCount();
		int current = tabHost.getCurrentTab();
		// TODO Auto-generated method stub
		if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
				&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
			if (current + 1 > total) {
				current = total - 1;
			} 
			else {
				current = current + 1;
			}
			tabHost.setCurrentTab(current);
			if (current % 4 != 0 || current == 0) {
				mHs.scrollTo(tabHost.getTabWidget().getChildTabViewAt(current - (current % 4))
						.getLeft(), mHs.getHeight());
			} else {
				mHs.scrollTo(tabHost.getTabWidget().getChildTabViewAt(current)
						.getLeft(), mHs.getHeight());
			}

		} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
				&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
			if (current - 1 < 0) {
				current = 0;
			} else {
				current = current - 1;
			}
			tabHost.setCurrentTab(current);
			mHs.scrollTo(tabHost.getTabWidget().getChildTabViewAt(current)
					.getLeft(), mHs.getHeight());
		}
		return false;
	}

	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return mGestureDetector.onTouchEvent(arg1);
	}

	public void Save() {
		String sql = "update addressTable set mAddress = '" + mAddress
				+ "'  where _id = (select _id from addressTable limit 1)";
		mDB.EXE(sql);
		KeyData.Save(mDB);
	}

	public void Load() {
		String sql;
		sql = "select * from addressTable";
		Cursor cursor = mDB.Query(sql);
		if (cursor.moveToFirst() == true) {
			if (cursor.getString(1).length() > 0) {
				mAddress = cursor.getString(1);
			}
		} else {
			sql = "insert into addressTable(mAddress) values('')";
			mDB.EXE(sql);
		}
		cursor.close();
		sql = "select * from stateTable";
		cursor = mDB.Query(sql);
		if (cursor.moveToFirst() == true) {
			KeyData.mIsStudy = Boolean.valueOf(cursor.getString(cursor
					.getColumnIndex("mIsStudy")));
			KeyData.mTVIsKnown = Boolean.valueOf(cursor.getString(cursor
					.getColumnIndex("mTVIsKnown")));
			KeyData.mTVRows = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mTVRows")));
			KeyData.mTVCols = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mTVCols")));
			KeyData.mSTBIsKnown = Boolean.valueOf(cursor.getString(cursor
					.getColumnIndex("mSTBIsKnown")));
			KeyData.mSTBRows = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mSTBRows")));
			KeyData.mSTBCols = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mSTBCols")));
			KeyData.mDVDIsKnown = Boolean.valueOf(cursor.getString(cursor
					.getColumnIndex("mDVDIsKnown")));
			KeyData.mDVDRows = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mDVDRows")));
			KeyData.mDVDCols = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mDVDCols")));
			KeyData.mFansIsKnown = Boolean.valueOf(cursor.getString(cursor
					.getColumnIndex("mFansIsKnown")));
			KeyData.mFansRows = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mFansRows")));
			KeyData.mFansCols = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mFansCols")));
			KeyData.mPJTIsKnown = Boolean.valueOf(cursor.getString(cursor
					.getColumnIndex("mPJTIsKnown")));
			KeyData.mPJTRows = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mPJTRows")));
			KeyData.mPJTCols = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mPJTCols")));			
			KeyData.mLightIsKnown = Boolean.valueOf(cursor.getString(cursor
					.getColumnIndex("mLightIsKnown")));
			KeyData.mAirIsKnown = Boolean.valueOf(cursor.getString(cursor
					.getColumnIndex("mAirIsKnown")));
			KeyData.mAirRows = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mAirRows")));
			KeyData.mAirCols = Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("mAirCols")));
		} else {
			sql = "insert into stateTable("
					+ "mIsStudy, "
					+ "mTVIsKnown, "
					+ "mTVRows, "
					+ "mTVCols, "
					+ "mSTBIsKnown, "
					+ "mSTBRows, "
					+ "mSTBCols, "
					+ "mDVDIsKnown, "
					+ "mDVDRows, "
					+ "mDVDCols, "
					+ "mFansIsKnown, "
					+ "mFansRows, "
					+ "mFansCols, "
					+ "mPJTIsKnown, "
					+ "mPJTRows, "
					+ "mPJTCols, "
					+ "mLightIsKnown, "
					+ "mAirIsKnown, "
					+ "mAirRows, "
					+ "mAirCols"
					+ ") values('false', 'true', '0', '0', 'true', '0', '0', 'true', '0', '0', 'true', '0', '0', 'true', '0', '0', 'false', 'true', '0', '0')";
			mDB.EXE(sql);
			KeyData.mTVIsKnown = true;
			KeyData.mSTBIsKnown = true;
			KeyData.mDVDIsKnown = true;
			KeyData.mFansIsKnown = true;
			KeyData.mPJTIsKnown = true;
			KeyData.mAirIsKnown = true;
		}
		cursor.close();
		sql = "select * from studyTable";
		cursor = mDB.Query(sql);
		while (cursor.moveToNext()) {
			KeyData.Add(cursor.getString(1),
					Tools.hexStringToBytes(cursor.getString(2)));
		}
		cursor.close();
	}
}
