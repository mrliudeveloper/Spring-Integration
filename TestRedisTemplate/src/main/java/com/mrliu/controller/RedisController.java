package com.mrliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrliu.service.RedisService;

@RestController
public class RedisController {
	
	@Autowired
	private RedisService redisService;
	@RequestMapping("/hello")
	public String sayhello(@RequestParam("value")String value)
	{
		
		redisService.setValue(value);
		return "hello world";
	}
	@RequestMapping("/seehello")
	public String seehello(@RequestParam("value")String value)
	{
		
		String string = redisService.getValue(value);
		return string;
	}
}
