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
            String str = stdin.readLine();
            int n = Integer.parseInt(str);
            numbers[0] = n;
            System.out.println(numbers[0]);
        }
        catch (Exception e)
        {
            System.out.println("An error occurred");
            System.out.println("Please try again");
        }


    }
}
