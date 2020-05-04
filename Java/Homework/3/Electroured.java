package com.company;

public class Electroured {
    private String name;
    private Proizvoditel proizvoditel;
    private double price;
    private double bazovaGaranciq;

    public Electroured(String name,Proizvoditel p,double price,double garanciq){
        //Няма да правя проверки за валидация на кода , тъй като не е удачно да се правят без да хвърляме изключения
        this.name = name;
        this.proizvoditel = p;
        this.price = price;
        this.bazovaGaranciq = garanciq;

    }

    public double calcAllGaranciq() {
        double allGaranciq = this.bazovaGaranciq;
        if(proizvoditel.getIsExtended())
            allGaranciq+=12;
        return allGaranciq;
    }
    public Proizvoditel getProizvoditel(){
        return this.proizvoditel;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return price;
    }

    public double getGaranciq(){
        return this.bazovaGaranciq;
    }

    protected void extendGaranciq(double garanciq){
        this.bazovaGaranciq+=garanciq;
    }

    @Override
    public String toString() {
        return this.name +
                proizvoditel.toString()+
                " Na cena: " + price +
                " obshta garanciq: " + calcAllGaranciq();

    }
}
