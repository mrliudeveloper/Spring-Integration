package com.mrliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(value = "com.mrliu")
@SpringBootApplication
public class TestPageHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestPageHelperApplication.class, args);
	}

}
