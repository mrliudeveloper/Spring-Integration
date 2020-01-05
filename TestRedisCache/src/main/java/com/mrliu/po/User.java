package com.mrliu.po;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int uid;
	
	private String username;

	private String password;

	private double salary;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uid, String username, String password, double salary) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.salary = salary;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", salary=" + salary + "]";
	}
	
	
}
