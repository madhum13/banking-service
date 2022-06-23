package com.mycompany.bankingservice.service;

import com.mycompany.bankingservice.dto.AccountDTO;

public interface AccountService {

    AccountDTO register(AccountDTO accountDTO);
    AccountDTO login(String email, String password);
    AccountDTO saveAccount(AccountDTO accountDTO);

}
