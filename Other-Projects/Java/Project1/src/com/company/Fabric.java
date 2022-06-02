package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Fabric {
    private double percentForClients;
    private List<Employee> employees;
    private double target; // Цел приходи към които се стреми хабриката , ако ги надвиши заплатата на мениджърите ще се увеличи с процент
    private double costsOfPaper;
    private double totalEarnings;
    private List<Order> orders;
    private List<Entry> readyEntries;
    private List<Integer> readyEntriesQuantity;


    public Fabric(double percentForClients){
        this.percentForClients = percentForClients;
        employees = new ArrayList<Employee>();
        orders = new ArrayList<Order>();
        readyEntries = new ArrayList<Entry>();
        readyEntriesQuantity = new ArrayList<Integer>();
    }

    public void addOrder(Order order){
        boolean isThereEntry = false;
        for(Order o:orders){
            if(o.getEntry().equals(order.getEntry())){
                isThereEntry = true;
                o.addQuantity(order.getQuantity());
                break;
            }
        }
        if(!isThereEntry){
            orders.add(order);
        }
    }

    public  void printOrders(){
        for(Order a:orders){
            System.out.println(a);
        }
    }
    public double income(){
        return 1;
    }

    public double getTotalEarnings(){
        return totalEarnings;
    }

    public void setPercent(double percent){
        if(percent<=0||percent>100)
            System.err.println("Percent was not changed , because of illegal parameter");
        else
            minimumSalary.MINIMUM_PERCENT.setMinimum(percent);
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public void hireEmployee(Employee employee){
        if(employees.contains(employee))
            System.err.println("This employee is already hired!\n");
        else
            employees.add(employee);
    }

    public double calculateCosts(){
        double allCosts = this.costsOfPaper;
        if(totalEarnings>=this.target)
        for(Employee e:employees) {
            allCosts += e.calculateSalary();
        }

        return allCosts;
    }

    public void makeSell(Order order){
        if(!orders.contains(order)){
            System.err.println("No SUCH ORDER!");
            return;
        }
        int index = readyEntries.indexOf(order.getEntry());
        if(index==-1){
            System.err.println("Not ready entry!");
        }
        int currentQuantity = readyEntriesQuantity.get(index);
        if(currentQuantity<order.getQuantity()){
            System.err.println("Not enough entries");
            return;
        }

        System.out.println(currentQuantity*readyEntries.get(index).getPaperSize().getPrice()*order.getPaperType().getPrice()*percentForClients/100);

        if(currentQuantity==order.getQuantity()){
            totalEarnings+=currentQuantity*readyEntries.get(index).getCost_whenSell();
            System.out.println("SOLD --> "+ readyEntries.get(index) + " Total quantity: " + readyEntriesQuantity.get(index) + " for " +
                    currentQuantity*readyEntries.get(index).getCost_whenSell() + " No Client percent profit");
        }
        else {
            totalEarnings+=(int)(currentQuantity*readyEntries.get(index).getCost_whenSell() - (readyEntries.get(index).getEntryPageNumber()*currentQuantity*readyEntries.get(index).getPaperSize().getPrice()*order.getPaperType().getPrice()*percentForClients/100) );
            System.out.println("SOLD --> "+ readyEntries.get(index) + " Total quantity: " + readyEntriesQuantity.get(index) + " for " +
                    (int)(currentQuantity*readyEntries.get(index).getCost_whenSell() - (readyEntries.get(index).getEntryPageNumber()*currentQuantity*readyEntries.get(index).getPaperSize().getPrice()*order.getPaperType().getPrice()*percentForClients/100) )
                    + " with profit for the Client % , because ready Entries are more than client's order");
        }

        readyEntries.remove(index);
        readyEntriesQuantity.remove(index);
        orders.remove(orders.indexOf(order));
    }

    private int getIndexSize_paper(paperSize paperSize){
        int index = -1;
        if(paperSize == com.company.paperSize.A1)
            index = 0;
        else if(paperSize == com.company.paperSize.A2)
            index = 1;
        else if(paperSize == com.company.paperSize.A3)
            index = 2;
        else if(paperSize == com.company.paperSize.A4)
            index = 3;
        else if(paperSize == com.company.paperSize.A5)
            index = 4;

        return index;
    }

    private int getIndexType_paper(paperType paperType){
        int index = -1;
        if(paperType == com.company.paperType.NORMAL)
            index = 0;
        else if(paperType == com.company.paperType.GLANZ)
            index = 1;
        else if(paperType == com.company.paperType.NEWSPAPER)
            index = 2;

        return index;
    }

    public void printReadyEntries(){
        for(Entry e:readyEntries){
            System.out.println(e + " - > " + readyEntriesQuantity.get(readyEntries.indexOf(e)));
        }
    }

    public int checkReadyEntriesIndex(Entry e){
        return readyEntries.indexOf(e);
    }
    public void addToReadyEntries(Entry e){
        readyEntries.add(e);
    }
    public void addToReadyEntriesQuantity(int i){
        readyEntriesQuantity.add(i);
    }

    public void addQuantityToExistingEntry(int index,int addable){
        int newValue = readyEntriesQuantity.get(index) + addable;
        readyEntriesQuantity.set(index,newValue);
    }
    public void subQuantityToExistingEntry(int index,int addable){
        int newValue = readyEntriesQuantity.get(index) - addable;
        readyEntriesQuantity.set(index,newValue);
    }



    public void print(PrintingMachine printingMachine,Entry entry,paperType paperType,int quantity){
        entry.setCost_whenSell(entry.getEntryPageNumber()*entry.getPaperSize().getPrice()*paperType.getPrice() + ((entry.getEntryPageNumber()*entry.getPaperSize().getPrice()*paperType.getPrice()*3)/10));
        PrintingProccess cnt = new PrintingProccess(printingMachine,entry,quantity,this);
        if(printingMachine.isJobSuccess()){
            printingMachine.setJobSuccess(false);
            costsOfPaper+=quantity*paperType.getPrice()*entry.getEntryPageNumber()*entry.getPaperSize().getPrice();
            if(readyEntries.contains(entry)){

            }
            else {
                readyEntries.add(entry);
                readyEntriesQuantity.add(quantity);
            }
        }
    }

    public void toFile(){
        try(FileWriter f = new FileWriter("Fabric.txt",false)){
            f.write(this.toString());
        }catch (IOException e){
            System.err.println("IO EXCEPTION ACCURED");
        }
    }

    public void readFromFile(){
        try(FileReader r =new FileReader("Fabric.txt")){
            int c;
            while((c=r.read())!=-1)
                System.out.print((char) c);
        }catch (IOException e){
            System.err.println("IO EXCEPTION ACCURED");
        }
    }

    public void calculateCurrentSell(){}
    @Override
    public String toString() {
        return "Total earnings: ----> " + this.totalEarnings+"\nTotal costs:----> "+(int)this.calculateCosts()
                +"\nReady entries are: "+readyEntries +"\nActive orders are: "+ orders;
    }
}
