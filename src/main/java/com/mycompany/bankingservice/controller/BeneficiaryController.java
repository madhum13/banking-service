package com.mycompany.bankingservice.controller;

import com.mycompany.bankingservice.dto.BeneficiaryDTO;
import com.mycompany.bankingservice.service.AccountService;
import com.mycompany.bankingservice.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/v1/beneficiary")
    public class BeneficiaryController {

        @Autowired
        private BeneficiaryService beneficiaryService;

        @PostMapping("/beneficiary")
        public ResponseEntity<BeneficiaryDTO> addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO){
            beneficiaryDTO = beneficiaryService.addBeneficiary(beneficiaryDTO);
            ResponseEntity<BeneficiaryDTO> responseEntity = new ResponseEntity<>(beneficiaryDTO, HttpStatus.CREATED);
            return responseEntity;
        }


        @PostMapping("/beneficiaryTxn")
        public ResponseEntity<BeneficiaryDTO> beneficiaryTxn(@RequestBody BeneficiaryDTO beneficiaryDTO) {

            beneficiaryDTO = beneficiaryService.beneficiaryTxn(beneficiaryDTO);
            ResponseEntity<BeneficiaryDTO> responseEntity = new ResponseEntity<>(beneficiaryDTO, HttpStatus.CREATED);
            return responseEntity;
        }
    }
