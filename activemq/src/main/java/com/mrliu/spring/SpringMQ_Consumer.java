package com.mrliu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringMQ_Consumer {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringMQ_Consumer consumer =(SpringMQ_Consumer)act.getBean("springMQ_Consumer");
		String receiveAndConvert = (String) consumer.jmsTemplate.receiveAndConvert();
		System.out.println("消费者收到的消息"+receiveAndConvert);
	}
	
}