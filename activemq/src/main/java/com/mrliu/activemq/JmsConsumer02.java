package com.mrliu.activemq;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQXAConnectionFactory;

public class JmsConsumer02 {
	public static final String ACTIVEMQ_URL="tcp://192.168.179.4:61616";
	public static final String QUEUE_NAME="queue";
	public static void main(String[] args) throws JMSException, IOException {
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
				//5.创建目的地
				Queue queue=session.createQueue(QUEUE_NAME);
				//6.创建消费者
				MessageConsumer messageConsumer = session.createConsumer(queue);
				//7.创建消息监听器
				messageConsumer.setMessageListener(new MessageListener() {
					
					@Override
					public void onMessage(Message message) {
						// TODO Auto-generated method stub
						if (message!=null && message instanceof TextMessage) {
							TextMessage textMessage=(TextMessage)message;
							try {
								System.out.println("消费者接收到信息："+textMessage.getText());
							} catch (JMSException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				System.in.read();//保证控制台不灭
				//8.关闭资源
				messageConsumer.close();
				session.close();
				connection.close();
	}
}
