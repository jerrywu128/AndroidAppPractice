package com.example.tool;


import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int [] imgId ={R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,
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

    int[] point ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45,46,47,48,49,50,51,52};

    int HowManyCard = imgId.length;
    int use=0;
    int number[]=imgId;
    int point2[] = point;
    poker countpoint = new poker();

    private Button puls;
    private ImageView pokerback,you_poker,rightp;
    private TextView nn,nowpoint,inputpoint;


    android.animation.ObjectAnimator ObjectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        puls = (Button)findViewById(R.id.puls);
        pokerback = (ImageView)findViewById(R.id.pokerback);
        you_poker = (ImageView)findViewById(R.id.you_poker);
        nn = (TextView)findViewById(R.id.nn);
        rightp = (ImageView)findViewById(R.id.rightp);
        nowpoint =(TextView)findViewById(R.id.nowpoint);
        inputpoint=(TextView)findViewById(R.id.inputpoint);

        puls.setOnClickListener(pulsLin);


        if (use < HowManyCard) {

            int count = number.length - use;
            int p = (int) (Math.random() * count);
            you_poker.setImageResource(number[p]);

            use++;

            int list = count-1;
            nn.setText("剩餘牌數："+ list);

            float a = countpoint.Score(point2[p]);
            nowpoint.setText(String.valueOf(a));
            inputpoint.setText("input: "+point2[p]);

            ObjectAnimator= android.animation.ObjectAnimator.ofFloat(you_poker,"x",1200);
            ObjectAnimator.setDuration(1000);

            Handler handler = new Handler();
            ObjectAnimator.start();

            rightp.setImageResource(number[p]);
            countpoint.Score(point2[p]);

            int i;
            for (i = p; i < count - 1; i++) {
                point2[i] = point2[i+1];
                number[i] = number[i + 1];
            }



        }


    }


    private final Button.OnClickListener pulsLin = new
            Button.OnClickListener() {
                public void onClick(View v) {

                    if (use < HowManyCard) {

                        int count = number.length - use;
                        int p = (int) (Math.random() * count);
                        you_poker.setImageResource(number[p]);
                        use++;

                        int list = count-1;
                        nn.setText("剩餘牌數："+ list);

                        float a = countpoint.Score(point2[p]);
                        nowpoint.setText(String.valueOf(a));
                        inputpoint.setText("input: " + point2[p]);

                        int i;
                        for (i = p; i < count - 1; i++) {
                            point2[i] = point2[i+1];
                            number[i] = number[i + 1];
                        }

                    }
                }
            };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//是否按下返回鍵
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            ConfirmExit();//按返回鍵，執行退出確認
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void ConfirmExit(){//退出確認
        AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this);
        ad.setTitle("離開");
        ad.setMessage("確定要離開此程式嗎?");
        ad.setPositiveButton("是", new DialogInterface.OnClickListener() {//退出按鈕
            public void onClick(DialogInterface dialog, int i) {
                // TODO Auto-generated method stub
                MainActivity.this.finish();
            }
        });
        ad.setNegativeButton("否",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        ad.show();
    }

}
