package com.mycompany.bankingservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TxDTO {

    private Long accountId;
    private String accountNumber;
    private Double txAmount;
    private Double availableBalance;
}
