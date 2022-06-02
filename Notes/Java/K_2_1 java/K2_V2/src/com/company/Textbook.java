package com.company;

public class Textbook {

    private String name;
    private String text;
    private String isbn;

    public Textbook() {
    }

    public Textbook(String name, String text, String isbn) {
        this.name = name;
        this.text = text;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIsbn() {
        return isbn;
    }

    // Task 1
    public void setIsbn(String isbn) throws IllegalISBN {
        if(isbn.length()!=10)
            throw new IllegalISBN("Illegal ISBN must contains exactly 10 symbols");
        else
            this.isbn = isbn;

    }

    // Task 3
    public int maxContaingWordLength(String str) {
        String[] entries = this.text.trim().split("\\s+");
        int max = 0;
        for(int i=0;i<entries.length;i++){
            if(entries[i].contains(str) && entries[i].length()>max)
                max = entries[i].length();
        }
        return max;
    }

    @Override
    public String toString() {
        return "TextBook{" + "name=" + name + ", text=" + text + ", isbn=" + isbn + '}';
    }

}