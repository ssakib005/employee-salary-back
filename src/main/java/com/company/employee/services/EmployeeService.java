package com.company.employee.services;

import com.company.employee.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> findAll();
}
