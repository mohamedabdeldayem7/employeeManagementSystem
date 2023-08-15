package com.example.example.mapper;


import com.example.example.dtos.AccountDto;
import com.example.example.dtos.EmployeeDto;
import com.example.example.model.entities.Account;
import com.example.example.model.entities.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface AccountMapper {
    AccountDto accountToAccountDto(Account account);
    Account accountDtoToAccount(AccountDto accountDto);
    Employee updateEmployee(EmployeeDto employeeDto, @MappingTarget Employee employee);
    List<AccountDto> toAccountDtoList(List<Account> accounts);
    List<Account> toAccountList(List<AccountDto> accounts);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account updateAccountFromAccountDto(AccountDto accountDto, @MappingTarget Account account);

}
