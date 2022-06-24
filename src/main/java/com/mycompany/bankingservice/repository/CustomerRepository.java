package com.mycompany.bankingservice.repository;

import com.mycompany.bankingservice.entity.AccountEntity;
import com.mycompany.bankingservice.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface CustomerRepository  extends JpaRepository<CustomerEntity,Long> {
    Optional<CustomerEntity> findByAdhaar(String adhaarNo);
    Optional<CustomerEntity> findByOwnerEmailAndPassword(String email, String password);


}
