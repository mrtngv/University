package com.company;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kostadinova
 */
public class Publisher {

    private String name;
    private List<PublishingOrder> orders;

    public Publisher() {
        orders = new ArrayList();
    }

    public Publisher(String name) {
        this.name = name;
        orders = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void addOrder(PublishingOrder order) {
        this.orders.add(order);
    }

    // Task 2

    public void writeOrderstoFile(String filename) {
        try(FileWriter fw = new FileWriter(filename,false)){ // Да презаписва , защото иначе трябва да пази индексите,които е записал и да ги прескочи
            for(int i=0;i<orders.size();i++)
                fw.append(orders.get(i).toString()+";");
        }catch (IOException ex){
            System.err.println("IO Exception accured");
        }
    }

    // Task 4
    public void startPublishing() {
        for(int i =0;i<orders.size();i++){
            new Publishing_Thread(orders.get(i));
        }

    }

    @Override
    public String toString() {
        return "Publisher{" + "name=" + name + ", orders=" + orders + '}';
    }
}

class Publishing_Thread implements Runnable{
    Thread p_thread;
    PublishingOrder p_order;

    Publishing_Thread(PublishingOrder p_order){
        this.p_order= p_order;
        p_thread = new Thread(this);
        p_thread.start();
    }

    @Override
    public void run() {
        System.out.println(this.p_order.toString());
    }
}