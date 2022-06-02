package com.company;

public class Goods {
    private static int totalGoods = 0;
    private int goodsID;
    private String name;
    private double price;
    private int goodCondition_days = 5;

    Goods(String name, double price){
        totalGoods++;
        goodsID = totalGoods;
        this.name = name;
        this.price = price;
    }

    Goods(String name, double price,int goodCondition_days){
        totalGoods++;
        goodsID = totalGoods;
        this.name = name;
        this.price = price;
        this.goodCondition_days = goodCondition_days;
    }

    public int getTotalGoods(){
        return totalGoods;
    }
    public int getGoodsID(){
        return goodsID;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getGoodCondition_days(){
        return goodCondition_days;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}
