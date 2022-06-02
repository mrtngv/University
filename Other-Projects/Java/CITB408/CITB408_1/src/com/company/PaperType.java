package com.company;

public enum PaperType {
    USUAL(0.2),GLOSSY(0.5),DOTTED(1.0);
    private double price;
    private PaperType(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        if(price<=0)
            this.price = 0;
        else
            this.price = price;
    }
}
