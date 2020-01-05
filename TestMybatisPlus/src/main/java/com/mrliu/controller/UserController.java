package com.mrliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrliu.po.User;
import com.mrliu.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "hello";
	}
	@RequestMapping("/find")
	public User findUserById(Integer id)
	{
		return userService.getUserById(id);
	}
}
