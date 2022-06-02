package com.company;

public enum MachinePrintingPaperKind {
    Casual(0.2), Glanzzing(0.4) , Other(0.8);
    private double costOfPages;
    private MachinePrintingPaperKind(double costOfPages){
        this.costOfPages = costOfPages;
    }

    public double getCostOfMachinePrintingPaperKind(){
        return this.costOfPages;
    }

    public void setCostOfMachinePrintingPaperKind(double costOfPages) {
        this.costOfPages = costOfPages;
    }
}
