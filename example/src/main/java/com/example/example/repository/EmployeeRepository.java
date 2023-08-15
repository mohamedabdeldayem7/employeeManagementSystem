package com.example.example.repository;

import com.example.example.model.entities.Account;
import com.example.example.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
