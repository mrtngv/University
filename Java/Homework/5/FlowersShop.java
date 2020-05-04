package com.company;

public class FlowersShop {
    private double price;
    private int ent;

    public FlowersShop(){}
    public FlowersShop(int ent){
        this.ent = ent;
    }
    public FlowersShop(double price){
        this.price = price;
    }
    public FlowersShop(int ent,double price){
        this.ent = ent;
        this.price = price;
    }

    public void setEnt(int ent) {
        this.ent = ent;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getEnt() {
        return ent;
    }

    public String toString(){
        return "There are " + ent + " flowers at: " + price + " each.";
    }

    public void incrEnt(int ent){
        if(ent<0)
            System.out.println("Error");
        else{
            this.ent+=ent;
        }
    }

    public void decrrEnt(int ent){
        if(ent<0)
            System.out.println("Error");
        else{
            this.ent-=ent;
        }
    }

    public void incrPrice(double price){
        if(price<0)
            System.out.println("Error");
        else{
            this.price+=price;
        }
    }

    public void decrPrice(double price){
        if(ent<0 || this.price-price <0)
            System.out.println("Error");
        else{
            this.price-=price;
        }
    }

    public double all(){
        return this.price*this.ent;
    }

    public void ifGreater(FlowersShop f2){
        if(this.all()<f2.all())
            System.out.println("It is not greater");
        else
            System.out.println("It is greater");
    }

    public FlowersShop greater(FlowersShop f2){
        if(this.all()<f2.all())
            return f2;
        return this;
    }

    private Seller seller;
    private double allAbove;

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setAllAbove(double allAbove) {
        this.allAbove = allAbove;
    }

    public Seller getSeller() {
        return seller;
    }

    public double getAllAbove() {
        return allAbove;
    }

    public void incrSal(double amount){
        if(amount<0)System.out.println("Amount must be positive!!!!");
        else {
            if (this.all() > allAbove)
            {
                seller.setSalary(seller.getSalary()+amount);
            }
        }
    }
}


