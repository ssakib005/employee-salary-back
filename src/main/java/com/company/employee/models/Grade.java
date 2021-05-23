package com.company.employee.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Setter
@Getter
@Table(name = "grade")
@NoArgsConstructor
public class Grade {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String grade_name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public Long getId() {
        return id;
    }

    public String getGrade_name() {
        return grade_name;
    }
}
