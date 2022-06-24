package com.mycompany.bankingservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter

public class BeneficiaryDTO {

    private Long beneficiaryId;
    @NotNull(message = "this filed is mandatory")
    @NotEmpty(message = "Not be Empty")
    private String beneficiaryName;
    @NotNull(message = "this filed is mandatory")
    @NotEmpty(message = "Not be Empty")
    @Size(min = 5, max = 10)
    private String accountNumber;
    private String bankName;
    private String IFSCCode;
    @NotNull(message = "this filed is mandatory")
    @NotEmpty(message = "Not be Empty")
    private String beneficiaryAccountType;
    private Double txAmount;
    private Long phone;





}
