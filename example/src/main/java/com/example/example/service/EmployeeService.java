package com.example.example.service;

import com.example.example.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById( Integer id) ;
    EmployeeDto updateEmployee(EmployeeDto EmployeeDto, Integer id);
    Boolean deleteEmployee(Integer id);
}
