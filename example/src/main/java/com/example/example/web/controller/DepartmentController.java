package com.example.example.web.controller;

import com.example.example.dtos.DepartmentDto;
import com.example.example.dtos.EmployeeDto;
import com.example.example.service.DepartmentService;
import com.example.example.web.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    ResponseEntity<ResponseModel<DepartmentDto>> addDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = this.departmentService.addDepartment(departmentDto);
        ResponseModel<DepartmentDto> responseModel = ResponseModel.<DepartmentDto>builder().data(departmentDto1)
                .statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(responseModel, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<ResponseModel<List<DepartmentDto>>> getAllDepartment() {
        List<DepartmentDto> departmentDtoList = this.departmentService.getAllDepartment();
        ResponseModel<List<DepartmentDto>> responseModel = ResponseModel.<List<DepartmentDto>>builder().data(departmentDtoList)
                .statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(responseModel, HttpStatus.OK);
    }
    @GetMapping("/{departmentName}")
    ResponseEntity<ResponseModel<DepartmentDto>> getDepartmentByDeptNumber(@PathVariable("departmentName") String departmentName){
        DepartmentDto departmentDto = this.departmentService.getDepartmentByDeptName(departmentName);
        ResponseModel<DepartmentDto> responseModel = ResponseModel.<DepartmentDto>builder().data(departmentDto)
                .statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(responseModel, HttpStatus.OK);
    }


    @DeleteMapping("/{name}")
    ResponseEntity<ResponseModel<DepartmentDto>> deleteDepartment(@PathVariable("name") String departmentName)  {
        ResponseModel<DepartmentDto> responseModel = ResponseModel.<DepartmentDto>builder()
                .data(this.departmentService.deleteDepartment(departmentName)).statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(responseModel, HttpStatus.OK);
    }
}
