package com.company;

import java.io.Serializable;

public class Song implements Serializable {
    private String name;
    private Category category;
    private double duration;

    public Song(String name, Category category, double duration) {
        this.name = name;
        this.category = category;
        this.duration = duration;
    }

    public void addSongTitle(String add){
        this.name+=add;
    }

    public Category getCategory(){
        return this.category;
    }

    public String getName(){
        return this.name;

    }



    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", duration=" + duration +
                '}';
    }
}