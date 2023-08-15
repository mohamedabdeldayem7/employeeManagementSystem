package com.example.example.repository;

import com.example.example.model.entities.Account;
import com.example.example.model.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findDepartmentByDepartmentName(String departmentName);
    void deleteByDepartmentName(String name);
}
