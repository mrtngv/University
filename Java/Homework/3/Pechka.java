package com.company;

public class Pechka extends Electroured{
    private boolean isGazova;

    public Pechka(String name,Proizvoditel p,double price,int garanciq,boolean isGazova){
        super(name,p,price,garanciq);
        this.isGazova = isGazova;

    }

    public double calcAllGaranciq(){
        double allGaranciq = this.getGaranciq();

        if(this.isGazova)
            allGaranciq+=12;
        if(this.getProizvoditel().getIsExtended())
            allGaranciq+=12;
        return  allGaranciq;

    }
    public String isGazova() {
        if(isGazova)
            return "Gazova";
        else
            return "Elektricheska";
    }

    @Override
    public String toString() {
        return
                super.toString() +
                "Gazova - > " +
                 this.isGazova() +
                '}';
    }
}
