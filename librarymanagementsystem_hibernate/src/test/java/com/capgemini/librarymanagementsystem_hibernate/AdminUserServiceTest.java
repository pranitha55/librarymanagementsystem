package com.capgemini.librarymanagementsystem_hibernate;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem_hibernate.dto.Book;
import com.capgemini.librarymanagementsystem_hibernate.dto.User;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminUserService;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminUserServiceImple;


public class AdminUserServiceTest {
	@SuppressWarnings("unused")
	private AdminUserService service= new AdminUserServiceImple();
	
	@Test
	public void testRegisterUser() {
		User user= new User();
		user.setFirstName("pranitha");
		user.setLastName("soma");
		user.setEmail("prani@gmail.com");
		user.setMobile(975765767);
		user.setPassword("Prani@21");
		user.setUId(15);
		user.setRole("student");
		boolean status=service.register(user);
		Assertions.assertTrue(status);
		
		
	}
	@Test
	public void testRegisterUser1() {
		User user= new User();
		user.setFirstName("pranitha");
		user.setLastName("soma");
		user.setEmail("prani@gmail.com");
		user.setMobile(975765767);
		user.setPassword("Prani@21");
		user.setUId(15);
		user.setRole("student");
		boolean status1=service.register(user);
		Assertions.assertTrue(status1);
		
		}
	@Test
	public void testAuthUser() {
		User status = service.login("prani@gmail.com", "Prani@21");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testAuthUser1() {
		User status1 = service.login("prani@gmail.com", "Prani@21");
		Assertions.assertNotNull(status1);
	}
	@Test
	public void testGetBooksInfo() {
		List<Book> b = service.getBooksInfo();
		Assertions.assertNotNull(b);
	}
	@Test
	public void testGetBooksInfo1() {
		List<Book> b1 = service.getBooksInfo();
		Assertions.assertNotNull(b1);
	}
	@Test
	public void testUpdatePassword() {
		boolean msg =service.updatePassword("praitha@gmail.com",  "pranitha@123", "pranitha@12", "student");
		Assertions.assertTrue(msg);

	}
	@Test
	public void testUpdatePassword1() {
		boolean msg1 =service.updatePassword("praitha@gmail.com",  "pranitha@123", "pranitha@12", "student");
		Assertions.assertTrue(msg1);

	}
	@Test
	public void testSearchBookById() {
		List<Book> b=service.searchBookById(876543);
		Assertions.assertNotNull(b);
	}
	@Test
	public void testSearchBookById1() {
		List<Book> b1=service.searchBookById(876543);
		Assertions.assertNotNull(b1);
	}
	@Test
	public void testSearchBookByAuthor() {
		List<Book> check = service.searchBookByAuthor("james");
		Assertions.assertNotNull(check);
		
	}
	@Test
	public void testSearchBookByAuthor1() {
		List<Book> check1 = service.searchBookByAuthor("james");
		Assertions.assertNotNull(check1);
		
	}
	@Test
	public void testSearchBookByTitle() {
		List<Book> info = service.searchBookByTitle("Ja");
		Assertions.assertNotNull(info);
		
	}
	@Test
	public void testSearchBookByTitle1() {
		List<Book> info1 = service.searchBookByTitle("Ja");
		Assertions.assertNotNull(info1);
		
	}




	

}
