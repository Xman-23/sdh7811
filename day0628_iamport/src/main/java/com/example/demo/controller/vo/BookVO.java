package com.example.demo.controller.vo;


public class BookVO {
	private String bookTitle;
	private String url;
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public BookVO(String bookTitle, String url) {
		super();
		this.bookTitle = bookTitle;
		this.url = url;
	}
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
