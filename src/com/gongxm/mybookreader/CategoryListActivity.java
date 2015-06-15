package com.gongxm.mybookreader;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.gongxm.mybookreader.adapter.BookListAdapter;
import com.gongxm.mybookreader.domain.BookDetail;
import com.gongxm.mybookreader.domain.CategoryList;
import com.gongxm.mybookreader.interfac.HttpCallBack;
import com.gongxm.mybookreader.utils.AppConstants;
import com.gongxm.mybookreader.utils.GsonUtils;
import com.gongxm.mybookreader.utils.HttpUtils;

/**
 * ��ʾ�鼮�����б�Ľ���
 * 
 * @author gongxm
 * 
 */
public class CategoryListActivity extends Activity {
	private LinearLayout ll_loading; // ����ҳ��
	private LinearLayout ll_complete;// �������ҳ��
	private LinearLayout ll_load_err;// ����ʧ��ҳ��
	private ListView lv_book_list;
	private BookListAdapter adapter;
	private View footer; // ���ظ���Ľ���
	private String url;//���صĵ�ַ
	private int page = 1;
	private boolean hasMore = true;// �Ƿ��и��࣬Ĭ����
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
				List<BookDetail> list = (List<BookDetail>) msg.obj;
				if (list.size() == 0) {
					hasMore = false;
					footer.setVisibility(View.INVISIBLE);
					Toast.makeText(getApplicationContext(),
							getString(R.string.no_data), Toast.LENGTH_SHORT)
							.show();
				} else {
					adapter.setData(list);
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
		setContentView(R.layout.categorylist_layout);
		initUI();
		initData();
	}

	/**
	 * ��������
	 */
	private void initData() {
		Intent intent = getIntent();
		String title = intent.getStringExtra("title");
		url = intent.getStringExtra("url");
		setTitle(title);// ���ý������
		load();
		adapter = new BookListAdapter(CategoryListActivity.this);
		lv_book_list.setAdapter(adapter);

		// ������������
		lv_book_list.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				switch (scrollState) {
				case OnScrollListener.SCROLL_STATE_IDLE: // ����Ǩ��ת��ʱ
					// �϶�Ǩ��ת�䵽�ײ�
					if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
						if (hasMore) {
							page++;
							load();
						}
					}
					break;
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
			}
		});

		lv_book_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				BookDetail item = (BookDetail) adapter.getItem(position);
				Intent intent = new Intent(CategoryListActivity.this,
						BookDetailActivity.class);
				intent.putExtra("BookDetail", item);
				startActivity(intent);
			}
		});
	}

	/**
	 * ������������
	 */
	private void load() {

		String uri = url + page;
		HttpUtils.executeGet(uri, new HttpCallBack() {

			@Override
			public void responseSuccess(int statusCode, String json) {
				CategoryList categoryList = GsonUtils.fromJson(json,
						CategoryList.class);
				int code = categoryList.getCode();
				if (code == 200) {
					handler.obtainMessage(AppConstants.SUCCESS,
							categoryList.getContent()).sendToTarget();
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
	 * ��ʼ������
	 */
	private void initUI() {
		ll_loading = (LinearLayout) findViewById(R.id.ll_loading);
		ll_complete = (LinearLayout) findViewById(R.id.ll_complete);
		ll_load_err = (LinearLayout) findViewById(R.id.ll_load_err);
		lv_book_list = (ListView) ll_complete.findViewById(R.id.lv_book_list);
		footer = View.inflate(this, R.layout.load_more, null);
		lv_book_list.addFooterView(footer);
	}
	
}
