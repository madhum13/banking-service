package com.mycompany.bankingservice.service;


import com.mycompany.bankingservice.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO register(CustomerDTO customerDTO);
    String login(String email, String password);

}
