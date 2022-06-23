package com.mycompany.bankingservice.repository;

import com.mycompany.bankingservice.entity.AccountEntity;
import com.mycompany.bankingservice.entity.BeneficiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeneficiaryRepository extends JpaRepository<AccountEntity, String> {


    Optional<BeneficiaryEntity> findByBeneficiaryName(String beneficiaryName);


}
