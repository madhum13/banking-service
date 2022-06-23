package com.mycompany.bankingservice.repository;

import com.mycompany.bankingservice.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository <AccountEntity, String> {

    Optional<AccountEntity> findByEmailAndPassword(String email, String password);

}
