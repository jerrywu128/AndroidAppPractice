package com.example.tool;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class start_page extends AppCompatActivity {

    private Movie mMovie;
    private Button start_gmae,end_game,rule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.gif1);
        start_gmae = (Button)findViewById(R.id.startbutton);
        end_game = (Button)findViewById(R.id.endbutton);
        rule = (Button)findViewById(R.id.GameRules);

        start_gmae.setOnClickListener(start_gmaeLin);
        end_game.setOnClickListener(end_gameLin);
        rule.setOnClickListener(ruleLin);
    }


    private Button.OnClickListener
        start_gmaeLin = new Button.OnClickListener() {
        public void onClick(View v) {
            finish();
            Intent intent = new Intent();
            intent.setClass(start_page.this, MainActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener
        end_gameLin = new Button.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    };

    private Button.OnClickListener
        ruleLin = new Button.OnClickListener() {
        public void onClick(View v) {
            finish();
            Intent intent = new Intent();
            intent.setClass(start_page.this, rule_page.class);
            startActivity(intent);
        }
    };

}
