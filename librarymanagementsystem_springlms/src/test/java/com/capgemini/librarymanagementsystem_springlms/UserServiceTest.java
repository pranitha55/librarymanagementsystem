package com.capgemini.librarymanagementsystem_springlms;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem_springlms.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystem_springlms.service.UserService;


public class UserServiceTest {
	@Autowired
    private UserService service;
	
	@Test
	public void testRequest() {
		boolean status = service.request(852852, 852852);
		Assertions.assertTrue(status);
	}
	@Test
	public void testReturnBook() {
		boolean status = service.returnBook(1234, 123123, "yes");
		Assertions.assertTrue(status);
	}
	@Test
	public void testBorrowedBook() {
		List<BorrowedBooks> info = service.borrowedBook(159753);
		Assertions.assertNotNull(info);
	}
	@Test
	public void testRequest1() {
		boolean status = service.request(852852, 987654);
		Assertions.assertTrue(status);
	}
	@Test
	public void testBookHistroyDetails1() {
		List<Integer> info = service.bookHistoryDetails(123456);
		Assertions.assertNotNull(info);
	}
	@Test
	public void testReturnBook1() {
		boolean status = service.returnBook(123123, 123456, "yes");
		Assertions.assertTrue(status);
	}
	@Test
	public void testBorrowedBook1() {
		List<BorrowedBooks> info = service.borrowedBook(741852);
		Assertions.assertNotNull(info);
	}
	@Test
	public void testBookHistroyDetails() {
		List<Integer> info = service.bookHistoryDetails(102102);
		Assertions.assertNotNull(info);
	}

}
