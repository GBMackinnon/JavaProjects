package com.duncan.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
	
	//@Autowired
	//private Alien alien;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

//		System.out.println("XXX");
		Alien alien = context.getBean(Alien.class);
		
	}

}
