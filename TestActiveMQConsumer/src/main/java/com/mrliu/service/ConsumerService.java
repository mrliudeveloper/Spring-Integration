package com.mrliu.service;

import javax.jms.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	
	@Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
	//@Autowired
	//private JmsMessagingTemplate jmsMessagingTemplate;
	
	@JmsListener(destination = "ActiveMQQueue") //,containerFactory = "jmsListenerContainerTopic"
	@SendTo("SQueue")
	public String handleMessage(String name)
	{
		logger.error(name);
		return name;
	}
}
