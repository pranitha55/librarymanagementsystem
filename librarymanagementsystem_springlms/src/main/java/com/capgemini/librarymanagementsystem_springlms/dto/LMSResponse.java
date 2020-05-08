package com.capgemini.librarymanagementsystem_springlms.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LMSResponse {
	
	private boolean error;
	private String message;
	
	private User user;
	private Book book;
	private BookIssueDetails bookIssueDetails;
	private BorrowedBooks borrowedBooks;
	private RequestDetails requestDetails;
	
	private List<User> user1;
	private List<Book> book1;
	private List<BookIssueDetails> bookIssueDetails1;
	private List<BorrowedBooks> borrowedBooks1;
	private List<RequestDetails> requestDetails1;
	
	
	

}
