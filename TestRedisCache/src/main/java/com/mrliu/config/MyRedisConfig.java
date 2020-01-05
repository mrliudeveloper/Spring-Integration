package com.mrliu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.mrliu.po.User;

@Configuration
public class MyRedisConfig {
    @Bean
    public  RedisTemplate<Object,User>empRedisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        RedisTemplate<Object,User>template=new  RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<User>  serializer = new  Jackson2JsonRedisSerializer<User>(User.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
}
