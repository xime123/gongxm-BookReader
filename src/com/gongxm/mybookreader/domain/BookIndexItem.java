package com.gongxm.mybookreader.domain;

import java.util.List;

public class BookIndexItem {
	private String updateTime;
	private List<Chapters> chapters;
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public List<Chapters> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapters> chapters) {
		this.chapters = chapters;
	}
	@Override
	public String toString() {
		return "BookIndexItem [updateTime=" + updateTime + ", chapters="
				+ chapters + "]";
	}
}
