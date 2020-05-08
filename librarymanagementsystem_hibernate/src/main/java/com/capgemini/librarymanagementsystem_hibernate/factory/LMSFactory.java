package com.capgemini.librarymanagementsystem_hibernate.factory;

import com.capgemini.librarymanagementsystem_hibernate.dao.AdminDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.AdminDAOImple;
import com.capgemini.librarymanagementsystem_hibernate.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.AdminUserDAOImple;
import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAOImple;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminService;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminServiceImple;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminUserService;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminUserServiceImple;
import com.capgemini.librarymanagementsystem_hibernate.service.UserService;
import com.capgemini.librarymanagementsystem_hibernate.service.UserServiceImple;


public class LMSFactory {
	
	public static UserDAO getUsersDao() {
		return new UserDAOImple();
	}
	public static UserService getUsersService() {
		return new UserServiceImple();
	}
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImple();
	}
	public static AdminService getAdminService() {
		return new AdminServiceImple();
	}
	public static AdminUserDAO getAdminUserDAO() {
		return new AdminUserDAOImple();
	}
	public static AdminUserService getAdminUsersService() {
		return new AdminUserServiceImple();
	}

}
