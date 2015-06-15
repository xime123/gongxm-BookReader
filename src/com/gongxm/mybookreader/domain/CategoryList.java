package com.gongxm.mybookreader.domain;

import java.util.List;

public class CategoryList {
	private int code;
	private List<BookDetail> content;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<BookDetail> getContent() {
		return content;
	}

	public void setContent(List<BookDetail> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CategoryList [code=" + code + ", content=" + content + "]";
	}

}
