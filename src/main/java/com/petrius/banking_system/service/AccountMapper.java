package com.petrius.banking_system.service;

import com.petrius.banking_system.domain.RequestAccount;
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

    public Account mapToAccount(RequestAccount requestAccount){
        return Account.builder()
                .fullName(requestAccount.getFullName())
                .iban(requestAccount.getIban())
                .currency(requestAccount.getCurrency())
                .balance(requestAccount.getBalance())
                .withdrawPerDayLimit(requestAccount.getWithdrawPerDayLimit())
                .build();
    }

//    public Account mapToAccount(RequestCreateAccount requestCreateAccount){
//        return Account.builder()
//                .f
//    }
}
