package com.gongxm.mybookreader.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;

import com.gongxm.mybookreader.CategoryListActivity;
import com.gongxm.mybookreader.R;
import com.gongxm.mybookreader.utils.AppConstants;

public class CategoryFragment extends Fragment implements OnItemClickListener, OnClickListener {
	private String[] categries=AppConstants.CATEGORIES;
	private EditText et_name;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.category_layout, null);
		et_name = (EditText) view.findViewById(R.id.et_name);
		view.findViewById(R.id.btn_search).setOnClickListener(this);
		GridView gv_category = (GridView) view.findViewById(R.id.gv_category);
		gv_category.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.category_item, categries));
		gv_category.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		int category = position+1;
		Intent intent = new Intent(getActivity(),CategoryListActivity.class);
		String url=AppConstants.CATEGORY_URL+"?count=20&categoryId="+category+"&page=";
		intent.putExtra("title",AppConstants.CATEGORIES[position]);
		intent.putExtra("url",url);
		startActivity(intent);
	}
	

	@Override
	public void onClick(View v) {
		String string = et_name.getText().toString();
		if(!TextUtils.isEmpty(string)){
			Intent intent = new Intent(getActivity(),CategoryListActivity.class);
			String url="http://api.dushubus.com/api/search?count=20&name="+string+"&page=";
			intent.putExtra("title",string);
			intent.putExtra("url",url);
			startActivity(intent);
		}
	}
	
}
