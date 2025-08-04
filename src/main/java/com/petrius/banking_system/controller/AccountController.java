package com.petrius.banking_system.controller;

import com.petrius.banking_system.domain.RequestCreateAccount;
import com.petrius.banking_system.domain.ResponseAccount;
import com.petrius.banking_system.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

//    Field Dependency Injection ist nicht mehr empfehlenswert
//    @Autowired
//    public AccountService accountService;

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("api/v1/accounts")
    public ResponseEntity<ResponseAccount> createAccount(@Valid @RequestBody RequestCreateAccount requestCreateAccount){
        ResponseAccount createAccount = this.accountService.create(requestCreateAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }

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

