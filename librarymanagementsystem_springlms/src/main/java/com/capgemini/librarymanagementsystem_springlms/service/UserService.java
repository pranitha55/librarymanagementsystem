package com.capgemini.librarymanagementsystem_springlms.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystem_springlms.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.User;


public interface UserService {
	
	boolean request(int uId, int bId);
	boolean returnBook(int bId,int uId,String status);
	List<BorrowedBooks> borrowedBook(int uId);
	List<Integer> bookHistoryDetails(int uId);
	List<BookIssueDetails> showIssuedBooks();
}
