package com.company.employee.repository;


import com.company.employee.models.BasicSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicSalaryRepo extends JpaRepository<BasicSalary, Long> {
}
