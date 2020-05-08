package com.capgemini.librarymanagementsystem_hibernate;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAOImple;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBooks;



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
	private UserDAO dao = new UserDAOImple();
	@Test
	public void testRequest() {
		boolean b = dao.request(878877, 975312);
		Assertions.assertTrue(b);
	}
	@Test
	public void testBookHistoryDetails() {
		List<Integer> info = dao.bookHistoryDetails(2);
		Assertions.assertNotNull(info);
	}
	@Test
	public void testBookHistoryDetails1() {
		List<Integer> info1 = dao.bookHistoryDetails(2);
		Assertions.assertNotNull(info1);
	}
	@Test
	public void testReturnBook() {
		boolean b=dao.returnBook(3,919190,"returning");
		Assertions.assertTrue(b);
	}
	@Test
	public void testReturnBook1() {
		boolean b1=dao.returnBook(2,919190,"returning");
		Assertions.assertTrue(b1);
	}
	@Test
	public void testBorrowedBook() {
		List<BorrowedBooks> b=dao.borrowedBook(3);
		Assertions.assertNotNull(b);
	}
	@Test
	public void testBorrowedBook1() {
		List<BorrowedBooks> b1=dao.borrowedBook(3);
		Assertions.assertNotNull(b1);
	}
	
	
}
