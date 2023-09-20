package com.example.example.service.servicesImpl;

import com.example.example.dtos.AccountDto;
import com.example.example.exceptions.RequestException;
import com.example.example.mapper.AccountMapper;
import com.example.example.model.constant.ExceptionMessages;
import com.example.example.model.entities.Account;
import com.example.example.repository.AccountRepository;
import com.example.example.service.AccountService;
import com.example.example.validation.AccountValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@EnableCaching
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository ;
    @Autowired
    private AccountMapper mapper;
    @Autowired
    private AccountValidation accountValidation;

    @Override
    @CacheEvict(value = { "getByIdAccount", "getAllAccount"}, key = "#root.methodName", allEntries = true)
    public AccountDto addAccount(AccountDto accountDto) {
        accountValidation.validateAccount(accountDto);
        Account account = this.mapper.accountDtoToAccount(accountDto);
//        Account account = Account.builder().id(accountDto.getId())
//                .name(accountDto.getName())
//                .balance(accountDto.getBalance()).build();
        Account accountRepo = this.accountRepository.save(account);
        AccountDto mappedAccount = this.mapper.accountToAccountDto(accountRepo);
        return mappedAccount;
    }

    @Override
    @Cacheable(value = "getAllAccount", key = "#root.methodName")
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = this.accountRepository.findAll();
        List<AccountDto> accountDtoList = new ArrayList<>(accounts.size());
        Iterator var3 = accounts.iterator();

        while(var3.hasNext()) {
            Account account = (Account)var3.next();
            accountDtoList.add(this.mapper.accountToAccountDto(account));
        }
        return accountDtoList;
    }

    @Override
    @Cacheable(value = "getByIdAccount", key = "#id")
    public AccountDto getAccountByID(Integer id){
        Optional<Account> account = this.accountRepository.findById(id);
        if(account.isPresent()){
            AccountDto accountDto = this.mapper.accountToAccountDto(account.get());
            return accountDto;
        }else {
            throw new RequestException("Account is Not Found");
        }
    }

    @Override
    @CacheEvict(value = { "getByIdAccount", "getAllAccount"}, key = "#id", allEntries = true)
    public AccountDto updateAccount(AccountDto accountDto, Integer id) {
        accountValidation.validateAccount(accountDto);
        Optional<Account> account = this.accountRepository.findById(id);
        if(account.isPresent()){
            Account existingAccount = this.mapper.updateAccountFromAccountDto(accountDto, account.get());
            Account savedAccount = this.accountRepository.save(existingAccount);
            AccountDto finalAccount = this.mapper.accountToAccountDto(savedAccount);
            return finalAccount;
        }else {
            throw new RequestException(ExceptionMessages.ACCOUNT_NOT_FOUND.getMessage());
        }
    }

    @Override
    @CacheEvict(value = { "getByIdAccount", "getAllAccount"}, key = "#id", allEntries = true)
    public AccountDto deleteAccount(Integer id)  {
        AccountDto accountDto = this.getAccountByID(id);
        this.accountRepository.deleteById(id);
        return  accountDto;
    }
}
