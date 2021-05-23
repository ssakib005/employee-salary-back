package com.company.employee.services.imp;

import com.company.employee.models.AccountType;
import com.company.employee.repository.AccountTypeRepo;
import com.company.employee.services.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountTypeServiceImp implements AccountTypeService{

    @Autowired
    private AccountTypeRepo repo;

    @Override
    public List<AccountType> findAll() {
        return repo.findAll();
    }
}
