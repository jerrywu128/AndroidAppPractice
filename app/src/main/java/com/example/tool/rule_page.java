package com.example.tool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class rule_page extends AppCompatActivity {

    private Button BackToStart;
    private TextView ruleBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rule_page);

        BackToStart = (Button)findViewById(R.id.BackToStart);
        BackToStart.setOnClickListener(BackToStartLin);


       }

    private Button.OnClickListener
        BackToStartLin = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            finish();
            Intent intent = new Intent();
            intent.setClass(rule_page.this, start_page.class);
            startActivity(intent);
        }
    };
}
