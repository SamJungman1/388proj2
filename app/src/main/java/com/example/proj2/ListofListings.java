package com.example.proj2;

import java.util.List;

public class ListofListings {
    /**
     * Null head element of this doubly linked list
     */
    private Listings head;

    /**
     * Current string that acts as the key which the list is sorted on
     */
    private String sortAttr;

    /**
     * Core data structure class for the listings
     */
    public ListofListings()
    {
        this.head = null;
    }

    /**
     * Adds a listing item to the data structure
     */
    public void add()
    {
        //TODO Priority 1
    }

    /**
     * Finds and deletes an element in the structure
     * @param owner
     * @param name
     */
    public void delete(String owner, String name)
    {
        //TODO Priority 4
    }

    /**
     * Sorts the Listings by a particular attribute such as owner, name, cost in alphabetical order
     * @param attr
     */
    public void sortBy(String attr)
    {
        //TODO Priority 2
    }

    /**
     * Returns a list of the closest entries to a particular search parameter, along the attribute of the current sort attr
     * @param entry
     * @return List<Listings> searchResults
     */
    public List<Listings> search(String entry)
    {
        //TODO Priority 3
        return null;
    }

    /**
     * Finds a given listing based on owner and name strings
     * @param owner
     * @param name
     */
    public void find(String owner, String name)
    {
        //TODO Priority 5
    }
}
