/**
 * Created by: Jennifer Doherty
 * Unit: ISY00246 S2 2015
 * Date: 21 August 2015
 * Assignment 1 Part 1a
 **/

package com.Part1bc;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        //Create confectionary test objects
        Confectionary whittakers = new Confectionary(111, "Whittaker's chocolate", 11, "01/01/2020");
        Confectionary snakes = new Confectionary(222, "Snakes lollies", 22, "02/02/2020");
        Confectionary juicyfruit = new Confectionary(333, "Juicy Fruit gum", 33, "03/03/2020");

        //Create soft drink test objects
        SoftDrink coke = new SoftDrink(444, "Coke cola", 44, 8);
        SoftDrink redbull = new SoftDrink(555, "Red Bull energy", 55, 10);
        SoftDrink orange = new SoftDrink(666, "Orange juice", 66, 12);

        //Create and display full initial records
        String confectionary1 = getFullConfectionaryRecord(whittakers);
        String confectionary2 = getFullConfectionaryRecord(snakes);
        String confectionary3 = getFullConfectionaryRecord(juicyfruit);
        String softDrink1 = getFullSoftDrinkRecord(coke);
        String softDrink2 = getFullSoftDrinkRecord(redbull);
        String softDrink3 = getFullSoftDrinkRecord(orange);

        System.out.println("Initial records:");
        System.out.println(confectionary1);
        System.out.println(confectionary2);
        System.out.println(confectionary3);
        System.out.println(softDrink1);
        System.out.println(softDrink2);
        System.out.println(softDrink3);

        //Modify initial records
        whittakers.setNumber(777);
        snakes.setNumber(888);
        juicyfruit.setNumber(999);
        coke.setNumber(101010);
        redbull.setNumber(111111);
        orange.setNumber(121212);

        //Create and display modified records
        String confectionary4 = getFullConfectionaryRecord(whittakers);
        String confectionary5 = getFullConfectionaryRecord(snakes);
        String confectionary6 = getFullConfectionaryRecord(juicyfruit);
        String softDrink4 = getFullSoftDrinkRecord(coke);
        String softDrink5 = getFullSoftDrinkRecord(redbull);
        String softDrink6 = getFullSoftDrinkRecord(orange);

        System.out.println();
        System.out.println("Modified records:");
        System.out.println(confectionary4);
        System.out.println(confectionary5);
        System.out.println(confectionary6);
        System.out.println(softDrink4);
        System.out.println(softDrink5);
        System.out.println(softDrink6);

        //Test getting basic stock info with polymorphic method
        String test1 = getBasicInfo(whittakers);
        String test2 = getBasicInfo(coke);

        System.out.println();
        System.out.println("Basic info (demonstrating polymorphic method):");
        System.out.println(test1);
        System.out.println(test2);
    }

    //Return full confectionary record
    public static String getFullConfectionaryRecord(Confectionary c)
    {
        return("Stock ID: " + c.getID() + ", Description: " +
                c.getDescription() + ", Number in stock: " + c.number() +
                ", Expiry date: " + c.getExpiry());
    }

    //Return full soft drink record
    public static String getFullSoftDrinkRecord(SoftDrink s)
    {
        return("Stock ID: " + s.getID() + ", Description: " +
                s.getDescription() + ", Number in stock: " + s.number() +
                ", Number in package: " + s.getPackageNum());
    }

    //Polymorphic method that will take either object type
    public static String getBasicInfo(Stock s)
    {
        return("Stock ID: " + s.getID() +
                ", Stock Description: " + s.getDescription());
    }
}
