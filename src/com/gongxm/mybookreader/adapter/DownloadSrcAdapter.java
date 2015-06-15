package com.gongxm.mybookreader.adapter;

import java.util.List;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.gongxm.mybookreader.R;
import com.gongxm.mybookreader.domain.DownloadSrc;
import com.gongxm.mybookreader.domain.Site;
import com.gongxm.mybookreader.utils.DBUtils;

public class DownloadSrcAdapter implements ListAdapter{
	private List<DownloadSrc> list;// 所有下载源
	private Context context;
	private int checkedItem;
	

	public DownloadSrcAdapter(Context context,List<DownloadSrc> list, int checkedItem) {
		super();
		this.list = list;
		this.context = context;
		this.checkedItem=checkedItem;
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
	public int getItemViewType(int position) {
		return 1;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=View.inflate(context, R.layout.download_src_select_item, null);
			TextView tv_site_name=(TextView) convertView.findViewById(R.id.tv_site_name);
			TextView tv_newChapterName=(TextView) convertView.findViewById(R.id.tv_newChapterName);
			ImageView iv_src_select=(ImageView) convertView.findViewById(R.id.iv_src_select);
			holder.tv_site_name=tv_site_name;
			holder.tv_newChapterName=tv_newChapterName;
			holder.iv_src_select=iv_src_select;
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		DownloadSrc item = (DownloadSrc) getItem(position);
		if(item!=null){
			int siteId = item.getSiteId();
			Site site = DBUtils.find(siteId);
			if(site!=null){
				holder.tv_site_name.setText(site.getSiteName());
			}else{
				holder.tv_site_name.setText(context.getString(R.string.unknown_src));
			}
			holder.tv_newChapterName.setText(item.getNewChapterName());
			if(position==checkedItem){
				holder.iv_src_select.setImageResource(R.drawable.radio_button_selected);
			}else{
				holder.iv_src_select.setImageResource(R.drawable.radio_button_deselected);
			}
		}
		return convertView;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		
	}

	@Override
	public boolean areAllItemsEnabled() {
		return true;
	}

	@Override
	public boolean isEnabled(int position) {
		return true;
	}
	
	class ViewHolder{
		TextView tv_site_name;
		TextView tv_newChapterName;
		ImageView iv_src_select;
	}

}
