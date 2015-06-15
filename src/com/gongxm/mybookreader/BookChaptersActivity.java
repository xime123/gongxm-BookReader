package com.gongxm.mybookreader;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.gongxm.mybookreader.adapter.BookChaptersAdapter;
import com.gongxm.mybookreader.domain.BookIndexContent;
import com.gongxm.mybookreader.domain.BookIndexItem;
import com.gongxm.mybookreader.domain.Chapters;
import com.gongxm.mybookreader.domain.DownloadSrc;
import com.gongxm.mybookreader.domain.Site;
import com.gongxm.mybookreader.interfac.HttpCallBack;
import com.gongxm.mybookreader.utils.AppConstants;
import com.gongxm.mybookreader.utils.DBUtils;
import com.gongxm.mybookreader.utils.GsonUtils;
import com.gongxm.mybookreader.utils.HttpUtils;

public class BookChaptersActivity extends Activity {
	private LinearLayout ll_loading;
	private LinearLayout ll_complete;
	private LinearLayout ll_load_err;
	private ListView lv_list;
	private Site site;//当前下载源
	
	
	private Handler handler = new Handler() {

		@SuppressWarnings("unchecked")
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case AppConstants.ERROR:
				ll_loading.setVisibility(View.INVISIBLE);
				ll_complete.setVisibility(View.INVISIBLE);
				ll_load_err.setVisibility(View.VISIBLE);
				break;
			case AppConstants.SUCCESS:
				List<Chapters> chapters=(List<Chapters>) msg.obj;
				adapter.setData(chapters);
				ll_loading.setVisibility(View.INVISIBLE);
				ll_complete.setVisibility(View.VISIBLE);
				ll_load_err.setVisibility(View.INVISIBLE);
				break;
			default:
				break;
			}
		};
	};
	private BookChaptersAdapter adapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_index_layout);
		initUI();
		initData();
	}

	private void initData() {
		Intent intent = getIntent();
		String title = intent.getStringExtra("title");
		DownloadSrc src = (DownloadSrc) intent.getSerializableExtra("src");
		site = DBUtils.find(src.getSiteId());
		setTitle(title);
		loadData(src.getListUrl());
	}

	

	private void loadData(String listUrl) {
		try {
			String url= AppConstants.BOOK_INDEX_URL+listUrl;
			HttpUtils.executeGet(url, new HttpCallBack() {
				
				@Override
				public void responseSuccess(int statusCode, String result) {
					System.out.println("result="+result);
					BookIndexContent content = GsonUtils.fromJson(result, BookIndexContent.class);
					BookIndexItem item = content.getContent();
					List<Chapters> chapters = item.getChapters();
					handler.obtainMessage(AppConstants.SUCCESS, chapters).sendToTarget();
				}
				
				@Override
				public void responseFail(int statusCode) {
					handler.sendEmptyMessage(AppConstants.ERROR);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			handler.sendEmptyMessage(AppConstants.ERROR);
		}
		
	}

	private void initUI() {
		ll_loading = (LinearLayout) findViewById(R.id.ll_loading);
		ll_complete = (LinearLayout) findViewById(R.id.ll_complete);
		ll_load_err = (LinearLayout) findViewById(R.id.ll_load_err);
		lv_list = (ListView) ll_complete.findViewById(R.id.lv_list);
		adapter = new BookChaptersAdapter(this);
		lv_list.setAdapter(adapter);
	}
}
