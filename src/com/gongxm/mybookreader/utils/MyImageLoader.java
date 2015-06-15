package com.gongxm.mybookreader.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.gongxm.mybookreader.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class MyImageLoader {// 框架里面设置了缓存和异步操作，不用单独设置线程池和缓存机制（也可以自定义缓存路径）

	private DisplayImageOptions options;
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

	private List<String> badUrl;// 加载图片异常的链接

	public MyImageLoader() {
		badUrl = new ArrayList<String>();

		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.book_cover_loading)
				.showImageForEmptyUri(R.drawable.book_default)
				.showImageOnFail(R.drawable.book_default).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true)
				.build();
	}

	@SuppressLint("NewApi")
	public static StateListDrawable createBg(Context context, int normalId,
			int pressId) {
		StateListDrawable bg = new StateListDrawable();
		Drawable idNormal = context.getResources().getDrawable(normalId);
		Drawable idPressed = context.getResources().getDrawable(pressId);
		bg.addState(new int[] { android.R.attr.state_pressed }, idPressed);
		bg.addState(new int[] { android.R.attr.state_enabled,
				android.R.attr.state_focused, android.R.attr.state_selected },
				idNormal);
		bg.addState(new int[] {}, idNormal);
		return bg;
	}

	public void display(ImageView container, String url) {// 外部接口函数
		ImageLoader.getInstance().displayImage(url, container, options,
				animateFirstListener);
	}

	private class AnimateFirstDisplayListener extends
			SimpleImageLoadingListener {

		final List<String> displayedImages = Collections
				.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				imageView.setTag(imageUri);
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}

		@Override
		public void onLoadingFailed(final String imageUri, View view,
				FailReason failReason) {/*
			String tag = (String) view.getTag();
			if (imageUri.equals(tag)) {
				view.setTag("1");
				display((ImageView) view, imageUri);
			} else if ("1".equals(tag)) {
				view.setTag("2");
				display((ImageView) view, imageUri);
			} else if ("2".equals(tag)) {
				if (!badUrl.contains(imageUri)) {
					badUrl.add(imageUri);
				}
				StateListDrawable bg = createBg(MainUtils.getMainActivity(),
						R.drawable.tip_download_fail_dark, R.drawable.tip_download_fail_light);
				final ImageView imageView = (ImageView) view;
				imageView.setImageDrawable(bg);
				imageView.setTag(imageUri);
				imageView.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						display(imageView, imageUri);
					}
				});
			}

		*/}

		@SuppressLint("NewApi")
		public StateListDrawable createBg(Context context, int normalId,
				int pressId) {
			StateListDrawable bg = new StateListDrawable();
			Drawable idNormal = context.getResources().getDrawable(normalId);
			Drawable idPressed = context.getResources().getDrawable(pressId);
			bg.addState(new int[] { android.R.attr.state_pressed }, idPressed);
			bg.addState(
					new int[] { android.R.attr.state_enabled,
							android.R.attr.state_focused,
							android.R.attr.state_selected }, idNormal);
			bg.addState(new int[] {}, idNormal);
			return bg;
		}
	}

	public List<String> getBadUrl() {
		return badUrl;
	}
}