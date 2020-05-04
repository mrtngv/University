package com.company;

public class Main {

    public static void main(String[] args) {
	Proizvoditel p1 = new Proizvoditel("Philips",true);
	Proizvoditel p2 = new Proizvoditel("Daikin",false);
	Electroured e1 = new Electroured("Blender",p1,500,12);
	Electroured e2 = new Electroured("Blender",p2,400,12);
	Pechka pa1 = new Pechka("Pechka model 113",p1,200,12,true);
	Pechka pa2 = new Pechka("Pechka model 213",p2,300,13,true);
	Pechka pa3 = new Pechka("Pechka model 313",p1,400,14,false);
	Pechka pa4 = new Pechka("Pechka model 413",p2,500,15,false);
	Peralnq pq1 = new Peralnq("Peralnq model a10",p1,1000,12,3000,true);
	Peralnq pq2 = new Peralnq("Peralnq model b10",p2,1050,14,4000,false);
	Peralnq pq3 = new Peralnq("Peralnq model c10",p1,1100,16,5000,false);
	Peralnq pq4 = new Peralnq("Peralnq model d10",p2,1500,18,6000,true);

	System.out.println(e1);
	System.out.println(e2);
	System.out.println(pa1);
	System.out.println(pa2);
	System.out.println(pa3);
	System.out.println(pa4);
	System.out.println(pq1);
	System.out.println(pq2);
	System.out.println(pq3);
	System.out.println(pq4);

	Client c1 = new Client("Pesho",500);
	Client c2 = new Client("Martin",3000);

	c1.buy(pa2);
	c1.buy(e1);
	c2.buy(pq4);
	c2.buy(pa3);
	c2.buy(e1);
	c2.buy(e1);
	c2.buy(e1);
	c2.buy(e1);
	c2.buy(e1);
	c2.buy(e1);
	
    }
}
