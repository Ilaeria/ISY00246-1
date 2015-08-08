/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 */

package com.Part1;

import java.io.*;
import java.util.*;

public class Part1
{

    public static void main(String[] args)
    {
	    InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        int [] numbers = new int[10];
        int arrayIndex = 0;

        System.out.println("Enter two integers:");

        try
        {
            for (int i = 0; i < numbers.length;)
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
                        arrayIndex++;
                        i++;
                        int n2 = Integer.parseInt(split2);
                        numbers[i] = n2;
                        arrayIndex++;
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

        System.out.println("There were " + arrayIndex + " numbers entered.");
        System.out.println("The numbers entered were:");
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
        Arrays.sort(numbers);
        System.out.println("Maximum = " + numbers[numbers.length - 1]);
        System.out.println("Minimum = " + numbers[0]);



    }
}
