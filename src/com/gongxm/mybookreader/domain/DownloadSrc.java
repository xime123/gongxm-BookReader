package com.gongxm.mybookreader.domain;

import java.io.Serializable;

/**
 * ����Դ
 * @author gongxm
 *
 */
public class DownloadSrc implements Serializable{
	private static final long serialVersionUID = 1L;
    private String listUrl;//�鼮Ŀ¼��ַ
    private String newChapterName;//�����½�
    private int siteId;//����ԴID
    private String updateTime;//������ʱ��
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
