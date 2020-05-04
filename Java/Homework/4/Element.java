package com.company;

public class Element implements IsFragile{
    private Material material;
    private double weight;

    public Element(Material m,double weight){
        this.material =m;
        this.weight = weight;

    }

    @Override
    public boolean getIsFragile() {
        return this.material.getIsFragile();
    }

    public double getWeight(){
        return this.weight;
    }


    @Override
    public String toString() {
        return this.material + " --- " + this.weight + " kg.";
    }
}