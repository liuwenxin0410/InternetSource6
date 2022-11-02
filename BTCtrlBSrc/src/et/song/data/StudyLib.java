package et.song.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import et.song.tool.Tools;

import android.database.Cursor;

public class StudyLib {
	private HashMap<String, byte[]> mLib = new HashMap<String, byte[]>();
	public void Add(String _token, byte[] _data)
	{
		mLib.put(_token, _data);
	}
	public void Del(String _token)
	{
		mLib.remove(_token);
	}
	public void Edit(String _token, byte[] _data)
	{
		Del(_token);
		Add(_token, _data);
	}
	public byte[] Get(String _token)
	{
		return mLib.get(_token);
	}
	public void Save(DB _db) 
	{
		String sql;
		Iterator<Map.Entry<String, byte[]>>  iter = mLib.entrySet().iterator();
		while (iter.hasNext()) {
		    Map.Entry<String, byte[]> entry = (Map.Entry<String, byte[]>) iter.next();
		    sql = "select * from studyTable where mToken = '" + entry.getKey() + "'";
			Cursor cursor = _db.Query(sql);
		    if(cursor.moveToFirst() == true)
		    {
		    	sql = "update studyTable set mData = '" + 
		    		  Tools.bytesToHexString(entry.getValue()) + "' where mToken = '" + entry.getKey() + "'";
		    }
		    else
		    {
		    	sql = "insert into studyTable(mToken, mData) values('" + 
		    			entry.getKey() + "', '" + Tools.bytesToHexString(entry.getValue()) + "'" +
						")";
		    }
		    _db.EXE(sql);
		}
	}
}
