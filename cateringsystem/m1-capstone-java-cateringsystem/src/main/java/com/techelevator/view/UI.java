package com.techelevator.view;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;


public class UI {

    // kind of looks like a menu class if you ask me ;-)

    private Scanner scanner;
    private PrintWriter printWriter;
    private Inventory inventory;
    private Item item;


    public UI() {
        scanner = new Scanner(System.in);
    }

    public String printOptionsMenu1() {
        System.out.println("Please choose one of the following options\n");
        System.out.println("(1) Display Catering Items");
        System.out.println("(2) Order");
        System.out.println("(3) Quit");
        String response = scanner.nextLine();


        return response;
    }
    public void cateringSystem() {
        System.out.println("\n****************************************************************");
        System.out.println("--------------------CATERING SYSTEM-----------------------------");
        System.out.println("****************************************************************\n");
    }


    public void printListOfItems(TreeMap<String, Item> itemTreeMap) {
        Set<String> keys=itemTreeMap.keySet();

        for(String key:keys){
            System.out.println(itemTreeMap.get(key));
        }

    }

    public String printOptionsMenu2(double balance){
        DecimalFormat format = new DecimalFormat("#.00");

        System.out.println("\n(1) Add Money");
        System.out.println("(2) Select Products");
        System.out.println("(3) Complete Transaction");
        System.out.println("Current Account Balance: $ "+format.format(balance) );
        String printOptionMenuResponse2=scanner.nextLine();
        return printOptionMenuResponse2;
    }



    public String addMoneyOption(){
        System.out.println("Please add cash $1,$5,$15,$20,$100 are excepted" );
        String userAddMoney=scanner.nextLine();
        return userAddMoney;

    }
   public String selectItemWithCode(){
       System.out.println("Please type the item code");
       String userItemCode=scanner.nextLine();
       return userItemCode;
   }


   public String selectItemQuantity(){
       System.out.println("Please enter the item quantity ");
       String userItemQuantity=scanner.nextLine();
       return userItemQuantity;
   }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    }





