package com.capgemini.librarymanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;

public class AdminServiceImple implements AdminService {

	private AdminDAO dao = LMSFactory.getAdminDAO();

	@Override
	public boolean registerAdmin(Admin admin) {
		return dao.registerAdmin(admin);
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		return dao.loginAdmin(email, password);
	}

	@Override
	public boolean addBook(Book book) {
		return dao.addBook(book);
	}


	@Override
	public ArrayList<Book> searchBookByAuthor(String author) {
		return dao.searchBookByAuthor(author);
	}


	@Override
	public ArrayList<Book> searchBookByTitle(String bookName) {
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public ArrayList<Book> searchBookByCategory(String category) {
		return dao.searchBookByCategory(category);
	}
	
	@Override
	public ArrayList<Book> getBooksInfo() {
		return dao.getBooksInfo();
	}
	
	@Override
	public boolean removeBook(int id) {
		return dao.removeBook(id);
	}

	@Override
	public boolean updateBook(Book book) {
		return dao.updateBook(book);
	}

	
	
	@Override
	public boolean bookIssue(User user, Book book) {
		return dao.bookIssue(user, book);
	}

	@Override
	public boolean isBookReceived(User user, Book book) {
		return dao.isBookReceived(user, book);
	}

	

	@Override
	public List<User> showUsers() {
		return dao.showUsers();
	}
	
	@Override
	public List<Request> showRequests() {
		return dao.showRequests();
	}


	
	
}
