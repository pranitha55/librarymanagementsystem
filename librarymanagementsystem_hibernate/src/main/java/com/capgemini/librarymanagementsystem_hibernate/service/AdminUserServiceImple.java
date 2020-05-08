package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dto.Book;
import com.capgemini.librarymanagementsystem_hibernate.dto.User;
import com.capgemini.librarymanagementsystem_hibernate.factory.LMSFactory;

public class AdminUserServiceImple implements AdminUserService {
	private AdminUserDAO service = LMSFactory.getAdminUserDAO();
	

	@Override
	public boolean register(User user) {
		return service.register(user);
	}

	@Override
	public User login(String email, String password) {
		return service.login(email, password);
	}

	@Override
	public List<Book> searchBookById(int bId) {
		return service.searchBookById(bId);
	}

	@Override
	public List<Book> searchBookByTitle(String bookName) {
		return service.searchBookByTitle(bookName);
	}

	@Override
	public List<Book> searchBookByAuthor(String author) {
		return service.searchBookByAuthor(author);
	}

	@Override
	public boolean updatePassword(String email, String password, String newPassword, String role) {
		return service.updatePassword(email, password, newPassword, role);
	}

	@Override
	public List<Book> getBooksInfo() {
		return service.getBooksInfo();
	}

}
