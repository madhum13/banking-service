package com.mycompany.bankingservice.repository;

import com.mycompany.bankingservice.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <AccountEntity, Long> {
}
