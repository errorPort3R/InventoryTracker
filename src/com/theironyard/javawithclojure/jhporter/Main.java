package com.theironyard.javawithclojure.jhporter;


import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
	    //declare variables
        GameManager theGameManager = GameManager.getTheGameManager();
        PlayerData player = null;
        char run = 'y';
        boolean optionsRun = true;
        String userName;
        String password;
        String optionsMenuChoice;
        Scanner input = new Scanner(System.in);
        String FILE_LOC = "/Users/jeffryporter/Desktop/Players.txt";


        //load presaved values
        theGameManager.loadPlayers(FILE_LOC);

        //run program
        while (run == 'y')
        {
            while (player == null)
            {
                player = theGameManager.verifyIdentity(input);
            }

            //options menu
            while (optionsRun)
            {
                System.out.printf("\n\nPlease Select From The following Menu:");
                System.out.printf("\n1. Add item to inventory\n2. Remove item from inventory\n3. Update quantity in inventory");
                System.out.printf("\n4. Log out to main menu \n");
                optionsMenuChoice = input.nextLine();
                switch (optionsMenuChoice)
                {
                    case "1":
                    {
                        theGameManager.addItemMenuOption(player, input);
                        break;
                    }
                    case "2":
                    {
                        theGameManager.removeItemFromInventory(player,input);
                        break;
                    }
                    case "3":
                    {
                        theGameManager.updateItemQuantity(player,input);
                        break;
                    }
                    case "4":
                    {
                        //theGameManager.Save(FILE_LOC);
                        optionsRun = false;
                        player = null;
                        break;
                    }
                    /*case "5":
                    {
                        theGameManager.Save(FILE_LOC);
                        break;
                    }*/
                    default:
                    {
                        System.err.printf("\n Not a valid choice!");
                        break;
                    }

                }
            }
            System.out.printf("\nLog in again?[y/n]");
            run = input.nextLine().toLowerCase().charAt(0);
        }
    }
}
