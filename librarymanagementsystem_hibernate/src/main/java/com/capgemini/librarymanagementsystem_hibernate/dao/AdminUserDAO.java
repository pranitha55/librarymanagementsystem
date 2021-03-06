package com.capgemini.librarymanagementsystem_hibernate.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dto.Book;
import com.capgemini.librarymanagementsystem_hibernate.dto.User;


public interface AdminUserDAO {
	boolean register(User user);
	User login(String email,String password);
	List<Book> searchBookById(int bId);
	List<Book> searchBookByTitle(String bookName);
	List<Book> searchBookByAuthor(String author);
	boolean updatePassword(String email,String password,String newPassword,String role);
	List<Book> getBooksInfo();

}
