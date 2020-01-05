package com.mrliu.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	@Bean
	public Queue queue()
	{
		ActiveMQQueue activeMQQueue = new ActiveMQQueue("ActiveMQQueue");
	
		return activeMQQueue;
	}
}
