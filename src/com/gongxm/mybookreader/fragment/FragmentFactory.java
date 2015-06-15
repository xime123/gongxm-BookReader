package com.gongxm.mybookreader.fragment;

import java.util.HashMap;
import java.util.Map;

import android.support.v4.app.Fragment;

public class FragmentFactory {
	private static Map<Integer,Fragment> map=new HashMap<Integer,Fragment>();
	public static Fragment createFragment(int position){
		Fragment fragment = map.get(position);
		if(fragment==null){
			switch (position) {
			case 0://分类
				fragment=new CategoryFragment();
				break;
			case 1://书架
				fragment=new BookStoreFragment();
				break;
			case 2://设置
				fragment=new SettingFragment();
				break;
			default:
				break;
			}
			map.put(position, fragment);
		}
		return fragment;
	}
}
