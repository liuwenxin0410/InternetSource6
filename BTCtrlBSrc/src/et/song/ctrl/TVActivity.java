package et.song.ctrl;

import et.song.data.KeyData;
import et.song.value.Value;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class TVActivity extends Activity implements OnClickListener,
		OnLongClickListener {
	private int mKey;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tv);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;

		Button tv_key0 = (Button) findViewById(R.id.tv_key0);
		tv_key0.setOnClickListener(this);
		tv_key0.setWidth((screenWidth) / 4);
		tv_key0.setHeight((screenHeight) / 10);
		tv_key0.getBackground().setAlpha(50);
		

		Button tv_key1 = (Button) findViewById(R.id.tv_key1);
		tv_key1.setOnClickListener(this);
		tv_key1.setWidth((screenWidth) / 4);
		tv_key1.setHeight((screenHeight) / 10);
		tv_key1.getBackground().setAlpha(50);

		Button tv_key2 = (Button) findViewById(R.id.tv_key2);
		tv_key2.setOnClickListener(this);
		tv_key2.setWidth((screenWidth) / 4);
		tv_key2.setHeight((screenHeight) / 10);
		tv_key2.getBackground().setAlpha(50);

		Button tv_key3 = (Button) findViewById(R.id.tv_key3);
		tv_key3.setOnClickListener(this);
		tv_key3.setWidth((screenWidth) / 4);
		tv_key3.setHeight((screenHeight) / 10);
		tv_key3.getBackground().setAlpha(50);

		Button tv_key4 = (Button) findViewById(R.id.tv_key4);
		tv_key4.setOnClickListener(this);
		tv_key4.setWidth((screenWidth) / 4);
		tv_key4.setHeight((screenHeight) / 10);
		tv_key4.getBackground().setAlpha(50);

		Button tv_key5 = (Button) findViewById(R.id.tv_key5);
		tv_key5.setOnClickListener(this);
		tv_key5.setWidth((screenWidth) / 4);
		tv_key5.setHeight((screenHeight) / 10);
		tv_key5.getBackground().setAlpha(50);

		Button tv_key6 = (Button) findViewById(R.id.tv_key6);
		tv_key6.setOnClickListener(this);
		tv_key6.setWidth((screenWidth) / 4);
		tv_key6.setHeight((screenHeight) / 10);
		tv_key6.getBackground().setAlpha(50);

		Button tv_key7 = (Button) findViewById(R.id.tv_key7);
		tv_key7.setOnClickListener(this);
		tv_key7.setWidth((screenWidth) / 4);
		tv_key7.setHeight((screenHeight) / 10);
		tv_key7.getBackground().setAlpha(50);

		Button tv_key8 = (Button) findViewById(R.id.tv_key8);
		tv_key8.setOnClickListener(this);
		tv_key8.setWidth((screenWidth) / 4);
		tv_key8.setHeight((screenHeight) / 10);
		tv_key8.getBackground().setAlpha(50);

		Button tv_key9 = (Button) findViewById(R.id.tv_key9);
		tv_key9.setOnClickListener(this);
		tv_key9.setWidth((screenWidth) / 4);
		tv_key9.setHeight((screenHeight) / 10);
		tv_key9.getBackground().setAlpha(50);

		Button tv_10 = (Button) findViewById(R.id.tv_key10);
		tv_10.setOnClickListener(this);
		tv_10.setWidth((screenWidth) / 4);
		tv_10.setHeight((screenHeight) / 10);
		tv_10.getBackground().setAlpha(50);

		Button tv_power = (Button) findViewById(R.id.tv_power);
		tv_power.setOnClickListener(this);
		tv_power.setWidth((screenWidth) / 4);
		tv_power.setHeight((screenHeight) / 10);
		tv_power.getBackground().setAlpha(50);

		Button tv_av = (Button) findViewById(R.id.tv_av);
		tv_av.setOnClickListener(this);
		tv_av.setWidth((screenWidth) / 4);
		tv_av.setHeight((screenHeight) / 10);
		tv_av.getBackground().setAlpha(50);

		Button tv_mute = (Button) findViewById(R.id.tv_mute);
		tv_mute.setOnClickListener(this);
		tv_mute.setWidth((screenWidth) / 4);
		tv_mute.setHeight((screenHeight) / 10);
		tv_mute.getBackground().setAlpha(50);

		Button tv_back = (Button) findViewById(R.id.tv_back);
		tv_back.setOnClickListener(this);
		tv_back.setWidth((screenWidth) / 4);
		tv_back.setHeight((screenHeight) / 10);
		tv_back.getBackground().setAlpha(50);

		Button tv_chadd = (Button) findViewById(R.id.tv_chadd);
		tv_chadd.setOnClickListener(this);
		tv_chadd.setWidth((screenWidth) / 4);
		tv_chadd.setHeight((screenHeight) / 10);
		tv_chadd.getBackground().setAlpha(50);

		Button tv_chsub = (Button) findViewById(R.id.tv_chsub);
		tv_chsub.setOnClickListener(this);
		tv_chsub.setWidth((screenWidth) / 4);
		tv_chsub.setHeight((screenHeight) / 10);
		tv_chsub.getBackground().setAlpha(50);

		Button tv_voladd = (Button) findViewById(R.id.tv_voladd);
		tv_voladd.setOnClickListener(this);
		tv_voladd.setOnLongClickListener(this);
		tv_voladd.setWidth((screenWidth) / 4);
		tv_voladd.setHeight((screenHeight) / 10);
		tv_voladd.getBackground().setAlpha(50);

		Button tv_volsub = (Button) findViewById(R.id.tv_volsub);
		tv_volsub.setOnClickListener(this);
		tv_volsub.setWidth((screenWidth) / 4);
		tv_volsub.setHeight((screenHeight) / 10);
		tv_volsub.getBackground().setAlpha(50);

		Button tv_ok = (Button) findViewById(R.id.tv_ok);
		tv_ok.setOnClickListener(this);
		tv_ok.setWidth((screenWidth) / 4);
		tv_ok.setHeight((screenHeight) / 10);
		tv_ok.getBackground().setAlpha(50);

		Button tv_menu = (Button) findViewById(R.id.tv_menu);
		tv_menu.setOnClickListener(this);
		tv_menu.setWidth((screenWidth) / 4);
		tv_menu.setHeight((screenHeight) / 10);
		tv_menu.getBackground().setAlpha(50);


	}
	@Override
	public void onStart()
	{
		super.onStart();
		RadioButton study_radio = (RadioButton) findViewById(R.id.radioStudy);
		study_radio.setOnClickListener(this);
		RadioButton known_radio = (RadioButton) findViewById(R.id.radioKnown);
		known_radio.setOnClickListener(this);
		if (KeyData.mTVIsKnown) {
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

	public void onClick(View _view) {
		switch (_view.getId()) {
		case R.id.radioStudy:
			KeyData.mTVIsKnown = false;
			mKey = 0;
			break;
		case R.id.radioKnown:
			KeyData.mTVIsKnown = true;
			mKey = 0;
			break;
		case R.id.tv_key0:
			mKey = Value.TV.KEY0;
			break;
		case R.id.tv_key1:
			mKey = Value.TV.KEY1;
			break;
		case R.id.tv_key2:
			mKey = Value.TV.KEY2;
			break;
		case R.id.tv_key3:
			mKey = Value.TV.KEY3;
			break;
		case R.id.tv_key4:
			mKey = Value.TV.KEY4;
			break;
		case R.id.tv_key5:
			mKey = Value.TV.KEY5;
			break;
		case R.id.tv_key6:
			mKey = Value.TV.KEY6;
			break;
		case R.id.tv_key7:
			mKey = Value.TV.KEY7;
			break;
		case R.id.tv_key8:
			mKey = Value.TV.KEY8;
			break;
		case R.id.tv_key9:
			mKey = Value.TV.KEY9;
			break;
		case R.id.tv_key10:
			mKey = Value.TV.KEY10;
			break;
		case R.id.tv_power:
			mKey = Value.TV.POWER;
			break;
		case R.id.tv_av:
			mKey = Value.TV.AV;
			break;
		case R.id.tv_mute:
			mKey = Value.TV.MUTE;
			break;
		case R.id.tv_back:
			mKey = Value.TV.BACK;
			break;
		case R.id.tv_chadd:
			mKey = Value.TV.CHADD;
			break;
		case R.id.tv_chsub:
			mKey = Value.TV.CHSUB;
			break;
		case R.id.tv_voladd:
			mKey = Value.TV.VOLADD;
			break;
		case R.id.tv_volsub:
			mKey = Value.TV.VOLSUB;
			break;
		case R.id.tv_ok:
			mKey = Value.TV.OK;
			break;
		case R.id.tv_menu:
			mKey = Value.TV.MENU;
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

	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_voladd:
			mKey = Value.TV.VOLADD;
			break;
		case R.id.tv_volsub:
			mKey = Value.TV.VOLSUB;
			break;
		default:
			mKey = 0;
		}
		return false;
	}
}
