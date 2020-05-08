package com.capgemini.librarymanagementsystem_hibernate;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystem_hibernate.service.UserService;
import com.capgemini.librarymanagementsystem_hibernate.service.UserServiceImple;


public class UserServiceTest {
	private UserService service = new UserServiceImple();
	
	@Test
	public void testRequest() {
		boolean b = service.request(878877, 975312);
		Assertions.assertTrue(b);
	}
	@Test
	public void testBookHistoryDetails() {
		List<Integer> info = service.bookHistoryDetails(2);
		Assertions.assertNotNull(info);
	}
	@Test
	public void testBookHistoryDetails1() {
		List<Integer> info1 = service.bookHistoryDetails(2);
		Assertions.assertNotNull(info1);
	}
	@Test
	public void testReturnBook() {
		boolean b=service.returnBook(3,919190,"returning");
		Assertions.assertTrue(b);
	}
	@Test
	public void testReturnBook1() {
		boolean b1=service.returnBook(2,919190,"returning");
		Assertions.assertTrue(b1);
	}
	@Test
	public void testBorrowedBook() {
		List<BorrowedBooks> b=service.borrowedBook(3);
		Assertions.assertNotNull(b);
	}
	@Test
	public void testBorrowedBook1() {
		List<BorrowedBooks> b1=service.borrowedBook(3);
		Assertions.assertNotNull(b1);
	}
	
	

}
