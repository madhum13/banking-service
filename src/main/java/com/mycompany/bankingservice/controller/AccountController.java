package com.mycompany.bankingservice.controller;

import com.mycompany.bankingservice.dto.AccountDTO;
import com.mycompany.bankingservice.entity.AccountEntity;
import com.mycompany.bankingservice.service.AccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "register", notes = "This method is used for user registration")
    @PostMapping("/register")
    public ResponseEntity<AccountDTO> register(@ApiParam(
            name = "AccountDTO",
            type = "AccountDTO",
            value = "account data",
            example = "Account information",
            required = true
    ) @Valid @RequestBody AccountDTO accountDTO) {
        accountDTO = accountService.register(accountDTO);
        return new ResponseEntity<>(accountDTO, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<AccountDTO> login(@Valid @RequestBody AccountDTO accountDTO) {
        accountDTO = accountService.login(accountDTO);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @PostMapping("/save_account")
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO) {

        accountDTO = accountService.saveAccount(accountDTO);

        ResponseEntity<AccountDTO> responseEntity = new ResponseEntity<>(accountDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/deposit/{accountNumber}")

    public ResponseEntity<AccountDTO> deposit(@RequestBody AccountDTO accountDTO, @PathVariable String accountNumber) {
        accountDTO = accountService.deposit(accountDTO, accountNumber);
        ResponseEntity<AccountDTO> responseEntity = new ResponseEntity<>(accountDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/withdraw/{accountNumber}")

    public ResponseEntity<AccountDTO> withdraw(@RequestBody AccountDTO accountDTO, @PathVariable String accountNumber) {
        accountDTO = accountService.deposit(accountDTO, accountNumber);
        ResponseEntity<AccountDTO> responseEntity = new ResponseEntity<>(accountDTO, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDTO> getAvailableBalance(@PathVariable String accountNumber){
        AccountDTO accountDTO = accountService.getAvailableBalance(accountNumber);
        ResponseEntity<AccountDTO> responseEntity = new ResponseEntity<>(accountDTO, HttpStatus.OK);
        return responseEntity;
    }


}

