package com.capgemini.librarymanagementsystem_springlms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem_springlms.dao.AdminDAO;
import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.User;


@Service
public class AdminServiceImple implements AdminService {
	@Autowired
	private AdminDAO dao;

	@Override
	public boolean addBook(Book book) {
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(int bId) {
		return dao.removeBook(bId);
	}

	@Override
	public boolean updateBook(Book book) {
		return dao.updateBook(book);
	}

	@Override
	public boolean issueBook(int bId, int uId) {
		return dao.issueBook(bId, uId);
	}

	@Override
	public List<RequestDetails> showRequests() {
		return dao.showRequests();
	}

	@Override
	public List<BookIssueDetails> showIssuedBooks() {
		return dao.showIssuedBooks();
	}

	@Override
	public List<User> showUsers() {
		return dao.showUsers();
	}

}
