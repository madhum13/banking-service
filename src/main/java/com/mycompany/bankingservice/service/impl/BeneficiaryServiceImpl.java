package com.mycompany.bankingservice.service.impl;

import com.mycompany.bankingservice.dto.BeneficiaryDTO;

import com.mycompany.bankingservice.entity.AccountEntity;
import com.mycompany.bankingservice.entity.BeneficiaryEntity;
import com.mycompany.bankingservice.exception.BusinessException;
import com.mycompany.bankingservice.exception.ErrorModel;

import com.mycompany.bankingservice.repository.BeneficiaryRepository;
import com.mycompany.bankingservice.service.BeneficiaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BeneficiaryServiceImpl implements BeneficiaryService {


    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Override
    public BeneficiaryDTO addBeneficiary(BeneficiaryDTO beneficiaryDTO) {
        Optional<BeneficiaryEntity> optUe = beneficiaryRepository.findByBeneficiaryName(beneficiaryDTO.getBeneficiaryName());
        if (optUe.isPresent()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("BENEFICIARY NAME_ALREADY_EXIST");
            errorModel.setMessage("The BENEFICIARY NAME With Which You Are Trying To Register Already Exist!");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }

        BeneficiaryEntity be = null;

        be = optUe.get();
        be.setBeneficiaryName(beneficiaryDTO.getBeneficiaryName());
        be.setAccountNumber(beneficiaryDTO.getAccountNumber());
        be.setBankName(beneficiaryDTO.getBankName());
        be.setPhone(beneficiaryDTO.getPhone());
        be.setBeneficiaryAccountType(beneficiaryDTO.getBeneficiaryAccountType());
       // be = beneficiaryRepository.save(be);

        BeanUtils.copyProperties(be, beneficiaryDTO);
        return beneficiaryDTO;
    }

    @Override
    public BeneficiaryDTO beneficiaryTxn(BeneficiaryDTO beneficiaryDTO) {

        Optional<BeneficiaryEntity> optEntity = beneficiaryRepository.findByBeneficiaryName(beneficiaryDTO.getBeneficiaryName());
        AccountEntity be = null;
        if(optEntity.isPresent()) {



        }
            BeanUtils.copyProperties(be, beneficiaryDTO);
            return beneficiaryDTO;

        }
}
