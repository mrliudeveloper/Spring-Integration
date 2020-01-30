package com.mrliu.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * @入门程序 生产者
 * @author Mr.Liu
 *
 */
public class Producer {
	private static final String queue="HELLO-WORLD";

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
			 channel.queueDeclare(queue, true, false, false, null);
			 //发送消息
			 //String exchange, String routingKey, BasicProperties props, byte[] body
			 //交换机，不指定使用默认交换机        交换机根据路由key转发到消息队列
			 //使用默认交换机时，路由key为队列名称
			 //props：消息的属性 
			 //body：消息体
			 String message="hello world";
			 channel.basicPublish("", queue, null, message.getBytes());
			 System.out.println("Send...ok");
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
