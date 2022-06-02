package com.company;
public class Main {

    public static void main(String[] args) throws Exception {
        //Демо на Проект с примерни входни данни:

         Manufactory myManufactory = new Manufactory();
         myManufactory.setManufactoryGoal(10000); // целта на печатницата е да направи 10000 лв оборот,ако това се осъществи , мениджърите ще получават процент към заплатата си
        myManufactory.setPrforManagers(10);

        Publishing publishing_b_1 = new Publishing("Спасителят в ръжта",215,65,pageSize.A5,PublishingFormat.BOOKS);
        Publishing publishing_b_2 = new Publishing("Гънка във времето",150,70,pageSize.A4,PublishingFormat.BOOKS);
        Publishing publishing_b_3 = new Publishing("Хрониките на Нарния: Лъвът, Вещицата и дрешникът",320,65,pageSize.A5,PublishingFormat.BOOKS);
        Publishing publishing_b_4 = new Publishing("Шерлок Холмс",400,77,pageSize.A5,PublishingFormat.BOOKS);
        Publishing publishing_d_1 = new Publishing("Реки в Германия",50,55,pageSize.A3,PublishingFormat.DICTIONARY);

        Machines machine_1 = new Machines("Машина АТЛАС",4500,40,true);
        Machines machine_2 = new Machines("Mашина БУРГАС",10000,50,false);
        Machines machine_3 = new Machines("Mашина ВИСТА",20500,60,false);

        Employee employee1 = new Operatori("Иван Иванов",1500);
        Employee employee2 = new Operatori("Костадин Табаков",1500);
        Employee employee3 = new Menageri("Мария Генова",5000);

        //Закачам данните за печатницата:
        myManufactory.hireEmployee(employee1);
        myManufactory.hireEmployee(employee2);
        myManufactory.hireEmployee(employee1); // Тук ще изпише,че този работник вече работи тук
        myManufactory.hireEmployee(employee3);

        myManufactory.wireMachine(machine_1);
        myManufactory.wireMachine(machine_2);
        myManufactory.wireMachine(machine_1); // Тук ще изпише ,че тази машина вече е вързана за системата
        myManufactory.wireMachine(machine_3);

        myManufactory.print(publishing_b_1,10,MachinePrintingPaperKind.Casual);
        myManufactory.print(publishing_b_1,15,MachinePrintingPaperKind.Casual);
        myManufactory.print(publishing_b_2,20,MachinePrintingPaperKind.Casual);
        myManufactory.print(publishing_d_1,20,MachinePrintingPaperKind.Casual); // тук ще каже че няма свободен принтер.

        while(Thread.activeCount()>2){} // Изчаквам пуснатите нишки с този цикъл, понеже нещата по-долу няма да имат смисъл
        //myManufactory.printReadyPublishings();
        myManufactory.makeDeal(publishing_b_1,10,20);
        //myManufactory.printSoldPublishings();
        //myManufactory.printReadyPublishings();

        myManufactory.print(publishing_b_4,50,MachinePrintingPaperKind.Casual); // Тук ще каже че няма достатъчно хартия
        myManufactory.AllMachinesCharging(); // тук зареждаме всички машини

        while(Thread.activeCount()>2){} // Изчаквам пуснатите нишки с този цикъл, понеже нещата по-долу няма да имат смисъл
        myManufactory.makeDeal(publishing_b_1,10,20); // тук ще каже,че няма печатано,защото първия път като е печатано вече е продадено

        myManufactory.print(publishing_b_3,6,MachinePrintingPaperKind.Other);
        myManufactory.print(publishing_b_2,10,MachinePrintingPaperKind.Casual);
        myManufactory.print(publishing_b_4,5,MachinePrintingPaperKind.Casual);
        while(Thread.activeCount()>2){} // Изчаквам пуснатите нишки с този цикъл, понеже нещата по-долу няма да имат смисъл
        myManufactory.makeDeal(publishing_b_2,10,20); // тук ще каже,че няма печатано,защото първия път като е печатано вече е продадено

        System.out.println("Total Income: " + myManufactory.getIncome());
        System.out.println("Total Cost: " + myManufactory.getTotalCost());

        myManufactory.toFile("myManufactory.txt"); // запазва цялата информация във файл с това име
        myManufactory.fromFile("myManufactory.txt"); // чете от файла


    }

}