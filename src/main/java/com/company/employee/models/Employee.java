package com.company.employee.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Setter
@Getter
@Table(name = "employee")
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 4, max = 4, message = "Employee id must be 4 digit.")
    @Column(unique = true)
    private String employee_id;

    private String name;
    @OneToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    private Grade grade;
    private String address;
    private String mobile_number;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_account_id", referencedColumnName = "id")
    private EmployeeAccount bank_account;


    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setBank_account(EmployeeAccount bank_account) {
        this.bank_account = bank_account;
    }

    public Long getId() {

        return id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public EmployeeAccount getBank_account() {
        return bank_account;
    }
}
