package com.theironyard.javawithclojure.jhporter;

import java.util.ArrayList;

/**
 * Created by jeffryporter on 5/23/16.
 */
public class PlayerData {
    //declare variables
    private String name;
    private String password;
    private ArrayList<String> inventoryItem;
    private ArrayList<Integer> inventoryQuantity;

    public PlayerData(String name, String password)
    {
        this.name=name;
        this.password=password;
        inventoryItem = new ArrayList<>();
        inventoryQuantity = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public String getInventoryItem(int index)
    {
        return inventoryItem.get(index);
    }

    public int getInventoryQuantity(int index)
    {
        return inventoryQuantity.get(index);
    }

    public void updateInventoryQty(int index, int qty)
    {
        inventoryQuantity.set(index, qty);
    }

    public String removeItem(int index)
    {
        return inventoryItem.remove(index);
    }

    public int removeQuantity(int index)
    {
        return inventoryQuantity.remove(index);
    }

    public void addItem(String name, int quantity)
    {
        inventoryItem.add(name);
        inventoryQuantity.add(quantity);
    }

    public void changeName(String name)
    {
        this.name = name;
    }

    public void changePassword(String password)
    {
        this.password = password;
    }

    public int getInventoryLength()
    {
        return inventoryItem.size();
    }

}
