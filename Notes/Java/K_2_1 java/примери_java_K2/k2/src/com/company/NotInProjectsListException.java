package com.company;

public class NotInProjectsListException extends Exception {
    public NotInProjectsListException(String text){
        super(text);
    }
}
