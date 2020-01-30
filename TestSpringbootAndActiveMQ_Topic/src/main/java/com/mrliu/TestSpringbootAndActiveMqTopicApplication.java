package com.mrliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class TestSpringbootAndActiveMqTopicApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringbootAndActiveMqTopicApplication.class, args);
	}

}
