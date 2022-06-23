package com.mycompany.bankingservice.service;

import com.mycompany.bankingservice.dto.AccountDTO;

public interface AccountService {

    AccountDTO register(AccountDTO accountDTO);
    AccountDTO login(AccountDTO accountDTO);
    AccountDTO saveAccount(AccountDTO accountDTO);
    AccountDTO deposit(AccountDTO accountDTO, String accountNumber);
    AccountDTO withdraw(AccountDTO accountDTO, String accountNumber);
    AccountDTO getAvailableBalance(String accountNumber);

}
