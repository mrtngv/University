package com.company;

import java.io.*;
import java.util.Arrays;

public class BottleCompany implements Serializable {
    // 0 - plastic
    // 1 - glass
    private static int sellsmade = 0;
    private int[] freeBottlesQuontity;
    private int[] bottlesReady;


    public BottleCompany(){
        freeBottlesQuontity = new int[2];
        bottlesReady = new int[2];

        freeBottlesQuontity[0] = 0;
        freeBottlesQuontity[1] = 0;
    }

    public BottleCompany(int plasticBottlesQuontity,int glassBottlesQuontity){
        freeBottlesQuontity = new int[2];
        bottlesReady = new int[2];

        freeBottlesQuontity[0] = plasticBottlesQuontity;
        freeBottlesQuontity[1] = glassBottlesQuontity;
    }

    public void Butilirane(BottleType bottleType,int quontity) throws InsufficientNumberOfBottelsException,NumberFormatException{
        if(quontity<=0)
            throw new NumberFormatException("Can't make 0 or negative quontity bottles");
        int bottleTypeDigit;
        if(bottleType==BottleType.PLASTIC)
            bottleTypeDigit = 0;
        else
            bottleTypeDigit = 1;

        if(freeBottlesQuontity[bottleTypeDigit]>=quontity){
            freeBottlesQuontity[bottleTypeDigit]-=quontity;
            bottlesReady[bottleTypeDigit]+=quontity;
        }   else
                throw new InsufficientNumberOfBottelsException("Not enough free Bottles of " + bottleType.toString());
    }

    public void printAllFakturi(){
        try(FileReader fr = new FileReader("fakturi.txt");){
            int c;

            while((c=fr.read())!=-1)
                System.out.print((char)c);

        }catch (FileNotFoundException ex){
            System.err.println(ex.toString());
        }catch (IOException ex){
            System.err.println(ex.toString());
        }
    }

    public void makeFreeBottles(BottleType bottleType,int quontity) throws NumberFormatException{
        int bottleTypedigit;
        if(bottleType==BottleType.PLASTIC)
            bottleTypedigit = 0;
        else
            bottleTypedigit =1;
        if(quontity>0)
            freeBottlesQuontity[bottleTypedigit] +=quontity;
        else throw new NumberFormatException("Negative Bottle Quontity");
    }

    public void sell(Driver driver,String address,String date,int p,int g) throws NumberFormatException,InsufficientNumberOfBottelsException{
        if(p<0||g<0)
            throw new NumberFormatException("Negative bottles");
        if(bottlesReady[0]<p||bottlesReady[1]<g)
            throw new InsufficientNumberOfBottelsException("Not enough ready bottles");

        try(FileWriter fw = new FileWriter("fakturi.txt",true)){
            fw.append(faktura(driver,address,date,p,g) + System.lineSeparator());
            bottlesReady[0]-=p;
            bottlesReady[1]-=g;
        }catch (IOException e){
            System.err.println("Error accured while writing");
        }
    }

    @Override
    public String toString() {
        return "BottleCompany{" +
                "freeBottlesQuontity=" + Arrays.toString(freeBottlesQuontity) +
                ", bottlesReady=" + Arrays.toString(bottlesReady) +
                '}';
    }

    public String faktura(Driver driver,String address,String date,int p,int g){
        sellsmade++;

        String[] entry = new String[9];
        double sum = p*BottleType.PLASTIC.getPrice() + g*BottleType.GLASS.getPrice();
        entry[0] = String.valueOf(sellsmade);
        entry[1] = driver.toString();
        entry[2] = address;
        entry[3] = date;
        entry[4] = String.valueOf(p);
        entry[5] = String.valueOf(BottleType.PLASTIC.getPrice());
        entry[6] = String.valueOf(g);
        entry[7] = String.valueOf(BottleType.GLASS.getPrice());
        entry[8] = String.valueOf(sum);
        return  String.join(", ",entry);
    }

    public void serialiaze(){
        String filePath = "bottleCompany.ser";
        try(FileOutputStream fos = new FileOutputStream(filePath);ObjectOutputStream outputStream = new ObjectOutputStream(fos);){

            outputStream.writeObject(this);

        }catch (IOException ex){
            System.err.println(ex.toString());
        }

    }

    public BottleCompany deserialiaze(){
        String filePaht = "bottleCompany.ser";
        BottleCompany bottleCompany = this;
        try(FileInputStream fis = new FileInputStream(filePaht);ObjectInputStream inputStream = new ObjectInputStream(fis);){
            bottleCompany = (BottleCompany)inputStream.readObject();
        }catch (ClassNotFoundException ex){
            System.err.println(ex.toString());
        }
        catch (IOException ex){
            System.err.println(ex.toString());
        }

        return  bottleCompany;
    }
}

