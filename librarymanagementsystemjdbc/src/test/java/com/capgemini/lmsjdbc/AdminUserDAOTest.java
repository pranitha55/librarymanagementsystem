package com.capgemini.lmsjdbc;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.AdminUserDAOImple;
import com.capgemini.librarymanagementsystemjdbc.dto.Book;
import com.capgemini.librarymanagementsystemjdbc.dto.User;

public class AdminUserDAOTest {
	
private AdminUserDAO dao = new AdminUserDAOImple();
	
	@Test
	public void testRegisterUser() {
		User user= new User();
		user.setFirstName("pranitha");
		user.setLastName("soma");
		user.setEmail("prani@gmail.com");
		user.setMobile(975765767);
		user.setPassword("Prani@21");
		user.setuId(15);
		user.setRole("student");
		boolean status=dao.register(user);
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
		user.setuId(15);
		user.setRole("student");
		boolean status1=dao.register(user);
		Assertions.assertTrue(status1);
		
		}
	@Test
	public void testAuthUser() {
		User status = dao.login("prani@gmail.com", "Prani@21");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testAuthUser1() {
		User status1 = dao.login("prani@gmail.com", "Prani@21");
		Assertions.assertNotNull(status1);
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
	public void testUpdatePassword() {
		boolean msg =dao.updatePassword("praitha@gmail.com",  "pranitha@123", "pranitha@12", "student");
		Assertions.assertTrue(msg);

	}
	@Test
	public void testUpdatePassword1() {
		boolean msg1 =dao.updatePassword("praitha@gmail.com",  "pranitha@123", "pranitha@12", "student");
		Assertions.assertTrue(msg1);

	}
	@Test
	public void testSearchBookById() {
		List<Book> b=dao.searchBookById(876543);
		Assertions.assertNotNull(b);
	}
	@Test
	public void testSearchBookById1() {
		List<Book> b1=dao.searchBookById(876543);
		Assertions.assertNotNull(b1);
	}
	@Test
	public void testSearchBookByAuthor() {
		List<Book> check = dao.searchBookByAuthor("james");
		Assertions.assertNotNull(check);
		
	}
	@Test
	public void testSearchBookByAuthor1() {
		List<Book> check1 = dao.searchBookByAuthor("james");
		Assertions.assertNotNull(check1);
		
	}
	@Test
	public void testSearchBookByTitle() {
		List<Book> info = dao.searchBookByTitle("Ja");
		Assertions.assertNotNull(info);
		
	}
	@Test
	public void testSearchBookByTitle1() {
		List<Book> info1 = dao.searchBookByTitle("Ja");
		Assertions.assertNotNull(info1);
		
	}




	

}
