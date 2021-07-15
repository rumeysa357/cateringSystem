package com.techelevator.view;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {
    private String fileName ;
    private File itemFile;
    private Scanner scanner;
    TreeMap<String,Item> itemMap=new TreeMap<>();
    List<Item> itemNameList=new ArrayList<>();

    public Inventory(String fileName) {

        itemFile = new File(fileName);
    }



    public TreeMap<String,Item> loadInventoryItems() {


        try {
            scanner = new Scanner(itemFile);

            while (scanner.hasNextLine()) {

                String record = scanner.nextLine();
                String[] fields = record.split("\\|");
                Item item = new Item(fields[0], fields[1], Double.parseDouble(fields[2]));
                itemMap.put(fields[0],item);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemMap;
    }




}

