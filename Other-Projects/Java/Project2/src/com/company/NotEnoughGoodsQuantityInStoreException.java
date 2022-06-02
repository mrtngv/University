package com.company;

public class NotEnoughGoodsQuantityInStoreException extends Exception {

    public NotEnoughGoodsQuantityInStoreException(String error){
        super(error);
    }
}
