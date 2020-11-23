package com.example.proj2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    String loggedInKey;
    String loggedInEmail;
    final String urlBase = "http://10.0.2.2:8080/";
    RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRequestQueue = Volley.newRequestQueue(getApplicationContext());

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
        final Fragment otProfile = (otherProfile) getSupportFragmentManager().findFragmentById(R.id.otherProfileFrag);
        final Fragment newProfile = (newAccount) getSupportFragmentManager().findFragmentById(R.id.newAccount);
        final Fragment login = (loginForm) getSupportFragmentManager().findFragmentById(R.id.loginFrag);
        final Fragment addRating = (addRating) getSupportFragmentManager().findFragmentById(R.id.newRating);

        FragmentManager fm = getSupportFragmentManager();

        ((profileFragment) profileFrag).show();
        ((myListFrag) myListFrag).gone();
        ((otListFrag) otListFrag).gone();
        ((newListing) newListFrag).gone();
        ((otherListing) otListing).gone();
        ((myListing) myListing).gone();
        ((otherProfile) otProfile).gone();
        ((newAccount) newProfile).gone();
        ((loginForm) login).gone();
        ((addRating) addRating).gone();

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).show();
                ((myListFrag) myListFrag).gone();
                ((otListFrag) otListFrag).gone();
                ((newListing) newListFrag).gone();
                ((otherListing) otListing).gone();
                ((myListing) myListing).gone();
                ((otherProfile) otProfile).gone();
                ((newAccount) newProfile).gone();
                ((loginForm) login).gone();
                ((addRating) addRating).gone();
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
                ((otherProfile) otProfile).gone();
                ((newAccount) newProfile).gone();
                ((loginForm) login).gone();
                ((addRating) addRating).gone();
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
                ((otherProfile) otProfile).gone();
                ((newAccount) newProfile).gone();
                ((loginForm) login).gone();
                ((addRating) addRating).gone();
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
                ((otherProfile) otProfile).gone();
                ((newAccount) newProfile).gone();
                ((loginForm) login).gone();
                ((addRating) addRating).gone();
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
                ((otherProfile) otProfile).gone();
                ((newAccount) newProfile).gone();
                ((loginForm) login).gone();
                ((addRating) addRating).gone();
            }
        });

        //My Profile Fragment Manager
        updateMyProfile("", "" , "", "", "", "", "", "", "", "", 0.0);
        Button createAccountButton = (Button) findViewById(R.id.newAccountButton);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).gone();
                ((myListFrag) myListFrag).gone();
                ((newListing) newListFrag).gone();
                ((otListFrag) otListFrag).gone();
                ((otherListing) otListing).gone();
                ((myListing) myListing).gone();
                ((otherProfile) otProfile).gone();
                ((newAccount) newProfile).show();
                ((loginForm) login).gone();
                ((addRating) addRating).gone();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).gone();
                ((myListFrag) myListFrag).gone();
                ((newListing) newListFrag).gone();
                ((otListFrag) otListFrag).gone();
                ((otherListing) otListing).gone();
                ((myListing) myListing).gone();
                ((otherProfile) otProfile).gone();
                ((newAccount) newProfile).gone();
                ((loginForm) login).show();
                ((addRating) addRating).gone();
            }
        });

        //Create Account Fragment Manager

        //Login Fragment Manager
        Button loginAcc = (Button) findViewById(R.id.loginAcc);
        loginAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailLogin = (EditText) findViewById(R.id.emailLogin);
                EditText passLogin = (EditText) findViewById(R.id.passLogin);

                String email = emailLogin.getText().toString();
                String pass = passLogin.getText().toString();

                final JSONObject loginJson = new JSONObject();
                try {
                    loginJson.put("email", email);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    loginJson.put("password", pass);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest login = new JsonObjectRequest(Request.Method.GET, urlBase + "/User/Login", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }

                    @Override
                    public byte[] getBody() {
                        try {
                            return loginJson == null ? null : loginJson.toString().getBytes("utf-8");
                        } catch (UnsupportedEncodingException uee) {
                            //Log.v("Unsupported Encoding while trying to get the bytes", data);
                            return null;
                        }
                    }

                };;
                mRequestQueue.add(login);
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
        if(loggedInEmail == null)
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
        if(loggedInEmail != null)
        {
            //TODO send listing to backend
        }
    }

    public void showOtherListing(String name, String owner, String desc, double cost, boolean available, int interested, String hashtags)
    {
        TextView otListingName = (TextView) findViewById(R.id.otItemName);
        TextView otListingOwner = (TextView) findViewById(R.id.otItemOwner);
        TextView otListingDesc = (TextView) findViewById(R.id.otItemDesc);
        TextView otListingCost = (TextView) findViewById(R.id.otItemCost);
        TextView otListingInter = (TextView) findViewById(R.id.otItemInterested);
        TextView otListingAva = (TextView) findViewById(R.id.otItemAvailable);
        TextView otListingHash = (TextView) findViewById(R.id.otHashtags);

        otListingName.setText("Name: " + name);
        otListingOwner.setText("Owner: " + owner);
        otListingDesc.setText("Description: " + desc);
        otListingCost.setText("Cost: " + cost);
        otListingInter.setText("Available: " + available);
        otListingAva.setText("Interested: " + interested);
        otListingHash.setText("Hashtags: " + hashtags);

    }

    public void showMyListing(String name, String desc, double cost, boolean available, int interested, String hashtags)
    {
        TextView myListingName = (TextView) findViewById(R.id.myItemName);
        TextView myListingDesc = (TextView) findViewById(R.id.myItemDesc);
        TextView myListingCost = (TextView) findViewById(R.id.myItemCost);
        TextView myListingInter = (TextView) findViewById(R.id.myItemInterested);
        TextView myListingAva = (TextView) findViewById(R.id.myItemAvailable);
        TextView myListingHash = (TextView) findViewById(R.id.myHashtags);

        myListingName.setText("Name: " + name);
        myListingDesc.setText("Description: " + desc);
        myListingCost.setText("Cost: " + cost);
        myListingInter.setText("Available: " + available);
        myListingAva.setText("Interested: " + interested);
        myListingHash.setText("Hashtags: " + hashtags);
    }

    public void updateMyProfile(String username, String tag, String email, String fn, String ln, String country, String city, String state, String addr, String zip, Double rating)
    {
        TextView myUsername = (TextView) findViewById(R.id.myUsername);
        TextView myTag = (TextView) findViewById(R.id.myTag);
        TextView myEmail = (TextView) findViewById(R.id.myEmail);
        TextView myFN = (TextView) findViewById(R.id.myFN);
        TextView myLN = (TextView) findViewById(R.id.myLN);
        TextView myCountry = (TextView) findViewById(R.id.myCountry);
        TextView myCity = (TextView) findViewById(R.id.myCity);
        TextView myState = (TextView) findViewById(R.id.myState);
        TextView myAddr = (TextView) findViewById(R.id.myAddr);
        TextView myZip = (TextView) findViewById(R.id.myZip);
        TextView myRating = (TextView) findViewById(R.id.myRating);

        myUsername.setText("Username: " + username);
        myTag.setText("Tag: " + tag);
        myEmail.setText("Email: " + email);
        myFN.setText("First Name: " + fn);
        myLN.setText("Last Name: " + ln);
        myCountry.setText("Country: " + country);
        myCity.setText("City: " + city);
        myState.setText("State: " + state);
        myAddr.setText("Address: " + addr);
        myZip.setText("ZIP: " + zip);
        myRating.setText("Rating: " + rating);
    }
}