package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBooks;

public interface UserService {
	
	boolean request(int uId, int bId);
	boolean returnBook(int bId,int uId,String status);
	List<BorrowedBooks> borrowedBook(int uId);
	List<Integer> bookHistoryDetails(int uId);
	List<BookIssueDetails> showIssuedBooks();

}
