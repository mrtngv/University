package com.company;

public class Publishing {
    private String title;
    private PublishingFormat publishingFormat;
    private int publishingPages;
    private double cost;
    private pageSize pageSize;

    public Publishing(String title,int publishingPages,double cost,pageSize pageSize,PublishingFormat publishingFormat){
        this.title = title;
        this.publishingPages = publishingPages;
        this.cost = cost;
        this.pageSize = pageSize;
        this.publishingFormat = publishingFormat;
    }

    public String getTitle(){
        return this.title;
    }

    public double getCost() {
        return cost;
    }

    public int getPublishingPages() {
        return publishingPages;
    }

    public pageSize getPageSize(){
        return this.pageSize;
    }

    @Override
    public String toString() {
        return "Publishing{" +
                "title='" + title + '\'' +
                ", publishingFormat=" + publishingFormat +
                ", publishingPages=" + publishingPages +
                ", cost=" + cost +
                ", pageSize=" + pageSize +
                '}';
    }
}