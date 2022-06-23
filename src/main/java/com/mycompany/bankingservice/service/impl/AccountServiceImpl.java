package com.mycompany.bankingservice.service.impl;

import com.mycompany.bankingservice.dto.AccountDTO;
import com.mycompany.bankingservice.entity.AccountEntity;
import com.mycompany.bankingservice.repository.AccountRepository;
import com.mycompany.bankingservice.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public AccountDTO register(AccountDTO accountDTO) {
        Optional<AccountEntity> optUe = accountRepository.findById(accountId)
        if(optUe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("The Email With Which You Are Trying To Register Already Exist!");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }

    }

    @Override
    public AccountDTO login(String email, String password) {
        return null;
    }

    @Override
    public AccountDTO saveAccount(AccountDTO accountDTO) {
        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(accountDTO, accountEntity);//all dto date will be set to entity
        accountEntity = accountRepository.save(accountEntity);
        BeanUtils.copyProperties(accountEntity, accountDTO);//convert entity to dto
        return accountDTO;
    }
}
