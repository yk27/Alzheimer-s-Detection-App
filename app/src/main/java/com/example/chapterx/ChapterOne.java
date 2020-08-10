package com.example.chapterx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChapterOne extends AppCompatActivity {

    RadioGroup group;
    RadioButton btnAns;
    static int score = 0;

    public static int getScore()
    {
        return score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_one);
        Button next = (Button)findViewById(R.id.tab1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.level_one);
                LevelOne();
            }
        });
    }

    public void LevelFive() {
        group = (RadioGroup)findViewById(R.id.rg5);
        Button next = (Button)findViewById(R.id.next5);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selOpt = group.getCheckedRadioButtonId();
                btnAns = findViewById(selOpt);
                group.check(selOpt);
                RadioButton ans = (RadioButton)findViewById(R.id.lvl5opt4);

                if(selOpt==-1)
                    Toast.makeText(ChapterOne.this, "Choose an option.", Toast.LENGTH_SHORT).show();
                else if(btnAns.getText() == ans.getText()) {
                    score += 1;
                    Intent intent = new Intent(ChapterOne.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(ChapterOne.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void LevelFour() {
        group = (RadioGroup)findViewById(R.id.rg4);
        Button next = (Button)findViewById(R.id.next4);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selOpt = group.getCheckedRadioButtonId();
                btnAns = findViewById(selOpt);
                group.check(selOpt);
                RadioButton ans = (RadioButton)findViewById(R.id.lvl4opt3);

                if(selOpt==-1)
                    Toast.makeText(ChapterOne.this, "Choose an option.", Toast.LENGTH_SHORT).show();
                else if(btnAns.getText() == ans.getText()) {
                    score += 1;
                    setContentView(R.layout.level_five);
                    LevelFive();
                }
                else{
                    setContentView(R.layout.level_five);
                    LevelFive();
                }
            }
        });
    }

    public void LevelThree() {
        group = (RadioGroup)findViewById(R.id.rg3);
        Button next = (Button)findViewById(R.id.next3);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selOpt = group.getCheckedRadioButtonId();
                btnAns = findViewById(selOpt);
                group.check(selOpt);
                RadioButton ans = (RadioButton)findViewById(R.id.lvl3opt1);

                if(selOpt==-1)
                    Toast.makeText(ChapterOne.this, "Choose an option.", Toast.LENGTH_SHORT).show();
                else if(btnAns.getText() == ans.getText()) {
                    score += 1;
                    setContentView(R.layout.level_four);
                    LevelFour();
                }
                else{
                    setContentView(R.layout.level_four);
                    LevelFour();
                }
            }
        });
    }

    public void TabTwo(){
        Button next = (Button)findViewById(R.id.tab2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.level_three);
                LevelThree();
            }
        });
    }

    public void LevelTwo(){
        group = (RadioGroup)findViewById(R.id.rg2);
        Button next = (Button)findViewById(R.id.next2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selOpt = group.getCheckedRadioButtonId();
                btnAns = findViewById(selOpt);
                group.check(selOpt);
                RadioButton ans = (RadioButton)findViewById(R.id.lvl2opt2);

                if(selOpt==-1)
                    Toast.makeText(ChapterOne.this, "Choose an option.", Toast.LENGTH_SHORT).show();
                else if(btnAns.getText() == ans.getText()) {
                    score += 1;
                    setContentView(R.layout.tab_two);
                    TabTwo();
                }
                else{
                    setContentView(R.layout.tab_two);
                    TabTwo();
                }
            }
        });
    }

    public void LevelOne(){
        group = (RadioGroup)findViewById(R.id.rg1);
        Button next = (Button)findViewById(R.id.next1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selOpt = group.getCheckedRadioButtonId();
                btnAns = findViewById(selOpt);
                group.check(selOpt);
                RadioButton ans = (RadioButton)findViewById(R.id.lvl1opt1);

                if(selOpt==-1)
                    Toast.makeText(ChapterOne.this, "Choose an option.", Toast.LENGTH_SHORT).show();
                else if(btnAns.getText() == ans.getText()) {
                    score += 1;
                    setContentView(R.layout.level_two);
                    LevelTwo();
                }
                else{
                    setContentView(R.layout.level_two);
                    LevelTwo();
                }
            }
        });
    }


}
