package com.mrliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
@EnableJms
@SpringBootApplication
public class TestActiveMqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestActiveMqConsumerApplication.class, args);
	}

}
