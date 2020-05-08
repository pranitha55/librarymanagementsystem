package com.capgemini.librarymanagementsystem_springlms.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.User;



public interface AdminUserService {
	boolean register(User user);
	User login(String email,String password);
	List<Book> searchBookById(int bId);
	List<Book> searchBookByTitle(String bookName);
	List<Book> searchBookByAuthor(String author);
	boolean updatePassword(int id,String password,String newPassword,String role);
	List<Book> getBooksInfo();

	

}
