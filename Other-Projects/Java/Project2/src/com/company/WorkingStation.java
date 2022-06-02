package com.company;

import java.util.List;

public class WorkingStation implements Runnable{
    Thread thread;
    private Store store;
    private Receipt receipt;

    WorkingStation(Worker worker,Sale salesToBeMade,Store s){
        this.store = s;
        receipt = new Receipt(worker,salesToBeMade);
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run(){
            try {
                receipt.makeTheSale(store.getGoods(), store.getGoodQuantity_byIndex());
                Thread.sleep(5000);

            } catch (NotEnoughGoodsQuantityInStoreException e) {
                System.err.println(e);
            } catch (InterruptedException e){
                System.err.println(e);
            }

    }

}
