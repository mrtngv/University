package com.company;

import java.util.List;
import java.util.ArrayList;
public class Pharmacy {
    private List<Item> solditemList;

    public Pharmacy(){
        solditemList = new ArrayList<Item>();
    }

    public void addItem(Item i){
        //Не правя проверка с contains , защото за тази функция няма смисл , може да имаме няколко артикула от 1 обект защото може да са повече от 1 количество.
            solditemList.add(i);


    }

    public double incomes(){
        double income = 0;
        for(Item i :solditemList){
            income+=i.totalPrice();
        }
        return income;
    }

    public double incomeByAge(AgeGroup ageGroup){
        double income = 0;
        for(Item i :solditemList){
            if(i.getAgeGroup() == ageGroup)
                income+=i.totalPrice();
        }
        return income;

    }

}
