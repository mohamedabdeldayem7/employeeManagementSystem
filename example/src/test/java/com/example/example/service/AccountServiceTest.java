package com.example.example.service;

import com.example.example.dtos.AccountDto;
import com.example.example.mapper.AccountMapper;
import com.example.example.model.entities.Account;
import com.example.example.repository.AccountRepository;
import com.example.example.service.servicesImpl.AccountServiceImpl;
import com.example.example.validation.AccountValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


//@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
    @InjectMocks
    AccountServiceImpl accountService;
    @Mock
    AccountRepository accountRepository;
    @Mock
    AccountMapper accountMapper;
    @Mock
    AccountValidation accountValidation;

    Account account;
    AccountDto accountDto;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Account account = Account.builder().id(1).name("mohamed").balance(20000.0).build();

        AccountDto accountDto = AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance()).build();
    }

    @Test
    public void givenAccountDtoObject_whenAddAccount_thenReturnAccountDtoObject() {

        when(accountRepository.save(account)).thenReturn(account);
        when(accountMapper.accountToAccountDto(account)).thenReturn(accountDto);
        when(accountMapper.accountDtoToAccount(accountDto)).thenReturn(account);

//        Account returnedAccount = accountRepository.save(account);
//        System.out.println(returnedAccount.getName());
//
//        Assertions.assertThat(returnedAccount).isNotNull();
//        Assertions.assertThat(returnedAccount).isEqualTo(account);

        AccountDto returnedAccount = accountService.addAccount(accountDto);
        System.out.println(returnedAccount);

        Assertions.assertThat(returnedAccount).isNotNull();
        Assertions.assertThat(returnedAccount).isEqualTo(accountDto);
    }

    @Test
    public void givenAccountsList_whenGetAllAccounts_thenReturnAccountsList() {

        Account account2 = Account.builder().id(2).name("hassan").balance(50000.0).build();

        given(accountRepository.findAll()).willReturn(List.of(account, account2));
        //when(accountMapper.toAccountList(new ArrayList<AccountDto>())).thenReturn(new ArrayList<Account>());
        //when(accountMapper.toAccountDtoList(new ArrayList<Account>())).thenReturn(new ArrayList<AccountDto>());
        when(accountMapper.accountToAccountDto(account)).thenReturn(accountDto);

        List<AccountDto> accountDtoList2 = accountService.getAllAccounts();

        Assertions.assertThat(accountDtoList2).isNotNull();
        Assertions.assertThat(accountDtoList2).hasSize(2);
    }

    @Test
    public void givenAccountId_whenGetAccountById_thenReturnAccountDtoObject() {
        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        when(accountMapper.accountToAccountDto(account)).thenReturn(accountDto);

        AccountDto returnedaccountDto = accountService.getAccountByID(account.getId());

        Assertions.assertThat(returnedaccountDto).isNotNull();
    }

    @Test
    public void givenAccountObjectAndAccountId_whenUpdateAccount_thenReturnUpdatedAccount() {

    }

    @Test
    public void givenAccountId_whenDeleteAccount_thenReturnTrue() {
        AccountDto accountDto1 = AccountDto.builder().id(1)
                .name("hamza")
                .balance(100000.0)
                .build();
        when()
    }

}
