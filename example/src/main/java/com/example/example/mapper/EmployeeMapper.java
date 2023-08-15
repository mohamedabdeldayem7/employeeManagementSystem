package com.example.example.mapper;

import com.example.example.dtos.DepartmentDto;
import com.example.example.dtos.EmployeeDto;
import com.example.example.model.entities.Department;
import com.example.example.model.entities.Employee;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(
        uses = {DepartmentMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto employeeToEmployeeDto(Employee employee);
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employee);
    List<Employee> toEmployeeList(List<EmployeeDto> employeeDtoList);
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee updateEmployeeFromEmplyeeDto(EmployeeDto employeeDto, @MappingTarget Employee employee);

}
