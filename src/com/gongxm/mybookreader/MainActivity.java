package com.gongxm.mybookreader;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RadioGroup;

import com.gongxm.mybookreader.adapter.MainAdapter;
import com.gongxm.mybookreader.domain.Site;
import com.gongxm.mybookreader.domain.SiteInfo;
import com.gongxm.mybookreader.interfac.HttpCallBack;
import com.gongxm.mybookreader.utils.AppConstants;
import com.gongxm.mybookreader.utils.DBUtils;
import com.gongxm.mybookreader.utils.GsonUtils;
import com.gongxm.mybookreader.utils.HttpUtils;

public class MainActivity extends FragmentActivity implements
		android.widget.RadioGroup.OnCheckedChangeListener, OnTouchListener {

	private static MainActivity instance;

	private ViewPager main_pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		instance = this;
		initUI();
		initUtils();
		initData();
	}

	public static MainActivity getInstance() {
		return instance;
	}

	/**
	 * ��ʼ������
	 */
	private void initUI() {
		main_pager = (ViewPager) findViewById(R.id.main_pager);
		main_pager.setAdapter(new MainAdapter(getSupportFragmentManager()));
		main_pager.setCurrentItem(1);
		main_pager.setOnTouchListener(this);
		RadioGroup group = (RadioGroup) findViewById(R.id.rg);
		group.setOnCheckedChangeListener(this);
	}

	/**
	 * ��ʼ������
	 */
	private void initData() {
		updateEnableSite();// ���¿��õ���վ
	}

	/**
	 * ���¿��õ���վ�����ݿ�
	 */
	private void updateEnableSite() {
		HttpUtils.executeGet(AppConstants.ENABLE_URL, new HttpCallBack() {

			@Override
			public void responseSuccess(int statusCode, String json) {
				if (!TextUtils.isEmpty(json)) {
					SiteInfo siteInfo = GsonUtils
							.fromJson(json, SiteInfo.class);
					if (siteInfo.getCode() == 200) {
						List<Site> list = siteInfo.getContent();
						for (Site site : list) {
							DBUtils.insert(site);
						}
					}
				}
			}

			@Override
			public void responseFail(int statusCode) {
			}
		});

	}

	/**
	 * ��ʼ��������
	 */
	private void initUtils() {
		DBUtils.init(this);// ���ݿ⹤����
	}

	/**
	 * ��ѡ��ť���ѡ���¼�
	 */
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rd_category:
			main_pager.setCurrentItem(0);
			break;
		case R.id.rd_bookstore:
			main_pager.setCurrentItem(1);
			break;
		case R.id.rd_setting:
			main_pager.setCurrentItem(2);
			break;
		default:
			break;
		}
	}

	/**
	 * ��ֹViewPager�Ļ�����ҳ�¼�
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return true;
	}

}
