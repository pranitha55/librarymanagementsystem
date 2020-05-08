package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Book implements Serializable{
	private int id = (int)Math.random();
	private String bookName;
	private String author;
	private String publication;
	private String category;
	private String issuedate;
	private String returndate;
	public Book() {
		
	}
	
	public Book(int bookId,String bookName,String authorName,
			String bookPublisher,String bookCategory) {
		this.id=bookId;
		this.bookName=bookName;
		this.author=authorName;
		this.publication=bookPublisher;
		this.category=bookCategory;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	
	}
	
	


