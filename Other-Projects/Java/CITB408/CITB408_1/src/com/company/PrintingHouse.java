package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PrintingHouse {
    private List<Employee> employees;
    private double percentForOrders = 10;
    private double percentForManagers = 20;
    private List<Printer> printers;
    private List<Publication> publications;
    private List<Integer> publicationNUmber;
    private Order order;// може да бъде и лист orders
    private Order soldOrders;
    private double earnings;
    private double target;
    private double costs;

    public PrintingHouse(){
        this.employees = new ArrayList<Employee>();
        this.printers = new ArrayList<Printer>();
        this.publications = new ArrayList<Publication>();
        this.publicationNUmber = new ArrayList<Integer>();
        this.earnings = 0;
        this.costs = 0;
        order = new Order();
        soldOrders = new Order();
    }

    public void setTarget(double target){
        this.target = target;
    }

    public void addOrder(Publication publication, int numberOfPupbications){
        order.addOrder(publication,numberOfPupbications);
    }

    public void seeDay(){
        try(FileReader fr = new FileReader("PrintingHouse_Details.txt");){
            int c;

            while((c= fr.read())!=-1)
                System.out.print((char) c);

        }catch (IOException e){
            System.err.println(e);
        }



    }


    public void sell(Publication publication){
        int indexSell = order.getIndexOfPublication(publication);
        if(indexSell==-1){
            System.err.println("There is not such an agreement");
            return;
        }
        int numberOfPublicatoons = order.getNumberOfPuplication(indexSell);
        int indexHere = this.getIndexOfPublication(publication);
        if(indexHere==-1){
            System.err.println("There is not such an Publication print yet!");
            return;
        }
        if(publicationNUmber.get(indexHere)<numberOfPublicatoons){
            System.err.println("There is not enough number of this publication in PrintingHouse");
            return;
        }
        double percent = 0;
        if(publicationNUmber.get(indexHere)>numberOfPublicatoons)
            percent = percentForOrders;

        this.earnings+=publication.getPublicationCost()*publicationNUmber.get(indexHere) -((publication.getPublicationCost()*publicationNUmber.get(indexHere)*percent)/100);
        soldOrders.addOrder(publication,publicationNUmber.get(indexHere));
        order.deleteOrder(indexSell);
        publications.remove(indexHere);
        publicationNUmber.remove(indexHere);

        /*
        soldOrders.printOrder();
        order.printOrder();
        this.getAllAvailablePublications();

         */

    }

    public double getEarnings(){
        return this.earnings;
    }

    public double getCosts(){
        return this.costs;
    }

    public void getAllAvailablePublications(){
        for(int i=0;i<publicationNUmber.size();i++){
            System.out.println(publications.get(i)+" --> " + publicationNUmber.get(i));
        }
    }

    public void addEmployee(Employee employee){
        if(this.employees.contains(employee))
            System.err.println(employee + "is working here");
        else
            employees.add(employee);
    }

    public void addPrinter(Printer printer){
        if(this.printers.contains(printer))
            System.err.println(printer + "is connected already");
        else
            printers.add(printer);
    }

    private int getIndexOfFreePrinter(){
        int freePrinterIndex = -1;
        for(int i=0;i<printers.size();i++){
            if(printers.get(i).getIsPrinterReady()==true){
                freePrinterIndex = i;
                break;
            }
        }
        return freePrinterIndex;
    }

    private int getIndexOfPublication(Publication publication){
        int index = -1;
        for(int i=0;i<publications.size();i++){
            if(publications.get(i).isEqual(publication))
                index = i;
        }
        return index;
    }

    public void print(Publication publication,int numberOfPublications,PaperType paperType) {
        int IndexOfFreePrinter = getIndexOfFreePrinter();
        if (IndexOfFreePrinter == -1)
            System.err.println("All printers are busy right now");
        else {
            PrintingThread p
                    = new PrintingThread(printers.get(IndexOfFreePrinter), publication, numberOfPublications);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            if(printers.get(IndexOfFreePrinter).getIsTaskDone()==true) {
                this.costs += publication.getNumberOfPages() * paperType.getPrice() * publication.getPaperSize().getPrice();
                int index = getIndexOfPublication(publication);
                if (index == -1) {
                    publications.add(publication);
                    publicationNUmber.add(numberOfPublications);
                } else
                    publicationNUmber.set(index, (publicationNUmber.get(index) + numberOfPublications));

            }
        }
    }

    public String availablePublications(){
        String text = "All available Publications that were print today:\n";

        for(int i=0;i<publications.size();i++){
            text+=publications.get(i);
            text+=" ---> ";
            text+=String.valueOf(publicationNUmber.get(i));
            text+="\n";
        }
        return text;
    }

    public void endDay(){
        String source = availablePublications();
        source+="Made deals:\n";
        source+=soldOrders.getOrder();
        source+="Remaining orders:\n";
        source+=order.getOrder();
        source+="Available Publications:\n";
        source+=availablePublications();
        source+="Total Earnings = " + String.valueOf(earnings);
        if(earnings>=target)
            Manager.percentBonus = percentForManagers;
        for(int i =0;i<employees.size();i++){
            costs+=employees.get(i).getAllSalary();
        }
        source+="\nTotal costs =  "+String.valueOf(costs);
        try(FileWriter fw = new FileWriter("PrintingHouse_Details.txt",false);){
            fw.write(source);
        }catch (IOException e){
            System.err.println(e);
        }

    }
    // To do public void print(paperTYpe....) , costs,earnings, tofile , fromfile
}

class PrintingThread implements Runnable{
    Printer printer;
    Publication publication;
    int numberOfPublications;
    Thread printThread;

    PrintingThread(Printer printer,Publication publication,int numberOfPublications){
        this.printer = printer;
        this.publication = publication;
        this.numberOfPublications = numberOfPublications;
        printThread = new Thread(this);
        System.out.println("Starting work on printer" + printer);
        printThread.start();
    }

    @Override
    public void run() {
        try{
            printer.setIsTaskDone(false);
            printer.print(publication, numberOfPublications);
            printer.setIsTaskDone(true);
            printer.setPrinterReady(false);
            for(int i =0;i<numberOfPublications-1;i++) {
                printer.print(publication, numberOfPublications);
                Thread.sleep(2000);
            }
            printer.removePrinterCurrentPage(numberOfPublications*publication.getNumberOfPages());
            printer.setPrinterReady(true);
        }catch (paperNumberExcepiton e){
            System.err.println(e);
        }catch (InterruptedException e){
            System.err.println(e);
        }
    }
}
