package com.example.employee;

public class Manager extends Employee{
    private String deptName;

    public Manager(String deptName) {
        this.deptName = deptName;
    }

    public Manager(int empId, String name, String ssn, double salary, String deptName) {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
    }
}
