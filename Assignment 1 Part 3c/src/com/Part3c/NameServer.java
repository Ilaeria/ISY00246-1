/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 * Assignment 1 Part 3c
 * Receives name db queries from the client and manipulates the name db. Can accept multiple connections.
 **/

package com.Part3c;

import java.io.*;
import java.net.*;
import java.util.*;

public class NameServer
{
    private static final int SERVERPORT = 2015;
    private static final String FILENAME = "NameDB.txt";

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
                    //Start threading client requests
                    Socket sock = server.accept();
                    MenuThread mthread = new MenuThread(FILENAME, sock);
                    mthread.start();
                }
                catch (IOException e)
                {
                    System.out.println(e);
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

/**
 The menu selection and processing from part 3b adapted to accept multiple clients
 and their requests at once.
 **/
class MenuThread extends Thread
{
    String file; //Need to pass the file as it's a program-level constant
    Socket sock;

    MenuThread(String f, Socket s)
    {
        file = f;
        sock = s;
    }

    public void run()
    {
        try
        {
            PrintWriter outStream = new PrintWriter(sock.getOutputStream());
            InputStreamReader inReader = new InputStreamReader(sock.getInputStream());
            BufferedReader inStream = new BufferedReader(inReader);

            Boolean menuSelected = false;
            outStream.flush();
            System.out.println("Waiting for menu selection");

            while (!menuSelected) //Keep listening until told to stop
            {
                String menu = inStream.readLine();

                if (menu.equals("1")) //Add a name
                {
                    System.out.println("Menu selection: " + menu);

                    //Create and fill array from file
                    ArrayList<String> namesArrayAdd = new ArrayList<>();
                    try
                    {
                        File namesRead = new File(file);
                        BufferedReader br = new BufferedReader(new FileReader(namesRead));
                        String line;
                        line = br.readLine();
                        namesArrayAdd.clear();

                        while (line != null)
                        {
                            namesArrayAdd.add(line);
                            line = br.readLine();
                        }
                        br.close();
                    }
                    catch (IOException e)
                    {
                        outStream.println("File read error");
                    }

                    //Add name to array
                    String addName = inStream.readLine();
                    namesArrayAdd.add(addName);

                    //Rewrite file
                    try
                    {
                        File namesWrite = new File(file);
                        PrintWriter pw = new PrintWriter(new FileOutputStream(namesWrite));
                        for (String line : namesArrayAdd)
                        {
                            pw.println(line);
                        }
                        pw.close();
                    }
                    catch (IOException e)
                    {
                        outStream.println("File write error");
                    }

                    System.out.println("Name \"" + addName + "\" added successfully.");
                    outStream.println("Name \"" + addName + "\" added successfully.");
                    outStream.flush();
                }
                else if (menu.equals("2")) //Remove a name
                {
                    System.out.println("Menu selection: " + menu);

                    //Create and fill array from file
                    ArrayList<String> namesArrayRemove = new ArrayList<>();
                    try
                    {
                        File namesRead = new File(file);
                        BufferedReader br = new BufferedReader(new FileReader(namesRead));
                        String line;
                        line = br.readLine();
                        namesArrayRemove.clear();

                        while (line != null)
                        {
                            namesArrayRemove.add(line);
                            line = br.readLine();
                        }
                        br.close();
                    }
                    catch (IOException e)
                    {
                        outStream.println("File read error");
                    }

                    //Remove name from array
                    String removeName = inStream.readLine();
                    if (namesArrayRemove.contains(removeName))
                    {
                        namesArrayRemove.remove(removeName);
                        System.out.println("Name \"" + removeName + "\" removed successfully.");
                        outStream.println("Name \"" + removeName + "\" removed successfully.");
                    }
                    else
                    {
                        System.out.println("Name \"" + removeName + "\" not found.");
                        outStream.println("Name \"" + removeName + "\" not found.");
                    }

                    //Rewrite file
                    try
                    {
                        File namesWrite = new File(file);
                        PrintWriter pw = new PrintWriter(new FileOutputStream(namesWrite));
                        for (String line : namesArrayRemove)
                        {
                            pw.println(line);
                        }
                        pw.close();
                    }
                    catch (IOException e)
                    {
                        outStream.println("File write error");
                    }

                    outStream.flush();
                }
                else if (menu.equals("3")) //List all names
                {
                    System.out.println("Menu selection: " + menu);

                    //Create and fill array from file
                    ArrayList<String> namesArrayList = new ArrayList<>();

                    try
                    {
                        File namesRead = new File(file);
                        BufferedReader br = new BufferedReader(new FileReader(namesRead));
                        String line;
                        line = br.readLine();
                        namesArrayList.clear();

                        while (line != null)
                        {
                            namesArrayList.add(line);
                            line = br.readLine();
                        }
                        br.close();
                    }
                    catch (IOException e)
                    {
                        outStream.println("File read error");
                    }

                    //Output array content
                    for (String n : namesArrayList) {
                        outStream.println(n);
                    }

                    System.out.println("Names displayed successfully.");
                    System.out.println("Total names displayed = " + namesArrayList.size());
                    outStream.println("Total names displayed = " + namesArrayList.size());
                    outStream.println();
                    outStream.flush();
                }
                else if (menu.equals("4")) //Check if a name recorded
                {
                    System.out.println("Menu selection: " + menu);

                    //Create and fill array from file
                    ArrayList<String> namesArrayCheck = new ArrayList<>();

                    try
                    {
                        File namesRead = new File(file);
                        BufferedReader br = new BufferedReader(new FileReader(namesRead));
                        String line;
                        line = br.readLine();
                        namesArrayCheck.clear();

                        while (line != null)
                        {
                            namesArrayCheck.add(line);
                            line = br.readLine();
                        }
                        br.close();
                    }
                    catch (IOException e)
                    {
                        outStream.println("File read error");
                    }

                    //Check if array contains name
                    String checkName = inStream.readLine();
                    if (namesArrayCheck.contains(checkName))
                    {
                        System.out.println("Name \"" + checkName + "\" is in the database.");
                        outStream.println("Name \"" + checkName + "\" is in the database.");
                        outStream.flush();
                    }
                    else
                    {
                        System.out.println("Name \"" + checkName + "\" not found.");
                        outStream.println("Name \"" + checkName + "\" not found.");
                        outStream.flush();
                    }
                }
                else if (menu.equals("5")) //Exit
                {
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
        }
        catch (Exception e)
        {
            System.out.println();
            System.out.println(e);
        }
    }
}