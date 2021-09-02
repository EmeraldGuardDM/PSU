package com.example.employee;

public class Director extends Manager{
    private double budget;

    public Director(String deptName, double budget) {
        super(deptName);
        this.budget = budget;
    }

    public Director(int empId, String name, String ssn, double salary, String deptName, double budget) {
        super(empId, name, ssn, salary, deptName);
        this.budget = budget;
    }

    public double getBudget(){
        return budget;
    }
}
