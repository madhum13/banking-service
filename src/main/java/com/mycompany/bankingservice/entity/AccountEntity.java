package com.mycompany.bankingservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNT_TABLE")
@NoArgsConstructor
@Getter
@Setter
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @Column(length = 50)
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
