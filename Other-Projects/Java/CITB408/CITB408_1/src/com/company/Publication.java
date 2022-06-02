package com.company;

public class Publication {
    private PublicationType publicationType;
    private PaperSize paperSize;
    private int numberOfPages;
    private String title;
    private double publicationCost;

    public Publication(String title,PublicationType publicationType,PaperSize paperSize,int numberOfPages,double publicationCost){
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.publicationType = publicationType;
        this.paperSize = paperSize;
        this.publicationCost = publicationCost;
    }

    public PublicationType getPublicationType() {
        return publicationType;
    }

    public PaperSize getPaperSize() {
        return paperSize;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public double getPublicationCost() {
        return publicationCost;
    }

    public boolean isEqual(Publication publication){
        // Тук правя проверка само за името, попринцип трябва за всичко, но за demo-то не е необходимо.
        if(this.title==publication.title)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "publicationType=" + publicationType +
                ", paperSize=" + paperSize +
                ", numberOfPages=" + numberOfPages +
                ", title='" + title + '\'' +
                '}';
    }
}

