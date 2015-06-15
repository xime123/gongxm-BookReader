package com.gongxm.mybookreader.domain;

import java.util.List;

/**
 * 可用的网站信息
 * @author gongxm
 *
 */
public class SiteInfo {
	
	private int code;
	private List<Site> content;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<Site> getContent() {
		return content;
	}
	public void setContent(List<Site> content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "SiteInfo [code=" + code + ", content=" + content + "]";
	}
	
}
