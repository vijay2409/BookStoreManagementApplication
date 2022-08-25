package com.cg.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreManagementApplication.class, args);
		System.out.println("Server Started");
	}

}
