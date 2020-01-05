package com.mrliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrliu.po.User;
import com.mrliu.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findUserById")
	public User findUserById(@RequestParam int id)
	{
		User findUserById = userService.findUserById(id);
		return findUserById;
	}
	
}
