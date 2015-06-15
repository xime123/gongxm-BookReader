package com.gongxm.mybookreader.domain;

public class Chapters {
	private String title;
	private String url;
	private String volume;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Chapters [title=" + title + ", url=" + url + ", volume="
				+ volume + "]";
	}

}
