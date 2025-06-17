package com.secure.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SecureNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureNotesApplication.class, args);
	}

}
