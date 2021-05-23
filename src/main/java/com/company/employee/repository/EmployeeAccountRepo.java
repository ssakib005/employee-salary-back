package com.company.employee.repository;

import com.company.employee.models.EmployeeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAccountRepo extends JpaRepository<EmployeeAccount, Long> {
}
