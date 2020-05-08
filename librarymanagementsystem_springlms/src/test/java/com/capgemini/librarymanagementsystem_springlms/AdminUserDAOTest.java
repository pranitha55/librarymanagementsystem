package com.capgemini.librarymanagementsystem_springlms;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem_springlms.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.User;




public class AdminUserDAOTest {
	
	@Autowired
	private AdminUserDAO dao;

	@Test
	public void testRegister() {
		User info = new User();
		info.setUId(951753);
		info.setFirstName("Prashanthi");
		info.setLastName("Soma");
		info.setMobile(758598698);
		info.setPassword("Prashuu@123");
		info.setRole("student");
		boolean status = dao.register(info);
		Assertions.assertTrue(status);
	}

	@Test
	public void testLogin() {
		User status = dao.login("prashanthi@gmail.com", "Prashuu@123");
		Assertions.assertNotNull(status);
	}

	@Test
	public void testSearchBookById() {
		List<Book> info = dao.searchBookById(123123);
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchBookByTitle() {
		List<Book> info = dao.searchBookByTitle("a");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchBookByAuthor() {
		List<Book> info = dao.searchBookByAuthor("ja");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testGetBooksInfo() {
		List<Book> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testUpdatePassword() {
		boolean status = dao.updatePassword(1234, "Prashanthi@123", "Prashanthi@123", "admin");
		Assertions.assertTrue(status);
	}

	@Test
	public void testRegister1() {
		User info = new User();
		info.setUId(951753);
		info.setFirstName("Prashanthi");
		info.setLastName("Soma");
		info.setMobile(758598698);
		info.setPassword("Prashuu@12");
		info.setRole("student");
		boolean status = dao.register(info);
		Assertions.assertFalse(status);
	}

	@Test
	public void testLogin1() {
		User status = dao.login("Prashuu@gmail.com", "Prashanthi@123");
		Assertions.assertNotNull(status);
	}

	@Test
	public void testSearchBookById1() {
		List<Book> info = dao.searchBookById(852852);
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchBookByTitle1() {
		List<Book> info = dao.searchBookByTitle("java");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchBookByAuthor1() {
		List<Book> info = dao.searchBookByAuthor("ja");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testGetBooksInfo1() {
		List<Book> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testUpdatePassword1() {
		boolean status = dao.updatePassword(8222, "sony", "Sony@12", "admin");
		Assertions.assertTrue(status);
	}


}
