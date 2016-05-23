package com.theironyard.javawithclojure.jhporter;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void loadUsers(String fileLoc)
    {
        try
        {
            Scanner input = new Scanner(new File(fileLoc));

        }
        catch(Exception e)
        {
            System.err.printf("\nNot a Valid File!\n");
        }

    }

    public static void saveUsers(String fileLoc, String name, String password, HashMap<String, Integer> inventory)
    {
        try
        {
            PrintWriter output = new PrintWriter(fileLoc);
            output.printf("%s, %s, ");
            Iterator iterator = inventory.keySet().iterator();

            while (iterator.hasNext())
            {
                String key = iterator.next().toString();
                Integer value = inventory.get(key);
                output.printf("%s, %d, ", key, value);
            }
        }
        catch(Exception e)
        {
            System.err.printf("\nNot a Valid File!");
        }
    }




    public static void main(String[] args)
    {
	    //declare variables
        Users user;
        HashMap<String, String> validateIdentityList = new HashMap<>();
        boolean validIdentity = false;
        boolean run = true;
        String userName;
        String password;
        Scanner input = new Scanner(System.in);
        String FILE_LOC = "";


        //load presaved values




        //run program
        while (run)
        {
            while (!validIdentity)
            System.out.printf("\nEnter User Name(type quit to exit): ");
            userName = input.nextLine();
            System.out.printf("\nEnter Password: ");
            password = input.nextLine();

            if (validateIdentityList.get(password) != userName)
            {
                System.err.printf("\nNot a valid user!");
                System.out.printf("\nWould you like to create a new user? [y/n]");
                char createNewUser = input.nextLine().toLowerCase().charAt(0);
                switch (createNewUser)
                {
                    case 'y':
                        user
                        break;
                }


            }

        }
    }
}
