package com.example.example.service.servicesImpl;

import com.example.example.dtos.EmployeeDto;
import com.example.example.exceptions.RequestException;
import com.example.example.mapper.DepartmentMapper;
import com.example.example.mapper.EmployeeMapper;
import com.example.example.model.entities.Employee;
import com.example.example.repository.EmployeeRepository;
import com.example.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper mapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        return this.mapper.employeeToEmployeeDto(this.employeeRepository.save(this.mapper.employeeDtoToEmployee(employeeDto)));
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return this.mapper.toEmployeeDtoList(this.employeeRepository.findAll());
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id){
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if(employee.isPresent()){
            EmployeeDto employeeDto = this.mapper.employeeToEmployeeDto(employee.get());
            return employeeDto;
        }else {
            throw new RequestException("Employee is Not Found");
        }
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer id){
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if(employee.isPresent()){
            Employee existingEmployee = employee.get();
            existingEmployee.setName(employeeDto.getName());
            existingEmployee.setAge(employeeDto.getAge());
            existingEmployee.setDepartment(this.departmentMapper.departmentDtoToDepartment(employeeDto.getDepartment()));
            existingEmployee.setRole(employeeDto.getRole());

            return this.mapper.employeeToEmployeeDto(this.employeeRepository.save(existingEmployee));
        }else {
            throw new RequestException("Employee is Not Found");
        }
    }

    @Override
    public Boolean deleteEmployee(Integer id)  {
        this.employeeRepository.deleteById(id);
        return true;
    }
}
