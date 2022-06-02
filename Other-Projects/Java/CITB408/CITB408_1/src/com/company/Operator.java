package com.company;

public class Operator extends Employee {
    public Operator(String name , double salary){
        super(name,salary);
    }

    public Operator(String name){
        super(name);
    }

    @Override
    public double getAllSalary() {
        return this.getSalary();
    }
}
