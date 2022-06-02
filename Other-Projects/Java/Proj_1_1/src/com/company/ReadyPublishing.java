package com.company;

public class ReadyPublishing {
    private Publishing p;
    private int numberOfPublishings;

    public ReadyPublishing(Publishing p,int numberOfPublishings){
        this.p = p;
        this.numberOfPublishings = numberOfPublishings;
    }

    public boolean isEqual(Publishing p){
        if(this.p.getTitle()==p.getTitle()) {
            return true;
        }
        else
            return false;
    }

    public String getTitle(){
        return this.p.getTitle();
    }
    public void addNumber(int numberOfPublishings){
        this.numberOfPublishings+=numberOfPublishings;
    }

    @Override
    public String toString() {
        return "Publishing: " + this.p + " ---> " + this.numberOfPublishings;
    }

    public Publishing getP() {
        return p;
    }


    public int getNumberOfPublishings() {
        return numberOfPublishings;
    }
}
