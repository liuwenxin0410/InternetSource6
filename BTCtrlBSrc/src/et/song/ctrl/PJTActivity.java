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

public class PJTActivity extends Activity implements OnClickListener {
	private int mKey;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pjt);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;

		Button pjt_power_on = (Button) findViewById(R.id.pjt_power_on);
		pjt_power_on.setOnClickListener(this);
		pjt_power_on.setWidth((screenWidth) / 4);
		pjt_power_on.setHeight((screenHeight) / 11);
		pjt_power_on.getBackground().setAlpha(50);
		
		Button pjt_power_off = (Button) findViewById(R.id.pjt_power_off);
		pjt_power_off.setOnClickListener(this);
		pjt_power_off.setWidth((screenWidth) / 4);
		pjt_power_off.setHeight((screenHeight) / 11);
		pjt_power_off.getBackground().setAlpha(50);
		
		Button pjt_computer = (Button) findViewById(R.id.pjt_computer);
		pjt_computer.setOnClickListener(this);
		pjt_computer.setWidth((screenWidth) / 4);
		pjt_computer.setHeight((screenHeight) / 11);
		pjt_computer.getBackground().setAlpha(50);
		
		Button pjt_video = (Button) findViewById(R.id.pjt_video);
		pjt_video.setOnClickListener(this);
		pjt_video.setWidth((screenWidth) / 4);
		pjt_video.setHeight((screenHeight) / 11);
		pjt_video.getBackground().setAlpha(50);
		
		Button pjt_sign = (Button) findViewById(R.id.pjt_sign);
		pjt_sign.setOnClickListener(this);
		pjt_sign.setWidth((screenWidth) / 4);
		pjt_sign.setHeight((screenHeight) / 11);
		pjt_sign.getBackground().setAlpha(50);
		
		Button pjt_zoomadd = (Button) findViewById(R.id.pjt_zoomadd);
		pjt_zoomadd.setOnClickListener(this);
		pjt_zoomadd.setWidth((screenWidth) / 4);
		pjt_zoomadd.setHeight((screenHeight) / 11);
		pjt_zoomadd.getBackground().setAlpha(50);
		
		Button pjt_zoomsub = (Button) findViewById(R.id.pjt_zoomsub);
		pjt_zoomsub.setOnClickListener(this);
		pjt_zoomsub.setWidth((screenWidth) / 4);
		pjt_zoomsub.setHeight((screenHeight) / 11);
		pjt_zoomsub.getBackground().setAlpha(50);
		
		Button pjt_pictureadd = (Button) findViewById(R.id.pjt_pictureadd);
		pjt_pictureadd.setOnClickListener(this);
		pjt_pictureadd.setWidth((screenWidth) / 4);
		pjt_pictureadd.setHeight((screenHeight) / 11);
		pjt_pictureadd.getBackground().setAlpha(50);
		
		Button pjt_picturesub = (Button) findViewById(R.id.pjt_picturesub);
		pjt_picturesub.setOnClickListener(this);
		pjt_picturesub.setWidth((screenWidth) / 4);
		pjt_picturesub.setHeight((screenHeight) / 11);
		pjt_picturesub.getBackground().setAlpha(50);
		
		Button pjt_brightness = (Button) findViewById(R.id.pjt_brightness);
		pjt_brightness.setOnClickListener(this);
		pjt_brightness.setWidth((screenWidth) / 4);
		pjt_brightness.setHeight((screenHeight) / 11);
		pjt_brightness.getBackground().setAlpha(50);
		
		Button pjt_exit = (Button) findViewById(R.id.pjt_exit);
		pjt_exit.setOnClickListener(this);
		pjt_exit.setWidth((screenWidth) / 4);
		pjt_exit.setHeight((screenHeight) / 11);
		pjt_exit.getBackground().setAlpha(50);
		
		Button pjt_menu = (Button) findViewById(R.id.pjt_menu);
		pjt_menu.setOnClickListener(this);
		pjt_menu.setWidth((screenWidth) / 4);
		pjt_menu.setHeight((screenHeight) / 11);
		pjt_menu.getBackground().setAlpha(50);
		
		Button pjt_pause = (Button) findViewById(R.id.pjt_pause);
		pjt_pause.setOnClickListener(this);
		pjt_pause.setWidth((screenWidth) / 4);
		pjt_pause.setHeight((screenHeight) / 11);
		pjt_pause.getBackground().setAlpha(50);
		
		Button pjt_mute = (Button) findViewById(R.id.pjt_mute);
		pjt_mute.setOnClickListener(this);
		pjt_mute.setWidth((screenWidth) / 4);
		pjt_mute.setHeight((screenHeight) / 11);
		pjt_mute.getBackground().setAlpha(50);
		
		Button  pjt_voladd = (Button) findViewById(R.id.pjt_voladd);
		pjt_voladd.setOnClickListener(this);
		pjt_voladd.setWidth((screenWidth) / 4);
		pjt_voladd.setHeight((screenHeight) / 11);
		pjt_voladd.getBackground().setAlpha(50);
		
		Button pjt_volsub = (Button) findViewById(R.id.pjt_volsub);
		pjt_volsub.setOnClickListener(this);
		pjt_volsub.setWidth((screenWidth) / 4);
		pjt_volsub.setHeight((screenHeight) / 11);
		pjt_volsub.getBackground().setAlpha(50);
		
		Button pjt_auto = (Button) findViewById(R.id.pjt_auto);
		pjt_auto.setOnClickListener(this);
		pjt_auto.setWidth((screenWidth) / 4);
		pjt_auto.setHeight((screenHeight) / 11);
		pjt_auto.getBackground().setAlpha(50);
		
		Button pjt_up = (Button) findViewById(R.id.pjt_up);
		pjt_up.setOnClickListener(this);
		pjt_up.setWidth((screenWidth) / 4);
		pjt_up.setHeight((screenHeight) / 11);
		pjt_up.getBackground().setAlpha(50);
		
		Button pjt_down = (Button) findViewById(R.id.pjt_down);
		pjt_down.setOnClickListener(this);
		pjt_down.setWidth((screenWidth) / 4);
		pjt_down.setHeight((screenHeight) / 11);
		pjt_down.getBackground().setAlpha(50);
		
		Button pjt_left = (Button) findViewById(R.id.pjt_left);
		pjt_left.setOnClickListener(this);
		pjt_left.setWidth((screenWidth) / 4);
		pjt_left.setHeight((screenHeight) / 11);
		pjt_left.getBackground().setAlpha(50);
		
		Button pjt_right = (Button) findViewById(R.id.pjt_right);
		pjt_right.setOnClickListener(this);
		pjt_right.setWidth((screenWidth) / 4);
		pjt_right.setHeight((screenHeight) / 11);
		pjt_right.getBackground().setAlpha(50);
		
		Button pjt_ok = (Button) findViewById(R.id.pjt_ok);
		pjt_ok.setOnClickListener(this);
		pjt_ok.setWidth((screenWidth) / 4);
		pjt_ok.setHeight((screenHeight) / 11);
		pjt_ok.getBackground().setAlpha(50);
		

	}
	@Override
	public void onStart()
	{
		super.onStart();
		RadioButton study_radio = (RadioButton) findViewById(R.id.radioStudy);
		study_radio.setOnClickListener(this);
		RadioButton known_radio = (RadioButton) findViewById(R.id.radioKnown);
		known_radio.setOnClickListener(this);
		if (KeyData.mPJTIsKnown) {
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
			KeyData.mPJTIsKnown = false;
			mKey = 0;
			break;
		case R.id.radioKnown:
			KeyData.mPJTIsKnown = true;
			mKey = 0;
			break;
		case R.id.pjt_power_on:
			mKey = Value.PJT.POWER_ON;
			break;
		case R.id.pjt_power_off:
			mKey = Value.PJT.POWER_OFF;
			break;
		case R.id.pjt_computer:
			mKey = Value.PJT.COMPUTER;
			break;
		case R.id.pjt_video:
			mKey = Value.PJT.VIDEO;
			break;
		case R.id.pjt_sign:
			mKey = Value.PJT.SIGN;
			break;
		case R.id.pjt_zoomadd:
			mKey = Value.PJT.ZOOMADD;
			break;
		case R.id.pjt_zoomsub:
			mKey = Value.PJT.ZOOMSUB;
			break;
		case R.id.pjt_mute:
			mKey = Value.PJT.MUTE;
			break;
		case R.id.pjt_voladd:
			mKey = Value.PJT.VOLADD;
			break;
		case R.id.pjt_volsub:
			mKey = Value.PJT.VOLSUB;
			break;
		case R.id.pjt_auto:
			mKey = Value.PJT.AUTO;
			break;
		case R.id.pjt_pause:
			mKey = Value.PJT.PAUSE;
			break;
		case R.id.pjt_brightness:
			mKey = Value.PJT.BRIGHTNESS;
			break;
		case R.id.pjt_exit:
			mKey = Value.PJT.EXIT;
			break;
		case R.id.pjt_menu:
			mKey = Value.PJT.MENU;
			break;
		case R.id.pjt_pictureadd:
			mKey = Value.PJT.PICTUREADD;
			break;
		case R.id.pjt_picturesub:
			mKey = Value.PJT.PICTURESUB;
			break;
		case R.id.pjt_up:
			mKey = Value.PJT.UP;
			break;
		case R.id.pjt_down:
			mKey = Value.PJT.DOWN;
			break;
		case R.id.pjt_left:
			mKey = Value.PJT.LEFT;
			break;
		case R.id.pjt_right:
			mKey = Value.PJT.RIGHT;
			break;
		case R.id.pjt_ok:
			mKey = Value.PJT.OK;
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