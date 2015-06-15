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
			case 0://����
				fragment=new CategoryFragment();
				break;
			case 1://���
				fragment=new BookStoreFragment();
				break;
			case 2://����
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
