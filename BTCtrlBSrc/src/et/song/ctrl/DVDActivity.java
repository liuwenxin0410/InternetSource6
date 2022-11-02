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

public class DVDActivity extends Activity implements OnClickListener {
	private int mKey;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dvd);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;
		
		Button dvd_av = (Button)findViewById(R.id.dvd_av);
		dvd_av.setOnClickListener(this);
		dvd_av.setWidth((screenWidth) / 4);
		dvd_av.setHeight((screenHeight) / 10);
		dvd_av.getBackground().setAlpha(50);
		
		Button dvd_back = (Button)findViewById(R.id.dvd_back);
		dvd_back.setOnClickListener(this);
		dvd_back.setWidth((screenWidth) / 4);
		dvd_back.setHeight((screenHeight) / 10);
		dvd_back.getBackground().setAlpha(50);
		
		Button dvd_down = (Button)findViewById(R.id.dvd_down);
		dvd_down.setOnClickListener(this);
		dvd_down.setWidth((screenWidth) / 4);
		dvd_down.setHeight((screenHeight) / 10);
		dvd_down.getBackground().setAlpha(50);
		
		Button dvd_downsong = (Button)findViewById(R.id.dvd_downsong);
		dvd_downsong.setOnClickListener(this);
		dvd_downsong.setWidth((screenWidth) / 4);
		dvd_downsong.setHeight((screenHeight) / 10);
		dvd_downsong.getBackground().setAlpha(50);
		
		Button dvd_left = (Button)findViewById(R.id.dvd_left);
		dvd_left.setOnClickListener(this);
		dvd_left.setWidth((screenWidth) / 4);
		dvd_left.setHeight((screenHeight) / 10);
		dvd_left.getBackground().setAlpha(50);
		
		Button dvd_menu = (Button)findViewById(R.id.dvd_menu);
		dvd_menu.setOnClickListener(this);
		dvd_menu.setWidth((screenWidth) / 4);
		dvd_menu.setHeight((screenHeight) / 10);
		dvd_menu.getBackground().setAlpha(50);
		
		Button dvd_mute = (Button)findViewById(R.id.dvd_mute);
		dvd_mute.setOnClickListener(this);
		dvd_mute.setWidth((screenWidth) / 4);
		dvd_mute.setHeight((screenHeight) / 10);
		dvd_mute.getBackground().setAlpha(50);
		
		Button dvd_ok = (Button)findViewById(R.id.dvd_ok);
		dvd_ok.setOnClickListener(this);
		dvd_ok.setWidth((screenWidth) / 4);
		dvd_ok.setHeight((screenHeight) / 10);
		dvd_ok.getBackground().setAlpha(50);
		
		Button dvd_open = (Button)findViewById(R.id.dvd_open);
		dvd_open.setOnClickListener(this);
		dvd_open.setWidth((screenWidth) / 4);
		dvd_open.setHeight((screenHeight) / 10);
		dvd_open.getBackground().setAlpha(50);
		
		Button dvd_pause = (Button)findViewById(R.id.dvd_pause);
		dvd_pause.setOnClickListener(this);
		dvd_pause.setWidth((screenWidth) / 4);
		dvd_pause.setHeight((screenHeight) / 10);
		dvd_pause.getBackground().setAlpha(50);
		
		Button dvd_play = (Button)findViewById(R.id.dvd_play);
		dvd_play.setOnClickListener(this);	
		dvd_play.setWidth((screenWidth) / 4);
		dvd_play.setHeight((screenHeight) / 10);
		dvd_play.getBackground().setAlpha(50);
		
		Button dvd_power = (Button)findViewById(R.id.dvd_power);
		dvd_power.setOnClickListener(this);
		dvd_power.setWidth((screenWidth) / 4);
		dvd_power.setHeight((screenHeight) / 10);
		dvd_power.getBackground().setAlpha(50);
		
		Button dvd_quickback = (Button)findViewById(R.id.dvd_quickback);
		dvd_quickback.setOnClickListener(this);
		dvd_quickback.setWidth((screenWidth) / 4);
		dvd_quickback.setHeight((screenHeight) / 10);
		dvd_quickback.getBackground().setAlpha(50);
		
		Button dvd_quickforward = (Button)findViewById(R.id.dvd_quickforward);
		dvd_quickforward.setOnClickListener(this);
		dvd_quickforward.setWidth((screenWidth) / 4);
		dvd_quickforward.setHeight((screenHeight) / 10);
		dvd_quickforward.getBackground().setAlpha(50);
		
		Button dvd_right = (Button)findViewById(R.id.dvd_right);
		dvd_right.setOnClickListener(this);
		dvd_right.setWidth((screenWidth) / 4);
		dvd_right.setHeight((screenHeight) / 10);
		dvd_right.getBackground().setAlpha(50);
		
		Button dvd_stop = (Button)findViewById(R.id.dvd_stop);
		dvd_stop.setOnClickListener(this);
		dvd_stop.setWidth((screenWidth) / 4);
		dvd_stop.setHeight((screenHeight) / 10);
		dvd_stop.getBackground().setAlpha(50);
		
		Button dvd_title = (Button)findViewById(R.id.dvd_title);
		dvd_title.setOnClickListener(this);
		dvd_title.setWidth((screenWidth) / 4);
		dvd_title.setHeight((screenHeight) / 10);
		dvd_title.getBackground().setAlpha(50);
		
		Button dvd_up = (Button)findViewById(R.id.dvd_up);
		dvd_up.setOnClickListener(this);
		dvd_up.setWidth((screenWidth) / 4);
		dvd_up.setHeight((screenHeight) / 10);
		dvd_up.getBackground().setAlpha(50);
		
		Button dvd_upsong = (Button)findViewById(R.id.dvd_upsong);
		dvd_upsong.setOnClickListener(this);
		dvd_upsong.setWidth((screenWidth) / 4);
		dvd_upsong.setHeight((screenHeight) / 10);
		dvd_upsong.getBackground().setAlpha(50);
		

	}
	@Override
	public void onStart()
	{
		super.onStart();
		RadioButton study_radio = (RadioButton) findViewById(R.id.radioStudy);
		study_radio.setOnClickListener(this);
		RadioButton known_radio = (RadioButton) findViewById(R.id.radioKnown);
		known_radio.setOnClickListener(this);
		if (KeyData.mDVDIsKnown) {
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
		switch(v.getId())
		{
		case R.id.radioStudy:
			KeyData.mDVDIsKnown = false;
			mKey = 0;
			break;
		case R.id.radioKnown:
			KeyData.mDVDIsKnown = true;
			mKey = 0;
			break;
		case R.id.dvd_av:
			mKey = Value.DVD.AV;
			break;
		case R.id.dvd_back:
			mKey = Value.DVD.BACK;
			break;
		case R.id.dvd_down:
			mKey = Value.DVD.DOWN;
			break;
		case R.id.dvd_downsong:
			mKey = Value.DVD.DOWNSONG;
			break;
		case R.id.dvd_left:
			mKey = Value.DVD.LEFT;
			break;
		case R.id.dvd_menu:
			mKey = Value.DVD.MENU;
			break;
		case R.id.dvd_mute:
			mKey = Value.DVD.MUTE;
			break;
		case R.id.dvd_open:
			mKey = Value.DVD.OPEN;
			break;
		case R.id.dvd_pause:
			mKey = Value.DVD.PAUSE;
			break;
		case R.id.dvd_play:
			mKey = Value.DVD.PLAY;
			break;
		case R.id.dvd_ok:
			mKey = Value.DVD.OK;
			break;
		case R.id.dvd_power:
			mKey = Value.DVD.POWER;
			break;
		case R.id.dvd_quickback:
			mKey = Value.DVD.QUICKFORWARD;
			break;
		case R.id.dvd_quickforward:
			mKey = Value.DVD.QUICKFORWARD;
			break;
		case R.id.dvd_right:
			mKey = Value.DVD.RIGHT;
			break;
		case R.id.dvd_title:
			mKey = Value.DVD.TITLE;
			break;
		case R.id.dvd_up:
			mKey = Value.DVD.UP;
			break;
		case R.id.dvd_upsong:
			mKey = Value.DVD.UPSONG;
			break;
		case R.id.dvd_stop:
			mKey = Value.DVD.STOP;
			break;
		default:
			mKey = 0;
		}
		if (mKey != 0)
		{
			try {
				KeyData.Write(mKey);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}