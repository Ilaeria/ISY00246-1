package com.Part1bcd;

public class SoftDrink implements Stock
{
    private int stockID = 0;
    private String description = "";
    private int number = 0;
    private int packageNum = 0;

    //Constructor
    public SoftDrink(int id, String d, int n, int p)
    {
        stockID = id;
        description = d;
        number = n;
        packageNum = p;
    }

    //Only number of stock can be set
    public void setNumber(int n)
    {
        number = n;
    }

    //Getters
    public int number()
    {
        return number;
    }

    public int getID()
    {
        return stockID;
    }

    public String getDescription()
    {
        return description;
    }

    public int getPackageNum()
    {
        return packageNum;
    }
}
