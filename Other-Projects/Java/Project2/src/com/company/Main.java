package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Worker w1 = new Worker("NIKI");
        Worker w2 = new Worker("VICTOR");
        Store store = new Store();

        store.addWorker(w1);
        store.addWorker(w1);
        store.addWorker(w2);

        Goods g1 = new Goods("Beer",5);
        Goods g2 = new Goods("Bread",1.40);
        Goods g3 = new Goods("Cheese",6.80);
        Goods g4 = new Goods("Ketchup",2.50);
        Goods g5 = new Goods("Chocolate",4.50,22);

        store.addGoods(g1);
        store.addGoods(g1);
        store.addGoods(g1,100);
        store.addGoods(g2,500);
        store.addGoods(g3,100);
        store.addGoods(g4,10);
        store.addGoods(g5,20);

        Sale s1 = new Sale();
        s1.addToCar(g1,10);
        s1.addToCar(g1,15);
        s1.addToCar(g2,5);
        s1.addToCar(g3,5);
        s1.addToCar(g4,3);
        s1.addToCar(g5,5);

        Sale s2 = new Sale();
        s2.addToCar(g1,16);
        s2.addToCar(g5,3);

        Sale s3 = new Sale();
        s3.addToCar(g1,13);
        s3.addToCar(g5,2);

        Sale s4 = new Sale();
        s4.addToCar(g1,5);
        s4.addToCar(g5,1);

        Sale s5 = new Sale();
        s5.addToCar(g1,10);
        s5.addToCar(g4,24);

        Sale s6 = new Sale();
        s6.addToCar(g1,5);
        s6.addToCar(g5,1);

        Sale s7 = new Sale();
        s7.addToCar(g1,3);
        s7.addToCar(g5,30);

        store.addSale(s1);
        store.addSale(s2);
        store.addSale(s3);
        store.addSale(s4);
        store.addSale(s5);
        store.addSale(s6);
        store.addSale(s7);

        store.sell();
        while(Thread.activeCount()>2){}

        System.out.println("\nTotal Earnings -- > " + store.getEarnings());
    }
}
