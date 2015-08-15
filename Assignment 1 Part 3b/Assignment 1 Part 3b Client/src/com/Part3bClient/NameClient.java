/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 * Assignment 1 Part 3a
 * Sends vote info to the server program.
 **/

package com.Part3bClient;

import java.io.*;
import java.net.*;

public class NameClient
{
    //Static port numbers
    private static final int CLIENTPORT = 2014;
    private static final int SERVERPORT = 2015;

    public static void main(String[] args)
    {
        try {
            InetAddress addr = InetAddress.getByName(args[0]);
            Socket sock = new Socket(addr,SERVERPORT);
            PrintStream outStream = new PrintStream(sock.getOutputStream());
            BufferedReader inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Name Server Menu");
            System.out.println();
            System.out.println("1. Add a name");
            System.out.println("2. Remove a name");
            System.out.println("3. List all names");
            System.out.println("4. Check if a name recorded");
            System.out.println("5. Exit");
            System.out.println();

            Boolean menuSelected = false;
            while (menuSelected == false)
            {
                System.out.println("Enter selection [1-5]:");
                String menu = inConsole.readLine();
                if (menu.equals("1"))
                {
                    System.out.println("Menu selection: " + menu);
                    menuSelected = true;
                }
                else if (menu.equals("2"))
                {
                    System.out.println("Menu selection: " + menu);
                    menuSelected = true;
                }
                else if (menu.equals("2"))
                {
                    System.out.println("Menu selection: " + menu);
                    menuSelected = true;
                }
                else if (menu.equals("2"))
                {
                    System.out.println("Menu selection: " + menu);
                    menuSelected = true;
                }
                else if (menu.equals("5"))
                {
                    System.out.println("Exiting Name Server");
                    menuSelected = true;
                }
                else
                {
                    menuSelected = false;
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
}
