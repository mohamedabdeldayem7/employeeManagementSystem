package com.example.example.web.controller;

import com.example.example.dtos.DepartmentDto;
import com.example.example.dtos.EmployeeDto;
import com.example.example.model.constant.Role;
import com.example.example.service.EmployeeService;
import com.example.example.web.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    ResponseEntity<ResponseModel<EmployeeDto>> addEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = this.employeeService.addEmployee(employeeDto);
        ResponseModel<EmployeeDto> responseModel = ResponseModel.<EmployeeDto>builder().data(employeeDto1)
                .statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(responseModel, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<ResponseModel<List<EmployeeDto>>> getAllEmployee() {
        List<EmployeeDto> employeeDtoList = this.employeeService.getAllEmployee();
        ResponseModel<List<EmployeeDto>> responseModel = ResponseModel.<List<EmployeeDto>>builder().data(employeeDtoList)
                .statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(responseModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel<EmployeeDto>> getEmployeeById(@PathVariable("id") Integer id){
        EmployeeDto employeeDto = this.employeeService.getEmployeeById(id);
        ResponseModel<EmployeeDto> responseModel = ResponseModel.<EmployeeDto>builder().data(employeeDto)
                .statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(responseModel, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseModel<EmployeeDto>> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") Integer id) {
        EmployeeDto employeeDto1 = this.employeeService.updateEmployee(employeeDto, id);
        ResponseModel<EmployeeDto> responseModel = ResponseModel.<EmployeeDto>builder().data(employeeDto1)
                .statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel<Boolean>> deleteEmployee(@RequestBody Integer id) {
        ResponseModel<Boolean> responseModel = ResponseModel.<Boolean>builder()
                .data(this.employeeService.deleteEmployee(id)).statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(responseModel, HttpStatus.OK);
    }
}
