package com.company.employee.services.imp;

import com.company.employee.models.EmployeeAccount;
import com.company.employee.repository.EmployeeAccountRepo;
import com.company.employee.services.EmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAccountServiceImp implements EmployeeAccountService {

    @Autowired
    EmployeeAccountRepo repo;

    @Override
    public EmployeeAccount save(EmployeeAccount account) {
        return repo.saveAndFlush(account);
    }
}
