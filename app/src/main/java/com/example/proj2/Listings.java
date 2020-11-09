package com.example.proj2;

public class Listings {
    /**
     * Owner of listing
     */
    private String owner;

    /**
     * Cost of item
     */
    private double cost;

    /**
     * True/false if item is still available
     */
    private boolean available;

    /**
     * Name of item
     */
    private String name;

    /**
     * Description of item
     */
    private String description;

    /**
     * Tally count of interested party
     */
    private int interested;

    /**
     * Constructer for Listing Item
     * @param owner of Item
     * @param cost of Item
     * @param name of Item
     * @param description of Item
     */
    public Listings(String owner, double cost, String name, String description)
    {
        this.owner = owner;
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.available = true;
        this.interested = 0;
    }

    /**
     * Sets owner of Item
     * @param owner of Item
     */
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    /**
     * Sets cost of Item
     * @param cost of Item
     */
    public void setCost(Double cost)
    {
        this.cost = cost;
    }

    /**
     * Sets name of Item
     * @param name of Item
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Sets description of Item
     * @param description of Item
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Sets item to available
     */
    public void setAvailable()
    {
        this.available = true;
    }

    /**
     * Sets item to unavailable
     */
    public void setUnavailable()
    {
        this.available = false;
    }

    /**
     * Increments number of interested party
     */
    public void incInterested()
    {
        this.interested++;
    }

    /**
     * Decrements number of interested party
     */
    public void decInterested()
    {
        this.interested--;
    }

    /**
     * Returns owner of Item
     * @return String owner
     */
    public String getOwner()
    {
        return this.owner;
    }

    /**
     * Returns cost of item
     * @return double cost
     */
    public double getCost()
    {
        return this.cost;
    }

    /**
     * Returns name of Item
     * @return String name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns description of Item
     * @return String description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Returns availablity of Item
     * @return boolean available
     */
    public boolean getAvailablity()
    {
        return this.available;
    }

    /**
     * Returns interested number of parties for Item
     * @return String item
     */
    public int getInterested()
    {
        return this.interested;
    }


}
