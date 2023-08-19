package com.example.example.dtos;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EmployeeDto {
    private Integer id;
    private String name;
    private Integer age;
    private DepartmentDto department;
    private String role;
}
