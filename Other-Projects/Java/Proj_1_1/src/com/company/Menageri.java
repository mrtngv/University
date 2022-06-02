package com.company;

public class Menageri extends Employee {
    protected static double percent = 0;
    public Menageri(String name , double mainSalary){
        super(name,mainSalary);
    }

    public double getPercent(){
        return this.percent;
    }

    public void setPercent(double percent){
       this.percent = percent;
    }

    public  double getTotalSalary(){
            return getMainSalary() + (getMainSalary()*percent)/100;
    }

}
