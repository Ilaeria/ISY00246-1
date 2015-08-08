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
	    Confectionary whittakers = new Confectionary(111,"Whittaker's chocolate",11,"01/01/2020");
        Confectionary snakes = new Confectionary(222,"Snakes lollies",22,"02/02/2020");
        Confectionary juicyfruit = new Confectionary(333,"Juicy Fruit gum",33,"03/03/2020");

        System.out.println("Initial stock numbers:");
        System.out.println("Stock ID: " + whittakers.getID() + ", Description: " +
                whittakers.getDescription() + ", Number in stock: " + whittakers.number() +
                ", Expiry date: " + whittakers.getExpiry());
        System.out.println("Stock ID: " + snakes.getID() + ", Description: " +
                snakes.getDescription() + ", Number in stock: " + snakes.number() +
                ", Expiry date: " + snakes.getExpiry());
        System.out.println("Stock ID: " + juicyfruit.getID() + ", Description: " +
                juicyfruit.getDescription() + ", Number in stock: " + juicyfruit.number() +
                ", Expiry date: " + juicyfruit.getExpiry());

        whittakers.setNumber(444);
        snakes.setNumber(555);
        juicyfruit.setNumber(666);

        System.out.println();
        System.out.println("Updated stock numbers:");
        System.out.println("Stock ID: " + whittakers.getID() + ", Description: " +
                whittakers.getDescription() + ", Number in stock: " + whittakers.number() +
                ", Expiry date: " + whittakers.getExpiry());
        System.out.println("Stock ID: " + snakes.getID() + ", Description: " +
                snakes.getDescription() + ", Number in stock: " + snakes.number() +
                ", Expiry date: " + snakes.getExpiry());
        System.out.println("Stock ID: " + juicyfruit.getID() + ", Description: " +
                juicyfruit.getDescription() + ", Number in stock: " + juicyfruit.number() +
                ", Expiry date: " + juicyfruit.getExpiry());
    }
}
