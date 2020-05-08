package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dao.AdminDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dto.Book;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.User;
import com.capgemini.librarymanagementsystem_hibernate.factory.LMSFactory;

public class AdminServiceImple implements AdminService {
	private AdminDAO service = LMSFactory.getAdminDAO();
	

	@Override
	public boolean addBook(Book book) {
		return service.addBook(book);
	}

	@Override
	public boolean removeBook(int bId) {
		return service.removeBook(bId);
	}

	@Override
	public boolean updateBook(Book book) {
		return service.updateBook(book);
	}

	@Override
	public boolean issueBook(int bId, int uId) {
		return service.issueBook(bId, uId);
	}

	@Override
	public List<RequestDetails> showRequests() {
		return service.showRequests();
	}

	@Override
	public List<BookIssueDetails> showIssuedBooks() {
		return service.showIssuedBooks();
	}

	@Override
	public List<User> showUsers() {
		return service.showUsers();
	}

}
