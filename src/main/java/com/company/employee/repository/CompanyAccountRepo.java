package com.company.employee.repository;

import com.company.employee.models.CompanyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyAccountRepo extends JpaRepository<CompanyAccount, Long> {
}
