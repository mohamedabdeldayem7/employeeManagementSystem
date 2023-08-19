package com.example.example.web.controller;

import com.example.example.dtos.AccountDto;
import com.example.example.service.AccountService;
import com.example.example.web.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController  {

    @Autowired
    private  AccountService accountService;

    @PostMapping("/")
    public ResponseEntity<ResponseModel<AccountDto>> addAccount(@RequestBody AccountDto accountDto) {
        AccountDto accountDto1 = this.accountService.addAccount(accountDto);
        ResponseModel<AccountDto> model = ResponseModel.<AccountDto>builder().data(accountDto1).statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<ResponseModel<List<AccountDto>>> getAllAccounts() {
        List<AccountDto> accountDtoList = this.accountService.getAllAccounts();
        ResponseModel<List<AccountDto>> model = ResponseModel.<List<AccountDto>>builder().data(accountDtoList).statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel<AccountDto>> getAccountByID(@PathVariable("id") Integer id) {
        AccountDto accountDto1 = this.accountService.getAccountByID(id);
        ResponseModel<AccountDto> model = ResponseModel.<AccountDto>builder().data(accountDto1).statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseModel<AccountDto>> updateAccount(@RequestBody AccountDto accountDto, @PathVariable("id") Integer id) {
        AccountDto accountDto1 = this.accountService.updateAccount(accountDto, id);
        ResponseModel<AccountDto> model = ResponseModel.<AccountDto>builder().data(accountDto1).statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel<AccountDto>> deleteAccount(@PathVariable("id") Integer id) {
        AccountDto deleteAccount = this.accountService.deleteAccount(id);
        ResponseModel<AccountDto> model = ResponseModel.<AccountDto>builder().data(deleteAccount).statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity(model, HttpStatus.OK);
    }
}
