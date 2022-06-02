package com.company;

public class Manager extends Employee {
    public static double percentBonus = 0;
    public Manager(String name , double salary){
        super(name,salary);
    }
    public Manager(String name){
        super(name);
    }

    public void setPercent(double percent){
        if(percent<=0||percent>100)
            this.percentBonus = 0;
        else
            this.percentBonus = percent;
    }

    public double getPercent(){
        return this.percentBonus;
    }


    @Override
    public double getAllSalary() {
        return getSalary()+((getSalary()*percentBonus)/100);
    }
}
