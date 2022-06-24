package com.mycompany.bankingservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ACCOUNT_TABLE")
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

   private Long accountId;
   @NotNull(message = "this filed is mandatory")
   @NotEmpty(message = "Not be Empty")
   private String ownerName;
   @NotNull(message = "this filed is mandatory")
   @NotEmpty(message = "Not be Empty")
   @Size(min = 5, max = 10)
   private String accountNumber;
   private String bankName;
   private String IFSCCode;
   @NotNull(message = "this filed is mandatory")
   @NotEmpty(message = "Not be Empty")
   private String accountType;
   private String emailId;
   @Size(min = 10 , message = "should be 10 digits")
   private String password;
   @NotNull(message = "this filed is mandatory")
   @NotEmpty(message = "Not be Empty")
   private Long phoneNo;
   private Double amount;
   private Double txAmount;
   private Double availableBalance;

}
