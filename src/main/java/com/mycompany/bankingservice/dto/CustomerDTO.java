package com.mycompany.bankingservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Owner Email cannot be empty")
    @Size(min = 1, max = 50, message = "Owner Email should be between 1 to 50 characters in length")
    private String ownerEmail;
    @NotNull(message = "Name is a required field")
    private String ownerName;
    @NotNull(message = "Password is mandatory")
    private String password;
    @NotNull(message = "Phone Number is mandatory")
    @Size(min = 9, message = "Not a valid phone number")
    private String phone;
    @NotNull(message = "Adhaar registration is mandatory")
    @Size(min = 8, message = "Not a valid adhar number")
    private String adhaarNo;
    private Long accountNo;
    private String beneficiaries;

}
