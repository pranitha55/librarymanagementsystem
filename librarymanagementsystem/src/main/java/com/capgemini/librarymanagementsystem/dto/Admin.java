package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;



@SuppressWarnings("serial")
public class Admin implements Serializable {
	
	private int adminId = (int)Math.random();
	private String adminPassword;
	private String adminName;
	private String adminEmail;
	private long mobile;
	public Admin() {
		
	}
	
	public Admin(int adminId,String email,String name,String password) {
		super();
		this.adminId = adminId;
		this.adminEmail=email;
		this.adminName=name;
		this.adminPassword=password;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
	

}
