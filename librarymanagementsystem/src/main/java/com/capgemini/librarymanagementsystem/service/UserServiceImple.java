package com.capgemini.librarymanagementsystem.service;

import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;

public class UserServiceImple implements UserService{
	
	private UserDAO dao = LMSFactory.getUserDAO();

	@Override
	public boolean registerUser(User user) {
		return dao.registerUser(user);
	}

	@Override
	public User loginUser(String email, String password) {
		return dao.loginUser(email, password);
	}

	@Override
	public Request bookRequest(User user, Book book) {
		return dao.bookRequest(user, book);
	}

	@Override
	public Request bookReturn(User user, Book book) {
		return dao.bookReturn(user, book);
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String bookName) {
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public ArrayList<Book> searchBookByAuthor(String author) {
		return dao.searchBookByAuthor(author);
	}

	@Override
	public ArrayList<Book> searchBookByCategory(String category) {
		return dao.searchBookByCategory(category);
	}

	@Override
	public ArrayList<Book> getBooksInfo() {
		return dao.getBooksInfo();
	}


	
}
