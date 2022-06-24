package com.mycompany.bankingservice.repository;

import com.mycompany.bankingservice.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {


}
