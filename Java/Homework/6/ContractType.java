package com.company;

public enum ContractType {
    PERMANENT(10),PART_TIME(7),TRAINEE(3);
    private double salaryPerHour;

    private ContractType(double salaryPerHour){
        this.salaryPerHour = salaryPerHour;
    }

    public double getSalaryPerHour(){
        return this.salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour){
        this.salaryPerHour = salaryPerHour;
    }

}
