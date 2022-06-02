package com.company;

public enum paperType {

        NORMAL(1.0),GLANZ(2.0),NEWSPAPER(0.5);
        private double price;

        paperType(double price){
            this.price = price;
        }

       public double getPrice(){
            return  this.price;
        }

        public void setPrice(double price){
            this.price = price;
        }
}
