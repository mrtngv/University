package com.company;

public class VideoClass extends DigitalResource {
    private static double percent = 0;
    private static int totalVideoClasses=0;


    public VideoClass(Subject subject,double time){
        super(subject,time,++totalVideoClasses);

    }

    public void setPercent(double percent){
        if(percent<0)
            this.percent = 0;
        else if(percent>100)
            this.percent = 100;
        else
            this.percent = percent;
    }

    public void increasePercent(double plusPercent){
        //ще го направя да може да добавя повече проценти да няма таван 100 % , ми да може да е и 300 %;
        if(plusPercent<0){
            System.out.println("Must be positive percent");
        }
        else{
            this.percent+=plusPercent;
        }
    }

    public double totalTime(){
        return super.totalTime() + (super.totalTime()*this.percent)/100;
    }

    public boolean thisFaster(VideoClass v2){
        if(this.totalTime()<v2.totalTime())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
