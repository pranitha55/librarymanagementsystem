package com.capgemini.librarymanagementsystem_springlms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem_springlms.dao.AdminDAO;
import com.capgemini.librarymanagementsystem_springlms.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.User;

public class AdminUserServiceImple implements AdminUserService {
	@Autowired
	private AdminUserDAO dao;	

	@Override
	public boolean register(User user) {
		return dao.register(user);
	}

	@Override
	public User login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public List<Book> searchBookById(int bId) {
		return dao.searchBookById(bId);
	}

	@Override
	public List<Book> searchBookByTitle(String bookName) {
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public List<Book> searchBookByAuthor(String author) {
		return dao.searchBookByAuthor(author);
	}

	@Override
	public boolean updatePassword(int id, String password, String newPassword, String role) {
		return dao.updatePassword(id, password, newPassword, role);
	}

	@Override
	public List<Book> getBooksInfo() {
		return dao.getBooksInfo();
	}

}
