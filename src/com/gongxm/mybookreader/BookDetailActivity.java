package com.gongxm.mybookreader;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.gongxm.mybookreader.adapter.DownloadSrcAdapter;
import com.gongxm.mybookreader.domain.BookDetail;
import com.gongxm.mybookreader.domain.DownloadSrc;
import com.gongxm.mybookreader.domain.EnableSite;
import com.gongxm.mybookreader.domain.Site;
import com.gongxm.mybookreader.domain.SrcContent;
import com.gongxm.mybookreader.interfac.HttpCallBack;
import com.gongxm.mybookreader.utils.AppConstants;
import com.gongxm.mybookreader.utils.DBUtils;
import com.gongxm.mybookreader.utils.GsonUtils;
import com.gongxm.mybookreader.utils.HttpUtils;

public class BookDetailActivity extends Activity implements OnClickListener {
	private LinearLayout ll_loading;
	private LinearLayout ll_complete;
	private LinearLayout ll_load_err;

	private ImageView iv_book_cover; // 封面
	private TextView tv_book_name;// 书名
	private ImageView iv_complete;// 是否全本
	private TextView tv_category;// 分类
	private TextView tv_author;// 作者
	private TextView tv_newChapter;// 最新章节
	private TextView tv_src;// 当前下载源
	private TextView tv_description; // 简介
	private BookDetail item; // 书的对象
	private LinearLayout ll_src;// 下载源
	private List<DownloadSrc> list;// 所有下载源
	private String[] items;// 所有下载源的名称

	private int checkedItem = 0;

	private Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case AppConstants.ERROR:
				ll_loading.setVisibility(View.INVISIBLE);
				ll_complete.setVisibility(View.INVISIBLE);
				ll_load_err.setVisibility(View.VISIBLE);
				break;
			case AppConstants.SUCCESS:
				list = (List<DownloadSrc>) msg.obj;
				if (list.size() == 0) {
					// 没有下载源
					tv_src.setText(getString(R.string.no_download_src));
				} else {
					DownloadSrc src = list.get(0);
					String newChapterName = src.getNewChapterName();
					int siteId = src.getSiteId();
					Site site = DBUtils.find(siteId);
					if (site.getId() != 0) {
						String siteName = site.getSiteName();
						tv_src.setText(siteName);
						tv_newChapter.setText(newChapterName);
					} else {
						tv_src.setText(getString(R.string.unknown_src));
					}
					ll_src.setOnClickListener(BookDetailActivity.this);
				}
				String author = item.getAuthor();
				String name = item.getName();
				String brief = item.getBrief();
				String category = item.getCategory();
				String cover = item.getCover();
				int type = item.getType();
				HttpUtils.loadImage(iv_book_cover, cover);
				tv_author.setText(getString(R.string.author) + author);
				tv_book_name.setText(name);
				tv_category.setText(category);
				if (!TextUtils.isEmpty(brief)) {
					tv_description.setText(brief);
				} else {
					tv_description.setText(getString(R.string.no_description));
				}
				if (type == 1) {
					iv_complete.setVisibility(View.VISIBLE);
				} else {
					iv_complete.setVisibility(View.INVISIBLE);
				}
				ll_loading.setVisibility(View.INVISIBLE);
				ll_complete.setVisibility(View.VISIBLE);
				ll_load_err.setVisibility(View.INVISIBLE);
				break;
			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_detail_layout);

		initUI();// 初始化界面

		initData();// 初始化数据

	}

	private void initUI() {
		ll_loading = (LinearLayout) findViewById(R.id.ll_loading);
		ll_complete = (LinearLayout) findViewById(R.id.ll_complete);
		ll_load_err = (LinearLayout) findViewById(R.id.ll_load_err);
		ll_src = (LinearLayout) ll_complete.findViewById(R.id.ll_src);
		iv_book_cover = (ImageView) ll_complete
				.findViewById(R.id.iv_book_cover);
		iv_complete = (ImageView) ll_complete.findViewById(R.id.iv_complete);
		tv_book_name = (TextView) ll_complete.findViewById(R.id.tv_book_name);
		tv_category = (TextView) ll_complete.findViewById(R.id.tv_category);
		tv_author = (TextView) ll_complete.findViewById(R.id.tv_author);
		tv_newChapter = (TextView) ll_complete
				.findViewById(R.id.tv_new_chapter);
		tv_src = (TextView) ll_complete.findViewById(R.id.tv_src);
		tv_description = (TextView) ll_complete
				.findViewById(R.id.tv_book_description);
	}

	private void initData() {
		Intent intent = getIntent();
		item = (BookDetail) intent.getSerializableExtra("BookDetail");
		if (item != null) {
			setTitle(item.getName());
			loadData(item);// 加载数据
		} else {
			handler.sendEmptyMessage(AppConstants.ERROR);
		}
	}

	private void loadData(BookDetail item) {
		String author = item.getAuthor();
		String name = item.getName();
		String url = AppConstants.BOOK_DETAIL_URL + "?author=" + author
				+ "&name=" + name;
		HttpUtils.executeGet(url, new HttpCallBack() {

			@Override
			public void responseSuccess(int statusCode, String result) {
				SrcContent srcContent = GsonUtils.fromJson(result,
						SrcContent.class);
				if (srcContent.getCode() == 200) {
					List<DownloadSrc> list = srcContent.getContent();
					List<DownloadSrc> temp = new ArrayList<DownloadSrc>();
					items = new String[list.size()];
					for (int i = 0; i < list.size(); i++) {
						int siteId = list.get(i).getSiteId();
						Site site = DBUtils.find(siteId);
						if (site.getId() != 0) {
							items[i] = site.getSiteName();
						} else {
							temp.add(list.get(i));
						}
					}
					list.removeAll(temp);//删除不可用的网站
					handler.obtainMessage(AppConstants.SUCCESS, list)
							.sendToTarget();
				} else {
					handler.sendEmptyMessage(AppConstants.ERROR);
				}
			}

			@Override
			public void responseFail(int statusCode) {
				handler.sendEmptyMessage(AppConstants.ERROR);
			}
		});
	}

	/**
	 * 下载书籍
	 * 
	 * @param view
	 */
	public void download(View view) {

		DownloadSrc src = list.get(checkedItem);
		Intent intent=new Intent(this,BookChaptersActivity.class);
		intent.putExtra("title", item.getName());
		intent.putExtra("src", src);
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle(getString(R.string.select_src));
		ListAdapter adapter = new DownloadSrcAdapter(this, list, checkedItem);
		android.content.DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				checkedItem = which;
				DownloadSrc src = list.get(which);
				String newChapterName = src.getNewChapterName();
				int siteId = src.getSiteId();
				Site site = DBUtils.find(siteId);
				if (site.getId() != 0) {
					String siteName = site.getSiteName();
					tv_src.setText(siteName);
					tv_newChapter.setText(newChapterName);
				} else {
					tv_src.setText(getString(R.string.unknown_src));
				}
				dialog.dismiss();
			}
		};
		builder.setSingleChoiceItems(adapter, checkedItem, listener).show();
	}
}
