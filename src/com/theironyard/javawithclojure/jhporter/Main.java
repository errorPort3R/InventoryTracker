package com.theironyard.javawithclojure.jhporter;

import sun.tools.asm.CatchData;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {





    public static void main(String[] args)
    {
	    //declare variables
        GameManager theGameManager = GameManager.getTheGameManager();
        boolean validIdentity = false;
        boolean run = true;
        boolean optionsRun;
        String userName;
        String password;
        String optionsMenuChoice;
        Scanner input = new Scanner(System.in);
        String FILE_LOC = "";


        //load presaved values
        theGameManager.loadPlayers(FILE_LOC);


        //run program
        while (run) {
            while (!validIdentity)
            {
                PlayerData player = theGameManager.verifyIdentity();
            }
            optionsRun = true;
            while (!validIdentity)
            System.out.printf("\nEnter User Name(type quit to exit): ");
            userName = input.nextLine();
            System.out.printf("\nEnter Password: ");
            password = input.nextLine();

            if ( != userName)
            {
                System.err.printf("\nNot a valid user!");
                System.out.printf("\nWould you like to create a new user? [y/n]");
                char createNewUser = input.nextLine().toLowerCase().charAt(0);
                switch (createNewUser)
                {
                    case 'y':

                        break;
                }


            }

            //options menu
            while (optionsRun)
            {
                System.out.printf("\n\nPlease Select From The following Menu:");
                System.out.printf("\n1. Add item to inventory\n2.Remove item from inventory\n3. Update quantity in inventory");
                System.out.printf("\n4. Save current user\n5. Log out to main menu\n");
                optionsMenuChoice = input.nextLine();
                switch (optionsMenuChoice)
                {
                    case "1":
                    {
                        System.out.printf("\nEnter the item name: ");
                        String itemToAdd = input.nextLine();
                        System.out.println("\nEnter the quantity: ");
                        String quantity = input.nextLine();
                        try
                        {
                            int qty = Integer.valueOf(quantity);
                            users.getUser(userName).addInventory(itemToAdd, qty);
                        }
                        catch(Exception e)
                        {
                            System.err.printf("Not a valid integer!");
                        }
                        break;
                    }
                    case "2":
                    {
                        Iterator iterator = users.getUser(userName).getInventory().keySet().iterator();
                        System.out.printf("\nSelect the item you wish to remove:");
                        int i = 1
                        while (iterator.hasNext())
                        {
                            String key = iterator.next().toString();
                            Integer value = users.getUser(userName).getInventory().get(key);
                            System.out.printf("\n%s. %d, ", i, key);
                        }

                        users.removeInventoryItem(userName, )
                        break;
                    }


                    case "3":
                    {

                        break;
                    }
                    case "4":
                    {

                        break;
                    }
                    case "5":
                    {

                        break;
                    }
                    default:
                    {
                        System.err.printf("\n Not a valid choice!");
                        break;
                    }

                }
            }


        }
    }
}
