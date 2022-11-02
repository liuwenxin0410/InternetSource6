package et.song.ctrl;

//import java.util.Locale;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.widget.ImageView;
////import android.widget.TextView;
//public class HelpActivity extends Activity {
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_help);
//		String lan = Locale.getDefault().getLanguage();
//		if (lan.equals("zh"))
//		{
//			((ImageView)findViewById(R.id.textHelp)).setBackgroundResource(R.drawable.help_cn);
//		}
//		else
//		{
//			((ImageView)findViewById(R.id.textHelp)).setBackgroundResource(R.drawable.help_cn);
//		}
//	}
//}

import java.io.InputStream;
import java.lang.ref.WeakReference;

import et.song.dialog.ETLoadDialog;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class HelpActivity extends Activity {
	public static final int VALUE_MSG_START = 0xF0000003;
	public static final int VALUE_MSG_STOP = 0xF0000004;
	public static final int VALUE_MSG_SHOW = 0xF0000005;
	private ImageView mImageHelp;
	int globalNum;
	int globalWidth, globalHeight;
	private static MsgHandler mHandler;
	private Bitmap mBitmap = null;
	private Bitmap mCutBitmap = null;

	Runnable mSetBitmap = new Runnable() {

		public void run() {
			// TODO Auto-generated method stub
			setImage();
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//
		setContentView(R.layout.activity_help);
		DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
		final int displayWidth = displayMetrics.widthPixels;
		final int displayHeight = displayMetrics.heightPixels;
		
		mHandler  = new MsgHandler(this);
		mImageHelp = (ImageView) findViewById(R.id.imageHelp);
		mImageHelp.setOnTouchListener(new MulitPointTouchListener());

		new Thread() {
			@Override
			public void run() {
				super.run();
				mHandler.sendEmptyMessage(VALUE_MSG_START);
				BitmapFactory.Options opt = new BitmapFactory.Options();
				opt.inPreferredConfig = Bitmap.Config.RGB_565;
				opt.inPurgeable = true;
				opt.inInputShareable = true;
				InputStream is = getResources().openRawResource(
						R.drawable.help_cn);
				mBitmap = BitmapFactory.decodeStream(is, null, opt);
				Matrix matrixBall = new Matrix();
				int w = mBitmap.getWidth();
				// int h = mBitmap.getHeight();
				float scaleWidth = ((float) displayWidth / w);
				// float scaleHeight = ((float) this.getHeight() / h);
				matrixBall.postScale(scaleWidth * 1.0f, scaleWidth * 1.0f);
				mBitmap = Bitmap.createBitmap(mBitmap, 0, 0,
						mBitmap.getWidth(), mBitmap.getHeight(), matrixBall,
						true);
				globalWidth = mBitmap.getWidth();
				globalHeight = mBitmap.getHeight();
				mCutBitmap = Bitmap.createBitmap(mBitmap, 0, 0, displayWidth,
						displayHeight, null, true);
				mHandler.post(mSetBitmap);
				mHandler.sendEmptyMessage(VALUE_MSG_STOP);
			}
		}.start();

	}

	void setImage() {
		if (mCutBitmap != null) {
			mImageHelp.setImageBitmap(mCutBitmap);
			mHandler.removeCallbacks(mSetBitmap);
			// iv.setScaleType(ScaleType.MATRIX);
			// iv.setImageMatrix(iv.getImageMatrix());
		}
	}

	public class MulitPointTouchListener implements OnTouchListener {
		// Matrix matrix = new Matrix();
		// Matrix savedMatrix = new Matrix();
		PointF pf = new PointF();

		public MulitPointTouchListener() {
			super();
		}

		// @Override
		// public boolean onTouch(View v, MotionEvent event) {
		// ImageView view = (ImageView) v;
		// switch (event.getAction() & MotionEvent.ACTION_MASK) {
		// case MotionEvent.ACTION_DOWN:
		// matrix.set(view.getImageMatrix());
		// savedMatrix.set(matrix);
		// pf.set(event.getX(), event.getY());
		// break;
		// case MotionEvent.ACTION_MOVE:
		// matrix.set(savedMatrix);
		// mx = event.getX() - pf.x;
		// my = event.getY() - pf.y;
		// globalX += mx;
		// globalY += my;
		// Log.i("globalY", Integer.valueOf(globalY).toString());
		// Log.i("globalHeight", Integer.valueOf(globalHeight).toString());
		// Log.i("my", Float.valueOf(my).toString());
		//
		// if (globalY < -(globalHeight - view.getHeight()) || globalY > 0) {
		// if (globalY > 0)
		// globalY = 0;
		// if (globalY < -(globalHeight - view.getHeight()))
		// globalY = -(globalHeight - view.getHeight());
		// } else {
		// matrix.postTranslate(0, my);
		// view.setImageMatrix(matrix);
		// }
		// break;
		// default:
		// break;
		//
		// }
		// return true;
		// }
		public boolean onTouch(View v, MotionEvent event) {
			float curX, curY;
			ImageView view = (ImageView) v;
			switch (event.getAction()) {

			case MotionEvent.ACTION_DOWN:
				// matrix.set(view.getImageMatrix());
				// savedMatrix.set(matrix);
				pf.set(event.getX(), event.getY());
				break;
			case MotionEvent.ACTION_MOVE:
				// matrix.set(savedMatrix);
				curX = event.getX();
				curY = event.getY();
				// mImageHelp.scrollBy((int) (globalX - curX), (int)
				// (globalY - curY));
				globalNum += (int) (pf.y - curY);
				Log.i("globalNum", Integer.valueOf(globalNum).toString());
				if (globalNum > (globalHeight - view.getHeight())
						|| globalNum < 0) {
					if (globalNum < 0) {
						globalNum = 0;
					}
					if (globalNum > (globalHeight - view.getHeight())) {
						globalNum = (globalHeight - view.getHeight());
					}
				} else {
					mCutBitmap = Bitmap.createBitmap(mBitmap, 0, globalNum,
							mBitmap.getWidth(), mImageHelp.getHeight(), null,
							true);
					mHandler.post(mSetBitmap);
					// mImageHelp.scrollBy(0, (int) (pf.y - curY));
					// matrix.postTranslate(0, (int) (pf.y - curY));
					// view.setImageMatrix(matrix);
				}
				// globalX = curX;
				// globalY = curY;
				pf.set(curX, curY);
				break;
			case MotionEvent.ACTION_UP:
				curX = event.getX();
				curY = event.getY();
				// mCutBitmap = Bitmap.createBitmap(mBitmap, 0, globalNum,
				// mBitmap.getWidth(), mImageHelp.getHeight(), null,
				// true);
				// handler.post(mSetBitmap);
				// mImageHelp.scrollBy((int) (globalX - curX), (int)
				// (globalY - curY));
				// mImageHelp.scrollBy(0, (int) (pf.y - curY));
				// matrix.postTranslate(0, (int) (pf.y - curY));
				// view.setImageMatrix(matrix);
				break;
			}

			return true;
		}
	}

	static class MsgHandler extends Handler {
		private ETLoadDialog loadDialog = null;
		private WeakReference<Activity> mActivity;

		MsgHandler(Activity activity) {
			mActivity = new WeakReference<Activity>(activity);
		}

		@Override
		public void handleMessage(Message msg) {
			Activity activity = mActivity.get();
			super.handleMessage(msg);
			switch (msg.what) {
			case VALUE_MSG_START:
				loadDialog = new ETLoadDialog(activity, R.style.ETLoadDialog);
				loadDialog.show();
				break;
			case VALUE_MSG_STOP:
				if (loadDialog != null) {
					if (loadDialog.isShowing()) {
						loadDialog.dismiss();
						loadDialog = null;
					}
				}
				break;

			}
		}
	}

	@Override
	protected void onStop() {
		if (mBitmap != null) {
			if (!mBitmap.isRecycled()) {
				mBitmap.recycle();
				mBitmap = null;
			}
		}
		if (mCutBitmap != null) {
			if (!mCutBitmap.isRecycled()) {
				mCutBitmap.recycle();
				mCutBitmap = null;
			}
		}
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mBitmap != null) {
			if (!mBitmap.isRecycled()) {
				mBitmap.recycle();
				mBitmap = null;
			}
		}
		if (mCutBitmap != null) {
			if (!mCutBitmap.isRecycled()) {
				mCutBitmap.recycle();
				mCutBitmap = null;
			}
		}
	}
}
