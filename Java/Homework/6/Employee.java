package com.company;

public class Employee {
    private String name;
    private int ID;
    private int hoursPerMounth;
    private double individualBonus;
    private static int identity = 0;
    private ContractType contractType;

    public Employee(String name,ContractType contractType, int hoursPerMounth){
        this.name = name;
        this.individualBonus = 0;
        this.contractType = contractType;
        this.hoursPerMounth = hoursPerMounth;
        identity++;
        this.ID = identity;
    }

    public Employee(String name,ContractType contractType, int hoursPerMounth,double individualBonus){
        this.name = name;
        this.individualBonus = individualBonus;
        this.contractType = contractType;
        this.hoursPerMounth = hoursPerMounth;
        identity++;
        this.ID = identity;
    }

    public void changeContract(ContractType contractType){
        this.contractType = contractType;
    }

    public int getID(){
        return this.ID;
    }

    public double getIndividualBonus(){
        return this.individualBonus;
    }

    public ContractType getContractType(){
        return this.contractType;
    }

    public void setIndividualBonus(double individualBonus){
        if(individualBonus<0)
            System.out.println("Must be more than 0");
        else
            this.individualBonus = individualBonus;
    }


    public double getSalary(){
        return this.hoursPerMounth*this.contractType.getSalaryPerHour() + this.individualBonus;
    }

    @Override
    public String toString() {
        return "Employee: " + name +
                "\nID = " + ID +
                "\nhoursPerMounth=" + hoursPerMounth +
                "\nindividualBonus=" + individualBonus +
                "\n contractType=" + contractType +
                '}';
    }
}
