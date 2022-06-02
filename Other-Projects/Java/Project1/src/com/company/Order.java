package com.company;

public class Order {
    private Entry entry;
    private int quantity;
    private paperType paperType;
    private static int totalOrders;
    private int orderID;

    public Order(Entry entry,int quantity,paperType paperType){
        totalOrders++;
        orderID = totalOrders;
        this.entry = entry;
        this.quantity = quantity;
        this.paperType = paperType;
    }

    public Entry getEntry() {
        return entry;
    }

    public void addQuantity(int quantity) {
        this.quantity+= quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public com.company.paperType getPaperType() {
        return paperType;
    }

    public static int getTotalOrders() {
        return totalOrders;
    }

    public int getOrderID() {
        return orderID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "entry=" + entry +
                ", quantity=" + quantity +
                ", paperType=" + paperType +
                ", orderID=" + orderID +
                '}';
    }
}
