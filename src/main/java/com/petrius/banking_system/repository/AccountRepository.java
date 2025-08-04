package com.petrius.banking_system.repository;

import com.petrius.banking_system.entity.Account;
import com.petrius.banking_system.schared.Currency;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class AccountRepository {

    private final ArrayList<Account> accounts = new ArrayList<>();
    private final Set<String> ibans = new HashSet<>();

    public AccountRepository(ArrayList<Account> accounts) {

        Account account1 = Account.builder()
                .id(1L)
                .fullName("Maria Petri")
                .iban("DE2345600012")
                .currency(Currency.EURO)
                .balance(new BigDecimal("1000"))
                .withdrawPerDayLimit(new BigDecimal("2000"))
                .build();

        this.ibans.add(account1.getIban());
        this.accounts.add(account1);

        Account account2 = Account.builder()
                .id(2L)
                .fullName("John Doe")
                .iban("DE1122334455")
                .currency(Currency.CHF)
                .balance(new BigDecimal("500"))
                .withdrawPerDayLimit(new BigDecimal("1000"))
                .build();
        this.ibans.add(account2.getIban());

        this.accounts.add(account2);
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
        return account;
    }

    private Long generateNextId(){
        Long result = accountList()
                .stream()
                .mapToLong(Account::getId)
                .max()
                .orElse(0L) + 1;
        return result;
    }

    public boolean isIbanExists(String iban){
        return this.ibans.contains(iban);
    }
}
