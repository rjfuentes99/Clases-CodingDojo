package com.codingdojo.ricardo.holahumano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HolahumanoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolahumanoApplication.class, args);
	}

}
