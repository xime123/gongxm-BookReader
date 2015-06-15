package com.gongxm.mybookreader.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gongxm.mybookreader.R;
import com.gongxm.mybookreader.domain.Chapters;

public class BookChaptersAdapter extends BaseAdapter {
	private List<Chapters> list;
	private Context context;

	public BookChaptersAdapter(Context context) {
		super();
		this.context = context;
	}
	
	public void setData(List<Chapters> list){
		this.list=list;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return list==null?0:list.size();
	}

	@Override
	public Object getItem(int position) {
		return list==null?null:list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			convertView=View.inflate(context, R.layout.book_index_item, null);
		}
		TextView item = (TextView) convertView.findViewById(R.id.tv_item);
		item.setText(list.get(position).getTitle());
		return convertView;
	}

}
