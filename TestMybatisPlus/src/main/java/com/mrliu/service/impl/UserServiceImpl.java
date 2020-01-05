package com.mrliu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrliu.mapper.UserMapper;
import com.mrliu.po.User;
import com.mrliu.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectById(id);
	}

}
