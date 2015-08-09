package com.Part1bcd;

public class Confectionary implements Stock
{
    private int stockID = 0;
    private String description = "";
    private int number = 0;
    private String expiry = "";

    //Constructor
    public Confectionary(int id, String d, int n, String e)
    {
        stockID = id;
        description = d;
        number = n;
        expiry = e;
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

    public String getExpiry()
    {
        return expiry;
    }
}
