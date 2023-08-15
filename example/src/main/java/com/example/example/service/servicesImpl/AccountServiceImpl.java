package com.example.example.service.servicesImpl;

import com.example.example.dtos.AccountDto;
import com.example.example.exceptions.RequestException;
import com.example.example.mapper.AccountMapper;
import com.example.example.model.entities.Account;
import com.example.example.repository.AccountRepository;
import com.example.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository ;
    @Autowired
    private AccountMapper mapper;

    @Override
    public AccountDto addAccount(AccountDto accountDto) {
        Account account = this.mapper.accountDtoToAccount(accountDto);
        return this.mapper.accountToAccountDto(this.accountRepository.save(account));
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return this.mapper.toAccountDtoList(this.accountRepository.findAll());
    }

    @Override
    public AccountDto getAccountByID(Integer id){
        Optional<Account> account = this.accountRepository.findById(id);
        if(account.isPresent()){
            return this.mapper.accountToAccountDto(account.get());
        }else {
            throw new RequestException("Account is Not Found");
        }
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto, Integer id) {
        Optional<Account> account = this.accountRepository.findById(id);
        if(account.isPresent()){
            Account existingAccount = this.mapper.updateAccountFromAccountDto(accountDto, account.get());
            return this.mapper.accountToAccountDto(this.accountRepository.save(existingAccount));
        }else {
            throw new RequestException("Account is Not Found");

        }
    }

    @Override
    public AccountDto deleteAccount(Integer id)  {
        AccountDto accountDto = this.getAccountByID(id);
        this.accountRepository.deleteById(id);
        return  accountDto;
    }
}
