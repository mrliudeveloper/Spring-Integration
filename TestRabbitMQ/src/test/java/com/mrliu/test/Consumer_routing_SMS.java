package com.mrliu.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
/**
 * @入门程序  消费者
 * @author Mr.Liu
 *
 */
public class Consumer_routing_SMS {
	private static final String QUEUE_SMS="QUEUE_SMS";
	
	private static final String EXCHANGE="EXCHANGE-ROUTING";
	private static final String ROUTING_KEY_SMS="ROUTING_KEY_SMS";
	
	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory=new ConnectionFactory();
		connectionFactory.setHost("localhost");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		//设置虚拟机，一个MQ服务可以设置多个虚拟机，一个虚拟机相当于一个MQ
		connectionFactory.setVirtualHost("/");
		Connection connection=null;
			//创建新连接
		try {
			 connection= connectionFactory.newConnection();
			 //创建会话通道，生产者和MQ服务所有通信都在channel通道中完成
			 Channel channel = connection.createChannel();
			 //声明队列:如果队列在MQ中,没有则要创建
			 //参数:String Queue,boolean durable,boolean exclusive,
			 //		队列名称  	是否持久化	是否独占连接	
			 //	   boolean autoDelete,Map<String,Object>arguments
			 //			是否自动删除	参数：队列的扩展参数
			 channel.queueDeclare(QUEUE_SMS, true, false, false, null);
			 channel.queueBind(QUEUE_SMS, EXCHANGE, ROUTING_KEY_SMS);
			DefaultConsumer defaultConsumer=new DefaultConsumer(channel) {
				 //当接受到消息后此方法被调用
				 @Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					// TODO Auto-generated method stub
					/**
					 *String consumerTag:消费者标签，用来标识消费者
 					 *Envelope envelope: 信封，通过envelope可以获得许多参数
 					 *BasicProperties properties：消息的属性
					 *byte[] body
					 */	
					 //交换机
					 String exchange = envelope.getExchange();
					 //消息id，mq在channel中用来标识消息的id，可以用来签收消息
					 long deliveryTag = envelope.getDeliveryTag();
					 //消息内容
					 String message=new String(body,"utf-8");
					 System.out.println(message);
				 }
			 };
			 
			 //监听队列
			 //String queue, boolean autoAck, Consumer callback
			 //队列名称,自动回复:为false时需要编码回复
			 //callback：消费方法，当消费者接收消息要执行的方法
			 channel.basicConsume(QUEUE_SMS, true, defaultConsumer);
			 
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
