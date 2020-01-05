package com.mrliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.mrliu")
@SpringBootApplication
public class TestRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestRedisCacheApplication.class, args);
	}

}
