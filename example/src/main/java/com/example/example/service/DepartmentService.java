package com.example.example.service;

import com.example.example.dtos.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto addDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> getAllDepartment();
    DepartmentDto getDepartmentByDeptName(String deptName) ;
    DepartmentDto deleteDepartment(String deptName);
}
