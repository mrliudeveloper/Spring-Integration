package com.mrliu.boot.topic;

import java.util.UUID;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Topic_Produce {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	private Topic topic;
	@Scheduled(fixedDelay = 3000)
	public void produceTopic()
	{
		jmsMessagingTemplate.convertAndSend(topic, UUID.randomUUID().toString().substring(0, 6));
	}
}
