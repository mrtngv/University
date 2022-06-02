package com.company;

public class Furniture extends Item {
    private String brand;
    private static final double goalVelume = 4000;

    public Furniture(String brand,  Box b, double totalPrice_withoutshipping, double cenaKilogram, Element... e) {
        super(b, totalPrice_withoutshipping, cenaKilogram, e);
        this.brand = brand;

    }

    @Override
    public double shippingPrice() {
        double shippingPrice = this.totalWeight() * this.getCenaKilogram();
        if (this.getBox().detVolume() > this.goalVelume)
            shippingPrice += shippingPrice * (1.5 / 100);
        return shippingPrice;
    }

    public double shipmentPrice() {
        return this.getTotalPrice_withoutshipping() + this.shippingPrice();
    }

    public String getBrand() {
        return this.brand;
    }

    public double getGoalVelume() {
        return this.goalVelume;
    }


    @Override
    public String toString() {
        return this.brand + " totalWeight: " +
                this.totalWeight() +
                " shipmentPrice: " + this.shipmentPrice() +
                " Volume: " + this.getBox().detVolume() +
                " Elements: " + this.getElements().toString();
    }
}