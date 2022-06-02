package com.company;

public abstract class Employee {
    private String name;
    private double mainSalary;

    public Employee(String name, double mainSalary){
        this.name = name;
        if(mainSalary<=300)// Това ще е минимималната заплата , като ако се подаде по малко автоматично ще стане на минималната
            this.mainSalary = 300;
        else
            this.mainSalary = mainSalary;
    }

    public Employee(String name){
        this.name = name;
    }

    public abstract double getTotalSalary();
    public double getMainSalary(){
        return this.mainSalary;
    }

    public String getName(){
        return this.getName();
    }

    @Override
    public String toString() {
        return name;
    }
}
