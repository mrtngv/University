package com.company;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Receipt {
    private static int numberofReceipts;
    private int receiptID;
    private boolean isReceiptSuccess = false;
    private Worker worker;
    private Sale sale;
    private double totalReceiptCost;

    public Receipt(Worker worker,Sale s){
        this.worker = worker;
        this.sale = s;
    }

    public void makeTheSale(List<Goods> allInStore,List<Integer> goodQuantity_byIndex) throws NotEnoughGoodsQuantityInStoreException{
        boolean yes = true;
        int i;
        int index = 0;
        for(i=0;i< sale.getSaleGoods().size();i++) {
             index = allInStore.indexOf(sale.getSaleGoods().get(i));
            if (!(index >= 0)) {
                yes = false;
                break;
            }

            if (!(goodQuantity_byIndex.get(index) >= sale.getQuantityBYINDEX(i))) {
                yes = false;
                break;
            }
        }

        if(yes) {
            sale.setSuccessfulSale(true);
            printReceipt();
        }
        else {
            throw new NotEnoughGoodsQuantityInStoreException("Not enough quantity of "+sale.getSaleGoods().get(i)+" ! Must be + " + (sale.getQuantityBYINDEX(i)-goodQuantity_byIndex.get(index)));
        }

    }

    public void printReceipt(){
        numberofReceipts++;
        receiptID = numberofReceipts;
        double price = 0;
        for(int i =0;i<sale.getSaleGoods().size();i++){
            price+= sale.getQuantityBYINDEX(i)*sale.getPriceBYINDEX(i);
        }
        totalReceiptCost = price;
        sale.setCost(totalReceiptCost);
        System.out.println(worker + " made sell right now in total price for the receipt --> "+ totalReceiptCost);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        String text = "";
        text+="Receipt Number: " + String.valueOf(receiptID) +"\n";
        text+=worker+"\n";
        text+=date+"\n";
        text+="\n###########################################\n\n";
        for(int i =0;i<sale.getSaleGoods().size();i++){
            text+=sale.getSaleGoods().get(i);
            text+="\n"+String.valueOf(sale.getQuantityBYINDEX(i)) + " X " + String.valueOf(sale.getPriceBYINDEX(i)) + " = " + String.valueOf(sale.getQuantityBYINDEX(i)*sale.getPriceBYINDEX(i));
            text+="\n-------------------------------------------\n";
        }
        text+="                         Total Price: " + String.valueOf(price);


        String file = String.valueOf(receiptID) + ".txt";
        try(FileWriter fw = new FileWriter(file,false);){
            fw.write(text);
        }catch (IOException e){
            System.err.println("Couldn't write "+ file);
        }

    }

}
