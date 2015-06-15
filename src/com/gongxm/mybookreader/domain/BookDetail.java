package com.gongxm.mybookreader.domain;

import java.io.Serializable;

public class BookDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	private int type;//类型
	private int isNewBook;//是否新书
    private int bookId;//书籍ID
    private int categoryId;//分类ID
    private String author;//作者
    private String name;//书名
    private String brief;//简介
    private String category;//分类
    private String cover;//封面链接
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsNewBook() {
		return isNewBook;
	}
	public void setIsNewBook(int isNewBook) {
		this.isNewBook = isNewBook;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	@Override
	public String toString() {
		return "BookDetail [type=" + type + ", isNewBook=" + isNewBook
				+ ", bookId=" + bookId + ", categoryId=" + categoryId
				+ ", author=" + author + ", name=" + name + ", brief=" + brief
				+ ", category=" + category + ", cover=" + cover + "]";
	}
    
}
