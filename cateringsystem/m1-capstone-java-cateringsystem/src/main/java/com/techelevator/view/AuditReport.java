package com.techelevator.view;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AuditReport {

    FileWriter fileWriter;
    String reportLine;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    LocalDateTime dateTimeNow = LocalDateTime.now();
    CashRegister cashRegister = new CashRegister();
    File auditFile = new File("Log.txt");


    public void writeToAFile(String reportLine) {
        try (FileWriter writer = new FileWriter(auditFile, true);
             BufferedWriter buffers = new BufferedWriter(writer)) {
            buffers.write(reportLine);
            buffers.newLine();
            buffers.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void addMoneyWriter(double amounttoAdd, double balance){
        reportLine=String.format("%s %s $%.2f $%.2f",dtf.format(dateTimeNow), "ADD MONEY:",amounttoAdd,balance );
        writeToAFile(reportLine);
    }
    public void addItemToCartWriter(Item item, int quantity, double balance) {
        reportLine = String.format("%s %s %s %s $%.2f $%.2f", dtf.format(dateTimeNow), quantity, item.getName(), item.getCode(), item.getPrice() * quantity, balance);
        writeToAFile(reportLine);
    }


    public void giveChangeWriter(double balance) {
        reportLine = String.format("%s %s  $%.2f $%s", dtf.format(dateTimeNow), "GIVE CHANGE:", balance, cashRegister.stringBalance());
        writeToAFile(reportLine);
    }



}

