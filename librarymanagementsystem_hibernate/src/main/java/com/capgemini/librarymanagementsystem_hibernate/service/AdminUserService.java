package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dto.Book;
import com.capgemini.librarymanagementsystem_hibernate.dto.User;

public interface AdminUserService {
	boolean register(User user);
	User login(String email,String password);
	List<Book> searchBookById(int bId);
	List<Book> searchBookByTitle(String bookName);
	List<Book> searchBookByAuthor(String author);
	boolean updatePassword(String email,String password,String newPassword,String role);
	List<Book> getBooksInfo();

	

}
