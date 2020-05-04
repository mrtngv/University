package com.company;

public class DigitalResource {
    private static int totalDigitalResources = 0;
    private int ID;
    private Subject subject;
    private double time;

    public DigitalResource(Subject subject,double time){
        this.totalDigitalResources++;
        this.ID = totalDigitalResources;
        this.subject = subject;
        this.time = time;
    }

    protected DigitalResource(Subject subject,double time,int ID){

        this.ID = ID;
        this.subject = subject;
        this.time = time;
    }

    public double totalTime(){
        return this.time + this.subject.getAdditionalTime();
    }

    public Subject getSubject(){
        return this.subject;
    }


    public boolean ifMathematics(){
        if(this.subject == Subject.MATHEMATICS)
            return true;
        else
            return false;
    }

    public DigitalResource slowerDigitalResource(DigitalResource d2){
        if(this.totalTime()>=d2.totalTime())
            return this;
        else
            return d2;
    }

    @Override
    public String toString() {
        return "DigitalResource{" +
                "ID=" + ID +
                ", subject=" + subject +
                ", time=" + time +
                '}';
    }
}
