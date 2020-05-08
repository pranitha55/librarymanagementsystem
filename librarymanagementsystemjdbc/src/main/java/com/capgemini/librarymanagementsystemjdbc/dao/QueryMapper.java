package com.capgemini.librarymanagementsystemjdbc.dao;

public interface QueryMapper {
	
	String registerQuery = "insert into users values(?,?,?,?,?,?,?)";
	String loginQuery = "select * from users where email=? and password=?";
	String addBookQuery = "insert into bookbean values(?,?,?,?,?)";
	String removeBookQuery = "delete from bookbean where bid=?";
	String updateBookQuery = "update bookbean set bookname=? where bid=?";
	String issueBookQuery1 = "select * from request_details where uId=? and bid=? "
			+ "and email=(select email from users where uId=?)";
	String issueBookQuery2 = "insert into book_issue_details values(?,?,?,?)";
	String issueBookQuery3 = "Insert into borrowed_books values(?,?,"
			+ "(select email from users where uId=?))";
	String requestQuery1 = "select count(*) as uId from borrowed_books where uId=? and bid=? "
			+ "and email=(select email from users where uid=?)";
	String requestQuery3 = "insert into request_details values(?,"
			+ "(select concat(firstName,'_',lastName) from users where uId=?)"
			+ ",?,(select bookname from bookbean where bid=?),(select email from users where uid=?))";
	String requestQuery2 = "select count(*) as uId from book_issue_details where uId=?";
	String titleQuery = "select * from bookBean where bookname=?";
	String authorQuery = "select * from bookBean where author=?";
	String getAllBooksQuery = "select * from bookbean";
	String bookHistroyQuery = "select count(*) as uId from book_issue_details where uId=?";
	String borrowQuery = "select * from borrowed_books where uId=?";
	String searchIdQuery = "select * from bookbean where bid=?";
	String returnBookQuery1 = "select * from book_issue_details where bid=? and uId=?";
	String returnBookQuery2 = "delete from book_issue_details where bid=? and uId=?";
	String returnBookQuery3 = "delete from borrowed_books where bid=? and uId=?";
	String returnBookQuery4 = "delete from request_details where bid=? and uId=?";
	String showRequestsQuery = "select * from request_details";
	String showIssuedBooksQuery = "select * from book_issue_details";
	String showUsersQuery = "select * from users";
	String updatePasswordQuery1 = "select * from users where email=? and role=?";
	String updatePasswordQuery2 = "update users set password=? where email=? and password=?";
		

}
