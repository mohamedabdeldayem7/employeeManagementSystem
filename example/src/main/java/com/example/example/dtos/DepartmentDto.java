package com.example.example.dtos;

import lombok.*;

import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DepartmentDto {
    private Integer departmentNumber;
    private String departmentName;


}
