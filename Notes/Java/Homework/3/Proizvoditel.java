package com.company;

public class Proizvoditel {

    private String name;
    private boolean isExtended;

    public Proizvoditel(String name,boolean isExtended){
        this.name = name;
        this.isExtended = isExtended;
    }

    public String getName(){
        return this.name;
    }

    public boolean getIsExtended(){
        return this.isExtended;
    }

    @Override
    public String toString() {
        return " Proizvoditel: " + name;
    }
}
