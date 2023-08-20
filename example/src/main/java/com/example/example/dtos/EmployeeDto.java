package com.example.example.dtos;

import com.example.example.model.constant.Regex;
import com.example.example.model.constant.Role;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EmployeeDto {
    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 3 , max = 15)
    private String name;

    @NotNull
    @Pattern(regexp = Regex.EMAIL_REGEX)
    private String email;

    @NotNull
    @Min(18)
    private Integer age;

    @NotNull
    private DepartmentDto department;

    @NotNull
    private Role role;
}
