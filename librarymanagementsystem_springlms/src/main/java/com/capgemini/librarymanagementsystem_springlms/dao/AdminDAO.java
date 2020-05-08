package com.capgemini.librarymanagementsystem_springlms.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.User;



public interface AdminDAO {
	boolean addBook(Book book);
	boolean removeBook(int bId);
	boolean updateBook(Book book);
	boolean issueBook(int bId,int uId);
	List<RequestDetails> showRequests();
	List<BookIssueDetails> showIssuedBooks();
	List<User> showUsers();

}
