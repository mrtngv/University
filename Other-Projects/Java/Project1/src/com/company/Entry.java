package com.company;

public class Entry {
    private double cost_whenSell;
    private String title;
    private EntryType entryType;
    private paperSize paperSize;
    private int entryPageNumber;

    public Entry(String title,EntryType entryType,paperSize paperSize,int entryPageNumber){
        this.title = title;
        this.entryType = entryType;
        this.paperSize = paperSize;
        this.entryPageNumber = entryPageNumber;
        this.cost_whenSell = cost_whenSell;
    }

    public void setCost_whenSell(double cost_whenSell) {
        this.cost_whenSell = cost_whenSell;
    }

    public String getTitle(){
        return  this.title;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public paperSize getPaperSize() {
        return paperSize;
    }

    public int getEntryPageNumber() {
        return entryPageNumber;
    }

    public double getCost_whenSell() {
        return cost_whenSell;
    }

    @Override
    public String toString() {
        return title + "["+entryPageNumber+"](pages)";
    }
}
