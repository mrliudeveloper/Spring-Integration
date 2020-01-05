package com.mrliu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrliu.po.User;
import com.mrliu.service.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/hello")
	private String sayHello()
	{
		return "hello world";
	}
	
	@RequestMapping("/getusers")
	public List<User> getUsers(@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum)
	{
		PageHelper.startPage(pageNum, 3);
		List<User> findUsers = testService.findUsers();
		PageInfo<User>pageInfo=new PageInfo<User>(findUsers);
		List<User> list = pageInfo.getList();
		return list;
	}
	
}
