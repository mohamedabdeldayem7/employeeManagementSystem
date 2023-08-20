package com.example.example.mapper;

import com.example.example.dtos.AccountDto;
import com.example.example.dtos.DepartmentDto;
import com.example.example.dtos.EmployeeDto;
import com.example.example.model.entities.Account;
import com.example.example.model.entities.Department;
import com.example.example.model.entities.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-19T21:13:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.7 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto accountToAccountDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto.AccountDtoBuilder accountDto = AccountDto.builder();

        accountDto.id( account.getId() );
        accountDto.name( account.getName() );
        accountDto.balance( account.getBalance() );

        return accountDto.build();
    }

    @Override
    public Account accountDtoToAccount(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account.AccountBuilder account = Account.builder();

        account.id( accountDto.getId() );
        account.name( accountDto.getName() );
        account.balance( accountDto.getBalance() );

        return account.build();
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto, Employee employee) {
        if ( employeeDto == null ) {
            return employee;
        }

        employee.setId( employeeDto.getId() );
        employee.setName( employeeDto.getName() );
        employee.setEmail( employeeDto.getEmail() );
        employee.setAge( employeeDto.getAge() );
        if ( employeeDto.getDepartment() != null ) {
            if ( employee.getDepartment() == null ) {
                employee.setDepartment( Department.builder().build() );
            }
            departmentDtoToDepartment( employeeDto.getDepartment(), employee.getDepartment() );
        }
        else {
            employee.setDepartment( null );
        }
        employee.setRole( employeeDto.getRole() );

        return employee;
    }

    @Override
    public List<AccountDto> toAccountDtoList(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( accountToAccountDto( account ) );
        }

        return list;
    }

    @Override
    public List<Account> toAccountList(List<AccountDto> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<Account> list = new ArrayList<Account>( accounts.size() );
        for ( AccountDto accountDto : accounts ) {
            list.add( accountDtoToAccount( accountDto ) );
        }

        return list;
    }

    @Override
    public Account updateAccountFromAccountDto(AccountDto accountDto, Account account) {
        if ( accountDto == null ) {
            return account;
        }

        if ( accountDto.getId() != null ) {
            account.setId( accountDto.getId() );
        }
        if ( accountDto.getName() != null ) {
            account.setName( accountDto.getName() );
        }
        if ( accountDto.getBalance() != null ) {
            account.setBalance( accountDto.getBalance() );
        }

        return account;
    }

    protected void departmentDtoToDepartment(DepartmentDto departmentDto, Department mappingTarget) {
        if ( departmentDto == null ) {
            return;
        }

        mappingTarget.setDepartmentNumber( departmentDto.getDepartmentNumber() );
        mappingTarget.setDepartmentName( departmentDto.getDepartmentName() );
    }
}
