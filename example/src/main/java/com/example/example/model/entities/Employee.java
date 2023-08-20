package com.example.example.model.entities;


import com.example.example.model.constant.Role;
import lombok.*;

import javax.persistence.*;

@Entity(name = "employee")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "department_number")
    private Department department;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
