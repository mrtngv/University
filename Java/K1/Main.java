package com.company;

public class Main {

    public static void main(String[] args) {
        //Subject Съм задал примерни стойности 2 , 3 и 4 , тъй като времето зависи от предмета по условие;



        MinistryOfEducation m = new MinistryOfEducation();
	    DigitalResource d1 = new DigitalResource(Subject.MATHEMATICS,20);
        VideoClass v1 = new VideoClass(Subject.BIOLOGY,30);
        DigitalResource d2 = new DigitalResource(Subject.GEOGRAPHY,10);
        VideoClass v2 = new VideoClass(Subject.MATHEMATICS,40);
        VideoClass v3 = new VideoClass(Subject.MATHEMATICS,50);
        DigitalResource d3 = new DigitalResource(Subject.MATHEMATICS,60);

        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(d3.toString());
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());

        System.out.println();
        System.out.println(d1.totalTime()); // 20 + 2
        System.out.println(d1.ifMathematics()); // да математика е
        d3 = d3.slowerDigitalResource(d2); // връща себе си , защото е по бавен;
        System.out.println(d3);

        System.out.println();
        System.out.println(v1.totalTime()); // 30 + 3
        v1.increasePercent(50); // + 50% става 49,5
        System.out.println(v1.totalTime());
        System.out.println(v2.thisFaster(v3)); // да по бърз е
        System.out.println();

        m.addDigitalResource(d1);
        m.addDigitalResource(v3);
        m.addDigitalResource(v2);
        m.addDigitalResource(v1);
        m.addDigitalResource(v1);// за теста добавям няколко пъти един и същи обект, но той няма да бъде добавен повече от 1 път в списъка така че съм чил.
        m.addDigitalResource(v1);
        m.addDigitalResource(v1);
        m.printAll(); // ето доказателството
        System.out.println(m.getTotalTime());
        System.out.println(m.getTotalTime(Subject.MATHEMATICS));


    }
}
