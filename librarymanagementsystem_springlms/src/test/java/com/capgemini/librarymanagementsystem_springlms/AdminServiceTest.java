package com.capgemini.librarymanagementsystem_springlms;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.User;
import com.capgemini.librarymanagementsystem_springlms.service.AdminService;




public class AdminServiceTest {
	
	@Autowired
	private AdminService service;

	@Test
	public void testAddBook() {
		Book info = new Book();
		info.setBId(101010);
		info.setBookName("javajava");
		info.setAuthor("jamesgosling");
		info.setCategory("javaprogramming");
		info.setPublisher("SunMicroSystem");
		boolean status = service.addBook(info);
		Assertions.assertTrue(status);
	}

	@Test
	public void testRemoveBook() {
		boolean status = service.removeBook(1234);
		Assertions.assertTrue(status);
	}

	@Test
	public void testUpdateBook() {
		Book info = new Book();
		info.setBId(123458);
		info.setBookName("jdbc");
		boolean status = service.updateBook(info);
		Assertions.assertTrue(status);
	}

	@Test
	public void testIssueBook() {
		boolean status = service.issueBook(123123, 102102);
		Assertions.assertTrue(status);
	}

	

	@Test
	public void testShowRequests() {
		List<RequestDetails> info = service.showRequests();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testShowIssuedBooks() {
		List<BookIssueDetails> info = service.showIssuedBooks();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testShowUsers() {
		List<User> info = service.showUsers();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testAddBook1() {
		Book info = new Book();
		info.setBId(101010);
		info.setBookName("javajava");
		info.setAuthor("jamesgosling");
		info.setCategory("javaprogramming");
		info.setPublisher("SunMicroSystem");
		boolean status = service.addBook(info);
		Assertions.assertFalse(status);
	}

	@Test
	public void testRemoveBook1() {
		boolean status = service.removeBook(1234);
		Assertions.assertFalse(status);
	}

	@Test
	public void testUpdateBook1() {
		Book info = new Book();
		info.setBId(123458);
		info.setBookName("jdbc");
		boolean status = service.updateBook(info);
		Assertions.assertFalse(status);
	}

	@Test
	public void testIssueBook1() {
		boolean status = service.issueBook(123123, 102102);
		Assertions.assertFalse(status);
	}

	

	@Test
	public void testShowRequests1() {
		List<RequestDetails> info = service.showRequests();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testShowIssuedBooks1() {
		List<BookIssueDetails> info = service.showIssuedBooks();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testShowUsers1() {
		List<User> info = service.showUsers();
		Assertions.assertNotNull(info);
	}


}
