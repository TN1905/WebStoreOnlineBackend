package com.example.storeonline.webstoreonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.storeonline.webstoreonline.model")
public class WebstoreonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebstoreonlineApplication.class, args);
	}

}
