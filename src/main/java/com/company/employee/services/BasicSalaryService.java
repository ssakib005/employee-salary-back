package com.company.employee.services;

import com.company.employee.models.CompanyInfoResponse;
import com.company.employee.models.TransferResponse;

public interface BasicSalaryService {

    Double geBasicSalary();
    Double updateBasicSalary(double amount);
    TransferResponse transferSalary(Long id);
    TransferResponse transferToAllAccount();

    CompanyInfoResponse companyInfo();
}
