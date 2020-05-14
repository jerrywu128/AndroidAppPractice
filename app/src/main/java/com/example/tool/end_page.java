package com.example.tool;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class end_page extends AppCompatActivity {

    int [] imgId ={R.drawable.back,R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,
            R.drawable.f6, R.drawable.f7,R.drawable.f8,R.drawable.f9,R.drawable.f10,
            R.drawable.f11,R.drawable.f12,R.drawable.f13,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.h11,R.drawable.h12,R.drawable.h13,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.d11,R.drawable.d12,R.drawable.d13,
            R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,
            R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b10,
            R.drawable.b11,R.drawable.b12,R.drawable.b13,};

    private ImageView[] your_card = new ImageView[5];
    private ImageView[] computer_card = new ImageView[5];
    private Button endgmae, restart;
    private TextView WinOrLose, your_point, computer_point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_page);

        your_card[0] = (ImageView)findViewById(R.id.your_card1);
        your_card[1] = (ImageView)findViewById(R.id.your_card2);
        your_card[2] = (ImageView)findViewById(R.id.your_card3);
        your_card[3] = (ImageView)findViewById(R.id.your_card4);
        your_card[4] = (ImageView)findViewById(R.id.your_card5);
        computer_card[0] = (ImageView)findViewById(R.id.computer_card1);
        computer_card[1] = (ImageView)findViewById(R.id.computer_card2);
        computer_card[2] = (ImageView)findViewById(R.id.computer_card3);
        computer_card[3] = (ImageView)findViewById(R.id.computer_card4);
        computer_card[4] = (ImageView)findViewById(R.id.computer_card5);
        WinOrLose = (TextView)findViewById(R.id.WinOrLose);
        your_point = (TextView)findViewById(R.id.your_point);
        computer_point = (TextView)findViewById(R.id.computer_point);
        endgmae = (Button) findViewById(R.id.endgame);
        endgmae.setOnClickListener(endgmaeLin);
        restart = (Button)findViewById(R.id.restart);
        restart.setOnClickListener(reLin);

        Bundle bundle = getIntent().getExtras();
        float Y_point = bundle.getFloat("nowpoint");
        int use_card[] = bundle.getIntArray("use_card");
        //int computer_use_card[] = bundle.getIntArray("computer_use_card");

        for(int i =0;i < 5; i++)
        {
            your_card[i].setImageResource(imgId[use_card[i]]);
        }

        /*
        for(int i =0;i < 5; i++)
        {
            computer_card[i].setImageResource(imgId[computer_use_card[i]]);
        }
        */

        your_point.setText("你的點數："+Y_point);

        if(Y_point > 10.5)
        {
            WinOrLose.setText("爆點！Lose");
        }

    }

    private Button.OnClickListener endgmaeLin =
            new Button.OnClickListener(){
                public void onClick(View V){
                    finish();
                }
            };

    private Button.OnClickListener reLin =
            new Button.OnClickListener(){
                public void onClick(View V){
                    finish();
                    Intent intent = new Intent();
                    intent.setClass(end_page.this, MainActivity.class);
                    startActivity(intent);
                }
            };

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
