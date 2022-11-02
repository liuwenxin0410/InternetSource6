package et.song.ctrl;

import et.song.data.AirData;
import et.song.data.KeyData;
import et.song.value.Value;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class AirActivity extends Activity implements OnClickListener {
	private int mKey;
	private String mMode;
	private String mWindCount;
	private String mWindDir;
	private int mTmp;

	// private boolean mIsOpen = false;
	// private boolean mIsOther = false;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_air);

		DisplayMetrics dm = new DisplayMetrics();
		Display display = getWindowManager().getDefaultDisplay();
		display.getMetrics(dm);
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;

		Button air_power = (Button) findViewById(R.id.air_power);
		air_power.setOnClickListener(this);
		air_power.setWidth((screenWidth) / 3);
		air_power.setHeight((screenHeight) / 10);
		air_power.getBackground().setAlpha(50);

		Button air_mode = (Button) findViewById(R.id.air_mode);
		air_mode.setOnClickListener(this);
		air_mode.setWidth((screenWidth) / 3);
		air_mode.setHeight((screenHeight) / 10);
		air_mode.getBackground().setAlpha(50);

		Button air_tempadd = (Button) findViewById(R.id.air_tempadd);
		air_tempadd.setOnClickListener(this);
		air_tempadd.setWidth((screenWidth) / 3);
		air_tempadd.setHeight((screenHeight) / 10);
		air_tempadd.getBackground().setAlpha(50);

		Button air_tempsub = (Button) findViewById(R.id.air_tempsub);
		air_tempsub.setOnClickListener(this);
		air_tempsub.setWidth((screenWidth) / 3);
		air_tempsub.setHeight((screenHeight) / 10);
		air_tempsub.getBackground().setAlpha(50);

		Button air_wind_auto_dir = (Button) findViewById(R.id.air_wind_auto_dir);
		air_wind_auto_dir.setOnClickListener(this);
		air_wind_auto_dir.setWidth((screenWidth) / 3);
		air_wind_auto_dir.setHeight((screenHeight) / 10);
		air_wind_auto_dir.getBackground().setAlpha(50);

		Button air_wind_count = (Button) findViewById(R.id.air_wind_count);
		air_wind_count.setOnClickListener(this);
		air_wind_count.setWidth((screenWidth) / 3);
		air_wind_count.setHeight((screenHeight) / 10);
		air_wind_count.getBackground().setAlpha(50);

		Button air_wind_dir = (Button) findViewById(R.id.air_wind_dir);
		air_wind_dir.setOnClickListener(this);
		air_wind_dir.setWidth((screenWidth) / 3);
		air_wind_dir.setHeight((screenHeight) / 10);
		air_wind_dir.getBackground().setAlpha(50);

		// mShow = (TextView)findViewById(R.id.text_show);
		// mText.setText("·Ö±æÂÊ:" + dm.widthPixels + "X" + dm.heightPixels);
		mTmp = AirData.mTmp;
		if (mTmp > 0x1E) {
			mTmp = 0x1E;
		}
		if (mTmp < 0x10) {
			mTmp = 0x10;
		}
		
		// if (AirData.mWindAutoDir == 0x00)
		// {
		// findViewById(R.id.air_wind_dir).setEnabled(true);
		// }
		// else
		// {
		// findViewById(R.id.air_wind_dir).setEnabled(false);
		// }
	}
	@Override
	public void onStart()
	{
		super.onStart();
		RadioButton study_radio = (RadioButton) findViewById(R.id.radioStudy);
		study_radio.setOnClickListener(this);
		RadioButton known_radio = (RadioButton) findViewById(R.id.radioKnown);
		known_radio.setOnClickListener(this);
		if (KeyData.mAirIsKnown) {
			known_radio.setChecked(true);
		} else {
			study_radio.setChecked(true);
		}
		if (AirData.mPower == 0x01) {
			mMode = getString(R.string.air_mode_val);
			if (AirData.mMode == 0x01) {
				mMode += getString(R.string.air_mode_value_1);
			}
			if (AirData.mMode == 0x02) {
				mMode += getString(R.string.air_mode_value_2);
			}
			if (AirData.mMode == 0x03) {
				mMode += getString(R.string.air_mode_value_3);
			}
			if (AirData.mMode == 0x04) {
				mMode += getString(R.string.air_mode_value_4);
			}
			if (AirData.mMode == 0x05) {
				mMode += getString(R.string.air_mode_value_5);
			}
			// mMsg += getString(R.string.air_temp_val);
			mWindDir = getString(R.string.air_wind_dir_val);
			if (AirData.mWindAutoDir == 0x01) {
				mWindDir += getString(R.string.air_wind_dir_value_4);

			} else {
				if (AirData.mWindDir == 0x01) {
					mWindDir += getString(R.string.air_wind_dir_value_1);
				}
				if (AirData.mWindDir == 0x02) {
					mWindDir += getString(R.string.air_wind_dir_value_2);
				}
				if (AirData.mWindDir == 0x03) {
					mWindDir += getString(R.string.air_wind_dir_value_3);
				}
			}
			mWindCount = getString(R.string.air_wind_val);
			if (AirData.mWindCount == 0x01) {
				mWindCount += getString(R.string.air_wind_count_value_1);
			}
			if (AirData.mWindCount == 0x02) {
				mWindCount += getString(R.string.air_wind_count_value_2);
			}
			if (AirData.mWindCount == 0x03) {
				mWindCount += getString(R.string.air_wind_count_value_3);
			}
			if (AirData.mWindCount == 0x04) {
				mWindCount += getString(R.string.air_wind_count_value_4);
			}
			((TextView) findViewById(R.id.text_show)).setText(String
					.valueOf(mTmp) + getString(R.string.d));
			((TextView) findViewById(R.id.text_mode)).setText(mMode);
			((TextView) findViewById(R.id.text_wind_dir)).setText(mWindDir);
			((TextView) findViewById(R.id.text_wind_count)).setText(mWindCount);
		} else {
			((TextView) findViewById(R.id.text_show)).setText("");
			((TextView) findViewById(R.id.text_mode))
					.setText(getString(R.string.air_mode_val));
			((TextView) findViewById(R.id.text_wind_dir))
					.setText(getString(R.string.air_wind_dir_val));
			((TextView) findViewById(R.id.text_wind_count))
					.setText(getString(R.string.air_wind_val));
		}
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (KeyData.mIsStudy == true) {
				KeyData.mIsStudy = false;
				Toast.makeText(getApplicationContext(),
						getString(R.string.study_exit), Toast.LENGTH_SHORT)
						.show();
				return true;
			}
			if (event.isLongPress()) {
				openOptionsMenu();
				return true;
			}
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(AirData.mPower == 0x00 && v.getId() != R.id.air_power)
		{
			return;
		}
		switch (v.getId()) {
		case R.id.radioStudy:
			KeyData.mAirIsKnown = false;
			mKey = 0;
			break;
		case R.id.radioKnown:
			KeyData.mAirIsKnown = true;
			mKey = 0;
			break;
		case R.id.air_mode:
			mKey = Value.AIR.MODE;
			// mIsOther = true;
			break;
		case R.id.air_power:
			mKey = Value.AIR.POWER;
			break;
		case R.id.air_tempadd:
			mKey = Value.AIR.TEMPADD;
			mTmp = AirData.mTmp > 0x1D ? 0x1E : AirData.mTmp + 1;
			// mIsOther = true;
			// mText.setText(getString(R.string.air_temp_val) + mTmp);
			break;
		case R.id.air_tempsub:
			mKey = Value.AIR.TEMPSUB;
			mTmp = AirData.mTmp < 0x11 ? 0x10 : AirData.mTmp - 1;
			// mIsOther = true;
			// mText.setText(getString(R.string.air_temp_val) + mTmp);
			break;
		case R.id.air_wind_auto_dir:
			mKey = Value.AIR.WIND_AUTO_DIR;
			// AirData.mWindAutoDir = 0x01;
			// if (AirData.mWindAutoDir == 0x01)
			// {
			// findViewById(R.id.air_wind_dir).setEnabled(true);
			// }
			// else
			// {
			// findViewById(R.id.air_wind_dir).setEnabled(false);
			// }
			// mIsOther = true;
			break;
		case R.id.air_wind_count:
			mKey = Value.AIR.WIND_COUNT;
			// mIsOther = true;
			break;
		case R.id.air_wind_dir:
			mKey = Value.AIR.WIND_DIR;
			// AirData.mWindAutoDir = 0x00;
			// mIsOther = true;
			break;
		}
		if (mKey != 0) {
			try {
				KeyData.Write(mKey);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mMode = null;
			mWindCount = null;
			mWindDir = null;
			mMode = getString(R.string.air_mode_val);
			if (AirData.mMode == 0x01) {
				mMode += getString(R.string.air_mode_value_1);
			}
			if (AirData.mMode == 0x02) {
				mMode += getString(R.string.air_mode_value_2);
			}
			if (AirData.mMode == 0x03) {
				mMode += getString(R.string.air_mode_value_3);
			}
			if (AirData.mMode == 0x04) {
				mMode += getString(R.string.air_mode_value_4);
			}
			if (AirData.mMode == 0x05) {
				mMode += getString(R.string.air_mode_value_5);
			}
			// mMsg += getString(R.string.air_temp_val);
			mWindDir = getString(R.string.air_wind_dir_val);
			if (AirData.mWindAutoDir == 0x01) {
				mWindDir += getString(R.string.air_wind_dir_value_4);

			} else {
				if (AirData.mWindDir == 0x01) {
					mWindDir += getString(R.string.air_wind_dir_value_1);
				}
				if (AirData.mWindDir == 0x02) {
					mWindDir += getString(R.string.air_wind_dir_value_2);
				}
				if (AirData.mWindDir == 0x03) {
					mWindDir += getString(R.string.air_wind_dir_value_3);
				}
			}
			mWindCount = getString(R.string.air_wind_val);
			if (AirData.mWindCount == 0x01) {
				mWindCount += getString(R.string.air_wind_count_value_1);
			}
			if (AirData.mWindCount == 0x02) {
				mWindCount += getString(R.string.air_wind_count_value_2);
			}
			if (AirData.mWindCount == 0x03) {
				mWindCount += getString(R.string.air_wind_count_value_3);
			}
			if (AirData.mWindCount == 0x04) {
				mWindCount += getString(R.string.air_wind_count_value_4);
			}
			if (AirData.mPower == 0x01) {
				((TextView) findViewById(R.id.text_show)).setText(String
						.valueOf(mTmp) + getString(R.string.d));
				((TextView) findViewById(R.id.text_mode)).setText(mMode);
				((TextView) findViewById(R.id.text_wind_dir)).setText(mWindDir);
				((TextView) findViewById(R.id.text_wind_count))
						.setText(mWindCount);
			}
			// else if (mIsOpen)
			// {
			// ((TextView)findViewById(R.id.text_show)).setText(String.valueOf(mTmp)
			// + getString(R.string.d));
			// }
			else {
				((TextView) findViewById(R.id.text_show)).setText("");
				((TextView) findViewById(R.id.text_mode))
						.setText(getString(R.string.air_mode_val));
				((TextView) findViewById(R.id.text_wind_dir))
						.setText(getString(R.string.air_wind_dir_val));
				((TextView) findViewById(R.id.text_wind_count))
						.setText(getString(R.string.air_wind_val));
				// mIsOther = false
			}
		}
	}
}