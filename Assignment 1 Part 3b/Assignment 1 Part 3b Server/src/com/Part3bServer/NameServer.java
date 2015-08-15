/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 * Assignment 1 Part 3a
 * Sends vote info to the server program.
 **/

package com.Part3bServer;

import java.io.*;
import java.net.*;

public class NameServer
{
    private static final int SERVERPORT = 2015;

    public static void main(String[] args)
    {
        try
        {
            InetAddress myAddr = InetAddress.getLocalHost(); //Get the server address
            System.out.println("Server operating on " + myAddr.getHostAddress());
            ServerSocket server = new ServerSocket(SERVERPORT);

            while (true)
            {
                try
                {
                    Socket sock = server.accept();
                    PrintWriter outStream = new PrintWriter(sock.getOutputStream());
                    BufferedReader inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                    Boolean menuSelected = false;
                    while (menuSelected == false)
                    {
                        String menu = inStream.readLine();

                        if (menu.equals("1"))
                        {
                            outStream.println(menu);
                            System.out.println("Menu selection: " + menu);
                            outStream.flush();
                        }
                        else if (menu.equals("2"))
                        {
                            outStream.println(menu);
                            System.out.println("Menu selection: " + menu);
                            outStream.flush();
                        }
                        else if (menu.equals("3"))
                        {
                            outStream.println(menu);
                            System.out.println("Menu selection: " + menu);
                            outStream.flush();
                        }
                        else if (menu.equals("4"))
                        {
                            outStream.println(menu);
                            System.out.println("Menu selection: " + menu);
                            outStream.flush();
                        }
                        else if (menu.equals("5"))
                        {
                            outStream.println(menu);
                            System.out.println("Menu selection: " + menu);
                            System.out.println("Socket disconnected.");
                            menuSelected = true;
                            outStream.flush();
                        }
                        else
                        {
                            menuSelected = false;
                        }
                    }
                    System.out.println("Name Server exiting.");
                    sock.close();
                }
                catch (IOException e)
                {
                }
            }
        }
        catch (Exception e)
        {
            System.out.println();
            System.out.println(e);
        }
    }
}
