package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.Book;
import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.factory.LMSFactory;

public class AdminUserServiceImple implements AdminUserService{
	@SuppressWarnings("unused")
	private AdminUserDAO dao = LMSFactory.getAdminUserDAO();

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
	public boolean updatePassword(String email, String password, String newPassword, String role) {
		return dao.updatePassword(email, password, newPassword, role);
	}

	@Override
	public List<Book> getBooksInfo() {
		return dao.getBooksInfo();
	}
	

}
