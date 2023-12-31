package com.example.example.service;

import com.example.example.dtos.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto addAccount(AccountDto accountDto);

    List<AccountDto> getAllAccounts();
    AccountDto getAccountByID(Integer id);
    AccountDto updateAccount(AccountDto accountDto, Integer id);
    AccountDto deleteAccount(Integer id);
}
