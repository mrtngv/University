package com.company;

public class Triangle
{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(){}
    public Triangle(double side){this.side1 = this.side2 = this.side3 = side;}
    public Triangle(double side1,double side2,double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1(){
        return this.side1;
    }
    public void setSide1(double side1){
        this.side1 = side1;
    }
    public double getSide2(){
        return this.side2;
    }
    public void setSide2(double side2){
        this.side2 = side2;
    }
    public double getSide3(){
        return this.side3;
    }
    public void setSide3(double side3){
        this.side3 = side3;
    }

    public boolean isTriangle(){
        return  (this.side1 + this.side2 >this.side3) &&
                (this.side1 + this.side3 >this.side2) &&
                (this.side3 + this.side2 >this.side1);
    }

    public double perimeter(){
        return this.side1+this.side2+this.side3;
    }

    public double area(){
        double pp = (this.side1+this.side2+this.side3)/2;
        return Math.sqrt(pp*(pp-this.side1)*(pp-this.side2)*(pp-this.side3));
    }

    public void increaseSides(double incr){
        if(incr<0)
            System.out.println("Invalid incr");
        else {
            this.side1 += incr;
            this.side2 += incr;
            this.side3 += incr;
        }
    }

    public boolean equalSides(){
        return  (this.side1==this.side2) &&
                (this.side3==this.side2);
    }

    public boolean isPrav(){
        return (this.side1*this.side1 == this.side2*this.side2 + this.side3*this.side3) ||
                (this.side2*this.side2 == this.side1*this.side1 + this.side3*this.side3) ||
                (this.side3*this.side3 == this.side2*this.side2 + this.side1*this.side1);
    }

    private static double hugenumber = 240;

    public double getHugenumber(){
        return hugenumber;
    }

    public static void setHugenumber(double hugenumber) {
        Triangle.hugenumber = hugenumber;
    }

    public boolean isHuge(){
        return this.side1+this.side2+this.side3 > hugenumber;
    }
}


