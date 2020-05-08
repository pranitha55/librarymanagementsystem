package com.capgemini.librarymanagementsystem.db;

import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;

public class BookDataBase {
	
	
	public static final ArrayList<Book> BOOK=new ArrayList<Book>();
	public static final ArrayList<Admin> ADMIN=new ArrayList<Admin>();
	public static final ArrayList<User> USER=new ArrayList<User>();
	public static final ArrayList<Request> REQUEST = new ArrayList<Request>();
	
public static void addToDB() {
		
		ADMIN.add(new Admin(11111, "pranitha@gmail.com","pranitha","Pranitha12@"));
		ADMIN.add(new Admin(22222, "prashanthi@gmail.com","prashanthi", "Prashanthi12@"));
		
		BOOK.add(new Book(10101,"The lord of the rings","J.R.R.Tolkien","Allen & Uniin ","Fantacy"));
		BOOK.add(new Book(10102,"The 3 mistakes of my life","chetan bhagat","Rupa ","Fiction"));
		BOOK.add(new Book(10103,"A brief history of time","Stephen Hawking","Bantam Dell"," Popular Science "));
						
	}
	
	

	
	
	

}
