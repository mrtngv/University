package com.company;

public class Shoes extends Item {
    private boolean tryThem;

    public Shoes(boolean tryThem, Box b, double totalPrice_withoutshipping, double cenaKilogram, Element... e) {
        super(b, totalPrice_withoutshipping, cenaKilogram, e);
        this.tryThem = tryThem;
    }

    @Override
    public double shippingPrice() {
        double shippingPrice = this.totalWeight() * this.getCenaKilogram();
        if (this.tryThem)
            shippingPrice += shippingPrice * (3 / 100);
        return shippingPrice;
    }

    public double shipmentPrice() {
        return this.getTotalPrice_withoutshipping() + this.shippingPrice();
    }

    @Override
    public String toString() {
        return "Obuvki: opciq za probwane-->"+this.tryThem+" totalWeight: " +
                this.totalWeight() +
                " shipmentPrice: " + this.shipmentPrice() +
                " Volume: " + this.getBox().detVolume() +
                " Elements: " + this.getElements().toString();
    }
}
