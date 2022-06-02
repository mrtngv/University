package com.company;

import java.security.spec.RSAPrivateKeySpec;

public class Main {

    public static void main(String[] args) {


        PrintingHouse printingHouse = new PrintingHouse();
        printingHouse.setTarget(300);
        Employee employee1 = new Operator("Mike",650);
        Employee employee2 = new Manager("Mike",650);
        Publication publication1 = new Publication("Economics",PublicationType.BOOK,PaperSize.A3,50,20);
        Publication publication2 = new Publication("Cars",PublicationType.MAGAZINE,PaperSize.A4,20,5);
        Publication publication3 = new Publication("Poker ",PublicationType.NEWSPAPER,PaperSize.A5,30,60);
        Publication publication4 = new Publication("Fishing carps",PublicationType.MAGAZINE,PaperSize.A2,15,10);
        Publication publication5 = new Publication("ChessPlay",PublicationType.MAGAZINE,PaperSize.A4,20,15);
        Publication publication6 = new Publication("Football teams 2020 ",PublicationType.NEWSPAPER,PaperSize.A5,10,20);
        Publication publication7 = new Publication("Playboy",PublicationType.MAGAZINE,PaperSize.A2,30,60);
        Printer printer1 = new Printer("Samsung",500,false,20);
        Printer printer2 = new Printer("Conica",500,true,50);
        Printer printer3 = new Printer("Lumix",300,true,50);

        printingHouse.addEmployee(employee1);
        printingHouse.addEmployee(employee2);
        printingHouse.addPrinter(printer1);
        printingHouse.addPrinter(printer2);
        printingHouse.addPrinter(printer3);

        printingHouse.print(publication1,10,PaperType.DOTTED);
        printingHouse.print(publication2,10,PaperType.DOTTED);
        printingHouse.print(publication5,10,PaperType.DOTTED);
        while(Thread.activeCount()>2){}
        printer1.chargeToMax();
        printer2.chargeToMax();
        printingHouse.print(publication4,10,PaperType.DOTTED);
        printingHouse.print(publication7,5,PaperType.DOTTED);
        printingHouse.print(publication5,10,PaperType.DOTTED);
        while(Thread.activeCount()>2){}
        printingHouse.addOrder(publication1,5);
        printingHouse.addOrder(publication2,5);
        printingHouse.sell(publication1);
        printingHouse.endDay();
        printingHouse.seeDay();

    }
}
