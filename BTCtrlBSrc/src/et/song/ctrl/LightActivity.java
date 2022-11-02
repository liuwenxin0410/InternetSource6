package et.song.ctrl;

import et.song.data.KeyData;
import et.song.value.Value;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class LightActivity extends Activity implements OnClickListener {
	private int mKey;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_light);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;
		
		Button light_power_all_on = (Button) findViewById(R.id.light_power_all_on);
		light_power_all_on.setOnClickListener(this);
		light_power_all_on.setWidth((screenWidth) / 4);
		light_power_all_on.setHeight((screenHeight) / 10);
		light_power_all_on.getBackground().setAlpha(50);
		
		Button light_power_all_off = (Button) findViewById(R.id.light_power_all_off);
		light_power_all_off.setOnClickListener(this);
		light_power_all_off.setWidth((screenWidth) / 4);
		light_power_all_off.setHeight((screenHeight) / 10);
		light_power_all_off.getBackground().setAlpha(50);
		
		Button light_power_on = (Button) findViewById(R.id.light_power_on);
		light_power_on.setOnClickListener(this);
		light_power_on.setWidth((screenWidth) / 4);
		light_power_on.setHeight((screenHeight) / 10);
		light_power_on.getBackground().setAlpha(50);
		
		Button light_power_off = (Button) findViewById(R.id.light_power_off);
		light_power_off.setOnClickListener(this);
		light_power_off.setWidth((screenWidth) / 4);
		light_power_off.setHeight((screenHeight) / 10);
		light_power_off.getBackground().setAlpha(50);
		
		Button light_light = (Button) findViewById(R.id.light_light);
		light_light.setOnClickListener(this);
		light_light.setWidth((screenWidth) / 4);
		light_light.setHeight((screenHeight) / 10);
		light_light.getBackground().setAlpha(50);
		
		Button light_dark = (Button) findViewById(R.id.light_dark);
		light_dark.setOnClickListener(this);
		light_dark.setWidth((screenWidth) / 4);
		light_dark.setHeight((screenHeight) / 10);
		light_dark.getBackground().setAlpha(50);
		
		Button light_lost = (Button) findViewById(R.id.light_lost);
		light_lost.setOnClickListener(this);
		light_lost.setWidth((screenWidth) / 4);
		light_lost.setHeight((screenHeight) / 10);
		light_lost.getBackground().setAlpha(50);
		
		Button light_study = (Button) findViewById(R.id.light_study);
		light_study.setOnClickListener(this);
		light_study.setWidth((screenWidth) / 4);
		light_study.setHeight((screenHeight) / 10);
		light_study.getBackground().setAlpha(50);
		
		Button light_keyA = (Button) findViewById(R.id.light_keyA);
		light_keyA.setOnClickListener(this);
		light_keyA.setWidth((screenWidth) / 4);
		light_keyA.setHeight((screenHeight) / 10);
		light_keyA.getBackground().setAlpha(50);
		
		Button light_keyB = (Button) findViewById(R.id.light_keyB);
		light_keyB.setOnClickListener(this);
		light_keyB.setWidth((screenWidth) / 4);
		light_keyB.setHeight((screenHeight) / 10);
		light_keyB.getBackground().setAlpha(50);
		
		Button light_keyC = (Button) findViewById(R.id.light_keyC);
		light_keyC.setOnClickListener(this);
		light_keyC.setWidth((screenWidth) / 4);
		light_keyC.setHeight((screenHeight) / 10);
		light_keyC.getBackground().setAlpha(50);
		
		Button light_keyD = (Button) findViewById(R.id.light_keyD);
		light_keyD.setOnClickListener(this);
		light_keyD.setWidth((screenWidth) / 4);
		light_keyD.setHeight((screenHeight) / 10);
		light_keyD.getBackground().setAlpha(50);
		
		Button light_key1 = (Button) findViewById(R.id.light_key1);
		light_key1.setOnClickListener(this);
		light_key1.setWidth((screenWidth) / 4);
		light_key1.setHeight((screenHeight) / 10);
		light_key1.getBackground().setAlpha(50);
		
		Button light_key2 = (Button) findViewById(R.id.light_key2);
		light_key2.setOnClickListener(this);
		light_key2.setWidth((screenWidth) / 4);
		light_key2.setHeight((screenHeight) / 10);
		light_key2.getBackground().setAlpha(50);
		
		Button light_key3 = (Button) findViewById(R.id.light_key3);
		light_key3.setOnClickListener(this);
		light_key3.setWidth((screenWidth) / 4);
		light_key3.setHeight((screenHeight) / 10);
		light_key3.getBackground().setAlpha(50);
		
		Button light_key4 = (Button) findViewById(R.id.light_key4);
		light_key4.setOnClickListener(this);
		light_key4.setWidth((screenWidth) / 4);
		light_key4.setHeight((screenHeight) / 10);
		light_key4.getBackground().setAlpha(50);
		
		Button light_key5 = (Button) findViewById(R.id.light_key5);
		light_key5.setOnClickListener(this);
		light_key5.setWidth((screenWidth) / 4);
		light_key5.setHeight((screenHeight) / 10);
		light_key5.getBackground().setAlpha(50);
		
		Button light_key6 = (Button) findViewById(R.id.light_key6);
		light_key6.setOnClickListener(this);
		light_key6.setWidth((screenWidth) / 4);
		light_key6.setHeight((screenHeight) / 10);
		light_key6.getBackground().setAlpha(50);
		
		Button light_setting = (Button) findViewById(R.id.light_setting);
		light_setting.setOnClickListener(this);
		light_setting.setWidth((screenWidth) / 4);
		light_setting.setHeight((screenHeight) / 10);
		light_setting.getBackground().setAlpha(50);
		
		Button light_timer1 = (Button) findViewById(R.id.light_timer1);
		light_timer1.setOnClickListener(this);
		light_timer1.setWidth((screenWidth) / 4);
		light_timer1.setHeight((screenHeight) / 10);
		light_timer1.getBackground().setAlpha(50);
		
		Button light_timer2 = (Button) findViewById(R.id.light_timer2);
		light_timer2.setOnClickListener(this);
		light_timer2.setWidth((screenWidth) / 4);
		light_timer2.setHeight((screenHeight) / 10);
		light_timer2.getBackground().setAlpha(50);
		
		Button light_timer3 = (Button) findViewById(R.id.light_timer3);
		light_timer3.setOnClickListener(this);
		light_timer3.setWidth((screenWidth) / 4);
		light_timer3.setHeight((screenHeight) / 10);
		light_timer3.getBackground().setAlpha(50);
		
		Button light_timer4 = (Button) findViewById(R.id.light_timer4);
		light_timer4.setOnClickListener(this);
		light_timer4.setWidth((screenWidth) / 4);
		light_timer4.setHeight((screenHeight) / 10);
		light_timer4.getBackground().setAlpha(50);
		

	}
	@Override
	public void onStart()
	{
		super.onStart();
		RadioButton study_radio = (RadioButton) findViewById(R.id.radioStudy);
		study_radio.setOnClickListener(this);
		RadioButton known_radio = (RadioButton) findViewById(R.id.radioKnown);
		known_radio.setOnClickListener(this);
		if (KeyData.mLightIsKnown) {
			known_radio.setChecked(true);
		} else {
			study_radio.setChecked(true);
		}
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (KeyData.mIsStudy == true)
			{
				KeyData.mIsStudy = false;
				Toast.makeText(getApplicationContext(),
						getString(R.string.study_exit),
						Toast.LENGTH_SHORT).show();
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
		switch (v.getId()) {
		case R.id.radioStudy:
			KeyData.mLightIsKnown = false;
			mKey = 0;
			break;
		case R.id.radioKnown:
			KeyData.mLightIsKnown = true;
			mKey = 0;
			break;
		case R.id.light_power_all_on:
			mKey = Value.LIGHT.POWERALLON;
			break;
		case R.id.light_power_all_off:
			mKey = Value.LIGHT.POWERALLOFF;
			break;
		case R.id.light_power_on:
			mKey = Value.LIGHT.POWERON;
			break;
		case R.id.light_power_off:
			mKey = Value.LIGHT.POWEROFF;
			break;
		case R.id.light_light:
			mKey = Value.LIGHT.LIGHT;
			break;
		case R.id.light_dark:
			mKey = Value.LIGHT.DARK;
			break;
		case R.id.light_lost:
			mKey = Value.LIGHT.LOST;
			break;
		case R.id.light_study:
			mKey = Value.LIGHT.STUDY;
			break;
		case R.id.light_keyA:
			mKey = Value.LIGHT.KEYA;
			break;
		case R.id.light_keyB:
			mKey = Value.LIGHT.KEYB;
			break;
		case R.id.light_keyC:
			mKey = Value.LIGHT.KEYC;
			break;
		case R.id.light_keyD:
			mKey = Value.LIGHT.KEYD;
			break;
		case R.id.light_key1:
			mKey = Value.LIGHT.KEY1;
			break;
		case R.id.light_key2:
			mKey = Value.LIGHT.KEY2;
			break;
		case R.id.light_key3:
			mKey = Value.LIGHT.KEY3;
			break;
		case R.id.light_key4:
			mKey = Value.LIGHT.KEY4;
			break;
		case R.id.light_key5:
			mKey = Value.LIGHT.KEY5;
			break;
		case R.id.light_key6:
			mKey = Value.LIGHT.KEY6;
			break;
		case R.id.light_setting:
			mKey = Value.LIGHT.SETTING;
			break;
		case R.id.light_timer1:
			mKey = Value.LIGHT.TIMER1;
			break;
		case R.id.light_timer2:
			mKey = Value.LIGHT.TIMER2;
			break;
		case R.id.light_timer3:
			mKey = Value.LIGHT.TIMER3;
			break;
		case R.id.light_timer4:
			mKey = Value.LIGHT.TIMER4;
			break;
		default:
			mKey = 0;
		}
		if (mKey != 0) {
			try {
				KeyData.Write(mKey);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}