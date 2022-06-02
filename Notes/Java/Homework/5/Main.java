package com.company;

public class Main {

    public static void main(String[] args) {
    	/* Задача 1 - Тест
	Triangle t1 = new Triangle(3,4,5);
	System.out.println(t1.getSide1()+" " + t1.getSide2()+" " + t1.getSide3());
	System.out.println(t1.isPrav());
	System.out.println(t1.isTriangle());
	System.out.println(t1.perimeter());
	System.out.println(t1.isHuge());
	Triangle.setHugenumber(11);
	Triangle t2 = new Triangle(3,4,11);
	System.out.println(t2.getSide1()+" " + t2.getSide2()+" " + t2.getSide3());
	System.out.println(t2.isPrav());
	System.out.println(t2.isTriangle());
	System.out.println(t2.perimeter());
	System.out.println(t2.isHuge());
    	 */


    	// Задача 2 - Тест

    	FlowersShop f1 = new FlowersShop(5);
    	FlowersShop f2 = new FlowersShop(3,15);
    	f1.setPrice(2);
    	System.out.println(f1.all());
    	f2 = f2.greater(f1);
		System.out.println(f2.toString());
		System.out.println(f1.toString());
    	f1 = f1.greater(f2);
		System.out.println(f1.toString());
    	f2.decrPrice(100);
    	f2.decrPrice(5);
		System.out.println(f2.toString());

		// От задача 3
		Seller s1 = new Seller("Marti",20);
		f1.setSeller(s1);
		f1.setAllAbove(300);
		f1.incrSal(100);
		System.out.println(s1.toString());
		f1.incrEnt(150);
        f1.incrSal(100);
        System.out.println(s1.toString());



    }
}
