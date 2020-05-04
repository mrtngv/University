package com.company;
import java.util.List;
import java.util.ArrayList;
public class Shipment {
    private String transportLocation;
    private List<Item> items;

    public Shipment(String transportLocation){
        this.transportLocation = transportLocation;
        items = new ArrayList<Item>();
    }

    public void addItem(Item i){
        items.add(i);
    }

    public void listItems(){
        for(Item i:items)
            System.out.println(i.toString());
    }

    public double totalCost(){
        double totalCost = 0;
        for(Item i:items){
            totalCost+=i.shipmentPrice();
        }
        return totalCost;
    }

    public List<Item> getItems(){
        return this.items;
    }

    public void printShipment(){
        System.out.println("Shipment Details:");
        System.out.println("Location: " + this.transportLocation);
        System.out.println("Items: ");
        this.listItems();
        System.out.println("Total cost:\n"+ this.totalCost());
    }


    public double getAllVolume(){
        double allVolume = 0;
        for(Item i:items)
            allVolume+=i.getBox().detVolume();
        return allVolume;
    }

}
