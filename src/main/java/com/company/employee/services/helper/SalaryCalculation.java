package com.company.employee.services.helper;

public class SalaryCalculation {

    public static Double Calculate(double basic, double increment, int totalGrade, Long currentGrade){
        basic = basic + (increment * (totalGrade - currentGrade));
        return basic + ((basic * 20)/100) + ((basic * 15)/100);
    }
}
