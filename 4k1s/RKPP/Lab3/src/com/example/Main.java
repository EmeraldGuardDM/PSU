package com.example;

import com.example.employee.*;

public class Main {

    public static void main(String[] args) {
        Engineer eng = new Engineer(1, "Nikita", "012-34-5678", 1765.27);
        Manager mgr = new Manager(2, "Ilya", "054-12-2367", 534.36, "US Marketing");
        Admin adm = new Admin(3, "Fedya", "108-23-2367", 6345.34);
        Director dir = new Director(4, "Vanya", "099-45-2340", 2345.36, "Global Marketing", 1_000_000.00);

        printEmployee(eng);
        printEmployee(mgr);
        printEmployee(adm);
        printEmployee(dir);
    }

    private static void printEmployee(Employee emp) {
        System.out.println("Employee ID: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Soc Sec # " + emp.getSsn());
        System.out.println("Employee salary: " + emp.getSalary());
    }

}
