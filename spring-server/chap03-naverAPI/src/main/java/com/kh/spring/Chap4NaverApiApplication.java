package com.kh.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"com.kh.spring.service.UserService"})
@SpringBootApplication
public class Chap4NaverApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap4NaverApiApplication.class, args);
		
	}

}
