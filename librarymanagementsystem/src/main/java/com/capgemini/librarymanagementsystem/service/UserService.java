package com.capgemini.librarymanagementsystem.service;

import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;

public interface UserService {
	boolean registerUser(User user);
	User loginUser(String email,String password);
	public Request bookRequest(User user, Book book);
	public Request bookReturn(User student, Book book);
	ArrayList<Book> searchBookByTitle(String bookName);
	ArrayList<Book> searchBookByAuthor(String author);
	ArrayList<Book> searchBookByCategory(String category);
	ArrayList<Book> getBooksInfo();
	

}
