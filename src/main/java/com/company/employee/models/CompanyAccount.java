package com.company.employee.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "company_account")
@NoArgsConstructor
public class CompanyAccount {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double banlance;

    public Long getId() {
        return id;
    }

    public Double getBanlance() {
        return banlance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBanlance(Double banlance) {
        this.banlance = banlance;
    }
}
