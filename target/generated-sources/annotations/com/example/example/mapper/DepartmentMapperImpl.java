package com.example.example.mapper;

import com.example.example.dtos.DepartmentDto;
import com.example.example.model.entities.Department;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-25T23:28:55+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.7 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto departmentToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto.DepartmentDtoBuilder departmentDto = DepartmentDto.builder();

        departmentDto.departmentNumber( department.getDepartmentNumber() );
        departmentDto.departmentName( department.getDepartmentName() );

        return departmentDto.build();
    }

    @Override
    public Department departmentDtoToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.departmentNumber( departmentDto.getDepartmentNumber() );
        department.departmentName( departmentDto.getDepartmentName() );

        return department.build();
    }

    @Override
    public List<Department> toDepartmentList(List<DepartmentDto> departmentDtoList) {
        if ( departmentDtoList == null ) {
            return null;
        }

        List<Department> list = new ArrayList<Department>( departmentDtoList.size() );
        for ( DepartmentDto departmentDto : departmentDtoList ) {
            list.add( departmentDtoToDepartment( departmentDto ) );
        }

        return list;
    }

    @Override
    public List<DepartmentDto> toDepartmentDtoList(List<Department> departmentList) {
        if ( departmentList == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( departmentList.size() );
        for ( Department department : departmentList ) {
            list.add( departmentToDepartmentDto( department ) );
        }

        return list;
    }
}
