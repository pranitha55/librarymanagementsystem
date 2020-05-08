package com.capgemini.librarymanagementsystem_springlms;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem_springlms.dao.UserDAO;
import com.capgemini.librarymanagementsystem_springlms.dto.BorrowedBooks;




public class UserDAOTest {
	
	
	/*
	 * public void testRegister() { User user = new User();
	 * user.setEmail("prani@gmail.com"); user.setFirstName("pranitha");
	 * user.setLastName("soma"); user.setMobile(956756778);
	 * user.setPassword("Prani12@"); user.setRole("student"); boolean
	 * status=dao.register(user); Assertions.assertEquals(true, status); }
	 * 
	 * public void testAddBook() { Book book = new Book(); book.setBId(101);
	 * book.setBookName("The 3 mistakes of my life");
	 * book.setAuthor("chetan bhagat"); book.setCategory("Fiction");
	 * book.setPublisher("Rupa" ); boolean status=dao.addBook(book);
	 * Assertions.assertTrue(status);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void updateBook() { Book book = new Book(); book.setBId(101); boolean
	 * status=dao.updateBook(book); Assertions.assertTrue(status); }
	 */
	@Autowired
	private UserDAO dao;
	
	@Test
	public void testRequest() {
		boolean status = dao.request(852852, 852852);
		Assertions.assertTrue(status);
	}
	@Test
	public void testReturnBook() {
		boolean status = dao.returnBook(1234, 123123, "yes");
		Assertions.assertTrue(status);
	}
	@Test
	public void testBorrowedBook() {
		List<BorrowedBooks> info = dao.borrowedBook(159753);
		Assertions.assertNotNull(info);
	}
	@Test
	public void testBookHistroyDetails1() {
		List<Integer> info = dao.bookHistoryDetails(123456);
		Assertions.assertNotNull(info);
	}

	@Test
	public void testRequest1() {
		boolean status = dao.request(852852, 987654);
		Assertions.assertTrue(status);
	}
	@Test
	public void testReturnBook1() {
		boolean status = dao.returnBook(123123, 123456, "yes");
		Assertions.assertTrue(status);
	}
	@Test
	public void testBorrowedBook1() {
		List<BorrowedBooks> info = dao.borrowedBook(741852);
		Assertions.assertNotNull(info);
	}
	@Test
	public void testBookHistroyDetails() {
		List<Integer> info = dao.bookHistoryDetails(102102);
		Assertions.assertNotNull(info);
	}
}
