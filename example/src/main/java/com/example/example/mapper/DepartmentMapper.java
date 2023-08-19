package com.example.example.mapper;

//import com.example.example.dtos.DepartmentDto;
//import com.example.example.model.entities.Department;
import com.example.example.dtos.DepartmentDto;
import com.example.example.model.entities.Department;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDto departmentToDepartmentDto(Department department);
    Department departmentDtoToDepartment(DepartmentDto departmentDto);
    List<Department> toDepartmentList(List<DepartmentDto> departmentDtoList);
    List<DepartmentDto> toDepartmentDtoList(List<Department> departmentList);

}
