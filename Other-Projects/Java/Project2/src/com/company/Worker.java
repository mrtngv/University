package com.company;

public class Worker {
    private static int numberofWorkers = 0;
    private int personalID;
    private String name;

    Worker(String name){
        numberofWorkers++;
        personalID = numberofWorkers;
        this.name = name;
    }

    public int getNumberofWorkers(){
        return numberofWorkers;
    }

    public int getPersonalID(){
        return personalID;
    }

    public String getNmae(){
        return name;
    }

    public String toString(){
        return "Worker: " + name + " personal ID " + personalID;
    }


}
