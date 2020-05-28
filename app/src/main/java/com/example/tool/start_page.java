package com.example.tool;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class start_page extends AppCompatActivity {

    private Movie mMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.gif1);

    }

}
