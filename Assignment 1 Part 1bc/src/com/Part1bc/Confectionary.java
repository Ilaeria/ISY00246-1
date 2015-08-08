package com.Part1bc;

public class Confectionary implements Stock
{
    private int stockID = 0;
    private String description = "";
    private int number = 0;
    private String expiry = "";

    public Confectionary(int id, String d, int n, String e)
    {
        stockID = id;
        description = d;
        number = n;
        expiry = e;
    }

    public void setNumber(int n)
    {
        number = n;
    }

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
