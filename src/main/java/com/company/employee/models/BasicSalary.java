package com.company.employee.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "basic_salary")
@NoArgsConstructor
public class BasicSalary {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double salary;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public Double getSalary() {
        return salary;
    }
}
