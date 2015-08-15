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
    public static void main(String[] args)
    {
        //Static port numbers
        final int clientPort = 2014;
        final int serverPort = 2015;

        //Create keyboard input reader
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        try
        {
            InetAddress addr = InetAddress.getByName(args[0]);
            System.out.print("Enter yes or no: ");
            String vote = stdin.readLine();
            DatagramSocket ds = new DatagramSocket(clientPort);
            byte [] buf = vote.getBytes();
            DatagramPacket pack = new DatagramPacket(buf, buf.length, addr, serverPort);
            ds.send(pack);
            System.out.println("Sent");
            ds.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
