package com.company;

public abstract class Employee {
    private String name;
    private double salary;

    public Employee(String name,double salary){
        this.name = name;
        setSalary(salary);
    }

    public Employee(String name){
        this.name = name;
        this.salary = 500;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        if(salary<=500)
            this.salary = 500;
        else
            this.salary = salary;
    }

    public abstract double getAllSalary();

    @Override
    public String toString() {
        return name + " --> " + String.valueOf(getAllSalary());
    }
}
