package com.example.tool;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Path;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
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
    int countri=0;
    int counttr_computer = 1;
    int Timefuntionpoker[]={0};
    int toX=759;
    int toY=-259;

    int[] use_card = {0,0,0,0,0};
    int[] computer_use_card = {0,0,0,0,0};

    float ComputerNowPoint=0;

    Bundle bundle = new Bundle();

    poker countpoint = new poker();
    AI AIpoint = new AI();
    private Button puls,stop;
    private ImageView pokerback,you_poker;
    private ImageView[] rightp = new ImageView[5];
    private ImageView[] lefttp = new ImageView[5];
    private TextView nn,nowpoint,inputpoint,yy,computerpoint;


    android.animation.ObjectAnimator ObjectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        puls = (Button)findViewById(R.id.puls);
        pokerback = (ImageView)findViewById(R.id.pokerback);
        you_poker = (ImageView)findViewById(R.id.you_poker);
        nn = (TextView)findViewById(R.id.nn);
        stop = (Button)findViewById(R.id.stop);
        computerpoint = (TextView)findViewById(R.id.computerpoint);

        rightp[0] = (ImageView)findViewById(R.id.rightp);
        rightp[1] = (ImageView)findViewById(R.id.rightp2);
        rightp[2] = (ImageView)findViewById(R.id.rightp3);
        rightp[3] = (ImageView)findViewById(R.id.rightp4);
        rightp[4] = (ImageView)findViewById(R.id.rightp5);

        lefttp[0] = (ImageView)findViewById(R.id.lefttp);
        lefttp[1] = (ImageView)findViewById(R.id.lefttp2);
        lefttp[2] = (ImageView)findViewById(R.id.lefttp3);
        lefttp[3] = (ImageView)findViewById(R.id.lefttp4);
        lefttp[4] = (ImageView)findViewById(R.id.lefttp5);

        nowpoint =(TextView)findViewById(R.id.nowpoint);
        inputpoint=(TextView)findViewById(R.id.inputpoint);

        puls.setOnClickListener(pulsLin);
        stop.setOnClickListener(stopLin);

        if (use < HowManyCard) {

            int count = number.length - use;
            int p  =(int) (Math.random() * count);
            Timefuntionpoker[0]= number[p];
            you_poker.setImageResource(number[p]);

            //rightp[0].setImageResource(number[Timefuntionpoker]);

            use++;

            int list = count-1;
            nn.setText("剩餘牌數："+ list);

            use_card[0] = point2[p];

            float a = countpoint.Score(point2[p],0);
            nowpoint.setText("目前點數： "+String.valueOf(a));
/*
            android.graphics.Path path = new Path();
            path.arcTo(500f,0f,1000f,800f,180f,140f,true);
            ObjectAnimator= android.animation.ObjectAnimator.ofFloat(you_poker,View.X,View.Y,path);
            ObjectAnimator.setDuration(1000);
            ObjectAnimator.start();
*/
            Animation am = new TranslateAnimation(0,toX,0,toY);
            am.setDuration(1800);
            you_poker.setAnimation(am);
            am.startNow();

            puls.setEnabled(false);
            new Handler().postDelayed(new Runnable(){
                public void run() {
                    rightp[0].setImageResource(Timefuntionpoker[0]);
                    puls.setEnabled(true);
                    you_poker.setImageResource(R.drawable.back);
                }
            }, 1800);


            countpoint.Score(point2[p],0);

            int i;
            for (i = p; i < count - 1; i++) {
                point2[i] = point2[i+1];
                number[i] = number[i + 1];
            }
        }

        if (use < HowManyCard) {

            int count = number.length - use;
            int p = (int) (Math.random() * count);

            use++;

            ComputerNowPoint = countpoint.Score(point2[p],1);
            computerpoint.setText("目前點數："+String.valueOf(ComputerNowPoint));

            lefttp[0].setImageResource(number[p]);

            int list = count - 1;
            nn.setText("剩餘牌數：" + list);

            computer_use_card[0] = point2[p];

            int i;
            for (i = p; i < count - 1; i++) {
                point2[i] = point2[i+1];
                number[i] = number[i + 1];
            }
        }

    }

    private final Button.OnClickListener
            pulsLin = new Button.OnClickListener() {
                public void onClick(View v) {
                    puls.setEnabled(false);
                    if (use < HowManyCard) {

                        int count = number.length - use;
                        int p = (int) (Math.random() * count);
                        Timefuntionpoker[0]= number[p];
                        countri++;

                        you_poker.setImageResource(number[p]);
                        use++;


                        new Handler().postDelayed(new Runnable(){
                            public void run() {
                                rightp[countri].setImageResource(Timefuntionpoker[0]);
                                you_poker.setImageResource(R.drawable.back);
                                puls.setEnabled(true);
                            }
                        }, 1800);



                        use_card[countri] = point2[p];


                        int list = count-1;
                        nn.setText("剩餘牌數："+ list);

                        float a = countpoint.Score(point2[p],0);

                        if(a<=10.5)
                            nowpoint.setText("目前點數： "+ String.valueOf(a));
                        else {

                            finish();
                            Intent intent = new Intent();
                            intent.setClass(MainActivity.this, end_page.class);

                            bundle.putFloat("nowpoint",a);
                            bundle.putIntArray("use_card",use_card);
                            bundle.putFloat("C_point",ComputerNowPoint);
                            bundle.putIntArray("computer_use_card",computer_use_card);

                            intent.putExtras(bundle);
                            startActivity(intent);

                        }
                        toX-=60;
                        toY+=45;
                        Animation am = new TranslateAnimation(0,toX,0,toY);
                        am.setDuration(1800);
                        you_poker.setAnimation(am);
                        am.startNow();


                        int i;
                        for (i = p; i < count - 1; i++) {
                            point2[i] = point2[i+1];
                            number[i] = number[i + 1];
                        }


                    }
                }
            };
    private Button.OnClickListener
            stopLin = new Button.OnClickListener() {
        public void onClick(View v) {

            stop.setEnabled(false);
            puls.setEnabled(false);

            boolean determine = AIpoint.determine(ComputerNowPoint);

            while (determine)
            {
                if (use < HowManyCard) {

                    int count = number.length - use;
                    int p = (int) (Math.random() * count);
                    you_poker.setImageResource(number[p]);
                    use++;
                    lefttp[counttr_computer].setImageResource(number[p]);
                    computer_use_card[counttr_computer] = point2[p];

                    counttr_computer++;
                    int list = count - 1;
                    nn.setText("剩餘排數" + list);

                    ComputerNowPoint = countpoint.Score(point2[p], 1);

                    if (ComputerNowPoint <= 10.5) {
                        determine = AIpoint.determine(ComputerNowPoint);
                        computerpoint.setText("目前點數："+ String.valueOf(ComputerNowPoint));
                    } else {
                        break;
                    }

                    int i;
                    for (i = p; i < count - 1; i++) {
                            point2[i] = point2[i + 1];
                            number[i] = number[i + 1];
                    }

                }
            }

            finish();
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, end_page.class);

            //Bundle bundle_Computer = new Bundle();

            float a = countpoint.Score(0,2);
            bundle.putFloat("nowpoint",a);
            bundle.putIntArray("use_card",use_card);
            bundle.putFloat("C_point",ComputerNowPoint);
            bundle.putIntArray("computer_use_card",computer_use_card);

            intent.putExtras(bundle);
            startActivity(intent);

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
