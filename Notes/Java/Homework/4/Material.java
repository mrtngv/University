package com.company;

public class Material implements IsFragile {
    private String name;
    private boolean isFragile;

    public Material(String name,boolean isFragile){
        this.name = name;
        this.isFragile = isFragile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public boolean getIsFragile() {
        return isFragile;
    }

    @Override
    public String toString() {
        return this.name + " ";
    }
}