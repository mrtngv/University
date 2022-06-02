package com.company;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Worker> workers;
    private List<Goods> goods;
    private List<Integer> goodQuantity_byIndex;
    private List<Sale> allSales;
    private int currentlyReceipts;
    private double earnings;

    public Store(){
        allSales = new ArrayList<Sale>();
        workers = new ArrayList<Worker>();
        goods = new ArrayList<Goods>();
        goodQuantity_byIndex = new ArrayList<Integer>();
        currentlyReceipts = 0;
        earnings = 0;
    }
    public void addSale(Sale sale) {
        this.allSales.add(sale);
    }
    public void addWorker(Worker worker){
        if(!this.workers.contains(worker))
            this.workers.add(worker);
        else
            System.err.println(worker + " is Currently working here!");
    }

    public void addGoods(Goods good){
        if(!this.goods.contains(good)) {
            this.goods.add(good);
            this.goodQuantity_byIndex.add(0);
        }
        else
            System.err.println("This item is already in the store. Do you want to add more of it?");
    }

    public void addGoods(Goods good,int quantity){
        if(!this.goods.contains(good)) {
            this.goods.add(good);
            this.goodQuantity_byIndex.add(quantity);
        }
        else
        {
            int index = goods.indexOf(good);
            goodQuantity_byIndex.set(index,(quantity+goodQuantity_byIndex.get(index)));
        }
    }

    public void TEST_seeAllGoods(){
        for(int i=0;i<goods.size();i++)
            System.out.print(goods.get(i)+" --> " + goodQuantity_byIndex.get(i)+"\n");
    }

    public void profit(double earningsFromCurrentDeal){
        earnings+= earningsFromCurrentDeal;
    }

    public double getEarnings(){
        return this.earnings;
    }

    public void addToreceiptQuantity(){
        currentlyReceipts++;
    }

    public void removeQuantityFromStore(Sale sale){
        for(int i =0;i<sale.getSaleGoods().size();i++){
            int index = -1;
            for(int j=0;j<goods.size();j++){
                if(goods.get(j)==sale.getSaleGoods().get(i)){
                    index = j;
                    break;
                }
            }
            if(this.goodQuantity_byIndex.get(index)<=sale.getQuantityBYINDEX(i)){
                this.goodQuantity_byIndex.set(index,0);
            }
            else {
                this.goodQuantity_byIndex.set(index,(this.goodQuantity_byIndex.get(index)-sale.getQuantityBYINDEX(i)));
            }
        }
        this.allSales.remove(allSales.indexOf(sale));
    }

    public int getCurrentlyReceipts(){
        return this.currentlyReceipts;
    }

    public List<Goods> getGoods(){
        return goods;
    }

    public List<Integer> getGoodQuantity_byIndex(){
        return goodQuantity_byIndex;
    }

    public void sell(){
        List<Integer> successfullSels_Indexes = new ArrayList<Integer>();
        if(allSales.size()<=workers.size()){
            for(int i=0;i<allSales.size();i++){
                new WorkingStation(workers.get(i),allSales.get(i),this);

            }
            while(Thread.activeCount()>2){}

        }else {
                for(int i=0;i<allSales.size()/workers.size();i++){
                    for(int j=0;j<workers.size();j++){
                        new WorkingStation(workers.get(j),allSales.get(i*workers.size()+j),this);
                    }
                    while(Thread.activeCount()>2){}
                }
                int lopp = allSales.size()/workers.size();
                for(int i=0;i<allSales.size()%workers.size();i++){
                    new WorkingStation(workers.get(i),allSales.get(lopp*workers.size()+i),this);
                }
            while(Thread.activeCount()>2){}
            // for cikul ot borqt na poruchkite / na rabotnicite i wutre for cikul s nihsktie
            // i sled towa edin for cikul s nishkite ot rezultata na modulno delene mu gornite
            //
        }

        if(Thread.currentThread().getName()!="main") {

            int j = 0;
            int max = allSales.size();

            for (int i = 0; i < max; i++)
                earnings += allSales.get(i).getCost();


            for (int i = 0; i < max; i++) {
                if (allSales.get(j).isSuccessfulSale())
                    removeQuantityFromStore(allSales.get(j));
                else
                    j++;
            }
        }


        }


    }

