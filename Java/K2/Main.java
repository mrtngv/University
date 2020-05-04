package com.company;

public class Main {

    public static void main(String[] args) {
	    Pharmacy pharmacy = new Pharmacy();
	    Item item1 = new Item("Item a",10,AgeGroup.CHILDREN);
        Item item2 = new Item("Item b",20,AgeGroup.ADULTS);
        Item item3 = new Item("Item c",30,AgeGroup.CHILDREN);
        Item item4 = new Item("Item d",40,AgeGroup.TEENAGERS);
        Item item5 = new Item("Item e",50,AgeGroup.CHILDREN);

        Medicine item6 = new Medicine("Item f",60,AgeGroup.CHILDREN,false);
        Medicine item7 = new Medicine("Item g",70,AgeGroup.ADULTS,true);
        Medicine item8 = new Medicine("Item h",80,AgeGroup.CHILDREN,true);
        Medicine item9 = new Medicine("Item i",90,AgeGroup.TEENAGERS,true);

        System.out.println(item1.totalPrice()); // 10 + 1
        System.out.println(item2.childrenOk());
        System.out.println(item3.childrenOk());
        System.out.println(item3.isMoreExpensive(item4)); // 30<40
        System.out.println(item5.isMoreExpensive(item1)); // 50> 10
        System.out.println();


        System.out.println(item6.getPercent()); // в началото процентът е 0
        item6.addPercent(20);
        item6.addPercent(20);
        item6.addPercent(10);
        System.out.println(item7.getPercent()); // процентът е статичен
        System.out.println(item8.totalPrice());// 80 + това че е за деца = 81 , процентът е 50 , така че цената е 40,5
        System.out.println(item8.lessPrice(item9)); // toString метод 80 < 90
        System.out.println();

        pharmacy.addItem(item1);
        pharmacy.addItem(item8);
        pharmacy.addItem(item9);
        pharmacy.addItem(item3);
        System.out.println(pharmacy.incomes());
        System.out.println(pharmacy.incomeByAge(AgeGroup.TEENAGERS)); // 90 + 3 na 50% e 46,5






    }
}
