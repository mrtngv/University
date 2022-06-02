package com.company;

public class Client {
    private String name;
    private double budjet;

    public Client(String name,double budjet){
        if(budjet<0)
            budjet =0;
        this.name = name;
        this.budjet = budjet;
    }

    public String getNmae(){
        return this.name;
    }

    public double getBudjet(){
        return this.budjet;
    }

    public void buy(Electroured e){
        if(e.getPrice()>budjet)
            System.out.println("Not enough money to buy " + e.toString());
        else {
            this.budjet-=e.getPrice();
            System.out.println(
                    name + " just buyed " + e.toString()
            );
        }
    }


    }


