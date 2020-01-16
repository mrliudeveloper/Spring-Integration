package com.mrliu.spring;

import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringMQ_Produce {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SpringMQ_Produce produce=(SpringMQ_Produce) act.getBean("springMQ_Produce");
		
		produce.jmsTemplate.send((session)->{
			TextMessage textMessage = session.createTextMessage("Spring333333ActiveMQ3333333333");
			return textMessage;
		});
		System.out.println("send task over..");
	}
	
}
