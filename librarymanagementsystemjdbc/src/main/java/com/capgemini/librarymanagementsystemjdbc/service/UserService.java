package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.Book;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.User;

public interface UserService {
	
	boolean request(int uId, int bId);
	boolean returnBook(int bId,int uId,String status);
	List<BorrowedBooks> borrowedBook(int uId);
	List<BookIssueDetails> bookHistoryDetails(int uId);
	List<BookIssueDetails> showIssuedBooks();

}
