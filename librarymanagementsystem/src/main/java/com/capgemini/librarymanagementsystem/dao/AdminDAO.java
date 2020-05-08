package com.capgemini.librarymanagementsystem.dao;


import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;


public interface AdminDAO {
	boolean registerAdmin(Admin admin);
	Admin loginAdmin(String email,String password);
	boolean addBook(Book book);
	ArrayList<Book> searchBookByAuthor(String author);
	ArrayList<Book> searchBookByTitle(String bookName);
	ArrayList<Book> searchBookByCategory(String category);
	ArrayList<Book> getBooksInfo();
	boolean removeBook(int id);
	boolean updateBook(Book book);
	boolean bookIssue(User user,Book book);
	boolean isBookReceived(User user,Book book);
	List<User> showUsers();
	List<Request> showRequests();

}
