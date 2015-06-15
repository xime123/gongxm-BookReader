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
 * ���ݿ⹤����
 * 
 * @author gongxm
 * 
 */
public class DBUtils {

	// ���ݿ����������
	private static SiteInfoDBHelper helper;

	/**
	 * ��ʼ��������
	 * 
	 * @param context
	 */
	public static void init(Context ctx) {
		helper = new SiteInfoDBHelper(ctx);
	}

	/**
	 * ����һ����¼
	 */
	public static void insert(Site site) {
		if (TextUtils.isEmpty(site.getSiteName())
				|| TextUtils.isEmpty(site.getHost())) {
			return;
		}
		// ����Ѵ��ڣ�����
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
	 * ����һ������
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
	 * ��ѯһ����¼�Ƿ����
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
	 * ɾ��һ����¼
	 */
	public static void delete(Site site) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.delete(AppConstants.TABLE_NAME_SITE_INFO, "id=?",
				new String[] { site.getId() + "" });
		db.close();
	}

	/**
	 * ����id����һ����¼
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
	 * ��ѯ���м�¼
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
	 * ����id����һ����¼
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
