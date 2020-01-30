package com.mrliu.boot.topic;

import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Topic_Consumer {
	@JmsListener(destination = "${myTopic}")
	public void receive(TextMessage textMessage)
	{
		try {
			System.out.println("消费者5566订阅的主题:"+textMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
