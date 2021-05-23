package com.company.employee.services.imp;

import com.company.employee.models.CompanyAccount;
import com.company.employee.repository.CompanyAccountRepo;
import com.company.employee.services.CompanyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyAccountServiceImp implements CompanyAccountService {

    @Autowired
    private CompanyAccountRepo repo;

    @Override
    public Double getBalance() {
        return repo.findAll().size() > 0 ? repo.findAll().get(0).getBanlance() : 0;
    }

    @Override
    public Double updateBalance(double amount) {

        List<CompanyAccount> accounts = repo.findAll();
        if (accounts.size() > 0){
            CompanyAccount account = accounts.stream().findFirst().orElseThrow(()-> new NullPointerException(""));
            amount += account.getBanlance();
            account.setBanlance(amount);
            repo.saveAndFlush(account);
            return account.getBanlance();
        }else{
            CompanyAccount account = new CompanyAccount();
            account.setBanlance(amount);
            repo.saveAndFlush(account);
            return amount;
        }
    }
}
