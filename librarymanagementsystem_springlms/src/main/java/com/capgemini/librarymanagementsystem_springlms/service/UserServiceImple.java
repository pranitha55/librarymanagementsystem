package com.capgemini.librarymanagementsystem_springlms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem_springlms.dao.UserDAO;
import com.capgemini.librarymanagementsystem_springlms.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.BorrowedBooks;


@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserDAO dao;
	

	
	@Override
	public boolean request(int uId, int bId) {
		return dao.request(uId, bId);
	}

	@Override
	public boolean returnBook(int bId, int uId, String status) {
		return dao.returnBook(bId, uId, status);
	}

	
	@Override
	public List<BorrowedBooks> borrowedBook(int uId) {
		return dao.borrowedBook(uId);
	}


	@Override
	public List<Integer> bookHistoryDetails(int uId) {
		return dao.bookHistoryDetails(uId);
	}

	

	@Override
	public List<BookIssueDetails> showIssuedBooks() {
		return dao.showIssuedBooks();
	}

	
	
}
