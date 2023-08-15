package com.example.example.model.entities;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Department {
    @Id
    private Integer departmentNumber;

    @Column(name = "departmentName", nullable = false, unique = true)
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;

}
