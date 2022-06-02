package com.company;

public class Operator extends Employee {

    public Operator(String employeeName){
        super(employeeName);
    }

    public Operator(String employeeName,double salary){
        super(employeeName,salary);
    }

    @Override
    public double calculateSalary() {
        return super.getSalary();
    }
}
