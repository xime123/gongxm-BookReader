package com.gongxm.mybookreader.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gongxm.mybookreader.fragment.FragmentFactory;

public class MainAdapter extends FragmentPagerAdapter {

	public MainAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return FragmentFactory.createFragment(position);
	}
	
	@Override
	public int getCount() {
		return 3;
	}

}
