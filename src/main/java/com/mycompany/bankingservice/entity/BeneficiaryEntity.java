package com.mycompany.bankingservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BeneficiaryEntity {


    private Long beneficiaryId;
    private String beneficiaryName;
    private String accountNumber;
    private String bankName;

    private String beneficiaryAccountType;
    private Double txAmount;
    private Long phone;
}
