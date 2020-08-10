package com.example.chapterx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView sv;


    public void homePage(){
        setContentView(R.layout.activity_main);

        Button chap1 = (Button)findViewById(R.id.btnChap);
        Button chap2 = (Button)findViewById(R.id.btnChap2);
        Button chap3 = (Button)findViewById(R.id.btnChap3);
        Button chap4 = (Button)findViewById(R.id.btnChap4);
        Button chap5 = (Button)findViewById(R.id.btnChap5);
        Button chap6 = (Button)findViewById(R.id.btnChap6);

        chap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChapterOne.class);
                startActivity(intent);
            }
        });

        chap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        chap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NavActivity.class);
                startActivity(intent);
            }
        });

        chap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MoActivity1.class);
                startActivity(intent);
            }
        });

        chap5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DinActivity1.class);
                startActivity(intent);
            }
        });

        chap6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RagActivity1.class);
                startActivity(intent);
            }
        });

        int chapSix1 = RagActivity1.getScore();
        int chapSix2 = RagActivity2.getScore();
        sv = (TextView)findViewById(R.id.scoreView);
        sv.setText("Chapter1 Score: "+ChapterOne.getScore()+"/5"+"\n"+"Chapter2 Score: "+MainActivity6.getFinalScore()+"/15"+"\n"+"Chapter5 Score: "+((DinActivity1.getScore()+DinActivity2.getScore())-1)+"/14"+"\n"+"Chapter6 Score: "+(chapSix1+chapSix2)+"/25");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homePage();
    }
}