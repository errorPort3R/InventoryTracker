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
        boolean isFound=false;
        char createNewPlayer = '';

        System.out.printf("\nEnter User Name(type quit to exit): ");
        userName = input.nextLine();
        for (int i = 0; i<Players.size(); i++)
            if(Players.get(i).getName().equals(userName))
            {
                System.out.printf("\nEnter Password: ");
                password = input.nextLine();
                if (Players.get(i).getPassword().equals(password))
                {
                    isFound = true;
                }
                else
                {
                    System.err.printf("\nInvalid Credentials!");
                }
            }
            else
            {
                System.out.printf("\nWould you like to create a new player?[y/n]");

            }




        return player;
    }
}
