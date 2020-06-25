package com.company;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kostadinova
 */
public class PublishingOrder {

    private int orderNumber;
    private Textbook textbook;
    private int textbooksQuantity;

    public PublishingOrder(int orderNumber, Textbook textbook, int textbooksQuantity) {
        this.orderNumber = orderNumber;
        this.textbook = textbook;
        this.textbooksQuantity = textbooksQuantity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
    }

    public int getTextbooksQuantity() {
        return textbooksQuantity;
    }

    public void setTextbooksQuantity(int textbooksQuantity) {
        this.textbooksQuantity = textbooksQuantity;
    }

    @Override
    public String toString() {
        return "Order{" + "orderNumber=" + orderNumber + ", textbook=" + textbook + ", textbooksQuantity=" + textbooksQuantity + '}';
    }

}