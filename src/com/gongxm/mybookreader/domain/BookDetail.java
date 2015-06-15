package com.gongxm.mybookreader.domain;

import java.io.Serializable;

public class BookDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	private int type;//����
	private int isNewBook;//�Ƿ�����
    private int bookId;//�鼮ID
    private int categoryId;//����ID
    private String author;//����
    private String name;//����
    private String brief;//���
    private String category;//����
    private String cover;//��������
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
