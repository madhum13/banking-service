package com.mycompany.bankingservice.service.impl;

import com.mycompany.bankingservice.dto.BeneficiaryDTO;

import com.mycompany.bankingservice.dto.CustomerDTO;
import com.mycompany.bankingservice.entity.AccountEntity;
import com.mycompany.bankingservice.entity.CustomerEntity;
import com.mycompany.bankingservice.exception.BusinessException;
import com.mycompany.bankingservice.exception.ErrorModel;

import com.mycompany.bankingservice.repository.CustomerRepository;
import com.mycompany.bankingservice.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerDTO register(CustomerDTO customerDTO) {
        Optional<CustomerEntity> customer = customerRepository.findByAdhaar(customerDTO.getAdhaarNo());
        List<ErrorModel> errors = null;
        if (customer.isPresent()) {
            ErrorModel error = new ErrorModel();
            error.setCode("EXIST_001");
            error.setMessage(" already registered");
            errors = new ArrayList<>();
            errors.add(error);
        } else {
            CustomerEntity customerEntity = new CustomerEntity();
            AccountEntity accentity = new AccountEntity();
            accentity.setBalance(0.0);
            customerEntity.setAccount(accentity);
            BeanUtils.copyProperties(customerDTO, customerEntity);
            customerEntity = customerRepository.save(customerEntity);

            BeanUtils.copyProperties(customerEntity, customerDTO);
            customerDTO.setAccountNo(customerEntity.getAccount().getAccountId());
        }
        if (errors != null) {
            throw new BusinessException(errors);
        } else {
            return customerDTO;
        }
    }

    @Override
    public String login(String email, String password) {
        String msg = "";
        Optional<CustomerEntity> custEntity = customerRepository.findByOwnerEmailAndPassword(email, password);
        if (custEntity.isPresent()) {
            msg = "login successful";
        } else {
            ErrorModel model = new ErrorModel();
            model.setMessage("login not successful");
            model.setCode("AUTH_001");
            List<ErrorModel> errors = new ArrayList<>();
            errors.add(model);
            throw new BusinessException(errors);
        }
        return msg;
    }
}