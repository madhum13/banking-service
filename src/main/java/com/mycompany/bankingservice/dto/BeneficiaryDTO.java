package com.mycompany.bankingservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;


@Getter
@Setter

public class BeneficiaryDTO {

    private Long customerId;
    @NotNull(message = "this filed is mandatory")
    @NotEmpty(message = "Not be Empty")
    private List<CustomerDTO> beneficiaries;
}






