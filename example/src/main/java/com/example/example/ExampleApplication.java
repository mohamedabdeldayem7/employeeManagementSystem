package com.example.example;

import com.example.example.dtos.DepartmentDto;
import com.example.example.dtos.EmployeeDto;
import com.example.example.mapper.DepartmentMapper;
import com.example.example.model.constant.Role;
import com.example.example.model.entities.Department;
import com.example.example.service.AccountService;
import com.example.example.service.DepartmentService;
import com.example.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.IntStream;


@SpringBootApplication
public class ExampleApplication {

	@Autowired
	private AccountService accountService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentMapper departmentMapper;

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}




}
