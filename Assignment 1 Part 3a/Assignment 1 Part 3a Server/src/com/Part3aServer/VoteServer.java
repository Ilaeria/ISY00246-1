/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 * Assignment 1 Part 3a VoteServer
 * Accepts and tallies votes from the client program.
 **/

package com.Part3aServer;

import java.net.*;
import java.io.*;

public class VoteServer
{
    public static void main(String[] args)
    {
        //Static port number
        final int serverPort = 2015;

        //Create keyboard input reader
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        try
        {
            InetAddress myAddr = InetAddress.getLocalHost(); //Get the server address
            DatagramSocket ds = new DatagramSocket(serverPort);

            System.out.println("Voting server " + myAddr.getHostAddress() + " active on " + ds.getLocalPort() + ".");
            System.out.println("Type Ctrl-C to finish.");

            String data = "";
            while (!data.equals("EXIT"))
            {
                byte [] buff = new byte[100];

                DatagramPacket pack =
                        new DatagramPacket(buff, buff.length);

                ds.receive(pack);
                buff = pack.getData();
                String vote = new String(buff);
                System.out.println(vote);
            }

            ds.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
