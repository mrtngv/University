package com.company;

public enum BottleType {
    GLASS(1),PLASTIC(0.5);
    private double price;

    private BottleType(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }
}
