package com.theironyard.javawithclojure.jhporter;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jeffryporter on 5/23/16.
 */
public class GameManager
{
    //Declare Variables
    private static GameManager theGameManager;
    private ArrayList<PlayerData> Players;
    //constructor
    private GameManager()
    {
    }

    //methods
    public static GameManager getTheGameManager()
    {
        if(theGameManager == null)
        {
            theGameManager = new GameManager();
        }
        return theGameManager;
    }

    public void loadPlayers(String fileLoc)
    {
        PlayerData newPlayer;
        try
        {
            Scanner input = new Scanner(new File(fileLoc));
            while (input.hasNext())
            {
                String line = input.nextLine();
                String[] fields = line.split(", ");
                String userName = fields[0];
                String password = fields[1];
                newPlayer = new PlayerData(userName, password);
                if(fields.length>2)
                {
                    for(int i = 2; i<(fields.length-1); i+=2)
                    {
                        int qty = Integer.valueOf(fields[i+1]);
                        newPlayer.addItem(fields[i], qty);
                    }
                }
                Players.add(newPlayer);
            }
        }
        catch(Exception e)
        {
            System.err.printf("\nNot a Valid File!\n");
        }
    }

    public void savePlayers(String fileLoc)
    {
        try {
            for (int i = 0; i < Players.size(); i++)
            {
                PrintWriter output = new PrintWriter(fileLoc);
                output.printf("\n%s, %s, ",Players.get(i).getName(), Players.get(i).getPassword());

                for (int j =0;j<Players.get(i).getInventoryLength();j++)
                {
                    output.printf("%s, %d, ", Players.get(i).getInventoryItem(j), Players.get(i).getInventoryQuantity(j));
                }
            }
        }
        catch(Exception e)
        {
            System.err.printf("\nNot a Valid File!");
        }
    }

    public PlayerData verifyIdentity(Scanner input)
    {
        PlayerData player;
        String userName;
        String password;
        char createNewPlayer = 'z';
        PlayerData tempPlayer = null;

        System.out.printf("\nEnter User Name(type quit to exit): ");
        userName = input.nextLine();
        for (int i = 0; i < Players.size(); i++)
        {
            if (Players.get(i).getName().equals(userName))
            {
                System.out.printf("\nEnter Password: ");
                password = input.nextLine();
                if (Players.get(i).getPassword().equals(password))
                {
                    tempPlayer = Players.get(i);
                    i = Players.size();
                }
                else
                {
                    System.err.printf("\nInvalid Credentials!");
                }
            }
            else
            {
                System.out.printf("\nWould you like to create a new player?[y/n]");
                createNewPlayer = input.nextLine().toLowerCase().charAt(0);
                if (createNewPlayer == 'y')
                {
                    System.out.printf("\nEnter User Name(type quit to exit): ");
                    userName = input.nextLine();
                    System.out.printf("\nEnter Password: ");
                    password = input.nextLine();
                    tempPlayer = new PlayerData(userName, password);
                    Players.add(tempPlayer);
                }
            }
        }
        return tempPlayer;
    }

    public void addItemMenuOption(PlayerData player, Scanner input)
    {
        String name;
        String tempInt;
        int qty;

        System.out.printf("\nWhat is the name of the item you wish to add? ");
        name = input.nextLine();
        System.out.printf("\nAnd how many %s's are we stockpiling? ");
        tempInt = input.nextLine();
        try
        {
            qty = Integer.valueOf(tempInt);

        }
        catch(Exception e)
        {

        }
    }

    public void removeItemFromInventory(PlayerData player, Scanner input)
    {
        String name;
        String tempInt;
        int choice;
        int qty;

        System.out.printf("\nWhich of the following would you like to remove?\n");
        for(int i=0;i<player.getInventoryLength();i++)
        {
            System.out.printf("%d. %s\n", i+1, player.getInventoryItem(i));
        }
        tempInt = input.nextLine();
        try
        {
            choice = Integer.valueOf(tempInt);
            choice--;
            name = player.removeItem(choice);
            qty = player.removeQuantity(choice);
            System.out.printf("You have dropped %d %s(s) from your inventory.", qty, name);
        }
        catch (Exception e)
        {
            System.err.printf("Not a Valid Selection!");
        }
    }

    public void updateItemQuantity(PlayerData player, Scanner input)
    {
        String name;
        String tempInt;
        int choice;
        int qty;

        System.out.printf("\nWhich of the following would you like to change the inventory quantity?\n");
        for(int i=0;i<player.getInventoryLength();i++)
        {
            System.out.printf("%d. %s\n", i+1, player.getInventoryItem(i));
        }
        tempInt = input.nextLine();
        try
        {
            choice = Integer.valueOf(tempInt);
            choice--;
            System.out.printf("\nWhat would you like the new quantity to be?");
            tempInt = input.nextLine();
            try
            {
                qty = Integer.valueOf(tempInt);
                if (player.getInventoryQuantity(choice)>qty)
                {
                    player.updateInventoryQty(choice, qty);
                }
                else if (player.getInventoryQuantity(choice)<=qty)
                {
                    name = player.removeItem(choice);
                    qty = player.removeQuantity(choice);
                    System.out.printf("You have dropped %d %s(s) from your inventory.", qty, name);
                }
                else
                {
                    System.err.printf("\nNot a valid quantity!");
                }
            }
            catch (Exception e)
            {
                System.err.printf("\nNot a valid quantity!");
            }
        }
        catch (Exception e)
        {
            System.err.printf("Not a Valid Selection!");
        }
    }

    public void Save(String fileLoc)
    {
        savePlayers(fileLoc);
    }

}
