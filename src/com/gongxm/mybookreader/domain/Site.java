package com.gongxm.mybookreader.domain;

/**
 * ������վ����Ϣ
 * 
 * @author gongxm
 * 
 */
public class Site {
	private int id;  //��վID
	private String siteName; //��վ����
	private String host; //����
	private String extra; //����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	@Override
	public String toString() {
		return "Site [id=" + id + ", siteName=" + siteName + ", host=" + host
				+ ", extra=" + extra + "]";
	}
}
