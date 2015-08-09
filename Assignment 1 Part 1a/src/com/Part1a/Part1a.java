/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 * Assignment 1 Part 1a
 **/

package com.Part1a;

import java.io.*;

public class Part1a
{

    public static void main(String[] args)
    {

        //Create keyboard input reader
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        //Create array and placeholders for the number of items, min and max values
        int [] numbers = new int[10];
        int arrayIndex = 0;
        int arrayMax = 0;
        int arrayMin = 0;

        System.out.println("Enter two integers:");

        try
        {
            //Start filling the array
            for (int i = 0; i < numbers.length;)
            {
                String str = stdin.readLine();

                //End if blank line is entered
                if (str.equals(""))
                {
                    i = numbers.length;
                }

                //Split if 2 numbers separated by a space are entered
                else if (str.contains(" "))
                {
                    String[] splits = str.split(" ");
                    String split1 = splits[0];
                    String split2 = splits[1];
                    try
                    {
                        //Set min/max with initial values on first loop
                        if (i == 0)
                        {
                            int n1 = Integer.parseInt(split1);
                            numbers[i] = n1;
                            arrayMax = n1;
                            arrayMin = n1;
                            i++;
                            arrayIndex = i;

                            int n2 = Integer.parseInt(split2);
                            numbers[i] = n2;
                            if (n2 > arrayMax)
                            {
                                arrayMax = n2;
                            }
                            else if (n2 < arrayMin)
                            {
                                arrayMin = n2;
                            }
                            i++;
                            arrayIndex = i;
                        }

                        //if it's not the first loop, compare min/max and update if needed
                        else
                        {
                            int n1 = Integer.parseInt(split1);
                            numbers[i] = n1;
                            if (n1 > arrayMax)
                            {
                                arrayMax = n1;
                            }
                            else if (n1 < arrayMin)
                            {
                                arrayMin = n1;
                            }
                            i++;
                            arrayIndex = i;

                            int n2 = Integer.parseInt(split2);
                            numbers[i] = n2;
                            if (n2 > arrayMax)
                            {
                                arrayMax = n2;
                            }
                            else if (n2 < arrayMin)
                            {
                                arrayMin = n2;
                            }
                            i++;
                            arrayIndex = i;
                        }
                    }

                    //Catch if non-numbers are entered and parse fails
                    catch (NumberFormatException e)
                    {
                        System.out.println("Please enter numbers only");
                    }
                }

                //If junk input received, try again
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

        //advise user if max capacity was reached
        if (arrayIndex == numbers.length)
        {
            System.out.println("You have entered the maximum number of numbers.");
        }

        //print results
        System.out.println("There were " + arrayIndex + " numbers entered.");
        System.out.println("Maximum = " + arrayMax);
        System.out.println("Minimum = " + arrayMin);
    }
}
