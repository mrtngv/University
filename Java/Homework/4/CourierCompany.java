package com.company;
import java.util.List;
import java.util.ArrayList;
public class CourierCompany {
    private List<Shipment> shipments;

    public CourierCompany(){
        shipments = new ArrayList<Shipment>();
    }

    public void addShipmnet(Shipment s){
        shipments.add(s);
    }

    public double totalEarnings(){
        double totalEarnings = 0;
        for(Shipment s:shipments)
            totalEarnings+=s.totalCost();

        return totalEarnings;
    }

    public double totalVolume(){
        double totalVolume = 0;
        for(Shipment s:shipments)
            totalVolume+=s.getAllVolume();

        return totalVolume;
    }

    @Override
    public String toString() {
        return "total Earnings = " + this.totalEarnings() + "\ntotal Volume = " + this.totalVolume();
    }
}
