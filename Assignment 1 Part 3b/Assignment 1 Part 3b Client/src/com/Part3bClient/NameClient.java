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

            String line = inConsole.readLine();
            while (!line.equals(""))
            {
                outStream.println(line);
                outStream.flush();
                String reply = inStream.readLine();
                System.out.println("Received: "+ reply);
                line = inConsole.readLine();
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
