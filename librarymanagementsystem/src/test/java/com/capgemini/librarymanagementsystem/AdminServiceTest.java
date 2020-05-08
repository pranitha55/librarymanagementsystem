package com.capgemini.librarymanagementsystem;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.AdminServiceImple;



public class AdminServiceTest {
	
	
private AdminService service = new AdminServiceImple();
	
	@Test
	public void testAddBook() {
		Book book = new Book();
		book.setId(989898);
		book.setBookName("java");
		book.setAuthor("gossling");
		book.setCategory("java");
		book.setPublication("sunmicrosystems");
		boolean status = service.addBook(book);
		Assertions.assertTrue(status);
	}

	@Test
	public void testAddBook1() {
		Book book = new Book();
		book.setId(989898);
		book.setBookName("java");
		book.setAuthor("gossling");
		book.setCategory("java");
		book.setPublication("sunmicrosystems");
		boolean status1 = service.addBook(book);
		Assertions.assertTrue(status1);
	}

	@Test
	public void testRegister() {
		Admin a = new Admin();
		a.setAdminId(989898);
		a.setAdminName("ghi");
		a.setAdminEmail("ghi@gmail.com");
		a.setAdminPassword("ghi@123");
		boolean status = service.registerAdmin(a);
		Assertions.assertTrue(status);
	}

	@Test
	public void testRegister1() {
		Admin a = new Admin();
		a.setAdminId(989898);
		a.setAdminName("ghi");
		a.setAdminEmail("ghi@gmail.com");
		a.setAdminPassword("ghi@123");
		boolean status1 = service.registerAdmin(a);
		Assertions.assertTrue(status1);
	}

	@Test
	public void testRemoveBook() {
		Book b = new Book();
		b.setId(989898);
		b.setBookName("java");
		b.setAuthor("gosling");
		b.setCategory("java");
		b.setPublication("sunmicrosystems");
		boolean status = service.removeBook(989898);
		Assertions.assertTrue(status);
	}

	@Test
	public void testRemoveBook1() {
		Book b = new Book();
		b.setId(989898);
		b.setBookName("java");
		b.setAuthor("gosling");
		b.setCategory("java");
		b.setPublication("sunmicrosystems");
		boolean status1 = service.removeBook(989898);
		Assertions.assertTrue(status1);
	}

	@Test
	public void testUpdateBook() {
		Book b = new Book();
		b.setId(11111);
		b.setBookName("hibernate");
		b.setAuthor("rahul");
		b.setCategory("aptitude");
		b.setPublication("sia");
		boolean status = service.addBook(b);
		Assertions.assertTrue(status);
	}

	@Test
	public void testUpdateBook1() {
		Book b = new Book();
		b.setId(11111);
		b.setBookName("hibernate");
		b.setAuthor("rahul");
		b.setCategory("aptitude");
		b.setPublication("sia");
		boolean status1 = service.addBook(b);
		Assertions.assertTrue(status1);
	}

	@Test
	public void testAuth() {
		Admin status = service.loginAdmin("ghi@gmail.com", "ghi@123");
		Assertions.assertNotNull(status);
	}

	@Test
	public void testAuthenticateBook() {
		Admin status = service.loginAdmin("ghi@gmail.com", "ghi@123");
		Assertions.assertNotNull(status);
	}

	@Test
	public void testSearchByTitle() {
		List<Book> info = service.searchBookByTitle("hibernate");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchByTitle1() {
		List<Book> info1 = service.searchBookByTitle("hibernate");
		Assertions.assertNotNull(info1);
	}

	@Test
	public void testSearchByAuthor() {
		List<Book> info = service.searchBookByAuthor("rahul");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchByAuthor1() {
		List<Book> info1 = service.searchBookByAuthor("rahul");
		Assertions.assertNotNull(info1);
	}

	@Test
	public void testSearchByCategory() {
		List<Book> info = service.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchByCategory1() {
		List<Book> info1 = service.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info1);
	}

	@Test
	public void testGetBooks() {
		List<Book> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testGetBooks1() {
		List<Book> info1 = service.getBooksInfo();
		Assertions.assertNotNull(info1);
	}

	@Test
	public void testShowUsera() {
		List<User> info = service.showUsers();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testShowUsers1() {
		List<User> info1 = service.showUsers();
		Assertions.assertNotNull(info1);
	}

	@Test
	public void testShowRequests() {
		List<Request> info = service.showRequests();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testShowRequests1() {
		List<Request> info1 = service.showRequests();
		Assertions.assertNotNull(info1);
	}

}