package com.techelevator.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CashRegister {
    private double balance=0;
    List<String > listbalance=new ArrayList<>();
    UI ui=new UI();
    DecimalFormat format = new DecimalFormat("#.00");



    public double getBalance(){

        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void printChange(double balance){

        System.out.println("Your change is : $"+format.format(balance));
    }

    public  double addMoney(double choice){
        if (choice < 0) {
            return balance;
        } else if (balance + choice <= 5000) {
            balance += choice;
        } else {
            System.out.println("Your balance cannot exceed $5000");
        }
        return balance;

    }

    public double withdrawMoney(double amountSpent){

        if (balance - amountSpent >= 0) {
            balance =balance- amountSpent;
        }
        return balance;
    }

    public List<String> log(String name, int quantity,String type,double totalPrice, double returnedBalance) {

        String str1=String.format("%-3d %-15s %-25s $%-10.2f $%-5.2f",quantity,type,name,totalPrice,returnedBalance);
        listbalance.add(str1);
        return listbalance;
    }


    public void getChangeBills(double balance) {
        double value;
        while (balance != 0) {

            if (balance >= 20) {
                value = (int) balance / 20;
                System.out.println((int) value + "  " + "$20 bills");
                balance = balance % 20;
            }
            if (balance >= 10) {
                value = (int) balance / 10;
                System.out.println((int) value + "  " + "$10 bills");
                balance = balance % 10;
            }
            if (balance >= 5) {
                value = (int) balance / 5;
                System.out.println((int) value + "  " + "$5 bills");
                balance = balance % 5;
            }
            if (balance >= 1) {
                value = (int) balance / 1;
                System.out.println((int) value + "  " + "$1 bills");
                balance = balance % 1;
            }
            if (balance >= .25) {
                value = (int) (balance / .25);
                System.out.println((int) value + "  " + "quarter(s)");
                balance = balance % .25;
            }
            if (balance >= .10) {
                value = (int) (balance / .10);
                System.out.println((int) value + "  " + "dime(s)");
                balance = balance % .10;
            }
            if (balance >= .05) {
                value = (int) (balance / .05);
                System.out.println((int) value + "  " + "nickel(s)");
                balance = balance % .05;

            }

            if (balance < 0.04) {
                balance = 0;
            }
        }
    }

    public String stringBalance() {
      return   "0.00";
    }
}




