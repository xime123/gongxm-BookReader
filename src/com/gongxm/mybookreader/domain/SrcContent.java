package com.gongxm.mybookreader.domain;

import java.util.List;

/**
 * 下载源列表解析对象
 * @author gongxm
 *
 */
public class SrcContent {
	private int code;
	private List<DownloadSrc> content;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<DownloadSrc> getContent() {
		return content;
	}
	public void setContent(List<DownloadSrc> content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "SrcContent [code=" + code + ", content=" + content + "]";
	}
	
}
