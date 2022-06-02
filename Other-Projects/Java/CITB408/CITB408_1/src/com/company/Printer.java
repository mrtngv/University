package com.company;

public class Printer {
    private String name;
    private int maxPageNum;
    private int currentPageNum;
    private boolean colorPrinter;
    private int maxPagesPerMinute;
    private boolean isPrinterReady;
    private boolean isTaskDone;

    public Printer(String name,int maxPageNumber,boolean colorPrinter,int maxPagesPerMinute){
        this.name = name;
        this.maxPageNum = maxPageNumber;
        this.colorPrinter = colorPrinter;
        this.maxPagesPerMinute = maxPagesPerMinute;
        this.currentPageNum = maxPageNum;
        this.isPrinterReady = true;
        this.isTaskDone = false;
    }

    public boolean getIsPrinterReady(){
        return this.isPrinterReady;
    }

    public boolean getIsTaskDone(){
        return  this.isTaskDone;
    }

    public void setPrinterReady(boolean isPrinterReady){
        this.isPrinterReady = isPrinterReady;
    }

    public void setIsTaskDone(boolean isTaskDone){
        this.isTaskDone = isTaskDone;
    }
    public void chargeToMax(){
        this.currentPageNum = this.maxPageNum;
    }

    public int getMaxPageNum(){
        return this.maxPageNum;
    }

    public int getCurrentPageNum(){
        return this.currentPageNum;
    }

    public boolean getColor(){
        return this.colorPrinter;
    }

    public int getMaxPagesPerMinute(){
        return this.getMaxPagesPerMinute();
    }

    public void removePrinterCurrentPage(int pages){
        this.currentPageNum-=pages;
    }

    public void print(Publication publication, int number) throws paperNumberExcepiton{
        if(publication.getNumberOfPages()*number>this.currentPageNum)
            throw new paperNumberExcepiton("Not enough paper. Must be charged!!");
        else
            System.out.println(this.name + " is printing " + publication);
    }

    @Override
    public String toString() {
        return "Printer{" +
                "name='" + name + '\'' +
                ", maxPageNum=" + maxPageNum +
                ", currentPageNum=" + currentPageNum +
                ", colorPrinter=" + colorPrinter +
                ", maxPagesPerMinute=" + maxPagesPerMinute +
                '}';
    }
}
