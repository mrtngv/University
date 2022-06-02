package com.company;


public enum PaperSize {
    A1(0.2),A2(0.4),A3(0.5),A4(0.8),A5(1.0);

    private double price;
    private PaperSize(double price){
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
