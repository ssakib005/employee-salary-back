package com.company.employee.controllers;


import com.company.employee.services.CompanyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    private static final String PATH = "company";
    private static final String PATH_SAVE = PATH + "/account";
    private static final String PATH_BALANCE = PATH + "/account-balance";

    @Autowired
    CompanyAccountService service;


    @PutMapping(path = PATH_SAVE)
    @CrossOrigin
    public ResponseEntity<Double> updateCompanyAccount(@RequestParam Double amount) throws NullPointerException {
        return ResponseEntity.ok(service.updateBalance(amount));
    }

    @GetMapping(path = PATH_BALANCE)
    @CrossOrigin
    public ResponseEntity<Double> getCompanyBalance(){
        return ResponseEntity.ok(service.getBalance());
    }

}
