package com.mrliu.activemq;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQXAConnectionFactory;

public class JmsProducer_Topic {

	public static final String ACTIVEMQ_URL="tcp://192.168.179.4:61616";
	public static final String TOPIC_NAME="Topic";
	
	public static void main(String[] args) throws JMSException {
		//1.创建连接工厂,按照给定的url地址，采用默认用户名和密码
		ActiveMQXAConnectionFactory activeMQXAConnectionFactory 
		= new ActiveMQXAConnectionFactory("admin", "admin", ACTIVEMQ_URL);
		//2.通过连接工厂获得connection连接
		Connection connection = activeMQXAConnectionFactory.createConnection();
		//3.启动访问
		connection.start();
		//4.创建会话Session
		//两个参数：第一个叫事务，第二个叫签收
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		
		//5.创建目的地(具体是队列还是主题)
		Topic topic = session.createTopic(TOPIC_NAME);
		
		//6.创建消息的生产者producer
		MessageProducer messageProducer = session.createProducer(topic);
		//7.使用生产者产生3条消息发送到Topic主题里面
		for (int i = 0; i <6; i++) {
			//8.创建消息
			TextMessage createTextMessage = session.createTextMessage("Topic msg---"+i);
			//9.通过Message producer发送给MQ
			messageProducer.send(createTextMessage);
		}
		//10.关闭资源
		messageProducer.close();
		session.close();
		connection.close();
		System.out.println("******消息发送到MQ完成*******");
	}
}
