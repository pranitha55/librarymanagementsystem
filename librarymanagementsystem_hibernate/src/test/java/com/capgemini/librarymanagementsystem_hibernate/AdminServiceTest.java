package com.capgemini.librarymanagementsystem_hibernate;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem_hibernate.dto.Book;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.User;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminService;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminServiceImple;



public class AdminServiceTest {
	
	private AdminService service = new AdminServiceImple();
	
	@Test
	public void testAddBook() {
		Book book = new Book();
		book.setBId(12);
		book.setBookName("JDBC");
		book.setAuthor("James");
		book.setCategory("Java");
		book.setPublisher("jackson");
		boolean status = service.addBook(book);
		Assertions.assertTrue(status);
	}

	@Test
	public void testAddBooks() {
		Book books = new Book();
		books.setBId(1);
		books.setBookName("JDBC");
		books.setAuthor("James");
		books.setCategory("Java");
		books.setPublisher("jackson");
		boolean check = service.addBook(books);
		Assertions.assertTrue(check);
	}

	@Test
	public void testUpdateBook() {
		Book book1 = new Book();
		book1.setBId(1);
		book1.setBookName("JDBC");
		book1.setAuthor("williams");
		book1.setCategory("java");
		book1.setPublisher("jackson");
		boolean msg = service.updateBook(book1);
		Assertions.assertTrue(msg);

	}

	@Test
	public void testUpdateBooks() {
		Book book = new Book();
		book.setBId(1);
		book.setBookName("JDBC");
		book.setAuthor("williams");
		book.setCategory("java");
		book.setPublisher("jackson");
		boolean check = service.updateBook(book);
		Assertions.assertTrue(check);
	}

	@Test
	public void testRemoveBook() {
		Book b = new Book();
		b.setBId(1);
		b.setBookName("JDBC");
		b.setAuthor("James");
		b.setCategory("Java");
		b.setPublisher("jackson");
		boolean status = service.removeBook(1);
		Assertions.assertTrue(status);

	}

	@Test
	public void testRemoveBook1() {
		Book b1 = new Book();
		b1.setBId(1);
		b1.setBookName("JDBC");
		b1.setAuthor("James");
		b1.setCategory("Java");
		b1.setPublisher("jackson");
		boolean check = service.removeBook(1);
		Assertions.assertTrue(check);

	}

	@Test
	public void testBookIssue() {
		BookIssueDetails bookDetails = new BookIssueDetails();
		bookDetails.setBId(975310);
		bookDetails.setUId(111111);
		bookDetails.setIssueDate(null);
		bookDetails.setReturnDate(null);
		boolean msg = service.issueBook(975310, 111111);
		Assertions.assertTrue(msg);
	}

	@Test
	public void testBookIssue1() {
		BookIssueDetails bookDetails = new BookIssueDetails();
		bookDetails.setBId(2);
		bookDetails.setUId(111111);
		bookDetails.setIssueDate(null);
		bookDetails.setReturnDate(null);
		boolean msg = service.issueBook(975310, 111111);
		Assertions.assertTrue(msg);
	}

	@Test
	public void testShowRequests() {
		List<RequestDetails> msg = service.showRequests();
		Assertions.assertNotNull(msg);

	}

	@Test
	public void testShowRequests1() {
		List<RequestDetails> msg1 = service.showRequests();
		Assertions.assertNotNull(msg1);

	}

	@Test
	public void testShowIssuedBooks() {
		List<BookIssueDetails> book = service.showIssuedBooks();
		Assertions.assertNotNull(book);
	}

	@Test
	public void testShowIssuedBooks1() {
		List<BookIssueDetails> book1 = service.showIssuedBooks();
		Assertions.assertNotNull(book1);
	}

	@Test
	public void testShowUsers() {
		List<User> user = service.showUsers();
		Assertions.assertNotNull(user);
	}

	@Test
	public void testShowUsers1() {
		List<User> user1 = service.showUsers();
		Assertions.assertNotNull(user1);
	}
	
	

}
