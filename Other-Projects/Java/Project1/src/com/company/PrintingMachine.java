package com.company;

public class PrintingMachine {
    private boolean isReady;
    private boolean jobSuccess;
    private int slots;
    private String name;
    private int maximumPages_charge;
    private int charged_withPages;
    private PrintingColor printingColor;
    private int printPages_perMinute;

    public PrintingMachine(String name,int printPages_perMinute,int maximumPages_charge,PrintingColor printingColor,int slots){
        this.name = name;
        this.printPages_perMinute = printPages_perMinute;
        this.maximumPages_charge = maximumPages_charge;
        this.printingColor = printingColor;
        this.charged_withPages = 0;
        this.isReady = true;
        this.jobSuccess = false;
        if(slots<5)
            this.slots = 5;
        else
            this.slots = slots;
    }

    public PrintingColor getPrintingColor() {
        return printingColor;
    }

    public int getPrintPages_perMinute() {
        return printPages_perMinute;
    }

    public int getSlots(){
        return this.slots;
    }

    public double charge(){
        charged_withPages = maximumPages_charge;
        return maximumPages_charge-charged_withPages;
    }

    public int getCharged_withPages(){
        return this.charged_withPages;
    }

    public int getMaximumPages_charge(){
        return this.maximumPages_charge;
    }

    public void print(Entry entry,int quantity,int currentPrintRangeA,int currentPrintRangeB) throws MachineNotEnoughPaperException{
        if(entry.getEntryPageNumber()*quantity>charged_withPages)
            throw new MachineNotEnoughPaperException("Not charged enough. Maximum paper that can fit is" + maximumPages_charge);
        else
            System.out.println(name+" Printing pages --> ["+currentPrintRangeA+" - "+ currentPrintRangeB+"] for --->  " + entry.toString());
    }

    public void setCharged_withPages(int pages){
        this.charged_withPages = pages;
    }
    public String getName(){
        return this.name;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isJobSuccess() {
        return jobSuccess;
    }

    public void setJobSuccess(boolean jobSuccess) {
        this.jobSuccess = jobSuccess;
    }

    @Override
    public String toString() {
        return "PrintingMachine: " + name + " prints per/min: " + printPages_perMinute + " has currently pages: " + charged_withPages + " has capacity: " + maximumPages_charge +  " prints: " + printingColor.toString();
    }
}
