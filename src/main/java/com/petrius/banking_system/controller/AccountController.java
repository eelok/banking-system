package com.petrius.banking_system.controller;

import com.petrius.banking_system.domain.ResponseAccount;
import com.petrius.banking_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    public AccountService accountService;

//    @PostMapping("api/v1/accounts")
//    public ResponseEntity<ResponseAccount> createAccount(@Valid @RequestBody RequestAccount requestAccount){
//        ResponseAccount createAccount = this.accountService.createAccount(requestAccount);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
//    }

    @GetMapping("/api/v1/accounts/{id}")
    public ResponseEntity<ResponseAccount> getAccount(@PathVariable Long id){
        ResponseAccount foundAccount = this.accountService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(foundAccount);
    }

    @GetMapping("api/v1/accounts")
    public ResponseEntity<List<ResponseAccount>> getAccountList(){
        List<ResponseAccount> accountList = this.accountService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(accountList);
    }
}

