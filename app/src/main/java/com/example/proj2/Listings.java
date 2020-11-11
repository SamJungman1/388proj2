package com.example.proj2;

import java.util.AbstractMap;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Class acts as node for List of Listings which will serve as the main data structure class for the listings in the project
 */
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
     * Next node in list operation
     */
    private Listings next;

    /**
     * Previous node in list operation
     */
    private Listings prev;

    /**
     * String containing all hashtags for this listing, each hashtag must start with a # symbol to be counted, any punctuation will be included in the name of the hashtag
     */
    private String hashtags;

    /**
     * List of all attributes so the nodes can be sorted along multiple parts of the node
     */
    private HashMap<String, String> attributes;

    /**
     * Constructer for Listing Item
     * @param owner of Item
     * @param cost of Item
     * @param name of Item
     * @param description of Item
     */
    public Listings(String owner, double cost, String name, String description, String hashtags)
    {
        this.owner = owner;
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.available = true;
        this.interested = 0;
        this.next = null;
        this.prev = null;
        this.hashtags = hashtags;
        this.attributes = new HashMap<String, String>();
        attributes.put("owner", this.owner);
        attributes.put("cost", (new Double(this.cost).toString()));
        attributes.put("name", this.name);
        attributes.put("description", this.description);
        String arr[] = hashtags.split("#");
        for(int i = 0; i < arr.length; i++)
        {
            attributes.put((new Integer(i)).toString(), arr[i]);
        }
    }

    /**
     * Sets owner of Item
     * @param owner of Item
     */
    public void setOwner(String owner)
    {
        this.owner = owner;
        attributes.put("owner", this.owner);
    }

    /**
     * Sets cost of Item
     * @param cost of Item
     */
    public void setCost(Double cost)
    {
        this.cost = cost;
        attributes.put("cost", (new Double(this.cost).toString()));
    }

    /**
     * Sets name of Item
     * @param name of Item
     */
    public void setName(String name)
    {
        this.name = name;
        attributes.put("name", this.name);
    }

    /**
     * Sets description of Item
     * @param description of Item
     */
    public void setDescription(String description)
    {
        this.description = description;
        attributes.put("description", this.description);
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
     * Sets next node in the data structure
     * @param next
     */
    public void setNext(Listings next)
    {
        this.next = next;
    }

    /**
     * Sets previous node in data structure
     * @param prev
     */
    public void setPrev(Listings prev)
    {
        this.prev = prev;
    }

    /**
     * Sets the hashtag string
     * @param hashtags
     */
    public void setHashtags(String hashtags)
    {
        this.hashtags = hashtags;
        String arr[] = hashtags.split("#");
        for(int i = 0; i < arr.length; i++)
        {
            attributes.put((new Integer(i)).toString(), arr[i]);
        }
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

    /**
     * Gets next node in list
     * @return Listings next
     */
    public Listings getNext()
    {
        return this.next;
    }

    /**
     * Gets prev node in list
     * @return Listings prev
     */
    public Listings getPrev()
    {
        return this.prev;
    }

    /**
     * Gets string containing all hashtags
     * @return String hashtags
     */
    public String getHashtags()
    {
        return this.hashtags;
    }

    /**
     * Gets attribute map for this node
     * @return Abstract.SimpleEntry<String, String>
     */
    public HashMap<String, String> getAttributes()
    {
        return this.attributes;
    }
}
