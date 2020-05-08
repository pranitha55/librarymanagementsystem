package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooks;

public interface UserDAO {

	boolean request(int uId, int bId);
	boolean returnBook(int bId,int uId,String status);
	List<BorrowedBooks> borrowedBook(int uId);
	List<BookIssueDetails> bookHistoryDetails(int uId);
	List<BookIssueDetails> showIssuedBooks();


}
