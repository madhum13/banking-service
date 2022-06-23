package com.mycompany.bankingservice.service;

import com.mycompany.bankingservice.dto.BeneficiaryDTO;

public interface BeneficiaryService {


    BeneficiaryDTO addBeneficiary (BeneficiaryDTO beneficiaryDTO);
    BeneficiaryDTO beneficiaryTxn (BeneficiaryDTO beneficiaryDTO);
}
