package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.Book;
import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemjdbc.utility.LMSUtility;

public class AdminUserDAOImple implements AdminUserDAO{
	
	@SuppressWarnings("unused")
	private static final int uId = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	@Override
	public boolean register(User user) {
		conn = LMSUtility.getConnection();

		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.registerQuery);) {

			statement.setInt(1, user.getuId());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPassword());
			statement.setLong(6, user.getMobile());
			statement.setString(7, user.getRole());
			int count = statement.executeUpdate();
			if ((user.getEmail().isEmpty()) && (count == 0)) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User login(String email, String password) {
		conn = LMSUtility.getConnection();

		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.loginQuery);) {

			statement.setString(1, email);
			statement.setString(2, password);
			rs = statement.executeQuery();
			if (rs.next()) {
				User bean = new User();
				bean.setuId(rs.getInt("uId"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("mobile"));
				bean.setRole(rs.getString("role"));
				return bean;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Book> searchBookById(int bId) {
conn = LMSUtility.getConnection();
		
		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.searchIdQuery);) {
			statement.setInt(1, bId);
			rs = statement.executeQuery();
			LinkedList<Book> beans = new LinkedList<Book>();
			while (rs.next()) {
				Book bean = new Book();
				bean.setBId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setAuthor(rs.getString("author"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Book> searchBookByTitle(String bookName) {
conn = LMSUtility.getConnection();
		
		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.titleQuery);) {

			statement.setString(1, bookName);
			rs = statement.executeQuery();
			LinkedList<Book> beans = new LinkedList<Book>();
			while (rs.next()) {
				Book bean = new Book();
				bean.setBId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setAuthor(rs.getString("author"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				beans.add(bean);
			}
			return beans;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Book> searchBookByAuthor(String author) {
conn = LMSUtility.getConnection();
		
		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.authorQuery);) {

			statement.setString(1, author);
			rs = statement.executeQuery();
			LinkedList<Book> beans = new LinkedList<Book>();
			while (rs.next()) {
				Book bean = new Book();
				bean.setBId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setAuthor(rs.getString("author"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updatePassword(String email, String password, String newPassword, String role) {
conn = LMSUtility.getConnection();
		

		try (PreparedStatement statement = conn.prepareStatement(QueryMapper.updatePasswordQuery1);) {
			statement.setString(1, email);
			statement.setString(2, role);
			rs = statement.executeQuery();
			if (rs.next()) {
				try (PreparedStatement pstmt = conn.prepareStatement(QueryMapper.updatePasswordQuery2);) {
					pstmt.setString(1, newPassword);
					pstmt.setString(2, email);
					pstmt.setString(3, password);
					int count = pstmt.executeUpdate();
					if (count != 0) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				throw new LMSException("user doesnt exist");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Book> getBooksInfo() {
		conn = LMSUtility.getConnection();
		try (Statement stmt = (Statement) conn.createStatement();) {
			rs = stmt.executeQuery(QueryMapper.getAllBooksQuery);
			LinkedList<Book> beans = new LinkedList<Book>();
			while (rs.next()) {
				Book bean = new Book();
				bean.setBId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setAuthor(rs.getString("author"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	}


