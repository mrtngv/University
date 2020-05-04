package com.company;

public enum Subject {
    MATHEMATICS(2),BIOLOGY(3),GEOGRAPHY(4);
    private int additionalTime;
    private Subject(int additionalTime){
        this.additionalTime = additionalTime;
    }

    public int getAdditionalTime(){
        return this.additionalTime;
    }
}
