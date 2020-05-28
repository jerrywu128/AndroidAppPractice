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

public class MainActivity  extends AppCompatActivity {

    int [] point = new int[52];

    int totaluse=0,PlayerUse=0,ComputerUse=0;

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
    Draw_card card = new Draw_card();

    private Button puls,stop;
    private ImageView pokerback,you_poker;
    private ImageView[] rightp = new ImageView[5];
    private ImageView[] lefttp = new ImageView[5];
    private TextView nn,nowpoint,inputpoint,yy,computerpoint;


    android.animation.ObjectAnimator ObjectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        finish();
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, start_page.class);
        startActivity(intent);
*/
        setContentView(R.layout.activity_main);

        for(int i= 0;i<52;i++){
            point[i]=i+1;
        }

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
//----------------玩家抽卡---------
        int [] draw_card = card.Draw_card();
// 0==point,1==number,2==use how many card

        if (totaluse < draw_card[2]) {

            Timefuntionpoker[0]= draw_card[1];
            you_poker.setImageResource(draw_card[1]);

            totaluse++;
            PlayerUse++;

            use_card[0] = draw_card[0];

            float a = countpoint.Score(draw_card[0],0);
            nowpoint.setText("目前點數： "+String.valueOf(a));

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


            countpoint.Score(draw_card[0],0);

        }

        //------------電腦抽卡------
        int [] Computre_draw_card = card.Draw_card();
// 0==point,1==number,2==use how many card

        if (totaluse < Computre_draw_card[2]) {


            totaluse++;
            ComputerUse++;

            ComputerNowPoint = countpoint.Score(Computre_draw_card[0],1);
            computerpoint.setText("目前點數："+String.valueOf(ComputerNowPoint));

            lefttp[0].setImageResource(Computre_draw_card[1]);

            nn.setText("剩餘牌數：" + (52 - Computre_draw_card[2]));

            computer_use_card[0] = Computre_draw_card[0];
        }

    }

    private final Button.OnClickListener
            pulsLin = new Button.OnClickListener() {
                public void onClick(View v) {


                    int [] draw_card = card.Draw_card();
                    // 0==point,1==number,2==use how many card

                    puls.setEnabled(false);
                    if (totaluse < draw_card[2]) {

                        Timefuntionpoker[0]= draw_card[1];
                        countri++;

                        you_poker.setImageResource(draw_card[1]);
                        totaluse++;
                        PlayerUse++;


                        new Handler().postDelayed(new Runnable(){
                            public void run() {
                                rightp[countri].setImageResource(Timefuntionpoker[0]);
                                you_poker.setImageResource(R.drawable.back);
                                puls.setEnabled(true);
                            }
                        }, 1800);

                        use_card[countri] = draw_card[0];


                        nn.setText("剩餘牌數："+ (52-draw_card[2]));

                        float a = countpoint.Score(draw_card[0],0);

                        if(a<=10.5)
                            nowpoint.setText("目前點數： "+ String.valueOf(a));
                        else {

                            finish();
                            Intent intent = new Intent();
                            intent.setClass(MainActivity.this, end_page.class);

                            bundle.putInt("PlayUse",PlayerUse);
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

                    }

                    if(PlayerUse == 5)//電腦一開始抽的
                    {
                        finish();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, end_page.class);
                        float a = countpoint.Score(0,2);

                        bundle.putInt("PlayUse",PlayerUse);
                        bundle.putFloat("nowpoint",a);
                        bundle.putIntArray("use_card",use_card);
                        bundle.putFloat("C_point",ComputerNowPoint);
                        bundle.putIntArray("computer_use_card",computer_use_card);

                        intent.putExtras(bundle);
                        startActivity(intent);
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

                int [] Computre_draw_card = card.Draw_card();
                // 0==point,1==number,2==use how many card
                if (totaluse < Computre_draw_card[2]) {

                    you_poker.setImageResource(Computre_draw_card[1]);

                    totaluse++;
                    ComputerUse++;

                    lefttp[counttr_computer].setImageResource(Computre_draw_card[1]);
                    computer_use_card[counttr_computer] = Computre_draw_card[0];

                    counttr_computer++;

                    nn.setText("剩餘排數" + (52- Computre_draw_card[2]));;

                    ComputerNowPoint = countpoint.Score(Computre_draw_card[0], 1);

                    if ((ComputerNowPoint <= 10.5) && (ComputerUse != 5)) {
                        determine = AIpoint.determine(ComputerNowPoint);
                        computerpoint.setText("目前點數："+ String.valueOf(ComputerNowPoint));
                    } else {
                        break;
                    }

                }
            }

            finish();
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, end_page.class);

            //Bundle bundle_Computer = new Bundle();

            float a = countpoint.Score(0,2);

            bundle.putInt("PlayUse",PlayerUse);
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
