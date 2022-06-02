package com.company;

public enum paperSize {
    A1(0.1),A2(0.2),A3(0.3),A4(0.4),A5(0.5);
    private double price;

    paperSize(double price){
        this.price = price;
    }

    double getPrice(){
        return this.price;
    }

    void setPrice(double price){
        this.price = price;
    }
}
