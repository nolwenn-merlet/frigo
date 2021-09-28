package com.projet.frigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrigoApplication.class, args);
	}

}

/*
	@SpringBootApplication is a meta-annotation that pulls in component scanning, autoconfiguration, and property support.
	It will fire up a servlet container and serve up our service
 */