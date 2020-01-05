package com.mrliu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
@Service
public class RedisService{

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	public void setValue(String value) {
		ValueOperations<Object, Object> vo = redisTemplate.opsForValue();
		vo.set(value, value);
	}

	public String getValue(String value) {
		// TODO Auto-generated method stub
		ValueOperations<Object, Object> vo = redisTemplate.opsForValue();
		String object =(String)vo.get(value);
		return object;
	}
	
}
