package com.capgemini.librarymanagementsystem.dao;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.db.BookDataBase;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class AdminDAOImple implements AdminDAO {
	
	@Override
	public boolean registerAdmin(Admin admin) {
		for(Admin ad : BookDataBase.ADMIN) {
			if(ad.getAdminEmail().equals(admin.getAdminEmail())) {
				return false;
			}
		}
		BookDataBase.ADMIN.add(admin);
		return true;
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		for(Admin admin : BookDataBase.ADMIN) {
			if(admin.getAdminEmail().equals(email) && admin.getAdminPassword().equals(password)) {
				return admin;
			}
		}
		throw new LMSException("Invalid credentials");

	}

	@Override
	public boolean addBook(Book book) {
		for(Book b : BookDataBase.BOOK) {
			if(b.getId()==book.getId()) {
				return false;
			}
		}
		BookDataBase.BOOK.add(book);
		return true;
	}
	
	@Override
	public ArrayList<Book> searchBookByAuthor(String author) {
		ArrayList<Book> searchList=new ArrayList<Book>();
		for(int i=0;i<=BookDataBase.BOOK.size()-1;i++)
		{
			Book retrievedBook=BookDataBase.BOOK.get(i);
			String retrievedBookAuthor=retrievedBook.getAuthor();
			if(author.equals(retrievedBookAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}		

	}
	
	@Override
	public ArrayList<Book> searchBookByTitle(String bookName) {
		ArrayList<Book> searchList=new ArrayList<Book>();
		for(int i=0;i<=BookDataBase.BOOK.size()-1;i++)
		{
			Book retrievedBook=BookDataBase.BOOK.get(i);
			String retrievedBookName=retrievedBook.getBookName();
			if(bookName.equals(retrievedBookName))
			{
				searchList.add(retrievedBook);	
				return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}

	}
	
	@Override
	public ArrayList<Book> searchBookByCategory(String category) {
		ArrayList<Book> searchList=new ArrayList<Book>();
		for(int i=0;i<=BookDataBase.BOOK.size()-1;i++)
		{
			Book retrievedBook=BookDataBase.BOOK.get(i);
			String retrievedCategory=retrievedBook.getCategory();
			if(category.equals(retrievedCategory))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}	
	}

	@Override
	public boolean removeBook(int id) {
		boolean removeStatus=false;
		for(int i=0;i<=BookDataBase.BOOK.size()-1;i++)
		{
			Book retrievedBook=BookDataBase.BOOK.get(i);
			int retrievedId=retrievedBook.getId();
			if(id==retrievedId)
			{
				removeStatus=true;
				BookDataBase.BOOK.remove(i);
				break;
			}
		}
		return removeStatus;
	}

	@SuppressWarnings("unused")
	@Override
public boolean updateBook(Book book) {
		
		for(int i=0;i<=BookDataBase.BOOK.size()-1;i++)
		{
			Book retrievedBook=BookDataBase.BOOK.get(i);
			if (retrievedBook.getId() == book.getId()) {
				retrievedBook.setBookName(book.getBookName());
				retrievedBook.setAuthor(book.getAuthor());
				retrievedBook.setCategory(book.getCategory());
				return true;
			}
			
			else {
				throw new LMSException("Invalid Book");
			}
		} 
		throw new LMSException("Book not updated");
	}
	
	@Override
	public boolean bookIssue(User user, Book book) {
		boolean isValid = false;

		Request requestInfo = new Request();

		int noOfBooksBorrowed = user.getBooksBorrowed();
		for (Request info : BookDataBase.REQUEST) {
			if (info.getUserInfo().getId() == user.getId()) {
				if (info.getBookInfo().getId() == book.getId()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)
		{
			for (Book info2 : BookDataBase.BOOK) {
				if (info2.getId() == book.getId()) {
					book = info2;
				}
			}

			for (User userInfo : BookDataBase.USER) {
				if (userInfo.getId() == user.getId()) {
					user = userInfo;
					noOfBooksBorrowed = user.getBooksBorrowed();

				}
			}

			if (noOfBooksBorrowed < 3) {

				boolean isRemoved = BookDataBase.BOOK.remove(book);
				if (isRemoved) {

					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					user.setBooksBorrowed(noOfBooksBorrowed);
					// DataBase.REQUESTDB.remove(requestInfo);
					requestInfo.setIssued(true);
					return true;
				} else {
					throw new LMSException("Book can't be borrowed");
				}

			} else {
				throw new LMSException("Student Exceeds maximum limit");
			}

		} else {
			throw new LMSException("Book data or Student data is incorrect");
		}
	}
	
	@Override
	public boolean isBookReceived(User user, Book book) {
		boolean isValid = false;
		Request requestInfo1 = new Request();
		for (Request requestInfo : BookDataBase.REQUEST) {

			if (requestInfo.getBookInfo().getId() == book.getId()
					&& requestInfo.getUserInfo().getId() == user.getId() 
					&& requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;
			}
		}
		if (isValid) {

			book.setAuthor(requestInfo1.getBookInfo().getAuthor());
			book.setBookName(requestInfo1.getBookInfo().getBookName());
			BookDataBase.BOOK.add(book);
			BookDataBase.REQUEST.remove(requestInfo1);


			for (User userInfo2 : BookDataBase.USER) {
				if (userInfo2.getId() == user.getId()) {
					user = userInfo2;
				}
			}
			int noOfBooksBorrowed = user.getBooksBorrowed();
			noOfBooksBorrowed--;
			user.setBooksBorrowed(noOfBooksBorrowed);
			return true;
		}
		return false;
	}
	
	


	

	

	@Override
	public ArrayList<Book> getBooksInfo() {
		return BookDataBase.BOOK;
	}

	

	@Override
	public List<User> showUsers() {
		List<User> usersList = new LinkedList<User>();
		for (User userBean : BookDataBase.USER) {

			userBean.getId();
			userBean.getName();
			usersList.add(userBean);

		}
		return usersList;
	}

	@Override
	public List<Request> showRequests() {
		List<Request> info = new LinkedList<Request>();
		for (Request requestInfo :BookDataBase.REQUEST) {
			requestInfo.getBookInfo();
			requestInfo.getUserInfo();
			requestInfo.isIssued();
			requestInfo.isReturned();
			info.add(requestInfo);
		}
		return info;
	}

	
	
	}


	

	

