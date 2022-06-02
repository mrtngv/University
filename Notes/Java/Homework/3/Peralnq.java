package com.company;

public class Peralnq extends Electroured{
    private int maxOborots;
    private boolean centrufuga3000;

    public Peralnq(String name,Proizvoditel p,double price,int garanciq,int maxOborots,boolean centrufuga3000){
        super(name,p,price,garanciq);
        this.maxOborots = maxOborots;
        this.centrufuga3000 = centrufuga3000;
    }

    public int getMaxOborots(){
        return maxOborots;
    }
    public boolean getCentruguga3000(){
        return this.centrufuga3000;
    }

    public double calcAllGaranciq(){
        double allGaranciq = this.getGaranciq();
        if(centrufuga3000)
           allGaranciq+=0.5*this.getGaranciq();
        if(this.getProizvoditel().getIsExtended())
            allGaranciq+=12;
        return  allGaranciq;
    }



    @Override
    public String toString() {
        return super.toString() +
                "Maximalni oboroti: " + this.maxOborots +
                " Sushilnq - > " + centrufuga3000;
    }
}
