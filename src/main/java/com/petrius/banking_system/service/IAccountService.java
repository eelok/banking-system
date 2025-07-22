package com.petrius.banking_system.service;

import com.petrius.banking_system.domain.ResponseAccount;

import java.util.List;

public interface IAccountService {


    ResponseAccount getById(Long id);

    List<ResponseAccount> getAll();

}
