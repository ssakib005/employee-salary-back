package com.company.employee.models;

public class CompanyInfoResponse {
    private double totalPaidSalary;
    private double remainingBalance;

    public CompanyInfoResponse() {
    }

    public CompanyInfoResponse(double totalPaidSalary, double remainingBalance) {
        this.totalPaidSalary = totalPaidSalary;
        this.remainingBalance = remainingBalance;
    }

    public void setTotalPaidSalary(double totalPaidSalary) {
        this.totalPaidSalary = totalPaidSalary;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public double getTotalPaidSalary() {
        return totalPaidSalary;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }
}
