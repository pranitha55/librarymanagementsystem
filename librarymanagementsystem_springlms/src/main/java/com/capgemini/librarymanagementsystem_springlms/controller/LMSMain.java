package com.capgemini.librarymanagementsystem_springlms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystem_springlms.dto.LMSResponse;
import com.capgemini.librarymanagementsystem_springlms.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.User;
import com.capgemini.librarymanagementsystem_springlms.service.AdminService;
import com.capgemini.librarymanagementsystem_springlms.service.AdminUserService;
import com.capgemini.librarymanagementsystem_springlms.service.UserService;
@RestController
public final class LMSMain {
	
		
		@Autowired
		private UserService service;
		@Autowired
		private AdminService adminService;
		@Autowired
		private AdminUserService adminUserService;

		@PostMapping(path = "/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })

		public LMSResponse addUser(@RequestBody User bean) {
			boolean isAdded = adminUserService.register(bean);
			LMSResponse response = new LMSResponse ();
			if (isAdded) {
				response.setMessage("record  is inserted");
			} else {
				response.setError(true);
				response.setMessage("unable to add");
			}
			return response;
		}

		@PostMapping(path = "/addBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  addBook(@RequestBody Book bean) {
			boolean isBookAdded = adminService.addBook(bean);
			LMSResponse  response = new LMSResponse ();
			if (isBookAdded) {
				response.setMessage("Book added succesfully");
			} else {
				response.setError(true);
				response.setMessage("Book cannot be added");
			}
			return response;

		}

		@PutMapping(path = "/bookUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  updateBook(@RequestBody Book bean) {
			boolean isBookUpdated = adminService.updateBook(bean);
			LMSResponse  response = new LMSResponse ();
			if (isBookUpdated) {
				response.setMessage("Book updated succesfully");
			} else {
				response.setError(true);
				response.setMessage("Book cannot be updated");
			}
			return response;

		}

		@PostMapping(path = "/login", 
				consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
				produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		public LMSResponse authentication(String email, String password) {
			User userLogin = adminUserService.login(email, password);
			LMSResponse response = new LMSResponse();
			if (userLogin != null) {
				response.setMessage("Login succesfull");
			} else {
				response.setError(true);
				response.setMessage("Invalid credentials,Please try again");
			}
			return response;
		}

		@DeleteMapping(path = "/removeBook/{bookId} ", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  deleteBook(@PathVariable(name = "bookId") int bookId) {
			boolean isBookDeleted = adminService.removeBook(bookId);
			LMSResponse  response = new LMSResponse ();
			if (isBookDeleted) {
				response.setMessage("Book deleted succesfully");
			} else {
				response.setError(true);
				response.setMessage("Book not deleted");
			}
			return response;
		}

		@GetMapping(path = "/BooksInfo", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  getBookInfo() {
			List<Book> getInfo = adminUserService.getBooksInfo();
			LMSResponse  response = new LMSResponse ();
			if (getInfo != null && !getInfo.isEmpty()) {
				response.setMessage("Books found");
				response.setBook1(getInfo);
			} else {
				response.setError(true);
				response.setMessage("They are no books in the Library");
			}
			return response;
		}

		@GetMapping(path = "/BooksByName", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  getBookByName(String bookTitle) {
			List<Book> bean = adminUserService.searchBookByTitle(bookTitle);
			LMSResponse  response = new LMSResponse ();
			if (bean != null && !bean.isEmpty()) {
				response.setMessage("Books found");
				response.setBook1(bean);
			} else {
				response.setError(true);
				response.setMessage("They are no books in the Library");
			}
			return response;
		}

		@GetMapping(path = "/BooksByAuthor", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  getBookByAuthor(String author) {
			List<Book> bean = adminUserService.searchBookByAuthor(author);
			LMSResponse  response = new LMSResponse ();
			if (bean != null && !bean.isEmpty()) {
				response.setMessage("Books found");
				response.setBook1(bean);
			} else {
				response.setError(true);
				response.setMessage("They are no books in the Library");
			}
			return response;
		}

		@GetMapping(path = "/BooksById", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  getBookById(int bId) {
			List<Book> bean = adminUserService.searchBookById(bId);
			LMSResponse  response = new LMSResponse ();
			if (bean != null && !bean.isEmpty()) {
				response.setMessage("Books found");
				response.setBook1(bean);
			} else {
				response.setError(true);
				response.setMessage("They are no books in the Library");
			}
			return response;
		}

		@PostMapping(path = "/bookIssue", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  issueBook(@RequestBody int userId, int bookId) {
			boolean isBookIssued = adminService.issueBook(userId, bookId);
			LMSResponse  response = new LMSResponse ();
			if (isBookIssued) {
				response.setMessage("Book issued succesfully");
			} else {
				response.setError(true);
				response.setMessage("Book cannot be issued");
			}
			return response;
		}

		@PostMapping(path = "/returnBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  returnBook(@RequestBody int bookId, int userId, String status) {
			boolean isBookReturned = service.returnBook(bookId, userId, status);
			LMSResponse  response = new LMSResponse ();
			if (isBookReturned) {
				response.setMessage("Book returned succesfully");
			} else {
				response.setError(true);
				response.setMessage("Book cannot be returned");
			}
			return response;
		}

		@PostMapping(path = "/requestBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  requestBook(@RequestBody int bookId, int userId) {
			boolean isBookRequested = service.request(bookId, userId);
			LMSResponse  response = new LMSResponse ();
			if (isBookRequested) {
				response.setMessage("Book requested succesfully");
			} else {
				response.setError(true);
				response.setMessage("Book cannot be requested");
			}
			return response;
		}

		@GetMapping(path = "/showRequests", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  showRequests() {
			List<RequestDetails> requestDetails = adminService.showRequests();
			LMSResponse  response = new LMSResponse ();

			if (requestDetails != null && !requestDetails.isEmpty()) {
				response.setRequestDetails1(requestDetails);
			} else {
				response.setError(true);
				response.setMessage("They are no requests");
			}
			return response;
		}

		@GetMapping(path = "/showIssuedBooks", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  showIssuedBooks() {
			List<BookIssueDetails> issueList = service.showIssuedBooks();
			LMSResponse  response = new LMSResponse ();

			if (issueList != null && !issueList.isEmpty()) {
				response.setBookIssueDetails1(issueList);
			} else {
				response.setError(true);
				response.setMessage("No Books are Issued");
			}
			return response;
		}

		@GetMapping(path = "/showUsers", produces = { MediaType.APPLICATION_JSON_VALUE, 
				MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  showUsers() {
			List<User> usersList = adminService.showUsers();
			LMSResponse  response = new LMSResponse ();

			if (usersList != null && !usersList.isEmpty()) {
				response.setUser1(usersList);
			} else {
				response.setError(true);
				response.setMessage("They are no Users");
			}
			return response;
		}

		@PutMapping(path = "/updatePassword", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  updatePassord(int id, String password, String newPassword, String role) {
			boolean isUpdated = adminUserService.updatePassword(id, password, newPassword, role);
			LMSResponse  response = new LMSResponse ();

			if (isUpdated) {
				response.setMessage("Password updated successfully");
			} else {
				response.setError(true);
				response.setMessage("Password is not updated");
			}
			return response;
		}

		@GetMapping(path = "/getBorrowedBooks", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
		public LMSResponse  getBorrowedBooks(@RequestBody int id) {
			List<BorrowedBooks> borrowed = service.borrowedBook(id);
			LMSResponse  response = new LMSResponse ();

			if (borrowed != null && !borrowed.isEmpty()) {
				response.setBorrowedBooks1(borrowed);
			} else {
				response.setError(true);
				response.setMessage("There are no borrowed  books");
			}
			return response;
		}
}

	
