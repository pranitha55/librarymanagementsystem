package com.capgemini.librarymanagementsystem_hibernate.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem_hibernate.dto.Book;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystem_hibernate.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.User;
import com.capgemini.librarymanagementsystem_hibernate.exception.LMSException;
import com.capgemini.librarymanagementsystem_hibernate.factory.LMSFactory;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminService;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminUserService;
import com.capgemini.librarymanagementsystem_hibernate.service.UserService;
import com.capgemini.librarymanagementsystem_hibernate.validation.Validation;

public class LibraryMain {
	public static void main(String[] args) {
		doReg();
	}
	public static void doReg() {
		boolean flag = false;

		int regId = 0; 
		String regFirstName = null; 
		String regLastName = null; 
		long regMobile = 0;
		String regEmail = null;
		String regPassword = null;

		boolean loginStatus = true;
		Validation validation = new Validation();
		do {
			try(Scanner scanner = new Scanner(System.in);){
				System.out.println("Press 1 to Register");
				System.out.println("Press 2 to Login");
				System.out.println("Press 3 to Exit");
				do {
					try {
						UserService service1= LMSFactory.getUsersService();
						AdminService as=LMSFactory.getAdminService();
						AdminUserService aus=LMSFactory.getAdminUsersService();
						int choice = scanner.nextInt();
						switch(choice) {
						case 1:
							
							do {
								try {
									System.out.println("Enter First Name :");
									regFirstName = scanner.next();
									validation.validatedName(regFirstName);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Name should contains only Alphabates");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);
							do {
								try {
									System.out.println("Enter Last Name :");
									regLastName = scanner.next();
									validation.validatedName(regLastName);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Name should contains only Alphabates");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);

							do {
								try {
									System.out.println("Enter Email :");
									regEmail = scanner.next();
									validation.validatedEmail(regEmail);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Email should be proper ");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);

							do {
								try {
									System.out.println("Enter Password :");
									regPassword = scanner.next();
									validation.validatedPassword(regPassword);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Enter correct Password ");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);

							do {
								try {
									System.out.println("Enter Mobile :");
									regMobile = scanner.nextLong();
									validation.validatedMobile(regMobile);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Mobile Number  should contains only numbers");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);
							System.out.println("Enter the role");
							String regRole = scanner.next();
							User u1 = new User();
							u1.setUId(regId);
							u1.setFirstName(regFirstName);
							u1.setLastName(regLastName);
							u1.setEmail(regEmail);
							u1.setPassword(regPassword);
							u1.setMobile(regMobile);
							u1.setRole(regRole);
							try {
								boolean check=aus.register(u1);
								if(check) {
									System.out.println("Registered");
								}else {
									System.out.println("Already user is registered");
								}
							}catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;
						case 2:
							System.out.println("enter email");
							String email=scanner.next();
							System.out.println("enter password");
							String password=scanner.next();
							try {
								User loginInfo=aus.login(email, password);
								if(loginInfo.getEmail().equals(email) && loginInfo.getPassword().equals(password)) {
									System.out.println("Logged In");
								}
								if(loginInfo.getRole().equals("admin")) {
									do {
										try {
											System.out.println("-----------------------------------------------");
											System.out.println("Press 1 to add book");
											System.out.println("Press 2 to remove book");
											System.out.println("Press 3 to issue book");
											System.out.println("Press 4 to Search the Book by Author");
											System.out.println("Press 5 to Search the Book by Title");
											System.out.println("Press 6 to Get the Book Information");
											System.out.println("Press 7 to Search the book by Id");
											System.out.println("Press 8 to update the book");
											System.out.println("Press 9 to check student book history");
											System.out.println("Press 10 to check requests");
											System.out.println("Press 11 to check issued books");
											System.out.println("Press 12 to view users");
											System.out.println("Press 13 to update Password");
											System.out.println("Press 14 to logout");

											int choice1 = scanner.nextInt();
											switch (choice1) {
											case 1:
												
												System.out.println("enter bookname");
												String addName=scanner.next();
												System.out.println("enter authorname");
												String addAuth=scanner.next();
												System.out.println("enter category");
												String addCategory=scanner.next();
												System.out.println("enter publisher");
												String addPublisher=scanner.next();
												Book bi =new Book();
												bi.setBookName(addName);
												bi.setAuthor(addAuth);
												bi.setCategory(addCategory);
												bi.setPublisher(addPublisher);
												try {
													boolean check2=as.addBook(bi);
													if(check2) {
														System.out.println("-----------------------------------------------");
														System.out.println("Added Book");
													}else {
														System.out.println("-----------------------------------------------");
														System.out.println("Book not added");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}

												break;	
											case 2:
												System.out.println("enter id");
												int removeId=scanner.nextInt();
												try {
													boolean check3=as.removeBook(removeId);
													if(check3) {
														System.out.println("-----------------------------------------------");
														System.out.println("Removed Book");
													}else {
														System.out.println("-----------------------------------------------");
														System.out.println("Book not removed");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 3:
												System.out.println("enter Book Id");
												int issueId=scanner.nextInt();
												System.out.println("Enter User Id");
												int userId = scanner.nextInt();
												try {
													boolean check4=as.issueBook(issueId,userId);
													if(check4) {
														System.out.println("-----------------------------------------------");
														System.out.println("Book Issued");
													}else {
														System.out.println("-----------------------------------------------");
														System.out.println("Book not issued");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 4:
												System.out.println("Search the book by the Author Name:");
												String author = scanner.next();
												try {
													List<Book> bookbyauthor = aus.searchBookByAuthor(author);
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","BookName","BookAuthor","BookCategory","BookPublisherName"));
													for (Book book : bookbyauthor) {

														if (book != null) {
															System.out.println("-----------------------------------------------");
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
																	book.getBId(),
																	book.getBookName(),
																	book.getAuthor(),
																	book.getPublisher(),
																	book.getCategory()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No books  available written by this author");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 5:
												System.out.println("  Search the book by the Book_Title :");
												String btitle = scanner.next();
												try {
													List<Book> booktitle = aus.searchBookByTitle(btitle);
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","BookName","BookAuthor","BookCategory","BookPublisherName"));
													for (Book book : booktitle) {	
														if (book != null) {
															System.out.println("-----------------------------------------------");
															
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
																	book.getBId(),
																	book.getBookName(),
																	book.getAuthor(),
																	book.getPublisher(),
																	book.getCategory()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No books are available with this title.");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 6:
												try {
													List<Book> details = aus.getBooksInfo();
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","BookName","BookAuthor","BookCategory","BookPublisherName"));
													for (Book book : details) {

														if (book != null) {
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
																	book.getBId(),
																	book.getBookName(),
																	book.getAuthor(),
																	book.getPublisher(),
																	book.getCategory()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("Books info is not present");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 7:
												System.out.println("  Search the book by the Book_ID :");
												int book_Id = scanner.nextInt();
												try {
													List<Book> bookId = aus.searchBookById(book_Id);
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","BookName","BookAuthor","BookCategory","BookPublisherName"));
													for (Book book : bookId) {	
														if (book != null) {
															System.out.println("-----------------------------------------------");
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
																	book.getBId(),
																	book.getBookName(),
																	book.getAuthor(),
																	book.getPublisher(),
																	book.getCategory()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No books are available with this ID.");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 8:
												System.out.println("Enter the updated id :");
												int bid= scanner.nextInt();
												System.out.println("Enter bookName to be updtaed");
												String updatedBookName =scanner.next();
												Book bean2 = new Book();
												bean2.setBId(bid);
												bean2.setBookName(updatedBookName);
												try {
													boolean updated = as.updateBook(bean2);
													if (updated) {
														System.out.println("-----------------------------------------------");
														System.out.println("Book is updated");
													} else {
														System.out.println("-----------------------------------------------");
														System.out.println("Book is not updated");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 9:
												System.out.println("Enter the User Id");
												int user_Id = scanner.nextInt();
												try {
													List<Integer> uid = service1.bookHistoryDetails(user_Id);
													for (Integer bookIssueDetails : uid) {
														if(bookIssueDetails != null) {
															System.out.println("-----------------------------------------------");
															System.out.println("No of books Borrowed :"+bookIssueDetails);
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("Respective user hasn't borrowed any books");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 10:
												System.out.println(" Requests received are:");
												try {
													List<RequestDetails> requests = as.showRequests();
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","UserId","BookName"));
													for (RequestDetails requestDetails : requests) {	
														if (requestDetails != null) {
															System.out.println("-----------------------------------------------");
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
															requestDetails.getUId(),
															requestDetails.getBId(),
															requestDetails.getBookName()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No Requests are received");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 11:
												System.out.println("Issued Books are:");
												try {
													List<BookIssueDetails> issuedBooks = service1.showIssuedBooks();
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","UserId","IssueDate","ReturnDate"));
													for (BookIssueDetails bookIssueBean : issuedBooks) {	
														if (bookIssueBean != null) {
															System.out.println("-----------------------------------------------");
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
															bookIssueBean.getUId(),
															bookIssueBean.getBId(),
															bookIssueBean.getIssueDate(),
															bookIssueBean.getReturnDate()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No book has been issued");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 12:
												System.out.println("Users are:");
												try {
													List<User> user = as.showUsers();
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "UserId","FirstName","LastName","EmailId","Pasword","MobileNo","UserRole"));
													for (User Bean : user) {	
														if (Bean != null) {
															System.out.println("-----------------------------------------------");
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
															Bean.getUId(),
															Bean.getFirstName(),
															Bean.getLastName(),
															Bean.getEmail(),
															Bean.getPassword(),
															Bean.getMobile(),
															Bean.getRole()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No Users are present");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 13:
												System.out.println("Enter the email :");
												String email_Id= scanner.next();
												System.out.println("Enter the Old password");
												String old_Password =scanner.next();
												System.out.println("Enter the new password");
												String new_Password =scanner.next();
												String user_Role = loginInfo.getRole();
												try {
													boolean updated = aus.updatePassword(email_Id, old_Password, new_Password, user_Role);
													if (updated) {
														System.out.println("-----------------------------------------------");
														System.out.println("Password is updated");
													} else {
														System.out.println("-----------------------------------------------");
														System.out.println("Password is not updated");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;


											case 14:
												doReg();

											default:
												System.out.println("-----------------------------------------------");
												System.out.println("Invalid Choice");
												break;
											}
										}catch (InputMismatchException ex) {
											System.out.println("Incorrect entry. Please input only a positive integer.");
											scanner.nextLine();
										}
									}while(true);
								}
								else if(loginInfo.getRole().equals("student")) {
									do {
										try {
											System.out.println("-----------------------------------------------");
											System.out.println("Press 1 to request book");
											System.out.println("Press 2 to view the books borrowed");
											System.out.println("Press 3 to search book by author");
											System.out.println("Press 4 to search book by title");
											System.out.println("Press 5 to search book by Id");
											System.out.println("Press 6 to get books info");
											System.out.println("Press 7 to return book");
											System.out.println("Press 8 to update password");
											System.out.println("Press 9 to main");


											int choice2 = scanner.nextInt();
											switch (choice2) {
											case 1:
												System.out.println("Enter the Book Id:");
												int reqBookId= scanner.nextInt();
												System.out.println("Enter the user Id:");
												int reqUserId = scanner.nextInt();
												try {
													if(loginInfo.getUId()==reqUserId) {
														boolean requested = service1.request(reqUserId,reqBookId);
														if (requested != false) {
															System.out.println("-----------------------------------------------");
															System.out.println("Book is Requested");
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("Book is not Requested");
														}	
													}else {
														System.out.println("Enter the correct UserId");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 2:
												System.out.println("Enter the user Id");
												int userId = scanner.nextInt();
												try {
													if(loginInfo.getUId()==userId) {
														List<BorrowedBooks> borrowedBooks = service1.borrowedBook(userId);
														System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","UserId","Email"));
														for (BorrowedBooks bookBean : borrowedBooks) {

															if (bookBean != null) {
																System.out.println("-----------------------------------------------");
																System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
																bookBean.getBId(),
																bookBean.getUId(),
																bookBean.getEmail()));
															} else {
																System.out.println("-----------------------------------------------");
																System.out.println("No books are borrowed by the user");
															}
														}
													}else {
														System.out.println("Incorrect user_Id");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 3:
												System.out.println("Search the book by the Author Name :");
												String author = scanner.next();
												try {
													List<Book> bookbyauthor = aus.searchBookByAuthor(author);
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","BookName","BookAuthor","BookCategory","BookPublisherName"));
													for (Book book : bookbyauthor) {

														if (book != null) {
															System.out.println("-----------------------------------------------");
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
																	book.getBId(),
																	book.getBookName(),
																	book.getAuthor(),
																	book.getPublisher(),
																	book.getCategory()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No books are available written by this author");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 4:
												System.out.println("Search the book by the Book Title :");
												String btitle = scanner.next();

												try {
													List<Book> bookbytitle = aus.searchBookByTitle(btitle);
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","BookName","BookAuthor","BookCategory","BookPublisherName"));
													for (Book bookBean : bookbytitle) {	
														if (bookBean != null) {
															System.out.println("-----------------------------------------------");
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
																	bookBean.getBId(),
																	bookBean.getBookName(),
																	bookBean.getAuthor(),
																	bookBean.getPublisher(),
																	bookBean.getCategory()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No books are available with this title.");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 5:
												System.out.println("  Search the book by the Book_ID :");
												int book_Id = scanner.nextInt();

												try {
													List<Book> bookId = aus.searchBookById(book_Id);
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","BookName","BookAuthor","BookCategory","BookPublisherName"));
													for (Book bookBean : bookId) {	
														if (bookBean != null) {
															System.out.println("-----------------------------------------------");
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
																	bookBean.getBId(),
																	bookBean.getBookName(),
																	bookBean.getAuthor(),
																	bookBean.getPublisher(),
																	bookBean.getCategory()));
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No books are available with this title.");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 6:
												try {
													List<Book> details = aus.getBooksInfo();
													System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "BookId","BookName","BookAuthor","BookCategory","BookPublisherName"));
													for (Book bookBean : details) {

														if (bookBean != null) {
															System.out.println("-----------------------------------------------");
															System.out.println(String.format("%-10s %-15s %-15s %-15s %s",
																	bookBean.getBId(),
																	bookBean.getBookName(),
																	bookBean.getAuthor(),
																	bookBean.getPublisher(),
																	bookBean.getCategory()));
																	
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("Books info is not present");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 7:
												System.out.println("Enter the Book id to return :");
												int returnId= scanner.nextInt();
												System.out.println("Enter userId");
												int user_Id = scanner.nextInt();	
												System.out.println("Enter the status of the book");
												String status = scanner.next();
												try {
													if(loginInfo.getUId()==user_Id) {
														boolean returned = service1.returnBook(returnId,user_Id,status);
														if (returned != false) {
															System.out.println("-----------------------------------------------");
															System.out.println("Book is Returned");
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("Book is not Returned");
														}	
													}else {
														System.out.println("Invalid userId");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 8:
												System.out.println("Enter the email :");
												String emailId= scanner.next();
												System.out.println("Enter the Old password");
												String oldPassword =scanner.next();
												System.out.println("Enter the new password");
												String newPassword =scanner.next();
												String userRole = loginInfo.getRole();
												try {
													boolean updated = aus.updatePassword(emailId, oldPassword, newPassword, userRole);
													if (updated) {
														System.out.println("-----------------------------------------------");
														System.out.println("Password is updated");
													} else {
														System.out.println("-----------------------------------------------");
														System.out.println("Password is not updated");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 9:
												doReg();
											default:
												break;
											}
										}catch (InputMismatchException ex) {
											System.out.println("Incorrect entry. Please input only a positive integer.");
											scanner.nextLine();
										}
									}while(true);
								}
							}catch(Exception e) {
								System.out.println("Invalid Credentials");
								System.out.println("Try logging in again,Press 2 to login");
							}
							break;

						case 3: 
							System.out.println("EXIT");
							System.exit(0);

						default:
							break;
						}
					}catch(InputMismatchException ex) {
						System.out.println("Incorrect entry. Please input only a positive integer.");
						scanner.nextLine();
					}
				}while(true);
			}
		}while(loginStatus);
	}
		
	}


