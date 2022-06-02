package com.company;

public enum pageSize {
    A5(0.4),A4(0.4),A3(0.2),A2(0.2),A1(0.2);
    private double costOfPages;
    private pageSize(double costOfPages){
        this.costOfPages = costOfPages;
    }

    public double getCostOfPages(){
        return this.costOfPages;
    }

    public void setCostOfPages(double costOfPages) {
        this.costOfPages = costOfPages;
    }
}
