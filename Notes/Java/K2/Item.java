package com.company;

public class Item {
    private int inventaryNumber;
    private static int numberOfItems =0;
    private String name;
    private double basePrice;
    private AgeGroup ageGroup;

    public Item(String name,double basePrice,AgeGroup ageGroup){
        this.numberOfItems++;
        this.inventaryNumber = this.numberOfItems;
        this.name = name;
        this.basePrice = basePrice;
        this.ageGroup = ageGroup;

    }

    public double totalPrice(){
        return this.basePrice+this.ageGroup.getPriceAge();
    }

    public AgeGroup getAgeGroup(){
        return this.ageGroup;
    }

    public boolean childrenOk(){
        if(this.ageGroup == AgeGroup.CHILDREN)
            return true;
        else
            return false;
    }

    public boolean isMoreExpensive(Item i){
        if(this.totalPrice()>i.totalPrice())
            return true;
        else
            return false;
    }


    @Override
    public String toString() {
        return "Item{" +
                "inventaryNumber=" + inventaryNumber +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", ageGroup=" + ageGroup +
                '}';
    }
}
