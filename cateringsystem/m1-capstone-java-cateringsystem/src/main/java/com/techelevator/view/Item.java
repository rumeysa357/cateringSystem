package com.techelevator.view;

public class Item {
    private String code;
    private String name;
    private double price;
    private int itemCount=50;
    private String itemType;


    public Item(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }


    public Item() {

    }

    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getItemCount() {

        return itemCount;
    }


    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }


    public boolean isEnoughQuantity() {
        if(this.itemCount >= 1) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        String items=String.format("%-5s %-25s $%-8.2f %-10s %d ",code,name,price,getItemType(),getItemCount());
        return items;

    }


    public String getItemType(){
        String word="";
        if(code.startsWith("A")){
            word="Appetizer";
        }
        if(code.startsWith("B")){
            word="Beverage";
        }
        if(code.startsWith("D")){
            word="Dessert";
        }
        if(code.startsWith("E")){
            word="Entree";
        }
        return word;
    }

}
