package com.wellsfargo.batch5.storeapp.model;

public class Category{

    private Integer catId;
    private String catName;
    private Double catGST;

    private Set<Item> items;

    public Category(){

    }

    public Category(Integer catId,String catName,Double catGST){
        this.catId=catId;
        this.catName=catName;
        this.catGST=catGST;
    }

    //setters and getters

    //override hashcode
    //override equals
}