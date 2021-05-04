package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText name_c,age_c;
    private Button male_b,female_b;

    private String name, age;
    boolean male=false,female=false;
    private static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_c= (EditText) findViewById(R.id.username);
        age_c= (EditText) findViewById(R.id.age);

        male_b= (Button) findViewById(R.id.male);
        female_b= (Button) findViewById(R.id.female);

    }



    public void setFemale(View view) {
        this.male=false;
        this.female=true;
        male_b.setBackgroundColor(Color.rgb(86, 128, 233));
        female_b.setBackgroundColor(Color.rgb(93, 200, 228));
    }

    public void setMale(View view) {
        this.male=true;
        this.female=false;
        male_b.setBackgroundColor(Color.rgb(93, 200, 228));
        female_b.setBackgroundColor(Color.rgb(86, 128, 233));
    }

    public void play(View view) {

        name = name_c.getText().toString();
        age = age_c.getText().toString();
        if (name.isEmpty() || age.isEmpty() || (male==false && female==false))
            error();
        else {
            user = new User(age, name, male, female);
            Intent gameIntent = new Intent(MainActivity.this, Game.class);
            startActivity(gameIntent);

        }
    }

    public void error(){
        AlertDialog.Builder error = new AlertDialog.Builder(this);
        error.setTitle("Date invalide!");
        error.setMessage("Completati toate campurile");
        error.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        error.create().show();
    }

    public static User getUser() {
        return user;
    }


}