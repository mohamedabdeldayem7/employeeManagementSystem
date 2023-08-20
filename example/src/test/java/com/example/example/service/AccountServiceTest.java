package com.example.example.service;

import com.example.example.dtos.AccountDto;
import com.example.example.mapper.AccountMapper;
import com.example.example.model.entities.Account;
import com.example.example.repository.AccountRepository;
import com.example.example.service.servicesImpl.AccountServiceImpl;
import com.example.example.validation.AccountValidation;
import org.assertj.core.api.Assertions;
import org.hibernate.sql.Update;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

        Account account = Account.builder().id(1).name("mohamed").balance(20000.0).build();

        AccountDto accountDto = AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance()).build();

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
        Account account = Account.builder().id(1).name("mohamed").balance(20000.0).build();

        AccountDto accountDto = AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance()).build();

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

        Account account = Account.builder().id(1).name("mohamed").balance(20000.0).build();

        AccountDto accountDto = AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance()).build();

        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        when(accountMapper.accountToAccountDto(account)).thenReturn(accountDto);

        AccountDto returnedaccountDto = accountService.getAccountByID(account.getId());

        Assertions.assertThat(returnedaccountDto).isNotNull();
    }

    @Test
    public void givenAccountObjectAndAccountId_whenUpdateAccount_thenReturnUpdatedAccount() {
        Account account = Account.builder().id(1).name("mohamed").balance(20000.0).build();

        AccountDto accountDto = AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance()).build();

        AccountDto updatedAccountDto = AccountDto.builder()
                .id(1)
                .name("Hamza")
                .balance(35000.0)
                .build();
        Account updatedAccount = Account.builder().id(1).name(updatedAccountDto.getName()).balance(updatedAccountDto.getBalance()).build();

        System.out.println(account);
        System.out.println(accountDto);

        Integer id = account.getId();

        when(accountRepository.findById(id)).thenReturn(Optional.ofNullable(account));
        when(accountRepository.save(updatedAccount)).thenReturn(updatedAccount);
        when(accountMapper.updateAccountFromAccountDto(updatedAccountDto, account)).thenReturn(updatedAccount);
        when(accountMapper.accountToAccountDto(updatedAccount)).thenReturn(updatedAccountDto);
        when(accountMapper.accountDtoToAccount(updatedAccountDto)).thenReturn(updatedAccount);

        AccountDto resultAccountDto = accountService.updateAccount(updatedAccountDto, id);

        Assertions.assertThat(resultAccountDto).isNotNull();
        Assertions.assertThat(resultAccountDto).isEqualTo(updatedAccountDto);

    }

    @Test
    public void givenAccountId_whenDeleteAccount_thenReturnDeletedAccountDto() {
        Account account = Account.builder().id(1).name("mohamed").balance(20000.0).build();

        AccountDto accountDto = AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance()).build();
        this.givenAccountId_whenGetAccountById_thenReturnAccountDtoObject();
        //given(accountRepository.deleteById(account.getId())).willRetur()
    }

}
