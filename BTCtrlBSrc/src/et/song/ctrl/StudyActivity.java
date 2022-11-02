package et.song.ctrl;

import et.song.data.KeyData;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StudyActivity extends Activity implements OnClickListener{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_studyed);
		DisplayMetrics dm = new DisplayMetrics();
		Display display = getWindowManager().getDefaultDisplay();
		display.getMetrics(dm);
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;
		
		Button studyTest = (Button) findViewById(R.id.button_study_test);
		studyTest.setOnClickListener(this);
		studyTest.setWidth((screenWidth) / 2);
		studyTest.setHeight((screenHeight) / 6);
		
		Button studyRepeat = (Button) findViewById(R.id.button_study_repeat);
		studyRepeat.setOnClickListener(this);
		studyRepeat.setWidth((screenWidth) / 2);
		studyRepeat.setHeight((screenHeight) / 6);
		
		Button studyNext = (Button) findViewById(R.id.button_study_next);
		studyNext.setOnClickListener(this);
		studyNext.setWidth((screenWidth) / 2);
		studyNext.setHeight((screenHeight) / 6);
		
		Button studyExit = (Button) findViewById(R.id.button_study_exit);
		studyExit.setOnClickListener(this);
		studyExit.setWidth((screenWidth) / 2);
		studyExit.setHeight((screenHeight) / 6);
		
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.button_study_test:
			KeyData.mIsStudy = false;
			KeyData.Test();
			break;
		case R.id.button_study_repeat:
			KeyData.mIsStudy = true;
			KeyData.Repeat();
			finish();
			break;
		case R.id.button_study_next:
			KeyData.mIsStudy = true;
			Toast toast = Toast.makeText(getApplicationContext(), R.string.study_alert,
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
			toast.show();
			finish();
			break;
		case R.id.button_study_exit:
			KeyData.mIsStudy = false;
			finish();
			break;
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (event.isLongPress()) {
				openOptionsMenu();
				return true;
			}
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}
	
}