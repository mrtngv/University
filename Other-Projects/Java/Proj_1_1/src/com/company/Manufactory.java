package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Manufactory {
    private double manufactoryGoal = 0;
    private List<Employee> employees;
    private List<ReadyPublishing> readyPublishings;
    private List<ReadyPublishing> soldPublishings;
    private List<Machines> machines;
    private double costsOfPublishings = 0;
    private double income = 0;
    private double prforManagers =0;

    public Manufactory(){
        this.employees = new ArrayList<Employee>();
        this.readyPublishings = new ArrayList<ReadyPublishing>();
        this.machines = new ArrayList<Machines>();
        this.soldPublishings = new ArrayList<ReadyPublishing>();
    }

    public void hireEmployee(Employee e){
        if(employees.contains(e))
            System.err.println(e + " currently working here!");
        else{
            System.out.println(e + " Hired.");
            employees.add(e);
        }
    }

    public void wireMachine(Machines m){
        if(machines.contains(m))
            System.err.println(m + " CURRENTLY wired to the System");
        else{
            System.out.println(m+" Wired to the System");
            machines.add(m);
        }
    }

    public void AllMachinesCharging(){
        for(int i=0;i<machines.size();i++)
            machines.get(i).makeItToMaximumPages();
    }

    public void makeDeal(Publishing publishing,int numberOfPublishings,double percentageIfOverflow){
        //Ако има такова печатано издание
            //Ако има достатъчно на брой такива издания
                //Ако са повече направи отстъпка - percentageIfOverflow
                //Ще добави в списъка със продадени (Книги) , ако е успяло да се продаде;
                //Ще увеличи приходите
        int indexOfReadyPublishingtoSell = -1;
        for(int i =0;i<readyPublishings.size();i++){
            //System.out.println("Сега сравнявам:" +readyPublishings.get(i).getTitle()+"с"+publishing.getTitle());
            if(readyPublishings.get(i).isEqual(publishing)==true){
                //System.err.println("Test");
                indexOfReadyPublishingtoSell = i;
                break;
            }
        }
        if(indexOfReadyPublishingtoSell==-1){ // Няма го в листа с принтирани издания
            System.err.println(publishing.toString()+" Не е печатано");
            return;
        }

        if(numberOfPublishings>readyPublishings.get(indexOfReadyPublishingtoSell).getNumberOfPublishings()){ // има такова издание ,но Няма достатъчно бройки от него
            System.err.println(publishing.toString()+" Няма достатъчно бройки");
            return;
        }
        double percentToBeDone = 0; //Засега е нула след следващата проверка ще разберем дали изданията са повече от колкото трябва и ще го променим на този, който е зададен
        if(numberOfPublishings<readyPublishings.get(indexOfReadyPublishingtoSell).getNumberOfPublishings())
            percentToBeDone = percentageIfOverflow;
        //Изчисляваме общата цена и я добавяме към приходите
        income+=(publishing.getCost()*readyPublishings.get(indexOfReadyPublishingtoSell).getNumberOfPublishings()) -
                (((publishing.getCost()*percentToBeDone)/100)*readyPublishings.get(indexOfReadyPublishingtoSell).getNumberOfPublishings());

        //Добавяме към списъка с продадени и изтриваме от списъка с принтирани
        for(int i=0;i<soldPublishings.size();i++){
            if(soldPublishings.get(i).isEqual(publishing)){
                soldPublishings.get(i).addNumber(readyPublishings.get(indexOfReadyPublishingtoSell).getNumberOfPublishings());
                readyPublishings.remove(indexOfReadyPublishingtoSell);
                return;
            }
        }
        soldPublishings.add(new ReadyPublishing(publishing,readyPublishings.get(indexOfReadyPublishingtoSell).getNumberOfPublishings()));
        readyPublishings.remove(indexOfReadyPublishingtoSell);
    }



    public void print(Publishing publishing,int publishingNumber,MachinePrintingPaperKind machinePrintingPaperKind){
        //Извиква startPrinting(Publishing publishing,Machines machine,int publishingNumber,MachinePrintingPaperKind machinePrintingPaperKind)
            //Ако върне true , значи успешно може да отпечата това издание , следователно разходите ще се увеличат;
                //Също така трябва да отпечатва единствено и само на свободна машина, ако машината не е свободна, претърсва в списъка с машини докато намери свободна такава
        int machineAvailablePosition = -1;
        for(int i=0;i<machines.size();i++){ // Намира пърата свободна машина и нейният индекс се запазва в machineAvailablePosition
            if(machines.get(i).isAvailable()==true){
                machineAvailablePosition = i;
                break;
            }
        }
        if(machineAvailablePosition==-1) {
            System.err.println("There is no available machine right now!"); // ако не е намерило свободна машина, функцията приключва изпълнение тук;
            return;
        }
        boolean isSuccessfullyPrintedPublishing =
                this.machines.get(machineAvailablePosition).startPrinting(publishing,machines.get(machineAvailablePosition),publishingNumber,machinePrintingPaperKind);
        if(!isSuccessfullyPrintedPublishing) // ако не е успяло да изпринтира успешно (Книгата) приключва изпълнение , ако не продължи надолу;
            return;
        //общия брой страници, по цената на размера на хартията , по цената на вида хартия , по брой разпечатани издания
        this.costsOfPublishings+=publishingNumber*machinePrintingPaperKind.getCostOfMachinePrintingPaperKind()*publishing.getPublishingPages()*publishing.getPageSize().getCostOfPages();
        for(int i =0;i<readyPublishings.size();i++){ // обхожда вече готовите публикации , за да провери дали има такава и просто да добави количеството вместо да записва но обект
            if(readyPublishings.get(i).isEqual(publishing)){
                readyPublishings.get(i).addNumber(publishingNumber);
                return;
            }
        }
        //ако е стигнало до тук означава че нито една от проверките горе не е изпълнена за това ще трябва да се добави в списъка
        readyPublishings.add(new ReadyPublishing(publishing,publishingNumber));
    }

    public void printReadyPublishings(){ // принтира всички текущи готови (Книги)
        System.out.println("Готови за продажба издания:");
        for(int i=0;i<readyPublishings.size();i++)
            System.out.println(readyPublishings.get(i).toString());
    }

    public void printSoldPublishings(){ // принтира всички текущи готови (Книги)
        System.out.println("Продадени издания:");
        for(int i=0;i<soldPublishings.size();i++)
            System.out.println(soldPublishings.get(i).toString());
    }

    public void setPrforManagers(double perc){
        this.prforManagers = perc;
    }

    public double getTotalCost(){

        double total = 0;
            if(income>=manufactoryGoal)
                Menageri.percent = this.prforManagers;

            for(int i =0;i<employees.size();i++){
                total+=employees.get(i).getTotalSalary();
            }
            total+=costsOfPublishings;


        total = total*100;
        total = Math.round(total);
        total = total /100;
        return total;
    }

    public double getIncome(){
        return this.income;
    }

    public void setManufactoryGoal(double goal){
        this.manufactoryGoal = goal;
    }

    public void toFile(String filename){
        // Да записва информацията във файл с име file name;
        String fileText = "Свободни Изпечатани издания\n";
        for(int i =0;i<readyPublishings.size();i++){
            fileText+=String.valueOf(i+1) +") " + readyPublishings.get(i).toString() +"\n";
        }
        fileText+="\nПродадени издания: \n";
        for(int i =0;i<soldPublishings.size();i++){
            fileText+=String.valueOf(i+1) +") " + soldPublishings.get(i).toString() +"\n";
        }
        fileText+="\nРаботници, които работят:\n";
        for(int i=0;i<employees.size();i++){
            fileText+=String.valueOf(i+1) +") " + employees.get(i).toString()+"\n";
        }
        fileText+="\nTotal income: " + String.valueOf(income) + "     Total costs: " + String.valueOf(getTotalCost());

        try(FileWriter fileWriter = new FileWriter(filename,false)){
            fileWriter.write(fileText);
        }catch (IOException e){
            System.err.println("AN IO EXCEPTION accured");
        }
    }

    public void fromFile(String filename){
        //Да чете информацията от файл;
        try(FileReader fileReader = new FileReader(filename)){
            int c;
            while((c=fileReader.read())!=-1)
                System.out.print((char)c);
        }catch (FileNotFoundException e){
            System.err.println("File not found");
        }catch (IOException i){
            System.err.println("IO EXCEPTION");
        }
    }
}
