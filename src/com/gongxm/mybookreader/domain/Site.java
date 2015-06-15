package com.gongxm.mybookreader.domain;

/**
 * 单个网站的信息
 * 
 * @author gongxm
 * 
 */
public class Site {
	private int id;  //网站ID
	private String siteName; //网站名称
	private String host; //域名
	private String extra; //其他
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
