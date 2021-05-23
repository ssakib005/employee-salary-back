package com.company.employee.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "employee_account")
@NoArgsConstructor
public class EmployeeAccount {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    private AccountType account_type;
    private String account_name;
    private String account_number;
    private String bank_name;
    private String branch_name;
    private Double current_banlance;
    private Integer status;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccount_type(AccountType account_type) {
        this.account_type = account_type;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public void setCurrent_banlance(Double current_banlance) {
        this.current_banlance = current_banlance;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {

        return id;
    }

    public AccountType getAccount_type() {
        return account_type;
    }

    public String getAccount_name() {
        return account_name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public String getBank_name() {
        return bank_name;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public Double getCurrent_banlance() {
        return current_banlance;
    }

    public Integer getStatus() {
        return status;
    }
}
