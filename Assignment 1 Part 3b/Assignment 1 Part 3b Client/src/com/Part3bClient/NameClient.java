/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 * Assignment 1 Part 3b
 * Queries and sends update requests to the server program for the name db.
 **/

package com.Part3bClient;

import java.io.*;
import java.net.*;

public class NameClient
{
    //Static port numbers
    private static final int SERVERPORT = 2015;

    public static void main(String[] args)
    {
        try
        {
            InetAddress addr = InetAddress.getByName(args[0]); //Get the server details from the command line argument
            Socket sock = new Socket(addr,SERVERPORT);
            PrintStream outStream = new PrintStream(sock.getOutputStream());
            BufferedReader inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

            Boolean menuSelected = true;
            outStream.flush();
            while (menuSelected) //Keep displaying menu until told to exit
            {
                DisplayMenu();
                String menu = inConsole.readLine(); //Hold menu selection
                String reply; //Hold server reply

                if (menu.equals("1")) //Add a name
                {
                    outStream.println(menu);
                    outStream.flush();
                    System.out.println("Menu selection: " + menu);
                    System.out.println("Please enter the name you wish to add: ");
                    String addName = inConsole.readLine();
                    outStream.println(addName);
                    System.out.println("Name " + addName + " sent");
                    outStream.flush();
                    reply = inStream.readLine();
                    System.out.println("Reply from server: " + reply);
                }
                else if (menu.equals("2")) //Remove a name
                {
                    outStream.println(menu);
                    System.out.println("Menu selection: " + menu);
                    System.out.println("Please enter the name you wish to remove: ");
                    String removeName = inConsole.readLine();
                    outStream.println(removeName);
                    reply = inStream.readLine();
                    System.out.println("Reply from server: " + reply);
                    outStream.flush();
                }
                else if (menu.equals("3")) //List all names
                {
                    outStream.println(menu);
                    System.out.println("Menu selection: " + menu);
                    reply = inStream.readLine();
                    while (!reply.equals(""))
                    {
                        System.out.println(reply);
                        reply = inStream.readLine();
                    }
                    outStream.flush();
                }
                else if (menu.equals("4")) //Check if a name recorded
                {
                    outStream.println(menu);
                    System.out.println("Menu selection: " + menu);
                    System.out.println("Please enter the name you wish to check: ");
                    String checkName = inConsole.readLine();
                    outStream.println(checkName);
                    reply = inStream.readLine();
                    System.out.println("Reply from server: " + reply);
                    outStream.flush();
                }
                else if (menu.equals("5")) //Exit
                {
                    outStream.println(menu);
                    System.out.println("Menu selection: " + menu);
                    System.out.println("Name Client exiting.");
                    menuSelected = false;
                    outStream.flush();
                }
                else
                {
                    menuSelected = true;
                }
            }
            outStream.println();
            outStream.flush();

            sock.close();
        }
        catch (Exception e)
        {
            System.out.println();
            System.out.println(e);
        }
    }
    public static void DisplayMenu() //Display menu items
    {
        System.out.println();
        System.out.println("Name Server Menu");
        System.out.println();
        System.out.println("1. Add a name");
        System.out.println("2. Remove a name");
        System.out.println("3. List all names");
        System.out.println("4. Check if a name recorded");
        System.out.println("5. Exit");
        System.out.println();
        System.out.println("Enter selection [1-5]: ");
    }
}
