package com.company.employee.services.imp;

import com.company.employee.models.*;
import com.company.employee.repository.BasicSalaryRepo;
import com.company.employee.repository.CompanyAccountRepo;
import com.company.employee.repository.EmployeeRepo;
import com.company.employee.repository.GradeRepo;
import com.company.employee.services.BasicSalaryService;
import com.company.employee.services.helper.SalaryCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Service
public class BasicSalaryServiceImp implements BasicSalaryService{

    @Autowired
    private BasicSalaryRepo repo;


    @Autowired
    private CompanyAccountRepo accountRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private GradeRepo graderepo;

    @Override
    public Double geBasicSalary() {
        return repo.findAll().size() > 0 ? repo.findAll().get(0).getSalary() : 0;
    }

    @Override
    public Double updateBasicSalary(double amount) {
        List<BasicSalary> accounts = repo.findAll();
        if (accounts.size() > 0){
            BasicSalary account = accounts.stream().findFirst().orElseThrow(()-> new NullPointerException(""));
            amount += account.getSalary();
            account.setSalary(amount);
            repo.saveAndFlush(account);
            return account.getSalary();
        }else{
            BasicSalary account = new BasicSalary();
            account.setSalary(amount);
            repo.saveAndFlush(account);
            return amount;
        }
    }

    @Override
    public TransferResponse transferSalary(Long id) {
        List<Employee> employees = employeeRepo.findAll().stream().filter(x -> Objects.equals(x.getId(), id) && x.getBank_account().getStatus() == 0).collect(toList());
        if (employees.size() > 0){

            Employee employee = employees.stream().findFirst().orElseThrow(()-> new NullPointerException(""));

            double basic = repo.findAll().get(0).getSalary();
            double salary = SalaryCalculation.Calculate(basic, 5000, graderepo.findAll().size(), employee.getGrade().getId());

            if (accountRepo.findAll().get(0).getBanlance() > salary){
                employee.getBank_account().setCurrent_banlance(salary);
                employee.getBank_account().setStatus(1);
                employeeRepo.saveAndFlush(employee);

                CompanyAccount account = accountRepo.findAll().get(0);
                account.setBanlance(account.getBanlance()-salary);
                accountRepo.saveAndFlush(account);

                return new TransferResponse("success", 1001);
            }else {
                return new TransferResponse("Sorry! Insufficient Balance", 1002);
            }
        }
        return new TransferResponse("sorry no data found!", 1002);
    }

    @Override
    public TransferResponse transferToAllAccount() {
        List<Employee> employees = employeeRepo.findAll().stream().filter(x -> x.getBank_account().getStatus() == 0).collect(toList());
        if (employees.size() > 0){
            for (Employee em: employees){

                double basic = repo.findAll().get(0).getSalary();
                double salary = SalaryCalculation.Calculate(basic, 5000, graderepo.findAll().size(), em.getGrade().getId());

                if (accountRepo.findAll().get(0).getBanlance() > salary){
                    em.getBank_account().setCurrent_banlance(salary);
                    em.getBank_account().setStatus(1);
                    employeeRepo.saveAndFlush(em);

                    CompanyAccount account = accountRepo.findAll().get(0);
                    account.setBanlance(account.getBanlance()-salary);
                    accountRepo.saveAndFlush(account);
                }else {
                    return new TransferResponse("Sorry! Insufficient Balance", 1002);
                }
            }
            return new TransferResponse("success", 1001);
        }else
        {
            return new TransferResponse("sorry no data found!", 1002);
        }

    }

    @Override
    public CompanyInfoResponse companyInfo() {
        CompanyInfoResponse response = new CompanyInfoResponse();
        List<CompanyAccount> companyBalance = accountRepo.findAll();
        if (companyBalance.size() > 0){
            double balance = companyBalance.get(0).getBanlance();
            double totalPaidSalary = employeeRepo.findAll().stream().filter(x-> x.getBank_account().getStatus().equals(1)).mapToDouble(y-> y.getBank_account().getCurrent_banlance()).sum();

            response.setRemainingBalance(balance);
            response.setTotalPaidSalary(totalPaidSalary);

            return response;
        }
        return response;
    }
}
