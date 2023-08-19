package com.example.example.validation;

import com.example.example.dtos.AccountDto;
import com.example.example.exceptions.NotValidException;
import com.example.example.model.constant.ExceptionMessages;
import com.example.example.model.constant.Regex;
import org.springframework.stereotype.Component;

@Component
public class AccountValidation {
    public void validateName(String name){
        if(!name.matches(Regex.NAME_REGEX)){
            throw new NotValidException(ExceptionMessages.NAME_NOT_ALLOWED.name());
        }
    }
    public void validateBalance(Double balance){
        if(balance < 50 || balance%50 != 0){
            throw new NotValidException(ExceptionMessages.BALANCE_NOT_ALLOWED.name());
        }
    }
    public void validateAccount(AccountDto accountDto){
        this.validateName(accountDto.getName());
        this.validateBalance(accountDto.getBalance());
    }
}
