package com.mrliu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrliu.mapper.UserMapper;
import com.mrliu.po.User;
import com.mrliu.service.TestService;
@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}
}
