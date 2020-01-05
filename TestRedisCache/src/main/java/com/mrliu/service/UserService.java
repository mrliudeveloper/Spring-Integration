package com.mrliu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mrliu.po.User;

public interface UserService {

	public List<User> queryAll();
	
	public User findUserById(int id);
	
	public int updateUser(@Param("user") User user);
	
	public  int deleteUserById(int id);
}
