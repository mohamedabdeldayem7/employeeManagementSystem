package com.example.example.dtos;

import com.example.example.model.constant.Role;
import com.example.example.model.entities.Department;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

@ToString
public class EmployeeDto {
    private Integer id;
    private String name;
    private Integer age;
    private DepartmentDto department;
    private String role;
}
