package com.example.proj2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button profileButton = (Button) findViewById(R.id.profile);
        Button myListings = (Button) findViewById(R.id.myList);
        Button otherListings = (Button) findViewById(R.id.otListings);

        final Fragment profileFrag = (profileFragment) getSupportFragmentManager().findFragmentById(R.id.profileFragment);
        final Fragment myListFrag = (myListFrag) getSupportFragmentManager().findFragmentById(R.id.myListFrag);
        final Fragment otListFrag = (otListFrag) getSupportFragmentManager().findFragmentById(R.id.otListFrag);

        FragmentManager fm = getSupportFragmentManager();


        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).show();
                ((myListFrag) myListFrag).gone();
                ((otListFrag) otListFrag).gone();
            }
        });

        myListings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).gone();
                ((myListFrag) myListFrag).show();
                ((otListFrag) otListFrag).gone();
            }
        });

        otherListings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((profileFragment) profileFrag).gone();
                ((myListFrag) myListFrag).gone();
                ((otListFrag) otListFrag).show();
            }
        });
    }
}