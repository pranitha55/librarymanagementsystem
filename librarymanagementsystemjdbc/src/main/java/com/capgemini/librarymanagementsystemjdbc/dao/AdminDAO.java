package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.Book;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.User;

public interface AdminDAO {
	
	boolean addBook(Book book);
	boolean removeBook(int bId);
	boolean updateBook(Book book);
	boolean issueBook(int bId,int uId);
	List<RequestDetails> showRequests();
	List<BookIssueDetails> showIssuedBooks();
	List<User> showUsers();

}
