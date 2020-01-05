package com.mrliu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mrliu.po.User;

@Mapper
public interface UserDao {

	public List<User> queryAll();
	@Select("select * from user where uid=#{id}")
	public User findUserById(int id);
	
	public int updateUser(@Param("user") User user);
	
	public  int deleteUserById(int id);
}
