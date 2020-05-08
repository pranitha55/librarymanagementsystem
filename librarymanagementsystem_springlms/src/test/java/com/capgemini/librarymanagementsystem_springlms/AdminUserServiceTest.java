package com.capgemini.librarymanagementsystem_springlms;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.User;
import com.capgemini.librarymanagementsystem_springlms.service.AdminUserService;



public class AdminUserServiceTest {
	@Autowired
    private AdminUserService service;
	
	@Test
	public void testRegister() {
		User info = new User();
		info.setUId(951753);
		info.setFirstName("Prashanthi");
		info.setLastName("Soma");
		info.setMobile(758592698);
		info.setPassword("Prashuu@12");
		info.setRole("student");
		boolean status = service.register(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testLogin() {
		User status = service.login("usha345@gmail.com", "Ush@1234");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testSearchBookById() {
		List<Book> info = service.searchBookById(133123);
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchBookByTitle() {
		List<Book> info = service.searchBookByTitle("a");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchBookByAuthor() {
		List<Book> info = service.searchBookByAuthor("jav");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testGetBooksInfo() {
		List<Book> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testUpdatePassword() {
		boolean status = service.updatePassword(7412, "kavya@12", "kavya@1234", "admin");
		Assertions.assertTrue(status);
	}
	@Test
	public void testRegister1() {
		User info = new User();
		info.setUId(942753);
		info.setFirstName("Prashanthi");
		info.setLastName("Soma");
		info.setMobile(758592698);
		info.setPassword("Prashuu@12");
		info.setRole("student");
		boolean status = service.register(info);
		Assertions.assertFalse(status);
	}
	@Test
	public void testLogin1() {
		User status = service.login("prani@gmail.com", "Prani@12");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testSearchBookById1() {
		List<Book> info = service.searchBookById(852252);
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchBookByTitle1() {
		List<Book> info = service.searchBookByTitle("java");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchBookByAuthor1() {
		List<Book> info = service.searchBookByAuthor("j");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testGetBooksInfo1() {
		List<Book> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testUpdatePassword1() {
		boolean status = service.updatePassword(8521, "sony", "Sony@12", "admin");
		Assertions.assertTrue(status);
	}
}
