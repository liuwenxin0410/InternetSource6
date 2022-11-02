package et.song.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB {
	private static final String DATABASE_NAME = "db.dat";
	private static final int DATABASE_VERSION = 4;
	private Context mContext;
	private DatabaseHelper mHelper;
	private SQLiteDatabase mDB;

	public DB(Context _context) {
		this.mContext = _context;
		mHelper = new DatabaseHelper(mContext, "");
	}

	public DB(Context _context, String _path) {
		this.mContext = _context;
		mHelper = new DatabaseHelper(mContext, _path);
	}

	private class DatabaseHelper extends SQLiteOpenHelper {
		public DatabaseHelper(Context _context, String _path) {
			super(_context, _path + DATABASE_NAME, null, DATABASE_VERSION);
		}

		public void onCreate(SQLiteDatabase db) {
			String sql = "create table stateTable " + "("
					+ " _id integer primary key autoincrement, "
					+ " mIsStudy text not null, "
					+ " mTVIsKnown text not null, "
					+ " mTVRows text not null, " + " mTVCols text not null, "
					+ " mSTBIsKnown text not null, "
					+ " mSTBRows text not null, " + " mSTBCols text not null, "
					+ " mDVDIsKnown text not null, "
					+ " mDVDRows text not null, " + " mDVDCols text not null, "
					+ " mFansIsKnown text not null, "
					+ " mFansRows text not null, "
					+ " mFansCols text not null, "
					+ " mPJTIsKnown text not null, "
					+ " mPJTRows text not null, " + " mPJTCols text not null, "
					+ " mAirIsKnown text not null, "
					+ " mAirRows text not null, " + " mAirCols text not null, "
					+ " mLightIsKnown text not null " + ");";
			db.execSQL(sql);
			sql = "create table studyTable " + "("
					+ " _id integer primary key autoincrement, "
					+ " mToken text not null, " + " mData text not null" + ");";
			db.execSQL(sql);
			sql = "create table addressTable " + "("
					+ " _id integer primary key autoincrement, "
					+ " mAddress text not null" + ");";
			db.execSQL(sql);
		}

		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			if (oldVersion < 2) {
				db.execSQL("ALTER TABLE stateTable ADD mDVDRows text");
				db.execSQL("ALTER TABLE stateTable ADD mDVDCols text");
				db.execSQL("update stateTable set mDVDRows = '0', mDVDCols = '0' where _id = (select _id from stateTable limit 1)");
				oldVersion = 2;
			}
			if (oldVersion < 3) {
				db.execSQL("ALTER TABLE stateTable ADD mLightIsKnown text");
				db.execSQL("update stateTable set mLightIsKnown = 'false' where _id = (select _id from stateTable limit 1)");
				oldVersion = 3;
			}
			if (oldVersion < 4) {
				db.execSQL("ALTER TABLE stateTable ADD mFansRows text");
				db.execSQL("ALTER TABLE stateTable ADD mFansCols text");
				db.execSQL("ALTER TABLE stateTable ADD mPJTIsKnown text");
				db.execSQL("ALTER TABLE stateTable ADD mPJTRows text");
				db.execSQL("ALTER TABLE stateTable ADD mPJTCols text");
				db.execSQL("update stateTable set mFansRows = '0', mFansCols = '0', mPJTRows = '0', mPJTCols = '0', mPJTIsKnown = 'false' where _id = (select _id from stateTable limit 1)");
				oldVersion = 4;
			}
		}

	}

	public void Open() {
		try {
			mDB = mHelper.getWritableDatabase();
		} catch (SQLException ex) {
			mDB = mHelper.getReadableDatabase();
		}
	}

	public void close() {
		mDB.close();
	}

	public void EXE(String _sql) {
		mDB.execSQL(_sql);
	}

	public Cursor Query(String _sql) {
		return mDB.rawQuery(_sql, new String[] {});
	}
}
