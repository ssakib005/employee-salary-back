package com.company.employee.repository;

import com.company.employee.models.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType, Long> {
}
