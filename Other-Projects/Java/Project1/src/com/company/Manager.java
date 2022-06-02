package com.company;

public class Manager extends Employee {

    public Manager(String employeeName){
        super(employeeName);
    }

    public Manager(String employeeName,double salary){
        super(employeeName,salary);
    }
    /*
    public Manager(String employeeName,double salary,double percent){
        super(employeeName,salary);
        if(percent<=minimumSalary.MINIMUM_PERCENT.getMinimum()||percent>100)
            this.percent = minimumSalary.MINIMUM_PERCENT.getMinimum();
        else
            this.percent = percent;
    }
    */

    @Override
    public double calculateSalary() {
        return super.getSalary() + ((super.getSalary()*minimumSalary.MINIMUM_PERCENT.getMinimum())/100);
    }
}
