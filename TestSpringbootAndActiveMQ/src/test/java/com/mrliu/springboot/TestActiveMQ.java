package com.mrliu.springboot;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mrliu.TestSpringbootAndActiveMqApplication;

@SpringBootTest(classes = TestSpringbootAndActiveMqApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {
	@Resource
	private Queue_Produce queue_Produce;
	@Test
	public void testSend()
	{
		queue_Produce.produceMsgScheduled();
		System.out.println("send ok");
	}
}
