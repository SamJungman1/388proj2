package com.example.proj2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Main Activity Manager
        Button profileButton = (Button) findViewById(R.id.profile);
        Button myListings = (Button) findViewById(R.id.myList);
        Button otherListings = (Button) findViewById(R.id.otListings);

        final Fragment profileFrag = (profileFragment) getSupportFragmentManager().findFragmentById(R.id.profileFragment);
        final Fragment myListFrag = (myListFrag) getSupportFragmentManager().findFragmentById(R.id.myListFrag);
        final Fragment otListFrag = (otListFrag) getSupportFragmentManager().findFragmentById(R.id.otListFrag);
        final Fragment newListFrag = (newListing) getSupportFragmentManager().findFragmentById(R.id.newListing);
        final Fragment myListing = (myListing) getSupportFragmentManager().findFragmentById(R.id.myListing);
        final Fragment otListing = (otherListing) getSupportFragmentManager().findFragmentById(R.id.otherListing);

        FragmentManager fm = getSupportFragmentManager();

        ((profileFragment) profileFrag).show();
        ((myListFrag) myListFrag).gone();
        ((otListFrag) otListFrag).gone();
        ((newListing) newListFrag).gone();
        ((otherListing) otListing).gone();
        ((myListing) myListing).gone();


        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).show();
                ((myListFrag) myListFrag).gone();
                ((otListFrag) otListFrag).gone();
                ((newListing) newListFrag).gone();
                ((otherListing) otListing).gone();
                ((myListing) myListing).gone();
            }
        });

        myListings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).gone();
                ((myListFrag) myListFrag).show();
                ((newListing) newListFrag).gone();
                ((otListFrag) otListFrag).gone();
                ((otherListing) otListing).gone();
                ((myListing) myListing).gone();
            }
        });

        otherListings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).gone();
                ((myListFrag) myListFrag).gone();
                ((otListFrag) otListFrag).show();
                ((newListing) newListFrag).gone();
                ((otherListing) otListing).gone();
                ((myListing) myListing).gone();
            }
        });




        //Other Listings Fragment Manager
        final Spinner searchSpinner = (Spinner) findViewById(R.id.searchAttr);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.searchCatagories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchSpinner.setAdapter(adapter);
        final String[] searchAttr = new String[1];
        searchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchAttr[0] = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                searchAttr[0] = parent.getItemAtPosition(0).toString();
            }
        });

        populateOtherListings(searchAttr[0], null);

        final EditText searchEntry = (EditText) findViewById(R.id.searchEntry);
        Button searchButton = (Button) findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateOtherListings(searchAttr[0], searchEntry.getText().toString());
            }
        });



        //My listings fragment manager
        populateMyListings();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.newListingButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).gone();
                ((myListFrag) myListFrag).gone();
                ((otListFrag) otListFrag).gone();
                ((newListing) newListFrag).show();
                ((otherListing) otListing).gone();
                ((myListing) myListing).gone();
            }
        });

        //New listing fragment manager
        final EditText newItemName = (EditText) findViewById(R.id.itemName);
        final EditText newItemDesc = (EditText) findViewById(R.id.itemDesc);
        final EditText newItemCost = (EditText) findViewById(R.id.itemCost);
        final EditText newItemHashtags = (EditText) findViewById(R.id.hashtags);
        Button newItemButton = (Button) findViewById(R.id.newItemButton);

        newItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewListing(newItemName.getText().toString(), newItemDesc.getText().toString(), newItemHashtags.getText().toString(), Double.parseDouble(newItemCost.getText().toString()));
                populateMyListings();
                ((profileFragment) profileFrag).gone();
                ((myListFrag) myListFrag).show();
                ((newListing) newListFrag).gone();
                ((otListFrag) otListFrag).gone();
                ((otherListing) otListing).gone();
                ((myListing) myListing).gone();
            }
        });
    }

    /**
     * Populates the recyclyerview in the OTListing fragment with a sorted list of items from the backend
     * @param attr
     * @param searchEntry
     */
    public void populateOtherListings(String attr, String searchEntry)
    {
        //TODO, if search entry is null, then just return a sorted list of all items
    }

    /**
     * Populates the recyclerview in the myListings fragment
     */
    public void populateMyListings()
    {
        //TODO, should grab user data and then populate all listings that user has made
        if(username == null)
            return;
    }

    /**
     * Creates a new listing under current logged in user
     * @param name
     * @param desc
     * @param hashtags
     * @param cost
     */
    public void createNewListing(String name, String desc, String hashtags, double cost)
    {
        if(username != null)
        {
            //TODO send listing to backend
        }
    }

    public void showOtherListing()
}