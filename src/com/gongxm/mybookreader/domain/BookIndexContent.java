package com.gongxm.mybookreader.domain;

import java.util.List;

public class BookIndexContent {
	private int code;
	private BookIndexItem content;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public BookIndexItem getContent() {
		return content;
	}

	public void setContent(BookIndexItem content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BookIndexContent [code=" + code + ", content=" + content + "]";
	}

}
