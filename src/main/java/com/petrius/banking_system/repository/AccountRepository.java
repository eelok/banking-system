package com.petrius.banking_system.repository;

import com.petrius.banking_system.entity.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository {

    private ArrayList<Account> accounts = new ArrayList<>();

    public AccountRepository(ArrayList<Account> accounts) {
        this.accounts.add(
                Account.builder()
                        .id(1L)
                        .fullName("Maria Petri")
                        .iban("DE2345600012")
                        .currency("EURO")
                        .balance(new BigDecimal("1000"))
                        .withdrawPerDayLimit(new BigDecimal("2000"))
                        .build()
        );
        this.accounts.add(
                Account.builder()
                        .id(2L)
                        .fullName("John Doe")
                        .iban("DE1122334455")
                        .currency("EURO")
                        .balance(new BigDecimal("500"))
                        .withdrawPerDayLimit(new BigDecimal("1000"))
                        .build()
        );

    }

    public List<Account> accountList(){
        return new ArrayList<>(this.accounts); //created copy of accounts array; it is save
    }

    public Optional<Account> getById(Long id){
        return this.accounts
                .stream()
                .filter(account -> account.getId().equals(id))
                .findFirst();
    }

    public Account save(Account account){
        if(account.getId() == null){
            account.setId(generateNextId());
        }

        this.accounts.add(account);
        return  account;
    }

    private Long generateNextId(){
        return accountList()
                .stream()
                .mapToLong(Account::getId)
                .max()
                .orElse(0L) +1;
    }

    public boolean isIbanExists(String iban){
        return this.accounts.stream().anyMatch(account -> account.getIban().equals(iban));
    }
}
