package com.company.employee.services.imp;

import com.company.employee.models.Grade;
import com.company.employee.repository.GradeRepo;
import com.company.employee.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImp implements GradeService {

    @Autowired
    private GradeRepo repo;

    @Override
    public List<Grade> findAll() {
        return repo.findAll();
    }
}
