package com.company;

public class Machines {
    private String name;
    private int maxPages;
    private int pagesNow;
    private boolean colorPrinting;
    private boolean available;
    private boolean success_Proccess;
    private int speedPages;


    public Machines(String name,int m,int speedPages,boolean colorPrinting){
        this.name = name;
        this.maxPages = m;
        this.speedPages = speedPages;
        this.colorPrinting = colorPrinting;
        this.pagesNow = m;
        this.available = true;
        this.success_Proccess =false;
    }

    public void makeItToMaximumPages(){
        this.pagesNow = maxPages;
    }

    public String getName() {
        return name;
    }

    public int getMaxPages() {
        return maxPages;
    }

    public boolean isColorPrinting() {
        return colorPrinting;
    }

    public int getSpeedPages() {
        return speedPages;
    }
    public void removePages(int pages){
        this.pagesNow-=pages;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setSuccess_Proccess(boolean success_Proccess) {
        this.success_Proccess = success_Proccess;
    }

    public int getPagesNow() {
        return pagesNow;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isSuccess_Proccess() {
        return success_Proccess;
    }

    @Override
    public String toString() {
        return "Machines{" +
                "name='" + name + '\'' +
                ", maxPages=" + maxPages +
                ", pagesNow=" + pagesNow +
                ", colorPrinting=" + colorPrinting +
                ", speedPages=" + speedPages +
                '}';
    }

    public boolean startPrinting(Publishing publishing,Machines machine,int publishingNumber,MachinePrintingPaperKind machinePrintingPaperKind){
        new MachinePrint(publishing,this,publishingNumber,machinePrintingPaperKind);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
        boolean buff = this.isSuccess_Proccess();
        this.setSuccess_Proccess(false);
        return buff;
    }

    public void print(Publishing p, int numberofPublishing, MachinePrintingPaperKind machinePrintingPaperKind,int step) throws MachinesPaperDeficites{
        if(this.pagesNow<p.getPublishingPages()*numberofPublishing)
            throw new MachinesPaperDeficites("Paper is not as Publishing count" + "\npagestoBePrint" + p.getPublishingPages()*numberofPublishing);
        System.out.println("[" + step+"/"+numberofPublishing+"]  Printing Publishing --> " + p);
    }

}
class MachinePrint implements Runnable{
    Publishing publishing;
    Machines machine;
    int publishingNumber;
    MachinePrintingPaperKind machinePrintingPaperKind;
    Thread t;

    MachinePrint(Publishing publishing,Machines machine,int publishingNumber,MachinePrintingPaperKind machinePrintingPaperKind){
        this.publishing = publishing;
        this.machine = machine;
        this.publishingNumber = publishingNumber;
        this.machinePrintingPaperKind = machinePrintingPaperKind;

        t = new Thread(this);

        t.start();

    }

    @Override
    public void run() {
        try{
            System.out.println("Starting machine " + machine);
            this.machine.setAvailable(false);
            this.machine.print(publishing, publishingNumber, machinePrintingPaperKind, 1);
            this.machine.setSuccess_Proccess(true);
            for(int a=0;a<this.publishingNumber-1;a++) {
                Thread.sleep(2450);
                this.machine.print(publishing, publishingNumber, machinePrintingPaperKind, a + 2);

            }
            System.out.println("Machine: " + this.machine+" Successfuly printed " +this.publishing);
            //Тук ще намаля свободните страници на машината;
            this.machine.removePages(publishing.getPublishingPages()*publishingNumber);
        }catch (MachinesPaperDeficites e){
            System.err.println(e);

        }catch (InterruptedException e){
            System.err.println(e);
        }
        this.machine.setAvailable(true);
        System.out.println("Machine: " + this.machine + "READY TO USE");

    }
}
