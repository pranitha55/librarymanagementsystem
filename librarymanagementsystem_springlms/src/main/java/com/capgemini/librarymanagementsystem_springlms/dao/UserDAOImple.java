package com.capgemini.librarymanagementsystem_springlms.dao;


import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem_springlms.dto.Book;
import com.capgemini.librarymanagementsystem_springlms.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystem_springlms.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_springlms.dto.User;
import com.capgemini.librarymanagementsystem_springlms.exception.LMSException;



@Repository
public class UserDAOImple implements UserDAO{
	
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;
	@PersistenceUnit
	private EntityManagerFactory factory ;
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public boolean request(int userId, int bookId) {
		int count=0;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from Book b where b.bookId=:bookId";
			TypedQuery<Book> query = manager.createQuery(jpql,Book.class);
			query.setParameter("bookId", bookId);
			List rs = query.getResultList();
			if(rs != null) {
				String jpql1 = "select b from BorrowedBooks b where b.userId=:userId and b.bookId=:bookId";
				TypedQuery<BorrowedBooks> query1 = (TypedQuery<BorrowedBooks>) manager.createQuery(jpql1,BorrowedBooks.class);
				//
				query1.setParameter("userId", userId);
				query1.setParameter("bookId", bookId);
				List rs1 = query1.getResultList();
				if( rs1.isEmpty() || rs1==null ) {
					String jpql2 = "select b from BookIssueDetails b where b.userId=:userId";
					TypedQuery<BookIssueDetails> query2 = (TypedQuery<BookIssueDetails>) manager.createQuery(jpql2,BookIssueDetails.class);
					query2.setParameter("userId", userId);
					List<BookIssueDetails> rs2 = query2.getResultList();
					for(BookIssueDetails p : rs2) {
						noOfBooks = count++;
					}
					if(noOfBooks<3) {
						Query bookName = manager.createQuery("select b.bookName from Book b where b.bookId=:bookId");
						bookName.setParameter("bookId", bookId);
						List book = bookName.getResultList();
						Query email = manager.createQuery("select u.email from User u where u.userId=:user_Id");
						email.setParameter("user_Id", userId);
						List userEmail = email.getResultList();
						transaction.begin();
						RequestDetails request = new RequestDetails();
						
						request.setUId(userId);
						request.setBId(bookId);
						request.setBookName(book.get(0).toString());
						manager.persist(request);
						transaction.commit();
						return true;

					}else {
						throw new LMSException("You have crossed the book limit");
					}
				}else {
					throw new LMSException("You have already borrowed the requested book");
				}
			}else {
				throw new LMSException("The book with requested id is not present");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BorrowedBooks> borrowedBook(int userId) {
		
	try {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from BorrowedBooks b where b.userId=:userId";
		TypedQuery<BorrowedBooks> query = manager.createQuery(jpql,BorrowedBooks.class);
		//
		query.setParameter("userId", userId);
		List<BorrowedBooks> recordList = query.getResultList();
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
	public boolean returnBook(int bookId, int userId, String status) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from Book b where b.bookId=:bookId";
			TypedQuery<Book> query = manager.createQuery(jpql,Book.class);
			query.setParameter("bookId", bookId);
			Book rs = query.getSingleResult();
			if(rs != null) {
				String jpql1 = "select b from BookIssueDetails b where b.bookId=:bookId and b.userId=:userId ";
				TypedQuery<BookIssueDetails> query1 = manager.createQuery(jpql1,BookIssueDetails.class);
				
				query1.setParameter("bookId", bookId);
				query1.setParameter("userId", userId);
				BookIssueDetails rs1 = query1.getSingleResult();
				if(rs1 != null) {
					Date issueDate = rs1.getIssueDate();
					Calendar cal = Calendar.getInstance();
					Date returnDate = cal.getTime();
					long difference = issueDate.getTime() - returnDate.getTime();
					float daysBetween = (difference / (1000*60*60*24));
					if(daysBetween>7.0) {
						float fine = daysBetween*5;
						System.out.println("The user has to pay the fine of the respective book of Rs:"+fine);
						if(status=="yes") {
							transaction.begin();
							
							manager.remove(rs1);
							transaction.commit();


							transaction.begin();
							String jpql3 = "select b from BorrowedBooks b  where b.bookId=:bookId and b.userId=:userId";
							Query query3 = manager.createQuery(jpql3);
							query3.setParameter("bookId", bookId);
							query3.setParameter("userId", userId);
							BorrowedBooks bbb = (BorrowedBooks) query3.getSingleResult();
							manager.remove(bbb);
							transaction.commit();

							transaction.begin();
							String jpql4 = "select r from RequestsDetails r where r.bookId=:bookId and r.userId=:userId";
							Query query4 = manager.createQuery(jpql4);
							query4.setParameter("bookId", bookId);
							query4.setParameter("userId", userId);
							RequestDetails rdb = (RequestDetails) query4.getSingleResult();
							manager.remove(rdb);
							transaction.commit();
							return true;
						}else {
							throw new LMSException("The User has to pay fine for delaying book return");
						}
					}else {
						transaction.begin();
						
						manager.remove(rs1);
						transaction.commit();


						transaction.begin();
						String jpql3 = "select b from BorrowedBooks b  where b.bookId=:bookId and b.userId=:userId";
						Query query3 = manager.createQuery(jpql3);
						query3.setParameter("bookId", bookId);
						//
						query3.setParameter("userId", userId);
						BorrowedBooks bbb = (BorrowedBooks) query3.getSingleResult();
						manager.remove(bbb);
						transaction.commit();

						transaction.begin();
						String jpql4 = "select r from RequestDetails r where r.bookId=:bookId and r.userId=:userId";
						Query query4 = manager.createQuery(jpql4);
						query4.setParameter("bookId", bookId);
						//
						query4.setParameter("userId", userId);
						RequestDetails rdb = (RequestDetails) query4.getSingleResult();
						//int rdb_Id = rdb.getId();
						manager.remove(rdb);
						transaction.commit();
						return true;
					}

				}else {
					throw new LMSException("This respective user hasn't borrowed any book");
				}
			}else {
				throw new LMSException("book doesnt exist");
			}

		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@SuppressWarnings("unused")
	@Override
	public List<Integer> bookHistoryDetails(int userId) {
		int count=0;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from BookIssueDetails b";
		TypedQuery<BookIssueDetails> query = manager.createQuery(jpql,BookIssueDetails.class);
		List<BookIssueDetails> recordList = query.getResultList();
		for(BookIssueDetails p : recordList) {
			noOfBooks = count++;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(noOfBooks);
		manager.close();
		factory.close();
		return list;
	}

	

	@Override
	public List<BookIssueDetails> showIssuedBooks() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from BookIssueDetails b";
		TypedQuery<BookIssueDetails> query = manager.createQuery(jpql,BookIssueDetails.class);
		List<BookIssueDetails> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

	

	
}
