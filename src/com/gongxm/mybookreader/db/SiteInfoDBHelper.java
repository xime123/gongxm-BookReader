package com.gongxm.mybookreader.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.gongxm.mybookreader.utils.AppConstants;

public class SiteInfoDBHelper extends SQLiteOpenHelper {

	private static final String SITE_TABLE_NAME = AppConstants.TABLE_NAME_SITE_INFO;// 操作的表名
	private static final String ENABLE_SITE_TABLE_NAME = AppConstants.TABLE_NAME_ENABLE_PARSER_SITE;// 操作的表名

	public SiteInfoDBHelper(Context context) {
		super(context, AppConstants.SITE_INFO_DB_NAME, null, AppConstants.SITE_INFO_DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE IF NOT EXISTS " + SITE_TABLE_NAME + "(id integer primary key,siteName VARCHAR(100),host VARCHAR(200),extra VARCHAR(500))";// 创建表的sql语句
		db.execSQL(sql);
		/*String sql2 = "CREATE TABLE IF NOT EXISTS " + ENABLE_SITE_TABLE_NAME + "(siteId integer primary key,siteName VARCHAR(100),host VARCHAR(200),urlReg VARCHAR(200),chapterReg VARCHAR(200),startTag VARCHAR(200),endTag VARCHAR(200),extra VARCHAR(500))";// 创建表的sql语句
		db.execSQL(sql2);
		addEnableSite(db);*/
		Log.e("Database", "数据库创建了！");
	}

	/**
	 * 把可以正常解析的网站信息添加到数据库中
	 */
	private void addEnableSite(SQLiteDatabase db) {
		for (int i = 0; i < AppConstants.siteIds.length; i++) {
			ContentValues values=new ContentValues();
			values.put("siteId", AppConstants.siteIds[i]);
			values.put("siteName", AppConstants.siteNames[i]);
			values.put("host", AppConstants.hosts[i]);
			values.put("urlReg", AppConstants.urlRegs[i]);
			values.put("chapterReg", AppConstants.chapterReg);
			values.put("startTag", AppConstants.startTags[i]);
			values.put("endTag", AppConstants.endTags[i]);
			values.put("extra", AppConstants.extra);
			db.insert(ENABLE_SITE_TABLE_NAME, null, values);
		}
		Log.e("Database", "数据库插入完成！");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + SITE_TABLE_NAME);
		onCreate(db);
		Log.e("Database", "数据库版本更新了！");
	}

}
