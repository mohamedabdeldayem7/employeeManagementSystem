package com.example.example.mapper;

import com.example.example.dtos.EmployeeDto;
import com.example.example.model.entities.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-19T21:13:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.7 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public EmployeeDto employeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto.EmployeeDtoBuilder employeeDto = EmployeeDto.builder();

        employeeDto.id( employee.getId() );
        employeeDto.name( employee.getName() );
        employeeDto.email( employee.getEmail() );
        employeeDto.age( employee.getAge() );
        employeeDto.department( departmentMapper.departmentToDepartmentDto( employee.getDepartment() ) );
        employeeDto.role( employee.getRole() );

        return employeeDto.build();
    }

    @Override
    public List<EmployeeDto> toEmployeeDtoList(List<Employee> employee) {
        if ( employee == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employee.size() );
        for ( Employee employee1 : employee ) {
            list.add( employeeToEmployeeDto( employee1 ) );
        }

        return list;
    }

    @Override
    public List<Employee> toEmployeeList(List<EmployeeDto> employeeDtoList) {
        if ( employeeDtoList == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeeDtoList.size() );
        for ( EmployeeDto employeeDto : employeeDtoList ) {
            list.add( employeeDtoToEmployee( employeeDto ) );
        }

        return list;
    }

    @Override
    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeDto.getId() );
        employee.name( employeeDto.getName() );
        employee.email( employeeDto.getEmail() );
        employee.age( employeeDto.getAge() );
        employee.department( departmentMapper.departmentDtoToDepartment( employeeDto.getDepartment() ) );
        employee.role( employeeDto.getRole() );

        return employee.build();
    }

    @Override
    public Employee updateEmployeeFromEmplyeeDto(EmployeeDto employeeDto, Employee employee) {
        if ( employeeDto == null ) {
            return employee;
        }

        if ( employeeDto.getId() != null ) {
            employee.setId( employeeDto.getId() );
        }
        if ( employeeDto.getName() != null ) {
            employee.setName( employeeDto.getName() );
        }
        if ( employeeDto.getEmail() != null ) {
            employee.setEmail( employeeDto.getEmail() );
        }
        if ( employeeDto.getAge() != null ) {
            employee.setAge( employeeDto.getAge() );
        }
        if ( employeeDto.getDepartment() != null ) {
            employee.setDepartment( departmentMapper.departmentDtoToDepartment( employeeDto.getDepartment() ) );
        }
        if ( employeeDto.getRole() != null ) {
            employee.setRole( employeeDto.getRole() );
        }

        return employee;
    }
}
