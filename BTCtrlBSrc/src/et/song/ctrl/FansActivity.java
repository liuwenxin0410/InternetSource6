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

public class FansActivity extends Activity implements OnClickListener {
	private int mKey;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fans);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;
		
		Button fans_key0 = (Button) findViewById(R.id.fans_key0);
		fans_key0.setOnClickListener(this);
		fans_key0.setWidth((screenWidth) / 4);
		fans_key0.setHeight((screenHeight) / 11);
		fans_key0.getBackground().setAlpha(50);
		
		Button fans_key1 = (Button) findViewById(R.id.fans_key1);
		fans_key1.setOnClickListener(this);
		fans_key1.setWidth((screenWidth) / 4);
		fans_key1.setHeight((screenHeight) / 11);
		fans_key1.getBackground().setAlpha(50);
		
		Button fans_key2 = (Button) findViewById(R.id.fans_key2);
		fans_key2.setOnClickListener(this);
		fans_key2.setWidth((screenWidth) / 4);
		fans_key2.setHeight((screenHeight) / 11);
		fans_key2.getBackground().setAlpha(50);
		
		Button fans_key3 = (Button) findViewById(R.id.fans_key3);
		fans_key3.setOnClickListener(this);
		fans_key3.setWidth((screenWidth) / 4);
		fans_key3.setHeight((screenHeight) / 11);
		fans_key3.getBackground().setAlpha(50);
		
		Button fans_key4 = (Button) findViewById(R.id.fans_key4);
		fans_key4.setOnClickListener(this);
		fans_key4.setWidth((screenWidth) / 4);
		fans_key4.setHeight((screenHeight) / 11);
		fans_key4.getBackground().setAlpha(50);
		
		Button fans_key5 = (Button) findViewById(R.id.fans_key5);
		fans_key5.setOnClickListener(this);
		fans_key5.setWidth((screenWidth) / 4);
		fans_key5.setHeight((screenHeight) / 11);
		fans_key5.getBackground().setAlpha(50);
		
		Button fans_key6 = (Button) findViewById(R.id.fans_key6);
		fans_key6.setOnClickListener(this);
		fans_key6.setWidth((screenWidth) / 4);
		fans_key6.setHeight((screenHeight) / 11);
		fans_key6.getBackground().setAlpha(50);
		
		Button fans_key7 = (Button) findViewById(R.id.fans_key7);
		fans_key7.setOnClickListener(this);
		fans_key7.setWidth((screenWidth) / 4);
		fans_key7.setHeight((screenHeight) / 11);
		fans_key7.getBackground().setAlpha(50);
		
		Button fans_key8 = (Button) findViewById(R.id.fans_key8);
		fans_key8.setOnClickListener(this);
		fans_key8.setWidth((screenWidth) / 4);
		fans_key8.setHeight((screenHeight) / 11);
		fans_key8.getBackground().setAlpha(50);
		
		Button fans_key9 = (Button) findViewById(R.id.fans_key9);
		fans_key9.setOnClickListener(this);
		fans_key9.setWidth((screenWidth) / 4);
		fans_key9.setHeight((screenHeight) / 11);
		fans_key9.getBackground().setAlpha(50);
		
		Button fans_power = (Button) findViewById(R.id.fans_power);
		fans_power.setOnClickListener(this);
		fans_power.setWidth((screenWidth) / 4);
		fans_power.setHeight((screenHeight) / 11);
		fans_power.getBackground().setAlpha(50);
		
		Button fans_timer = (Button) findViewById(R.id.fans_timer);
		fans_timer.setOnClickListener(this);
		fans_timer.setWidth((screenWidth) / 4);
		fans_timer.setHeight((screenHeight) / 11);
		fans_timer.getBackground().setAlpha(50);
		
		Button fans_li = (Button) findViewById(R.id.fans_li);
		fans_li.setOnClickListener(this);
		fans_li.setWidth((screenWidth) / 4);
		fans_li.setHeight((screenHeight) / 11);
		fans_li.getBackground().setAlpha(50);
		
		Button fans_cool = (Button) findViewById(R.id.fans_cool);
		fans_cool.setOnClickListener(this);
		fans_cool.setWidth((screenWidth) / 4);
		fans_cool.setHeight((screenHeight) / 11);
		fans_cool.getBackground().setAlpha(50);
		
		Button fans_mode = (Button) findViewById(R.id.fans_mode);
		fans_mode.setOnClickListener(this);
		fans_mode.setWidth((screenWidth) / 4);
		fans_mode.setHeight((screenHeight) / 11);
		fans_mode.getBackground().setAlpha(50);
		
		Button fans_sleep = (Button) findViewById(R.id.fans_sleep);
		fans_sleep.setOnClickListener(this);
		fans_sleep.setWidth((screenWidth) / 4);
		fans_sleep.setHeight((screenHeight) / 11);
		fans_sleep.getBackground().setAlpha(50);
		
		Button fans_light = (Button) findViewById(R.id.fans_light);
		fans_light.setOnClickListener(this);
		fans_light.setWidth((screenWidth) / 4);
		fans_light.setHeight((screenHeight) / 11);
		fans_light.getBackground().setAlpha(50);
		
		Button fans_speed = (Button) findViewById(R.id.fans_speed);
		fans_speed.setOnClickListener(this);
		fans_speed.setWidth((screenWidth) / 4);
		fans_speed.setHeight((screenHeight) / 11);
		fans_speed.getBackground().setAlpha(50);
		
		Button fans_speedlow = (Button) findViewById(R.id.fans_speedlow);
		fans_speedlow.setOnClickListener(this);
		fans_speedlow.setWidth((screenWidth) / 4);
		fans_speedlow.setHeight((screenHeight) / 11);
		fans_speedlow.getBackground().setAlpha(50);
		
		Button fans_speedmiddle = (Button) findViewById(R.id.fans_speedmiddle);
		fans_speedmiddle.setOnClickListener(this);
		fans_speedmiddle.setWidth((screenWidth) / 4);
		fans_speedmiddle.setHeight((screenHeight) / 11);
		fans_speedmiddle.getBackground().setAlpha(50);
		
		Button fans_speedhight = (Button) findViewById(R.id.fans_speedhight);
		fans_speedhight.setOnClickListener(this);
		fans_speedhight.setWidth((screenWidth) / 4);
		fans_speedhight.setHeight((screenHeight) / 11);
		fans_speedhight.getBackground().setAlpha(50);
		
		Button fans_freq = (Button) findViewById(R.id.fans_freq);
		fans_freq.setOnClickListener(this);
		fans_freq.setWidth((screenWidth) / 4);
		fans_freq.setHeight((screenHeight) / 11);
		fans_freq.getBackground().setAlpha(50);

	}
	@Override
	public void onStart()
	{
		super.onStart();
		RadioButton study_radio = (RadioButton) findViewById(R.id.radioStudy);
		study_radio.setOnClickListener(this);
		RadioButton known_radio = (RadioButton) findViewById(R.id.radioKnown);
		known_radio.setOnClickListener(this);
		if (KeyData.mFansIsKnown) {
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
			KeyData.mFansIsKnown = false;
			mKey = 0;
			break;
		case R.id.radioKnown:
			KeyData.mFansIsKnown = true;
			mKey = 0;
			break;
		case R.id.fans_key0:
			mKey = Value.FANS.KEY0;
			break;
		case R.id.fans_key1:
			mKey = Value.FANS.KEY1;
			break;
		case R.id.fans_key2:
			mKey = Value.FANS.KEY2;
			break;
		case R.id.fans_key3:
			mKey = Value.FANS.KEY3;
			break;
		case R.id.fans_key4:
			mKey = Value.FANS.KEY4;
			break;
		case R.id.fans_key5:
			mKey = Value.FANS.KEY5;
			break;
		case R.id.fans_key6:
			mKey = Value.FANS.KEY6;
			break;
		case R.id.fans_key7:
			mKey = Value.FANS.KEY7;
			break;
		case R.id.fans_key8:
			mKey = Value.FANS.KEY8;
			break;
		case R.id.fans_key9:
			mKey = Value.FANS.KEY9;
			break;
		case R.id.fans_sleep:
			mKey = Value.FANS.SLEEP;
			break;
		case R.id.fans_power:
			mKey = Value.FANS.POWER;
			break;
		case R.id.fans_mode:
			mKey = Value.FANS.MODE;
			break;
		case R.id.fans_cool:
			mKey = Value.FANS.COOL;
			break;
		case R.id.fans_li:
			mKey = Value.FANS.LI;
			break;
		case R.id.fans_timer:
			mKey = Value.FANS.TIMER;
			break;
		case R.id.fans_speed:
			mKey = Value.FANS.SPEED;
			break;
		case R.id.fans_light:
			mKey = Value.FANS.LIGHT;
			break;
		case R.id.fans_speedlow:
			mKey = Value.FANS.SPEEDLOW;
			break;
		case R.id.fans_speedmiddle:
			mKey = Value.FANS.SPEEDMIDDLE;
			break;
		case R.id.fans_speedhight:
			mKey = Value.FANS.SPEEDHIGHT;
			break;
		case R.id.fans_freq:
			mKey = Value.FANS.FREQ;
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