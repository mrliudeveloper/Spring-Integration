package com.mrliu.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * @入门程序 生产者
 * @author Mr.Liu
 *
 */
public class Producer_publish {
	private static final String QUEUE_EMAIL="QUEUE_EMAIL";
	private static final String QUEUE_SMS="QUEUE_SMS";
	private static final String EXCHANGE="EXCHANGE";

	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory=new ConnectionFactory();
		connectionFactory.setHost("localhost");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		//设置虚拟机，一个MQ服务可以设置多个虚拟机，一个虚拟机相当于一个MQ
		connectionFactory.setVirtualHost("/");
		Connection connection=null;
		Channel channel=null;
			//创建新连接
		try {
			 connection= connectionFactory.newConnection();
			 //创建会话通道，生产者和MQ服务所有通信都在channel通道中完成
			 channel = connection.createChannel();
			 //声明队列:如果队列在MQ中,没有则要创建
			 //参数:String Queue,boolean durable,boolean exclusive,
			 //		队列名称  	是否持久化	是否独占连接	
			 //	   boolean autoDelete,Map<String,Object>arguments
			 //			是否自动删除	参数：队列的扩展参数
			 channel.queueDeclare(QUEUE_EMAIL, true, false, false, null);
			 channel.queueDeclare(QUEUE_SMS, true, false, false, null);
			 //声明一个交换机
			 /**
			  * @ 交换机的名称
			  * @ 交换机的类型 :FANOUT发布订阅模式
			  *  	   DIRECT:路由的工作模式
			  *  	   TOPIC:通配符迷失
			  *  	   headers:对应的headers工作模式 
			  */
			 
			 channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.FANOUT);
			 //String queue, String exchange, String routingKey
			 //队列名称  交换机名称 路由key
			 channel.queueBind(QUEUE_EMAIL, EXCHANGE, "");
			 channel.queueBind(QUEUE_SMS, EXCHANGE, "");
			 //发送消息
			 //String exchange, String routingKey, BasicProperties props, byte[] body
			 //交换机，不指定使用默认交换机        交换机根据路由key转发到消息队列
			 //使用默认交换机时，路由key为队列名称
			 //props：消息的属性 
			 //body：消息体
			 for (int i = 0; i < 5; i++) {
				 String message="这是一个通知：hello world to user";
				 channel.basicPublish(EXCHANGE,"", null, message.getBytes());
				 System.out.println("Send...ok");
			
			}
			} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				channel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
