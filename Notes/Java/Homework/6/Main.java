package com.company;

public class Main {

    public static void main(String[] args) {
	    Employee e1 = new Employee("Martin",ContractType.PART_TIME,160,100);
        Employee e2 = new Employee("Kristiqn",ContractType.PERMANENT,100,50);
        Employee e3 = new Employee("Petur",ContractType.TRAINEE,50);
        Employee e4 = new Employee("Gosho",ContractType.PERMANENT,20,10);
        Employee e5 = new Employee("Toshko",ContractType.TRAINEE,40);
        Employee e6 = new Employee("Slavcho",ContractType.PERMANENT,40);

        Company c1 = new Company("ExoticSoft",5);
        //Опитвам се да вмъкна един и същи служител, но не успява
        c1.addEmployee(e1);
        c1.addEmployee(e1);
        c1.addEmployee(e2);
        c1.addEmployee(e3);
        c1.addEmployee(e4);
        c1.addEmployee(e5);
        c1.addEmployee(e6);
        //Опитвам се да надхвърля лиита на максимален брой служители, за това първо уволнявам един и след това назначавам e6
        c1.removeEmployee(e4);
        c1.addEmployee(e6);

        c1.printEmployees();

        System.out.println(c1.middleSalary());

        //Увеличавам с 50% допълнителното възнагражение на е1- и от 100 става на 150 лв.
        c1.increaseIndividualBonus_byPercent(e1,50);
        c1.printEmployees();

        //Опитвам се да увелича допълнителното възнаграждение на Работник,който е създаден но не е добавен в Компанията;
        c1.increaseIndividualBonus_byPercent(e4,50);
        c1.printEmployees();


        //Увеличавам допълнителното възнагражение на всички;
        c1.increaseAllIndividualBonus_byPercent(50);
        c1.printEmployees();


        System.out.println(c1.middleSalary());
        
        System.out.println(c1.getAvaregeSalary_byTipe(ContractType.PERMANENT));

        c1.printCompany();

    }
}
