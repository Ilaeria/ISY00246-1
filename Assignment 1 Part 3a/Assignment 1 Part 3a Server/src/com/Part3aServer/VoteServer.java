/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 16 August 2015
 * Assignment 1 Part 3a VoteServer
 * Accepts and tallies votes from the client program.
 **/

package com.Part3aServer;

import java.net.*;

public class VoteServer
{
    //Static port number
    private static final int SERVERPORT = 2015;

    public static void main(String[] args)
    {
        //Create vote tallies
        int yesTotal = 0;
        int noTotal = 0;

        try
        {
            InetAddress myAddr = InetAddress.getLocalHost(); //Get the server address
            DatagramSocket ds = new DatagramSocket(SERVERPORT); //Create the socket

            System.out.println("Voting server " + myAddr.getHostAddress() + " active on " + ds.getLocalPort() + ".");
            System.out.println("Type Ctrl-C to finish.");

            String vote;
            Boolean listen = true;
            while (listen) //Keep listening until told otherwise
            {
                byte [] buff = new byte[100];

                DatagramPacket pack =
                        new DatagramPacket(buff, buff.length);

                //Receive vote and update tallies
                ds.receive(pack);
                buff = pack.getData();
                InetAddress voteAddr = pack.getAddress();
                vote = new String(buff,0,pack.getLength());
                if (vote.equalsIgnoreCase("yes"))
                {
                    yesTotal++;
                    System.out.println("[" + voteAddr + "] " + "\"Yes\" vote received");
                    System.out.println("So far Yes= " + yesTotal + " No= " + noTotal +".");
                }
                else if (vote.equalsIgnoreCase("no"))
                {
                    noTotal++;
                    System.out.println("[" + voteAddr + "] " + "\"No\" vote received");
                    System.out.println("So far Yes= " + yesTotal + " No= " + noTotal +".");
                }
                else
                {
                    System.out.println("**Error ** Bad vote string received");
                }
            }

            System.out.println("Vote counting completed."); //Exit when told to
            ds.close();
        }
        catch (Exception e)
        {
            System.out.println();
            System.out.println(e);
        }
    }
}
