package com.gongxm.mybookreader.domain;
/**
 *=============================
 *
 * 版本：1.0
 * 
 * 作者：gongxm
 *
 * 时间：2015-4-5 下午4:32:21
 *
 * 修正：
 *
 * 版权所有：gongxm
 *
 * 描述：
 * 		可以正常解析的网站信息
 *
 *=============================
 */
 
public class EnableSite {
	private int siteId;
	private String siteName;
	private String host;
	private String urlReg;
	private String chapterReg;
	private String startTag;
	private String endTag;
	private String extra;

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
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

	public String getUrlReg() {
		return urlReg;
	}

	public void setUrlReg(String urlReg) {
		this.urlReg = urlReg;
	}

	public String getChapterReg() {
		return chapterReg;
	}

	public void setChapterReg(String chapterReg) {
		this.chapterReg = chapterReg;
	}

	public String getStartTag() {
		return startTag;
	}

	public void setStartTag(String startTag) {
		this.startTag = startTag;
	}

	public String getEndTag() {
		return endTag;
	}

	public void setEndTag(String endTag) {
		this.endTag = endTag;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "EnableSite [siteId=" + siteId + ", siteName=" + siteName
				+ ", host=" + host + ", urlReg=" + urlReg + ", chapterReg="
				+ chapterReg + ", startTag=" + startTag + ", endTag=" + endTag
				+ ", extra=" + extra + "]";
	}

}
