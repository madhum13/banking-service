package com.mycompany.bankingservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferDTO {

    private Long customerId;
    private Long beneficiaryId;
    private Double amount;
}
