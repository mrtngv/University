package com.company;
import java.util.List;
import java.util.ArrayList;

public class Company {
    private String name;
    private int maxEntEmployees;
    private List<Employee> employeeList;

    public Company(String name){
        this.name = name;
        this.maxEntEmployees = 0;
        employeeList = new ArrayList<Employee>();
    }

    public Company(String name,int maxEntEmployees){
        this.name = name;
        this.maxEntEmployees = maxEntEmployees;
        employeeList = new ArrayList<Employee>();
    }

    public void addEmployee(Employee e) {
        if (employeeList.size() < this.maxEntEmployees) {
            if (!employeeList.contains(e))
                employeeList.add(e);
            else
                System.out.println("Already exist");
        } else {

            System.out.println("Can not add Employee, max size Employees reached!");
        }
    }

    public void removeEmployee(Employee e){
        if(employeeList.contains(e))
            employeeList.remove(e);
        else{
            System.out.println("There is not such Employee");
        }
    }

    private boolean checkEmployee(Employee e){
        if(employeeList.contains(e))
            return true;
        else
            return false;
    }

    public void printEmployees(){
        for(Employee e:employeeList)
            System.out.println(e.toString());
    }

    public double allSalaries(){
        double allSalaries = 0;
        for(Employee e:employeeList)
            allSalaries+=e.getSalary();

        return allSalaries;
    }

    public double middleSalary(){

        return allSalaries()/employeeList.size();
    }

    public void increaseIndividualBonus_byPercent(Employee e,double percent){
        // Валидация на кода за процента : 0 -100 %
        if (checkEmployee(e))
            e.setIndividualBonus(e.getIndividualBonus()+e.getIndividualBonus()*percent/100);
        else
            System.out.println("There is not such Employee");
    }

    public void increaseAllIndividualBonus_byPercent(double percent){
        for(Employee e:employeeList)
            e.setIndividualBonus(e.getIndividualBonus()+e.getIndividualBonus()*percent/100);
    }

    public double getAvaregeSalary_byTipe(ContractType contractType){
        double avarage_Salary =0;
        int quantitty_byContractType =0;
        for(Employee e :employeeList){
            if(e.getContractType()==contractType){
                avarage_Salary+=e.getSalary();
                quantitty_byContractType++;
            }
        }
        return avarage_Salary/quantitty_byContractType;
    }

    public void printCompany(){
        System.out.println(this.name);
        System.out.println(this.maxEntEmployees);
        System.out.println(this.employeeList.size());
    }
}

