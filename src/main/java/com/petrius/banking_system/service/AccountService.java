package com.petrius.banking_system.service;

import com.petrius.banking_system.domain.RequestCreateAccount;
import com.petrius.banking_system.domain.ResponseAccount;
import com.petrius.banking_system.entity.Account;
import com.petrius.banking_system.exception.AccountNotFoundException;
import com.petrius.banking_system.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService{


    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final IbanGenerator ibanGenerator;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper, IbanGenerator ibanGenerator) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.ibanGenerator = ibanGenerator;
    }

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


    public ResponseAccount create(RequestCreateAccount requestCreateAccount){
        String iban = ibanGenerator.generateIban();
        while (accountRepository.isIbanExists(iban)){
            iban = ibanGenerator.generateIban();
        }
        Account account = Account.builder()
                .fullName(requestCreateAccount.getFullName())
                .iban(iban)
                .currency(requestCreateAccount.getCurrency())
                .balance(new BigDecimal(0))
                .withdrawPerDayLimit(new BigDecimal(0))
                .build();

        Account savedAccount = this.accountRepository.save(account);
        return accountMapper.mapToresponseAccount(savedAccount);
    }


}


