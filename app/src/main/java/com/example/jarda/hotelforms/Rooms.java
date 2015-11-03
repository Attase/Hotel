package com.example.jarda.hotelforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Rooms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        luxury();
        ordinary();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void luxury(){
        Button english = (Button) findViewById(R.id.luxury);



        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Rooms.this, "Luxusní pokoje", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Rooms.this, Luxury.class));
            }

        });
    }

    private void ordinary(){
        Button english = (Button) findViewById(R.id.ordinary);



        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Rooms.this, "Obyčejné pokoje", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Rooms.this, Ordinary.class));
            }

        });
    }

}
