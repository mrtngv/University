package com.company;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        BottleCompany bottleCompany = new BottleCompany(10,20);
        bottleCompany.makeFreeBottles(BottleType.PLASTIC,6);
        bottleCompany.makeFreeBottles(BottleType.GLASS,5);
        try {
            bottleCompany.Butilirane(BottleType.PLASTIC, 10);
            bottleCompany.Butilirane(BottleType.GLASS, 10);
        }catch (InsufficientNumberOfBottelsException ex){
            System.err.println(ex.toString());
        }catch (NumberFormatException ex){
            System.err.println(ex.toString());
        }

        bottleCompany.serialiaze(); // Записвам текъщото състояние на обект

        //Тук продавам ако мога и записвам данните на фактурата във файл

        try {
            bottleCompany.sell(Driver.GEORGE, "Lulin 5", "10.05.2020", 2, 3);
            bottleCompany.sell(Driver.PETER, "Lulin 6", "11.05.2020", 4, 7);
            bottleCompany.sell(Driver.MARTI, "Lulin 7", "12.05.2020", 4, 0);
            bottleCompany.sell(Driver.MARTI, "Lulin 7", "13.05.2020", 4, 0);//Тук ще хвърли изключени , останалите ще ги е записало
        }catch (InsufficientNumberOfBottelsException e){
            System.err.println(e.toString());
        }catch (NumberFormatException e){
            System.err.println(e.toString());
        }


        //принтирам файла
        bottleCompany.printAllFakturi();

        System.out.println("Текущо състояние на bottleCompany:" + bottleCompany);
        bottleCompany = bottleCompany.deserialiaze();
        System.out.println("Състояние след сериализация: " + bottleCompany);
    }
}
