package com.company;

import java.util.List;
import java.util.ArrayList;

public abstract class Item implements IsFragile{
    private Box box;
    private double totalPrice_withoutshipping;
    private double cenaKilogram;
    private List<Element> elements;

    public Item(Box b,double cena,double cenaKilogram,Element ...e){
        this.box = b;
        this.totalPrice_withoutshipping = cena;
        this.cenaKilogram = cenaKilogram;
        elements = new ArrayList();
        for(Element element:e)
            this.elements.add(element);

    }

    public List<Element> getElements(){
        return this.elements;
    }
    public double getCenaKilogram(){
        return this.cenaKilogram;
    }

    public Box getBox(){
        return  this.box;
    }

    public abstract double shippingPrice();
    public abstract double shipmentPrice();

    public void printElements() {
            System.out.print("Elements: " + elements);
    }

    public void addElement(Element e){
        this.elements.add(e);
    }

    public double totalWeight(){
        double totalweight = 0;
        for(Element element:this.elements) {
            totalweight+=element.getWeight();

        }
        return totalweight;
    }

    public double getTotalPrice_withoutshipping() {
        return totalPrice_withoutshipping;
    }

    @Override
    public boolean getIsFragile() {

        for(Element element:this.elements) {
            if (element.getIsFragile() == true)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Item{" +
                "box=" + box +
                ", cenaKilogram=" + cenaKilogram +
                ", elements=" + elements +
                '}';
    }
}

