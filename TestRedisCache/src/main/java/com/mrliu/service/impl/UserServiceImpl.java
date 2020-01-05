package com.mrliu.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.mrliu.dao.UserDao;
import com.mrliu.po.User;
import com.mrliu.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RedisTemplate<Object,User> redisTemplate;
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		String key="user_"+id;
		ValueOperations<Object, User>operations=redisTemplate.opsForValue();
		boolean haskey=redisTemplate.hasKey(key);
		if (haskey) {
			User user=operations.get(key);
			System.out.println("=======从缓存中获得数据=======");
			System.out.println("=====>"+user.toString());
			System.out.println("=========================");
			return user;
		}else {
			User user = userDao.findUserById(id);
            System.out.println("==========从数据表中获得数据=========");
            System.out.println("====>"+user.toString());
            System.out.println("==============================");

            // 写入缓存
            operations.set(key, user, 5, TimeUnit.HOURS);
            return user;
		}
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		ValueOperations<Object, User> operations = redisTemplate.opsForValue();
        int result = userDao.updateUser(user);
        if (result != 0) {
            String key = "user_" + user.getUid();
            boolean haskey = redisTemplate.hasKey(key);
            if (haskey) {
                redisTemplate.delete(key);
                System.out.println("====删除缓存中的key====>" + key);
            }
            // 再将更新后的数据加入缓存
            User userNew = userDao.findUserById(user.getUid());
            if (userNew != null) {
                operations.set(key, userNew, 3, TimeUnit.HOURS);
            }
        }
        return result;
	}

	@Override
	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		 int result = userDao.deleteUserById(id);
	        String key = "user_" + id;
	        if (result != 0) {
	            boolean hasKey = redisTemplate.hasKey(key);
	            if (hasKey) {
	                redisTemplate.delete(key);
	                System.out.println("====删除缓存中的key====>" + key);
	            }
	        }
	        return result;
	}

}
