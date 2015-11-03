package com.example.jarda.hotelforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reservation extends AppCompatActivity {
    EditText name;
    EditText surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupMessageButton();
        setupEnglish();


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

    private void setupMessageButton(){
        Button messageButton = (Button) findViewById(R.id.odeslat);
        name=(EditText)findViewById(R.id.name);
        surname=(EditText)findViewById(R.id.surname);
        final EditText email=(EditText)findViewById(R.id.email);
        final EditText telefon=(EditText)findViewById(R.id.telefon);


        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(name.getText().length()<1){
                    name.setError("Jméno není vyplněno");
                    name.requestFocus();
                }
                else if (surname.getText().length()<1){
                    surname.setError("Příjmení není vyplněno");
                    surname.requestFocus();

                }
                else if(!validateEmail(email.getText().toString())){
                    email.setError("Špatně zadaný email");
                    email.requestFocus();

                }
                else if(!validateCislo(telefon.getText().toString())){
                    telefon.setError("Špatně zadaný telefon");
                    telefon.requestFocus();

                }
                else{
                    Toast.makeText(Reservation.this, "Odesláno!", Toast.LENGTH_LONG).show();

                }



            }



        });
    }

    private void setupEnglish(){
        Button english = (Button) findViewById(R.id.english);



        english.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(Reservation.this, "English", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Reservation.this, English.class));
            }







        });
    }


    private boolean validateEmail(String email) {
        String znaky = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(znaky);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validateCislo(String cislo) {
        String telefon= "^(\\00420)? ?[1-9][0-9]{2} ?[0-9]{3} ?[0-9]{3}$" ;
        Pattern pattern = Pattern.compile(telefon);
        Matcher matcher = pattern.matcher(cislo);
        return matcher.matches();
    }

}
