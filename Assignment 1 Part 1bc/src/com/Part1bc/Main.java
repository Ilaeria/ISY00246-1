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

        System.out.println(whittakers.getID() + " " + whittakers.getDescription() + " " +
                whittakers.number() + " " + whittakers.getExpiry());
        System.out.println(snakes.getID() + " " + snakes.getDescription() + " " +
                snakes.number() + " " + snakes.getExpiry());
        System.out.println(juicyfruit.getID() + " " + juicyfruit.getDescription() + " " +
                juicyfruit.number() + " " + juicyfruit.getExpiry());
    }
}
