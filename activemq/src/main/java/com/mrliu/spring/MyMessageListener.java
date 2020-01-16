package com.mrliu.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;
@Component("myMessageListener")
public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		if (message!=null && message instanceof TextMessage) {
			TextMessage textMessage=(TextMessage) message;
			try {
				System.out.println(textMessage.getText());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
