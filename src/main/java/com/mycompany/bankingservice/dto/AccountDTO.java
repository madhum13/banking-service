package com.mycompany.bankingservice.dto;

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
public class AccountDTO {

   private Long accountId;
   private String accountNumber;
   private String bankName;
   private String ownerName;
   private String accountType;
   private String emailId;
   private String password;
   private Long phoneNo;
   private Double amount;
   private Double txAmount;
   private Double availableBalance;

}
