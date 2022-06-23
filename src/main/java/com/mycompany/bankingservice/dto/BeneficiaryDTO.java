package com.mycompany.bankingservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class BeneficiaryDTO {

    private Long beneficiaryId;
    private String beneficiaryName;
    private String accountNumber;
    private String bankName;
    private String beneficiaryAccountType;
    private Double txAmount;
    private Long phone;





}
