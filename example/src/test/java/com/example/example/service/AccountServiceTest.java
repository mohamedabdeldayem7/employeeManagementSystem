package com.example.example.service;

import com.example.example.dtos.AccountDto;
import com.example.example.mapper.AccountMapper;
import com.example.example.model.entities.Account;
import com.example.example.repository.AccountRepository;
import com.example.example.service.servicesImpl.AccountServiceImpl;
import com.example.example.validation.AccountValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;


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

        account = Account.builder().id(1).name("mohamed").balance(20000.0).build();

        accountDto = AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance()).build();
    }

    @DisplayName("JUnit test for addAccount method")
    @Test
    public void givenAccountDtoObject_whenAddAccount_thenReturnAccountDtoObject() {

        when(accountRepository.save(account)).thenReturn(account);
        when(accountMapper.accountToAccountDto(account)).thenReturn(accountDto);
        when(accountMapper.accountDtoToAccount(accountDto)).thenReturn(account);

        AccountDto returnedAccount = accountService.addAccount(accountDto);

        Assertions.assertThat(returnedAccount).isNotNull();
        Assertions.assertThat(returnedAccount).isEqualTo(accountDto);
    }

    @DisplayName("JUnit test for getAllAccounts method")
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

    @DisplayName("JUnit test for getAccountById method")
    @Test
    public void givenAccountId_whenGetAccountById_thenReturnAccountDtoObject() {

//        account = Account.builder().id(1).name("mohamed").balance(20000.0).build();
//
//        accountDto = AccountDto.builder()
//                .id(account.getId())
//                .name(account.getName())
//                .balance(account.getBalance()).build();

        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        when(accountMapper.accountToAccountDto(account)).thenReturn(accountDto);

        AccountDto returnedaccountDto = accountService.getAccountByID(account.getId());

        Assertions.assertThat(returnedaccountDto).isNotNull();
        Assertions.assertThat(returnedaccountDto.getId()).isEqualTo(account.getId());
    }


    @DisplayName("JUnit test for updateAccount method")
    @Test
    public void givenAccountObjectAndAccountId_whenUpdateAccount_thenReturnUpdatedAccount() {

        AccountDto updatedAccountDto = AccountDto.builder()
                .id(1)
                .name("Hamza")
                .balance(35000.0)
                .build();
        Account updatedAccount = Account.builder()
                .id(1)
                .name(updatedAccountDto.getName())
                .balance(updatedAccountDto.getBalance())
                .build();

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

    @DisplayName("JUnit test for deleteAccount method")
    @Test
    public void givenAccountId_whenDeleteAccount_thenReturnDeletedAccountDto() {
        Account account = Account.builder().id(1).name("mohamed").balance(20000.0).build();

        AccountDto accountDto = AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance()).build();

        this.givenAccountId_whenGetAccountById_thenReturnAccountDtoObject();

        willDoNothing().given(accountRepository).deleteById(account.getId());

        AccountDto deletedAccountDto = accountService.deleteAccount(accountDto.getId());

        Assertions.assertThat(deletedAccountDto).isNotNull();
        verify(accountRepository, times(1)).deleteById(account.getId());
    }

}
