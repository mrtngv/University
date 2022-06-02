package com.company;

public class Main {

    public static void main(String[] args) {
        //Има реално забавяне ако машината печата до 50 страница на минута Направил съм го така :
        //Thread.sleep(10000 - m.getPrintPages_perMinute()*90);
        //Но вече го махнах за да е по-бързо

        //Продажната цена я изчислявам автоматично - и е с 30 % от евентуалния разход за отпечатване горница ;)

        Fabric f = new Fabric(10);
        f.setPercent(20);
        Employee e1 = new Operator("Bart",50); // Няма как заплатата да е толкова малко и затова ще сложи минимална заплата от 1000лв.
        Employee e2 = new Manager("Marti",1200);

        Entry en1 = new Entry("Java for begginers",EntryType.BOOK,paperSize.A5,104);
        Entry en2 = new Entry("C++ for pro's",EntryType.NEWSPAPER,paperSize.A3,207);
        Entry en3 = new Entry("How to train your girlriend",EntryType.BOOK,paperSize.A4,69);
        Entry en4 = new Entry("No sleep",EntryType.NEWSPAPER,paperSize.A1,14);

        PrintingMachine m1 = new PrintingMachine("Delux",25,10000,PrintingColor.COLOR,15);
        PrintingMachine m2 = new PrintingMachine("Inter",50,20000,PrintingColor.BLACK,20);

        m1.charge();
        m2.charge();

        f.hireEmployee(e1);
        f.hireEmployee(e2);

        f.setTarget(1000);

        //Тествам програмата като създавам и добавям поръчки , печатам издания и ги продавам както е описано по условие , накрая записам информацията във файл , а след това чета от него

        Order o2 = new Order(en1,50,paperType.GLANZ);
        Order o3 = new Order(en3,10,paperType.NEWSPAPER);
        Order o9 = new Order(en3,100,paperType.GLANZ);
        Order o4 = new Order(en1,2,paperType.GLANZ);
        Order o5 = new Order(en4,10,paperType.NORMAL);
        Order o6 = new Order(en2,50,paperType.GLANZ);
        Order o7 = new Order(en4,60,paperType.NORMAL);

        f.addOrder(o2);
        f.addOrder(o3);
        f.addOrder(o4);
        f.addOrder(o5);
        f.addOrder(o6);
        f.addOrder(o7);

        f.print(m1,en1,paperType.GLANZ,96);
        f.print(m2,en3,paperType.NEWSPAPER,55);
        while(Thread.activeCount()>2){}
        f.print(m1,en1,paperType.GLANZ,31); // Тук ще даде грешка защото вече машниата има само 16 свободни страници от 10000,които е имала в началото ,затова трябва да се зареди
        f.print(m2,en3,paperType.NEWSPAPER,55);
        while(Thread.activeCount()>2){}
        m1.charge();  // тук зареждам машината напълно
        f.print(m1,en1,paperType.GLANZ,31); //
        while(Thread.activeCount()>2){}
        f.print(m1,en2,paperType.GLANZ,96);
        f.print(m2,en4,paperType.NORMAL,55);
        while(Thread.activeCount()>2){}
        f.makeSell(o7); // няма достатъчно за това ще изпечатам още малко
        m1.charge();
        m2.charge();
        f.makeSell(o6);
        f.print(m2,en4,paperType.NORMAL,15);
        f.print(m1,en1,paperType.GLANZ,31); //
        while(Thread.activeCount()>2){}
        f.makeSell(o2);
        f.makeSell(o5); //сега са точно


        f.toFile();
        f.readFromFile();
    }
}
