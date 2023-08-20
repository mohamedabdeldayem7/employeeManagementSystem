package com.example.example;

import com.example.example.dtos.AccountDto;
import com.example.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

}
