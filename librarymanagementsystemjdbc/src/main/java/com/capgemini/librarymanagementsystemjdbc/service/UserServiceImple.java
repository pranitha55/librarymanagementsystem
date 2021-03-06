package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dao.UserDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystemjdbc.factory.LMSFactory;

public class UserServiceImple implements UserService {
	private UserDAO dao = LMSFactory.getUserDAO();
	

	@Override
	public boolean request(int uId, int bId) {
		return dao.request(uId, bId);
	}
	
	@Override
	public boolean returnBook(int bId,int uId,String status) {
		return dao.returnBook(bId,uId,status);
	}
	
	
	@Override
	public List<BorrowedBooks> borrowedBook(int uId) {
		return dao.borrowedBook(uId);
	}

	@Override
	public List<BookIssueDetails> bookHistoryDetails(int uId) {
		return dao.bookHistoryDetails(uId);
	}

	@Override
	public List<BookIssueDetails> showIssuedBooks() {
		return dao.showIssuedBooks();
	}

	
	
}
