package com.gongxm.mybookreader.domain;

import java.io.Serializable;

/**
 * 下载源
 * @author gongxm
 *
 */
public class DownloadSrc implements Serializable{
	private static final long serialVersionUID = 1L;
    private String listUrl;//书籍目录地址
    private String newChapterName;//最新章节
    private int siteId;//下载源ID
    private String updateTime;//最后更新时间
	public String getListUrl() {
		return listUrl;
	}
	public void setListUrl(String listUrl) {
		this.listUrl = listUrl;
	}
	public String getNewChapterName() {
		return newChapterName;
	}
	public void setNewChapterName(String newChapterName) {
		this.newChapterName = newChapterName;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DownloadSrc [listUrl=" + listUrl + ", newChapterName="
				+ newChapterName + ", siteId=" + siteId + ", updateTime="
				+ updateTime + "]";
	}
    
}
