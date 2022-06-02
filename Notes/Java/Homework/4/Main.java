package com.company;

public class Main {

    public static void main(String[] args) {
    	/*
    		Изменил съм от части условието, понеже смятам ,че Пратката се състои от много артикули
    		както Куриерската компания се състои от много Пратки.
    	 */

		CourierCompany company = new CourierCompany();

		Box box1 = new Box(1,2,3);
		Box box2 = new Box(20,20,20);
		Box box3 = new Box(10,15,10);

		Material m1 = new Material("plastmasa",false);
		Material m2 = new Material("stuklo",true);
		Material m3 = new Material("izkustvena koja",false);
		Material m4 = new Material("estestvena koja",false);

		Element e1 = new Element(m2,10);
		Element e2 = new Element(m1,10);
		Element e3 = new Element(m3,100);
		Element e4 = new Element(m2,1);
		Element e5 = new Element(m4,15);

		Item i1,i2,i3,i4,i5;
		i1 = new Furniture("videnov",box2,1000,2,e3,e2);
		i2 = new Furniture("marti",box1,500,3,e3,e2,e1);
		i3 = new Shoes(true,box1,80,1,e5,e1);
		i4 = new Shoes(false,box1,100,1,e4,e1);
		i5 = new Shoes(false,box1,200,1,e5,e4,e1);

		Shipment s1 = new Shipment("Zona B5");
		Shipment s2 = new Shipment("Mladkost 2 bl.13 ap.55");

		s1.addItem(i1);
		s1.addItem(i2);
		s1.printShipment();

		s2.addItem(i3);
		s2.addItem(i3);
		s2.addItem(i4);
		s2.addItem(i5);
		s2.printShipment();

		company.addShipmnet(s1);
		company.addShipmnet(s2);

		System.out.println(company);


    }
}
