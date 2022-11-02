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

public class STBActivity extends Activity implements OnClickListener {
	private int mKey;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stb);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;
		
		Button stb_key1 = (Button) findViewById(R.id.stb_key1);
		stb_key1.setOnClickListener(this);
		stb_key1.setWidth((screenWidth) / 4);
		stb_key1.setHeight((screenHeight) / 11);
		stb_key1.getBackground().setAlpha(50);
		
		Button stb_key2 = (Button) findViewById(R.id.stb_key2);
		stb_key2.setOnClickListener(this);
		stb_key2.setWidth((screenWidth) / 4);
		stb_key2.setHeight((screenHeight) / 11);
		stb_key2.getBackground().setAlpha(50);
		
		Button stb_key3 = (Button) findViewById(R.id.stb_key3);
		stb_key3.setOnClickListener(this);
		stb_key3.setWidth((screenWidth) / 4);
		stb_key3.setHeight((screenHeight) / 11);
		stb_key3.getBackground().setAlpha(50);
		
		Button stb_wait = (Button) findViewById(R.id.stb_wait);
		stb_wait.setOnClickListener(this);
		stb_wait.setWidth((screenWidth) / 4);
		stb_wait.setHeight((screenHeight) / 11);
		stb_wait.getBackground().setAlpha(50);
		
		Button stb_key4 = (Button) findViewById(R.id.stb_key4);
		stb_key4.setOnClickListener(this);
		stb_key4.setWidth((screenWidth) / 4);
		stb_key4.setHeight((screenHeight) / 11);
		stb_key4.getBackground().setAlpha(50);
		
		Button stb_key5 = (Button) findViewById(R.id.stb_key5);
		stb_key5.setOnClickListener(this);
		stb_key5.setWidth((screenWidth) / 4);
		stb_key5.setHeight((screenHeight) / 11);
		stb_key5.getBackground().setAlpha(50);
		
		Button stb_key6 = (Button) findViewById(R.id.stb_key6);
		stb_key6.setOnClickListener(this);
		stb_key6.setWidth((screenWidth) / 4);
		stb_key6.setHeight((screenHeight) / 11);
		stb_key6.getBackground().setAlpha(50);
		
		Button stb_chadd = (Button) findViewById(R.id.stb_chadd);
		stb_chadd.setOnClickListener(this);
		stb_chadd.setWidth((screenWidth) / 4);
		stb_chadd.setHeight((screenHeight) / 11);
		stb_chadd.getBackground().setAlpha(50);
		
		Button stb_key7 = (Button) findViewById(R.id.stb_key7);
		stb_key7.setOnClickListener(this);
		stb_key7.setWidth((screenWidth) / 4);
		stb_key7.setHeight((screenHeight) / 11);
		stb_key7.getBackground().setAlpha(50);
		
		Button stb_key8 = (Button) findViewById(R.id.stb_key8);
		stb_key8.setOnClickListener(this);
		stb_key8.setWidth((screenWidth) / 4);
		stb_key8.setHeight((screenHeight) / 11);
		stb_key8.getBackground().setAlpha(50);
		
		Button stb_key9 = (Button) findViewById(R.id.stb_key9);
		stb_key9.setOnClickListener(this);
		stb_key9.setWidth((screenWidth) / 4);
		stb_key9.setHeight((screenHeight) / 11);
		stb_key9.getBackground().setAlpha(50);
		
		Button stb_chsub = (Button) findViewById(R.id.stb_chsub);
		stb_chsub.setOnClickListener(this);
		stb_chsub.setWidth((screenWidth) / 4);
		stb_chsub.setHeight((screenHeight) / 11);
		stb_chsub.getBackground().setAlpha(50);
		
		Button stb_voladd = (Button) findViewById(R.id.stb_voladd);
		stb_voladd.setOnClickListener(this);
		stb_voladd.setWidth((screenWidth) / 4);
		stb_voladd.setHeight((screenHeight) / 11);
		stb_voladd.getBackground().setAlpha(50);
		
		Button stb_key0 = (Button) findViewById(R.id.stb_key0);
		stb_key0.setOnClickListener(this);
		stb_key0.setWidth((screenWidth) / 4);
		stb_key0.setHeight((screenHeight) / 11);
		stb_key0.getBackground().setAlpha(50);
		
		Button stb_volsub = (Button) findViewById(R.id.stb_volsub);
		stb_volsub.setOnClickListener(this);
		stb_volsub.setWidth((screenWidth) / 4);
		stb_volsub.setHeight((screenHeight) / 11);
		stb_volsub.getBackground().setAlpha(50);
		
		Button stb_watch = (Button) findViewById(R.id.stb_watch);
		stb_watch.setOnClickListener(this);
		stb_watch.setWidth((screenWidth) / 4);
		stb_watch.setHeight((screenHeight) / 11);
		stb_watch.getBackground().setAlpha(50);
		
		Button stb_up = (Button) findViewById(R.id.stb_up);
		stb_up.setOnClickListener(this);
		stb_up.setWidth((screenWidth) / 4);
		stb_up.setHeight((screenHeight) / 11);
		stb_up.getBackground().setAlpha(50);
		
		Button stb_down = (Button) findViewById(R.id.stb_down);
		stb_down.setOnClickListener(this);
		stb_down.setWidth((screenWidth) / 4);
		stb_down.setHeight((screenHeight) / 11);
		stb_down.getBackground().setAlpha(50);
		
		Button stb_left = (Button) findViewById(R.id.stb_left);
		stb_left.setOnClickListener(this);
		stb_left.setWidth((screenWidth) / 4);
		stb_left.setHeight((screenHeight) / 11);
		stb_left.getBackground().setAlpha(50);
		
		Button stb_right = (Button) findViewById(R.id.stb_right);
		stb_right.setOnClickListener(this);
		stb_right.setWidth((screenWidth) / 4);
		stb_right.setHeight((screenHeight) / 11);
		stb_right.getBackground().setAlpha(50);
		
		Button stb_ok = (Button) findViewById(R.id.stb_ok);
		stb_ok.setOnClickListener(this);
		stb_ok.setWidth((screenWidth) / 4);
		stb_ok.setHeight((screenHeight) / 11);
		stb_ok.getBackground().setAlpha(50);
		
		Button stb_back = (Button) findViewById(R.id.stb_back);
		stb_back.setOnClickListener(this);
		stb_back.setWidth((screenWidth) / 4);
		stb_back.setHeight((screenHeight) / 11);
		stb_back.getBackground().setAlpha(50);
		
		Button stb_menu = (Button) findViewById(R.id.stb_menu);
		stb_menu.setOnClickListener(this);
		stb_menu.setWidth((screenWidth) / 4);
		stb_menu.setHeight((screenHeight) / 11);
		stb_menu.getBackground().setAlpha(50);
		
	}
	@Override
	public void onStart()
	{
		super.onStart();
		RadioButton study_radio = (RadioButton) findViewById(R.id.radioStudy);
		study_radio.setOnClickListener(this);
		RadioButton known_radio = (RadioButton) findViewById(R.id.radioKnown);
		known_radio.setOnClickListener(this);
		if (KeyData.mSTBIsKnown) {
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
			KeyData.mSTBIsKnown = false;
			mKey = 0;
			break;
		case R.id.radioKnown:
			KeyData.mSTBIsKnown = true;
			mKey = 0;
			break;
		case R.id.stb_key0:
			mKey = Value.STB.KEY0;
			break;
		case R.id.stb_key1:
			mKey = Value.STB.KEY1;
			break;
		case R.id.stb_key2:
			mKey = Value.STB.KEY2;
			break;
		case R.id.stb_key3:
			mKey = Value.STB.KEY3;
			break;
		case R.id.stb_key4:
			mKey = Value.STB.KEY4;
			break;
		case R.id.stb_key5:
			mKey = Value.STB.KEY5;
			break;
		case R.id.stb_key6:
			mKey = Value.STB.KEY6;
			break;
		case R.id.stb_key7:
			mKey = Value.STB.KEY7;
			break;
		case R.id.stb_key8:
			mKey = Value.STB.KEY8;
			break;
		case R.id.stb_key9:
			mKey = Value.STB.KEY9;
			break;
		case R.id.stb_wait:
			mKey = Value.STB.WAIT;
			break;
		case R.id.stb_watch:
			mKey = Value.STB.WATCH;
			break;
		case R.id.stb_voladd:
			mKey = Value.STB.VOLADD;
			break;
		case R.id.stb_volsub:
			mKey = Value.STB.VOLSUB;
			break;
		case R.id.stb_chadd:
			mKey = Value.STB.CHADD;
			break;
		case R.id.stb_chsub:
			mKey = Value.STB.CHSUB;
			break;
		case R.id.stb_up:
			mKey = Value.STB.UP;
			break;
		case R.id.stb_down:
			mKey = Value.STB.DOWN;
			break;
		case R.id.stb_left:
			mKey = Value.STB.LEFT;
			break;
		case R.id.stb_right:
			mKey = Value.STB.RIGHT;
			break;
		case R.id.stb_ok:
			mKey = Value.STB.OK;
			break;
		case R.id.stb_back:
			mKey = Value.STB.BACK;
			break;
		case R.id.stb_menu:
			mKey = Value.STB.MENU;
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
