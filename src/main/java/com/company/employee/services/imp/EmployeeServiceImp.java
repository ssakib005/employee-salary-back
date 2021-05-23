package com.company.employee.services.imp;

import com.company.employee.models.Employee;
import com.company.employee.repository.EmployeeRepo;
import com.company.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public Employee save(Employee employee) {
        Employee ep =repo.saveAndFlush(employee);
        return ep;
    }

    @Override
    public List<Employee> findAll() {
        return repo.findAll();
    }
}
