package com.petrius.banking_system.service;

import com.petrius.banking_system.domain.ResponseAccount;
import com.petrius.banking_system.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public ResponseAccount mapToresponseAccount(Account account) {
        return ResponseAccount.builder()
                .id(account.getId())
                .fullName(account.getFullName())
                .iban(account.getIban())
                .currency(account.getCurrency())
                .balance(account.getBalance())
                .withdrawPerDayLimit(account.getWithdrawPerDayLimit())
                .build();
    }
}
