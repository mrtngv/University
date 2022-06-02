package com.company;

import java.util.List;
import java.util.ArrayList;
public class Order {
    private List<Publication> publicationList;
    private List<Integer> publicationNumber;

    public Order(){
        publicationList = new ArrayList<Publication>();
        publicationNumber = new ArrayList<Integer>();
    }

    public void printOrder(){
        for(int i=0;i<publicationList.size();i++){
            System.out.println(publicationList.get(i) + " --> " +publicationNumber.get(i));
        }
    }

    public int getIndexOfPublication(Publication publication){
        int index = -1;
        for(int i=0;i<publicationList.size();i++){
            if(publicationList.get(i).isEqual(publication))
                index = i;
        }
        return index;
    }

    public void addOrder(Publication publication, int numberOfPublications){
        int index = getIndexOfPublication(publication);
        if(index==-1){
            publicationList.add(publication);
            publicationNumber.add(numberOfPublications);
        }
        else
            publicationNumber.set(index,(publicationNumber.get(index)+numberOfPublications));
    }

    public int getNumberOfPuplication(int index){
        return publicationNumber.get(index);
    }

    public void deleteOrder(int index){
        publicationNumber.remove(index);
        publicationList.remove(index);
    }

    public String getOrder(){
        String text="";
        for(int i=0;i<publicationList.size();i++){
            text+=publicationList.get(i);
            text+=" ---> ";
            text+=publicationNumber.get(i);
            text+="\n";
        }
        return text;
    }



}
