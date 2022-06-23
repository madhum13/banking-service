package com.mycompany.bankingservice.service.impl;

import com.mycompany.bankingservice.dto.AccountDTO;
import com.mycompany.bankingservice.entity.AccountEntity;
import com.mycompany.bankingservice.exception.BusinessException;
import com.mycompany.bankingservice.exception.ErrorModel;
import com.mycompany.bankingservice.repository.AccountRepository;
import com.mycompany.bankingservice.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;




    @Override
    public AccountDTO register(AccountDTO accountDTO) {
        Optional<AccountEntity> optUe = accountRepository.findById(accountDTO.getOwnerName());
        if(optUe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("OWNER NAME_ALREADY_EXIST");
            errorModel.setMessage("The OWNER NAME With Which You Are Trying To Register Already Exist!");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        AccountEntity ae = null;

        ae = optUe.get();
        ae.setEmailId(accountDTO.getEmailId());
        ae.setAccountNumber(accountDTO.getAccountNumber());
        ae.setAccountType(accountDTO.getAccountType());
        ae.setOwnerName(accountDTO.getOwnerName());
        ae.setPhoneNo(accountDTO.getPhoneNo());
        ae.setPassword(accountDTO.getPassword());
        ae = accountRepository.save(ae);

        BeanUtils.copyProperties(ae, accountDTO);
        return accountDTO;
    }

    @Override
    public AccountDTO login(AccountDTO accountDTO) {

        Optional<AccountEntity> optionalAccountEntity = accountRepository.findByEmailAndPassword(accountDTO.getEmailId(), accountDTO.getPassword());
        optionalAccountEntity.orElseThrow(()-> {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        });
        BeanUtils.copyProperties(optionalAccountEntity.get(), accountDTO);
        accountDTO.setPassword(null);
        return accountDTO;

    }

    @Override
    public AccountDTO saveAccount(AccountDTO accountDTO) {
        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(accountDTO, accountEntity);
        accountEntity = accountRepository.save(accountEntity);
        BeanUtils.copyProperties(accountEntity, accountDTO);
        return accountDTO;
    }

    @Override
    public AccountDTO deposit(AccountDTO accountDTO, String accountNumber) {
        Optional<AccountEntity> optEntity = accountRepository.findById(accountNumber);
        AccountEntity be = null;
        if(optEntity.isPresent()){
            be = optEntity.get();
            be.setAvailableBalance(accountDTO.getAvailableBalance());
            be = accountRepository.save(be);
        }
        BeanUtils.copyProperties(be, accountDTO);
        return accountDTO;
    }

    @Override
    public AccountDTO withdraw(AccountDTO accountDTO, String accountNumber) {
        Optional<AccountEntity> optEntity = accountRepository.findById(accountNumber);
        AccountEntity be = null;
        if(optEntity.isPresent()){
            be = optEntity.get();
            be.setAvailableBalance(accountDTO.getAvailableBalance());
            be = accountRepository.save(be);
        }
        BeanUtils.copyProperties(be, accountDTO);
        return accountDTO;
    }

    @Override
    public AccountDTO getAvailableBalance(String accountNumber) {
        Optional<AccountEntity> optBook = accountRepository.findById(accountNumber);
        AccountDTO accountDTO = null;
        if(optBook.isPresent()){
            accountDTO = new AccountDTO();
            BeanUtils.copyProperties(optBook.get(), accountDTO);
        }
        return accountDTO;
    }


}
