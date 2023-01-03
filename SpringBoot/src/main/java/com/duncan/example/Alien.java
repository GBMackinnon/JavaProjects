package com.duncan.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	@Autowired
	private Laptop lap;
	
	public void code() {
		System.out.println("I am coding");
		lap.compile();
	}
}
