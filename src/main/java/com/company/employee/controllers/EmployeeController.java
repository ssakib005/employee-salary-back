package com.company.employee.controllers;

import com.company.employee.models.*;
import com.company.employee.services.AccountTypeService;
import com.company.employee.services.BasicSalaryService;
import com.company.employee.services.EmployeeService;
import com.company.employee.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.xml.ws.Response;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EmployeeController {

    private static final String ENTITY_NAME = "employee";
    private static final String PATH = "employee";
    private static final String PATH_SAVE = PATH + "/save";
    private static final String PATH_UPDATE = PATH + "/update";
    private static final String PATH_DELETE = PATH + "/delete/{id}";
    private static final String PATH_FIND_ALL = PATH + "/get-all";
    private static final String PATH_FIND = PATH + "/{id}";

    private static final String PATH_GRADE_ALL = PATH + "/grades";
    private static final String PATH_TYPES_ALL = PATH + "/types";

    private static final String PATH_SAVE_SALARY = PATH + "/salary";
    private static final String PATH_SALARY = PATH + "/salary-amount";

    private static final String PATH_SALARY_TRANSFER = PATH + "/salary-transfer";
    private static final String PATH_SALARY_TRANSFER_ALL = PATH + "/salary-all";
    private static final String PATH_COMPANY_INFO = PATH + "/info";


    @Autowired
    private EmployeeService service;

    @Autowired
    private GradeService gradService;

    @Autowired
    private AccountTypeService accountTypeService;

    @Autowired
    private BasicSalaryService salaryService;


    @GetMapping(path = PATH_GRADE_ALL)
    @CrossOrigin
    public List<Grade> findAllGrades(){
        return gradService.findAll();
    }

    @GetMapping(value = PATH_TYPES_ALL)
    @CrossOrigin
    public List<AccountType> findAllTypes(){
        return accountTypeService.findAll();
    }


    @GetMapping(path = PATH_FIND_ALL, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<List<Employee>> getAll() throws URISyntaxException{
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(path = PATH_SAVE)
    @CrossOrigin
    public ResponseEntity<Employee> save(@Validated @RequestBody Employee employee) throws URISyntaxException {
        Employee emp = service.save(employee);
        return ResponseEntity.ok(emp);
    }

    @PutMapping(path = PATH_SAVE_SALARY)
    @CrossOrigin
    public ResponseEntity<Double> updateBasicSalary(@RequestParam Double amount) throws NullPointerException {
        return ResponseEntity.ok(salaryService.updateBasicSalary(amount));
    }

    @GetMapping(path = PATH_SALARY)
    @CrossOrigin
    public ResponseEntity<Double> getBasicSalary(){
        return ResponseEntity.ok(salaryService.geBasicSalary());
    }

    @PutMapping(path = PATH_SALARY_TRANSFER+"/{id}")
    @CrossOrigin
    public ResponseEntity<TransferResponse> transferSalaryById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(salaryService.transferSalary(id));
    }

    @GetMapping(path = PATH_SALARY_TRANSFER_ALL)
    @CrossOrigin
    public ResponseEntity<TransferResponse> transferToAll(){
        return ResponseEntity.ok(salaryService.transferToAllAccount());
    }

    @GetMapping(path = PATH_COMPANY_INFO)
    @CrossOrigin
    public ResponseEntity<CompanyInfoResponse> getCompanyProfile(){
        return ResponseEntity.ok(salaryService.companyInfo());
    }

}
