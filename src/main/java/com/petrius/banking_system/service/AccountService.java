package com.petrius.banking_system.service;

import com.petrius.banking_system.domain.ResponseAccount;
import com.petrius.banking_system.entity.Account;
import com.petrius.banking_system.exception.AccountNotFoundException;
import com.petrius.banking_system.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService{

    @Autowired
    protected AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;


    @Override
    public ResponseAccount getById(Long id) {
        Optional<Account> foundAccount = this.accountRepository.getById(id);
        if(foundAccount.isEmpty()){
            throw new AccountNotFoundException("Account mit id " + id + " was not found");
        }
        return this.accountMapper.mapToresponseAccount(foundAccount.get());
    }

    @Override
    public List<ResponseAccount> getAll() {
        List<Account> accounts = this.accountRepository.accountList();
        return accounts
                .stream()
                .map(account -> accountMapper.mapToresponseAccount(account))
                .toList();
    }


}
