package com.company;

public enum AgeGroup {
    ADULTS(5),TEENAGERS(3),CHILDREN(1);
    private double priceAge;
    private AgeGroup(double priceAge){
        this.priceAge = priceAge;
    }

    public double getPriceAge(){
        return this.priceAge;
    }

    public void setPriceAge(double priceAge){
        if(priceAge>0)
            this.priceAge = priceAge;
    }
}
