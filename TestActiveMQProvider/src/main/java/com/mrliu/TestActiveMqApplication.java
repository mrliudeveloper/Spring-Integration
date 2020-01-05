package com.mrliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
@EnableJms
@SpringBootApplication
public class TestActiveMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestActiveMqApplication.class, args);
	}

}
