package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.Book;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemjdbc.utility.LMSUtility;

public class AdminDAOImple implements AdminDAO {
	
	@SuppressWarnings("unused")
	private static final int uId = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	@Override
	public boolean addBook(Book book) {
		conn = LMSUtility.getConnection();
		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.addBookQuery);) {

			statement.setInt(1, book.getBId());
			statement.setString(2, book.getBookName());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getCategory());
			statement.setString(5, book.getPublisher());
			int count = statement.executeUpdate();
			if (count != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean removeBook(int bId) {
conn = LMSUtility.getConnection();
		
		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.removeBookQuery);) {

			statement.setInt(1, bId);
			int count = statement.executeUpdate();
			if (count != 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateBook(Book book) {
conn = LMSUtility.getConnection();
		
		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.updateBookQuery);) {

			statement.setString(1, book.getBookName());
			statement.setInt(2, book.getBId());
			int count = statement.executeUpdate();
			if (count != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean issueBook(int bId, int uId) {
conn = LMSUtility.getConnection();
		
		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.issueBookQuery1);) {

			statement.setInt(1, bId);
			statement.setInt(2, bId);
			statement.setInt(3, bId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				try (PreparedStatement pstmt1 = conn.prepareStatement(QueryMapper.issueBookQuery2);) {
					pstmt1.setInt(1, bId);
					pstmt1.setInt(2, bId);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar cal = Calendar.getInstance();
					String issueDate = sdf.format(cal.getTime());
					pstmt1.setDate(3, java.sql.Date.valueOf(issueDate));
					cal.add(Calendar.DAY_OF_MONTH, 7);
					String returnDate = sdf.format(cal.getTime());
					pstmt1.setDate(4, java.sql.Date.valueOf(returnDate));
					int count = pstmt1.executeUpdate();
					if (count != 0) {
						try (PreparedStatement pstmt2 = conn.prepareStatement(QueryMapper.issueBookQuery3);) {
							pstmt2.setInt(1, bId);
							pstmt2.setInt(2, bId);
							pstmt2.setInt(3, uId);
							int isBorrowed = pstmt2.executeUpdate();
							if (isBorrowed != 0) {
								return true;
							} else {
								return false;
							}
						}
					} else {
						throw new LMSException("Book Not issued");
					}
				}
			} else {
				throw new LMSException("The respective user have not placed any request");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<RequestDetails> showRequests() {
conn = LMSUtility.getConnection();
		
		try (Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(QueryMapper.showRequestsQuery);) {
			LinkedList<RequestDetails> beans = new LinkedList<RequestDetails>();
			while (rs.next()) {
				RequestDetails bean = new RequestDetails();
				bean.setuId(rs.getInt("uId"));
				bean.setFullName(rs.getString("fullName"));
				bean.setbId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<BookIssueDetails> showIssuedBooks() {
conn = LMSUtility.getConnection();
		
		try (Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(QueryMapper.showIssuedBooksQuery);) {
			LinkedList<BookIssueDetails> beans = new LinkedList<BookIssueDetails>();
			while (rs.next()) {
				BookIssueDetails bean = new BookIssueDetails();
				bean.setbId(rs.getInt("bookId"));
				bean.setuId(rs.getInt("userId"));
				bean.setIssueDate(rs.getDate("issueDate"));
				bean.setReturnDate(rs.getDate("returnDate"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<User> showUsers() {
		conn = LMSUtility.getConnection();
		try (Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(QueryMapper.showUsersQuery);) {
			LinkedList<User> beans = new LinkedList<User>();
			while (rs.next()) {
				User bean = new User();
				bean.setuId(rs.getInt("uId"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("mobile"));
				bean.setRole(rs.getString("role"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

}
