package com.capgemini.librarymanagementsystem_springlms.dao;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.User;
import com.capgemini.librarymanagementsystem_springlms.exception.LMSException;


@Repository
public class AdminUserDAOImple implements AdminUserDAO {
	
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;
	
	@PersistenceUnit
	private EntityManagerFactory factory ;
	
	@Override
	public boolean register(User user) {
		boolean isRegistered = false;
		try{
			
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			isRegistered = true;
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			//return false;
		}
		return isRegistered;
	}

	@Override
	public User login(String email, String password) {
		try {
			manager = factory.createEntityManager();
			String jpql="select u from UsersBean u where u.email=:email and u.password=:password";
			TypedQuery<User> query = manager.createQuery(jpql,User.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			User bean = query.getSingleResult();
			return bean;
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	
	
	

	@Override
	public List<Book> searchBookById(int bookId) {
		try{
			manager = factory.createEntityManager();
			String jpql = "select b from Book b where b.bId=:bId";
			TypedQuery<Book> query = manager.createQuery(jpql,Book.class);
			query.setParameter("bId", bookId);
			List<Book> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Book> searchBookByTitle(String bookName) {
		try{
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bookName=:bookName";
			TypedQuery<Book> query = manager.createQuery(jpql,Book.class);
			query.setParameter("bookName", bookName);
			List<Book> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Book> searchBookByAuthor(String authorName) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from Book b where b.authorName=:authorName";
			TypedQuery<Book> query = manager.createQuery(jpql,Book.class);
			query.setParameter("authorName", authorName);
			List<Book> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean updatePassword(int id, String password, String newPassword, String role) {
		try{
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "select u from User u where u.uId=:uId and u.role=:role and u.password=:password";
			TypedQuery<User> query = manager.createQuery(jpql,User.class);
			query.setParameter("uId", id);
			query.setParameter("role", role);
			query.setParameter("password", password);
			User rs = query.getSingleResult();
			if(rs != null) {
				User record = manager.find(User.class,id);
				record.setPassword(newPassword);
				transaction.commit();
				return true;			
			}else {
				throw new LMSException("User doesnt exist");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		} 
	}
	



	@Override
	public List<Book> getBooksInfo() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from Book b";
		TypedQuery<Book> query = manager.createQuery(jpql,Book.class);
		List<Book> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

	
	}




