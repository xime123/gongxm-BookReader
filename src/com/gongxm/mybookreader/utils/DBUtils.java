package com.gongxm.mybookreader.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.gongxm.mybookreader.db.SiteInfoDBHelper;
import com.gongxm.mybookreader.domain.EnableSite;
import com.gongxm.mybookreader.domain.Site;

/**
 * 数据库工具类
 * 
 * @author gongxm
 * 
 */
public class DBUtils {

	// 数据库操作帮助类
	private static SiteInfoDBHelper helper;

	/**
	 * 初始化工具类
	 * 
	 * @param context
	 */
	public static void init(Context ctx) {
		helper = new SiteInfoDBHelper(ctx);
	}

	/**
	 * 插入一条记录
	 */
	public static void insert(Site site) {
		if (TextUtils.isEmpty(site.getSiteName())
				|| TextUtils.isEmpty(site.getHost())) {
			return;
		}
		// 如果已存在，更新
		if (query(site)) {
			update(site);
			return;
		}
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("id", site.getId());
		values.put("siteName", site.getSiteName());
		values.put("host", site.getHost());
		values.put("extra", site.getExtra());
		db.insert(AppConstants.TABLE_NAME_SITE_INFO, null, values);
		db.close();
	}

	/**
	 * 更新一条数据
	 */
	public static void update(Site site) {
		if (TextUtils.isEmpty(site.getSiteName())
				|| TextUtils.isEmpty(site.getHost())) {
			return;
		}
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("id", site.getId());
		values.put("siteName", site.getSiteName());
		values.put("host", site.getHost());
		values.put("extra", site.getExtra());
		db.update(AppConstants.TABLE_NAME_SITE_INFO, values, "id=?",
				new String[] { site.getId() + "" });
		db.close();
	}

	/**
	 * 查询一条记录是否存在
	 * 
	 * @return
	 */
	public static boolean query(Site site) {
		boolean exsit = false;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query(AppConstants.TABLE_NAME_SITE_INFO,
				new String[] { "id" }, "id=?",
				new String[] { site.getId() + "" }, null, null, null);
		exsit = cursor.moveToNext();
		cursor.close();
		db.close();
		return exsit;
	}

	/**
	 * 删除一条记录
	 */
	public static void delete(Site site) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.delete(AppConstants.TABLE_NAME_SITE_INFO, "id=?",
				new String[] { site.getId() + "" });
		db.close();
	}

	/**
	 * 根据id查找一条记录
	 * 
	 * @param id
	 * @return
	 */
	public static Site find(int id) {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query(AppConstants.TABLE_NAME_SITE_INFO, null,
				"id=?", new String[] { id + "" }, null, null, null);
		Site site = new Site();
		if (cursor.moveToNext()) {
			site.setId(id);
			site.setSiteName(cursor.getString(cursor.getColumnIndex("siteName")));
			site.setHost(cursor.getString(cursor.getColumnIndex("host")));
			site.setExtra(cursor.getString(cursor.getColumnIndex("extra")));
		}
		cursor.close();
		db.close();
		return site;
	}

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	public static List<Site> findAll() {
		List<Site> list = new ArrayList<Site>();
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query(AppConstants.TABLE_NAME_SITE_INFO, null, null,
				null, null, null, null);
		while (cursor.moveToNext()) {
			Site site = new Site();
			site.setId(cursor.getInt(cursor.getColumnIndex("id")));
			site.setSiteName(cursor.getString(cursor.getColumnIndex("siteName")));
			site.setHost(cursor.getString(cursor.getColumnIndex("host")));
			site.setExtra(cursor.getString(cursor.getColumnIndex("extra")));
			list.add(site);
		}
		cursor.close();
		db.close();
		return list;
	}
	
	
	/**
	 * 根据id查找一条记录
	 * 
	 * @param id
	 * @return
	 */
/*	public static EnableSite findEnableSite(int siteId) {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query(AppConstants.TABLE_NAME_ENABLE_PARSER_SITE, null,
				"siteId=?", new String[] { siteId + "" }, null, null, null);
		EnableSite site = new EnableSite();
		if (cursor.moveToNext()) {
			site.setSiteId(siteId);
			site.setSiteName(cursor.getString(cursor.getColumnIndex("siteName")));
			site.setHost(cursor.getString(cursor.getColumnIndex("host")));
			site.setUrlReg(cursor.getString(cursor.getColumnIndex("urlReg")));
			site.setChapterReg(cursor.getString(cursor.getColumnIndex("chapterReg")));
			site.setStartTag(cursor.getString(cursor.getColumnIndex("startTag")));
			site.setEndTag(cursor.getString(cursor.getColumnIndex("endTag")));
			site.setExtra(cursor.getString(cursor.getColumnIndex("extra")));
		}
		cursor.close();
		db.close();
		return site;
	}*/
	
}
