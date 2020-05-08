package com.capgemini.librarymanagementsystem;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.dao.UserDAOImple;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.User;




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
	public void testRegisterUser() {
		User u = new User();
		u.setId(111222);
		u.setName("paparao");
		u.setPassword("paparao@123");
		u.setEmail("paparao@gmail.com");
		u.setReturnDate(null);
		u.setIssueDate(null);
		u.setBooksBorrowed(1);
		boolean b = dao.registerUser(u);
		Assertions.assertTrue(b);
	}

	@Test
	public void testRegisterUser1() {
		User u = new User();
		u.setId(111222);
		u.setName("paparao");
		u.setPassword("paparao@123");
		u.setEmail("paparao@gmail.com");
		u.setReturnDate(null);
		u.setIssueDate(null);
		u.setBooksBorrowed(1);
		boolean b1 = dao.registerUser(u);
		Assertions.assertTrue(b1);
	}

	@Test
	public void testAuthUser() {
		User u = dao.loginUser("paparao@gmail.com", "paparao@123");
		Assertions.assertNotNull(u);
	}

	@Test
	public void testAuthUser1() {
		User u1 = dao.loginUser("paparao@gmail.com", "paparao@123");
		Assertions.assertNotNull(u1);
	}

	@Test
	public void testGetBooksInfo() {
		List<Book> b = dao.getBooksInfo();
		Assertions.assertNotNull(b);

	}

	@Test
	public void testGetBooksInfo1() {
		List<Book> b1 = dao.getBooksInfo();
		Assertions.assertNotNull(b1);

	}

	@Test
	public void testSearchByTitle() {
		List<Book> info = dao.searchBookByTitle("hibernate");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchByTitle1() {
		List<Book> info1 = dao.searchBookByTitle("hibernate");
		Assertions.assertNotNull(info1);
	}

	@Test
	public void testSearchByAuthor() {
		List<Book> info = dao.searchBookByAuthor("rahul");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchByAuthor1() {
		List<Book> info1 = dao.searchBookByAuthor("rahul");
		Assertions.assertNotNull(info1);
	}

	@Test
	public void testSearchByCategory() {
		List<Book> info = dao.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchByCategory1() {
		List<Book> info1 = dao.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info1);
	}


}
