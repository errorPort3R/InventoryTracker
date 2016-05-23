package com.theironyard.javawithclojure.jhporter;

import java.util.HashMap;

/**
 * Created by jeffryporter on 5/23/16.
 */
public class Users
{
    //declare variables
    private static Users theUsers;
    private HashMap<String, Integer> inventory;
    private HashMap<String, String> credentials;

    //constructor
    private Users()
    {
    }

    //methods
    public static Users getTheUsers()
    {
        if(theUsers == null)
        {
            theUsers =  new Users();
        }
        return theUsers;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public HashMap<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(HashMap<String, String> credentials) {
        this.credentials = credentials;
    }


}
