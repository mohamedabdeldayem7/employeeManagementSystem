package com.example.example.service.servicesImpl;

import com.example.example.dtos.DepartmentDto;
import com.example.example.exceptions.RequestException;
import com.example.example.mapper.DepartmentMapper;
import com.example.example.model.entities.Department;
import com.example.example.repository.DepartmentRepository;
import com.example.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentMapper mapper;

    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        return this.mapper.departmentToDepartmentDto(this.departmentRepository.save(this.mapper.departmentDtoToDepartment(departmentDto)));
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        return this.mapper.toDepartmentDtoList(this.departmentRepository.findAll());
    }

    @Override
    public DepartmentDto getDepartmentByDeptName(String deptName) {
        Optional<Department> department = this.departmentRepository.findDepartmentByDepartmentName(deptName);
        if(department.isPresent()){
            DepartmentDto departmentDto = this.mapper.departmentToDepartmentDto(department.get());
            return departmentDto;
        }else{
            throw new RequestException("Department is Not Found");
        }
    }

    @Override
    public DepartmentDto deleteDepartment(String deptName) {
        DepartmentDto departmentDto = this.getDepartmentByDeptName(deptName);
        this.departmentRepository.deleteById(departmentDto.getDepartmentNumber());
        return  departmentDto;
    }
}
