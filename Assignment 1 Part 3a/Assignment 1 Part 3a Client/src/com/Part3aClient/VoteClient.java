/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 * Assignment 1 Part 3a
 * Sends vote info to the server program.
 **/

package com.Part3aClient;

import java.io.*;
import java.net.*;

public class VoteClient
{
    //Static port numbers
    private static final int CLIENTPORT = 2014;
    private static final int SERVERPORT = 2015;

    public static void main(String[] args)
    {
        //Create keyboard input reader
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        String prompt = "Enter \"yes\" or \"no\": ";

        System.out.print(prompt);

        try
        {
            InetAddress addr = InetAddress.getByName(args[0]);
            String vote = stdin.readLine();

            while (!vote.equalsIgnoreCase("yes") && (!vote.equalsIgnoreCase("no"))) //Only accept valid votes
            {
                System.out.println("Invalid vote entered");
                System.out.print(prompt);
                vote = stdin.readLine();
            }
            DatagramSocket ds = new DatagramSocket(CLIENTPORT);
            byte[] buf = vote.getBytes();
            DatagramPacket pack = new DatagramPacket(buf, buf.length, addr, SERVERPORT);
            ds.send(pack);
            System.out.println("Vote " + "\"" + vote + "\"" + " sent to " + addr);
            ds.close();

        }
        catch (Exception e)
        {
            System.out.println();
            System.out.println(e);
        }
    }
}
