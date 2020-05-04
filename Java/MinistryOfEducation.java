package com.company;
import java.util.List;
import java.util.ArrayList;

public class MinistryOfEducation {
    private List<DigitalResource> digitalResourcesList;

    public MinistryOfEducation(){
        this.digitalResourcesList = new ArrayList<DigitalResource>();
    }

    public void addDigitalResource(DigitalResource d){
        if(digitalResourcesList.contains(d)){

        }
        else
        digitalResourcesList.add(d);
    }

    public double getTotalTime(){
        double totalTime = 0;
        for(DigitalResource d:digitalResourcesList)
            totalTime+=d.totalTime();

        return totalTime;
    }

    public double getTotalTime(Subject subject){
        double totalTime = 0;
        for(DigitalResource d:digitalResourcesList) {
            if(d.getSubject()==subject)
            totalTime += d.totalTime();
        }

        return totalTime;
    }

    public void printAll(){
        for(DigitalResource d:digitalResourcesList) {
           System.out.print(d + "  ");
            System.out.println(d.totalTime());
        }

    }
}
