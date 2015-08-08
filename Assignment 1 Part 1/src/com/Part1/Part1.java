/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 */

package com.Part1;

import java.io.*;

public class Part1
{

    public static void main(String[] args)
    {
	    InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        int [] numbers = new int[10];

        System.out.println("Enter two integers:");

        try
        {
            for (int i = 0; i < 10;)
            {
                String str = stdin.readLine();
                if (str.contains(" "))
                {
                    String[] splits = str.split(" ");
                    String split1 = splits[0];
                    String split2 = splits[1];
                    try
                    {
                        int n1 = Integer.parseInt(split1);
                        numbers[i] = n1;
                        i++;
                        int n2 = Integer.parseInt(split2);
                        numbers[i] = n2;
                        i++;
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Please enter numbers only");
                    }
                }
                else
                {
                    System.out.println("Enter 2 integers separated by a space");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("An error occurred");
        }

        System.out.println("The numbers entered were:");
        for (int i = 0; i < 10; i++)
        {
            System.out.println(numbers[i]);
        }


    }
}
