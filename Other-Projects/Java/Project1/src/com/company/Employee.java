package com.company;

public abstract class Employee {
    private String employeeName;
    private double salary;

    public Employee(String employeeName){
        this.employeeName = employeeName;
        this.salary = minimumSalary.MINIMUM_SALARY.getMinimum();
    }

    public Employee(String employeeName,double salary){
        this.employeeName = employeeName;
        setSalary(salary);
    }

    public double getSalary(){
        return this.salary;
    }

    public abstract double calculateSalary();

    public String getEmployeeName(){
        return this.employeeName;
    }

    public void setSalary(double salary) {
        if(salary<=minimumSalary.MINIMUM_SALARY.getMinimum()) {
            this.salary = minimumSalary.MINIMUM_SALARY.getMinimum();
        }
        else
            this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
