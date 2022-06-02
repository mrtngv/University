package com.company;

public class Operatori extends Employee {
    public Operatori(String name, double mainSalary){
        super(name,mainSalary);
    }

    public  double getTotalSalary(){
        return getMainSalary();
    }
}
