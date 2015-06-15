package com.gongxm.mybookreader.adapter;

import java.util.List;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gongxm.mybookreader.R;
import com.gongxm.mybookreader.domain.BookDetail;
import com.gongxm.mybookreader.utils.HttpUtils;

public class BookListAdapter extends BaseAdapter {

	private List<BookDetail> list;
	private Context context;

	public BookListAdapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		return list == null ? 0 : list.size();
	}

	public void setData(List<BookDetail> list) {
		if(this.list==null){
			this.list=list;
		}else{
			this.list.addAll(list);
		}
		notifyDataSetChanged();
	}

	@Override
	public Object getItem(int position) {
		return list == null ? null : list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(context, R.layout.book_list_item, null);
			ImageView iv_book_cover = (ImageView) convertView
					.findViewById(R.id.iv_book_cover);
			TextView tv_category = (TextView) convertView
					.findViewById(R.id.tv_category);
			TextView tv_book_name = (TextView) convertView
					.findViewById(R.id.tv_book_name);
			TextView tv_book_author = (TextView) convertView
					.findViewById(R.id.tv_book_author);
			ImageView iv_new = (ImageView) convertView
					.findViewById(R.id.iv_new);
			ImageView iv_complete = (ImageView) convertView
					.findViewById(R.id.iv_complete);
			holder.iv_book_cover = iv_book_cover;
			holder.iv_new = iv_new;
			holder.iv_complete = iv_complete;
			holder.tv_category = tv_category;
			holder.tv_book_name = tv_book_name;
			holder.tv_book_author = tv_book_author;
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		BookDetail item = (BookDetail) getItem(position);
		String cover = item.getCover();
		if(!TextUtils.isEmpty(cover)){
			HttpUtils.loadImage(holder.iv_book_cover, cover);
		}
		if (item.getIsNewBook() == 1) {
			holder.iv_new.setVisibility(View.VISIBLE);
		} else {
			holder.iv_new.setVisibility(View.INVISIBLE);
		}
		holder.tv_category.setText(item.getCategory());
		holder.tv_book_name.setText(item.getName());
		if(item.getType()==1){
			holder.iv_complete.setVisibility(View.VISIBLE);
		}else{
			holder.iv_complete.setVisibility(View.INVISIBLE);
		}
		holder.tv_book_author.setText(item.getAuthor());

		return convertView;
	}

	class ViewHolder {
		public ImageView iv_complete;
		ImageView iv_book_cover;
		ImageView iv_new;
		TextView tv_category;
		TextView tv_book_name;
		TextView tv_book_author;
	}

}
