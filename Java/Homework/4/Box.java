package com.company;

public class Box {
    private double  d1;
    private double  d2;
    private double  d3;

    public Box(double d1,double d2,double d3){
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public double detVolume(){
        return d1*d2*d3;
    }

    @Override
    public String toString() {
        return "Box{" +
                "d1=" + d1 +
                ", d2=" + d2 +
                ", d3=" + d3 +
                '}';
    }
}