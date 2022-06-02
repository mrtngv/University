package com.company;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private double cost;
    private List<Goods> goods;
    private List<Integer> goodQuantity_byIndex;
    private boolean successfulSale = false;

    public Sale(){
        goods = new ArrayList<Goods>();
        goodQuantity_byIndex = new ArrayList<Integer>();
        cost = 0;
    }

    public void addToCar(Goods good,int quantity){
        if(!this.goods.contains(good)) {
            this.goods.add(good);
            this.goodQuantity_byIndex.add(quantity);
        }
        else
        {
            int index = goods.indexOf(good);
            goodQuantity_byIndex.set(index,(quantity+goodQuantity_byIndex.get(index)));
        }
    }

    public void setSuccessfulSale(boolean successfulSale) {
        this.successfulSale = successfulSale;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isSuccessfulSale() {
        return successfulSale;
    }

    public List getSaleGoods(){
        return this.goods;
    }
    public List getSaleGoodsQuantity(){
        return this.goodQuantity_byIndex;
    }
    public int getQuantityBYINDEX(int i){
        return goodQuantity_byIndex.get(i);
    }
    public double getPriceBYINDEX(int i){
        return goods.get(i).getPrice();
    }


}
