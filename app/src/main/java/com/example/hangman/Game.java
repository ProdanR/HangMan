package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Game extends AppCompatActivity {


    private ImageView cap;
    private ImageView corp_m, corp_f;
    private ImageView mana_d, mana_s;
    private ImageView picior_d, picior_s;

    private TextView message;
    private TextView word_t;
    private String in_word;
    private StringBuilder word;
    private int cnt = 6;

    private ArrayList<String> listData = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        word_t = (TextView) findViewById(R.id.word);
        message = (TextView) findViewById(R.id.message);
        cap = (ImageView) findViewById(R.id.cap);
        corp_f = (ImageView) findViewById(R.id.corp_f);
        corp_m = (ImageView) findViewById(R.id.corp_m);
        mana_d = (ImageView) findViewById(R.id.mana_d);
        mana_s = (ImageView) findViewById(R.id.mana_s);
        picior_d = (ImageView) findViewById(R.id.picior_d);
        picior_s = (ImageView) findViewById(R.id.picior_s);

        setListData();


        Random rand = new Random();
        int index = rand.nextInt(listData.size());
        in_word = listData.get(index);
        word = new StringBuilder(in_word);
        setWord();

        word_t.setText(word);
    }


    //  When you click a character(button) the function will check if it appears and make the button dissapear
    public void click(View view) {
        Button b = (Button) view;
        b.setVisibility(View.INVISIBLE);
        if (in_word.contains(b.getText().toString())) {
            appear(b.getText().charAt(0));
            check(cnt);
        } else {
            cnt--;
            draw(cnt);
            check(cnt);
        }
    }

    //  Set the word with '_' for display
    public void setWord() {
        for (int i = 2; i < in_word.length() - 2; i += 2)
            if (word.charAt(i) != in_word.charAt(0) && word.charAt(i) != in_word.charAt(in_word.length() - 1))
                word.setCharAt(i, '_');
    }


    //  Make characters appear in the dispalyed word
    public void appear(char c) {
        int index = in_word.indexOf(c);

        while (index != -1) {
            word.setCharAt(index, c);
            in_word = in_word.substring(0, index) + '.' + in_word.substring(index + 1);
            index = in_word.indexOf(c);
        }

        word_t.setText(word);
    }

    //  check the count to see what part of the body will be drawn
    public void draw(int k) {
        if (k == 5)
            cap.setVisibility(View.VISIBLE);

        if (k == 4) {
            if (MainActivity.getUser().female == true)
                corp_f.setVisibility(View.VISIBLE);
            else
                corp_m.setVisibility(View.VISIBLE);
        }

        if (k == 3)
            mana_s.setVisibility(View.VISIBLE);
        if (k == 2)
            mana_d.setVisibility(View.VISIBLE);
        if (k == 1)
            picior_s.setVisibility(View.VISIBLE);
        if (k == 0)
            picior_d.setVisibility(View.VISIBLE);


    }


    //  it will start a new game
    public void reset(View view) {
        startActivity(new Intent(Game.this, Game.class));
        Game.this.finish();
    }


    //  Check to see if you win or lost (+show messages)
    public void check(int k) {
        if (word.indexOf("_") == -1) {
            AlertDialog.Builder win = new AlertDialog.Builder(this);
            win.setTitle("Ai castigat!");
            win.setMessage("Armata te felicita, " + MainActivity.getUser().name);
            win.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(Game.this, Game.class));
                    Game.this.finish();
                }
            });
            win.create().show();
        }

        if (k == 0) {
            AlertDialog.Builder lose = new AlertDialog.Builder(this);
            lose.setTitle("Ai pierdut!");
            lose.setMessage("Armata te-a spanzurat " + MainActivity.getUser().name + "!");
            lose.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(Game.this, Game.class));
                    Game.this.finish();
                }
            });
            lose.create().show();
        }

        message.setText("Mai ai " + cnt + " incercari");
    }



    //  set data
    private void setListData() {
        listData.add("I T L A B S");
        listData.add("A M E R I C A N");
        listData.add("F A C U L T A T E");
        listData.add("L A P T O P");
        listData.add("T A S T A T U R A");
        listData.add("P I R A T I");
        listData.add("T A N C U R I");
        listData.add("B A T A L I O N ");
        listData.add("V A C A N T A");
        listData.add("I N T E R N S H I P");
    }

}