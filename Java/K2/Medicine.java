package com.company;

public class Medicine extends Item {
    private static double percent = 0;
    private boolean isLessExpensive;

    public Medicine(String name,double basePrice,AgeGroup ageGroup,boolean isLessExpensive){
        super(name,basePrice,ageGroup);
        this.isLessExpensive = isLessExpensive;
    }

    public double totalPrice(){
        double totalPrice = super.totalPrice();
        if(this.isLessExpensive){
            totalPrice = totalPrice - totalPrice*percent/100;
            if(totalPrice<0)
                totalPrice = 0;

        }
        return totalPrice;
    }

    public double getPercent(){
        return this.percent;
    }

    public void setPercent(double percent){
        if(percent<0)
            percent = 0;
        else if(percent>100)
            percent = 100;
        else
            this.percent = percent;
    }

    public void addPercent(double percent){
        if(percent>0){
            this.setPercent(this.percent+percent);

        }
    }

    public Medicine lessPrice(Medicine medicine){
        if(this.totalPrice()>=medicine.totalPrice())
            return  medicine;
        else
            return this;
    }

    @Override
    public String toString() {
        return super.toString() + "Medicine{" +
                "isLessExpensive=" + isLessExpensive +
                '}';
    }
}

