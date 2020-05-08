package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagementsystem.db.BookDataBase;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class UserDAOImple implements UserDAO {

	@Override
	public boolean registerUser(User user) {
		for(User u : BookDataBase.USER) {
			if(u.getEmail().equals(user.getEmail())) {
				return false;
			}
		}
		BookDataBase.USER.add(user);
		return true;
	}

	@Override
	public User loginUser(String email, String password){
		for(User user : BookDataBase.USER) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		throw new LMSException("Invalid Credentials");
	}


	@Override
	public List<Book> searchBookByTitle(String bookName) {
		List<Book> searchList=new ArrayList<Book>();
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
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}

	}

	@Override
	public List<Book> searchBookByAuthor(String author) {
		List<Book> searchList=new ArrayList<Book>();
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
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}	
	}

	@Override
	public List<Book> searchBookByCategory(String category) {
		List<Book> searchList=new ArrayList<Book>();
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
	public List<Book> getBooksInfo() {
		return BookDataBase.BOOK;
	}

	@Override
	public Request bookRequest(User user, Book book) {
		boolean flag = false, 
				isRequestExists = false;
		Request requestInfo = new Request();
		User userInfo2 = new User();
		Book bookInfo2 = new Book();

		for (Request requestInfo2 : BookDataBase.REQUEST) {
			if (book.getId() == requestInfo2.getBookInfo().getId()) {
				isRequestExists = true;

			}

		}

		if (!isRequestExists) {
			for (User userBean : BookDataBase.USER) {
				if (user.getId() == userBean.getId()) {
					for (Book book1 : BookDataBase.BOOK) {
						if (book1.getId() == book1.getId()) {
							userInfo2 = userBean;
							bookInfo2 = book1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookInfo(bookInfo2);
				requestInfo.setUserInfo(userInfo2);;
				BookDataBase.REQUEST.add(requestInfo);
				return requestInfo;
			}

		}

		throw new LMSException("Invalid request or you cannot request that book");
	}

	@Override
	public Request bookReturn(User user, Book book) {
		for (Request requestInfo : BookDataBase.REQUEST) {

			if (requestInfo.getBookInfo().getId() == book.getId() &&
					requestInfo.getUserInfo().getId() == user.getId() &&
					requestInfo.isIssued() == true) {


				System.out.println("Returning Issued book only");
				requestInfo.setReturned(true);


				return requestInfo;
			}

		}

		throw new  LMSException("Invalid return ");
	}


}
