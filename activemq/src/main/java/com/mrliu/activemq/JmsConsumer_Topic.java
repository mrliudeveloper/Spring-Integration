package com.mrliu.activemq;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQXAConnectionFactory;

public class JmsConsumer_Topic {
	public static final String ACTIVEMQ_URL="tcp://192.168.179.4:61616";
	public static final String TOPIC_NAME="Topic";
	public static void main(String[] args) throws JMSException, IOException {
		//1.创建连接工厂,按照给定的url地址，采用默认用户名和密码
				System.out.println("@@@@@@@@@@@@@@@@@");
				ActiveMQXAConnectionFactory activeMQXAConnectionFactory 
				= new ActiveMQXAConnectionFactory("admin", "admin", ACTIVEMQ_URL);
				//2.通过连接工厂获得connection连接
				Connection connection = activeMQXAConnectionFactory.createConnection();
				connection.setClientID("hello");
				//3.启动访问
				//connection.start();
				//4.创建会话Session
				//两个参数：第一个叫事务，第二个叫签收
				Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
				//5.创建目的地
				Topic topic=session.createTopic(TOPIC_NAME);
				TopicSubscriber topicSubscriber=session.createDurableSubscriber(topic, "mark...");
				
				connection.start();
				Message message = topicSubscriber.receive();
				while (message!=null) {
					
					TextMessage textMessage=(TextMessage) message;
					System.out.println("持久化的message"+textMessage.getText());
					message=topicSubscriber.receive();
				}
				session.close();
				connection.close();
	}
}
