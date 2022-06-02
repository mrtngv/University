package com.company;

public class Seller {
    private String name;
    private double salary;

    public Seller(){}
    public Seller(String name,double salary){this.name = name;this.salary = salary;}

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String toString(){
        return "I am " + name + " and i have salary: " + salary;
    }

}
