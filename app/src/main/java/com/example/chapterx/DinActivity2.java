package com.example.chapterx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class DinActivity2 extends AppCompatActivity {
    TextView tv_level,tv_number;
    EditText et_number;
    Button b_confirm;
    static int currentlevel=1;
    Random r=new Random();
    String generatednumber;

    public static int getScore()
    {
        return currentlevel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dlvl2);
        tv_level=findViewById(R.id.tx_level);
        tv_number=findViewById(R.id.tx_number);
        et_number=findViewById(R.id.et_number);
        b_confirm=findViewById(R.id.button);
        tv_level.setText("level: "+currentlevel);
        generatednumber=generateNumber(currentlevel);
        tv_number.setText(generatednumber);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                et_number.setVisibility(View.VISIBLE);
                b_confirm.setVisibility(View.VISIBLE);
                tv_number.setVisibility(View.GONE);
                et_number.requestFocus();
            }
        },1000);
        b_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(generatednumber.equals(et_number.getText().toString())) {
                    et_number.setVisibility(View.GONE);
                    b_confirm.setVisibility(View.GONE);
                    tv_number.setVisibility(View.VISIBLE);
                    et_number.setText("");

                    currentlevel++;
                    tv_level.setText("level: "+currentlevel);
                    generatednumber = generateNumber(currentlevel);
                    tv_number.setText(generatednumber);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            et_number.setVisibility(View.VISIBLE);
                            b_confirm.setVisibility(View.VISIBLE);
                            tv_number.setVisibility(View.GONE);
                            et_number.requestFocus();
                        }
                    },1000);
                }
                else
                {
                    tv_level.setText("game over the number was"+generatednumber);
                    b_confirm.setEnabled(false);
                    Intent intent = new Intent(DinActivity2.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
    private String generateNumber(int digits)
    {
        String output="";
        for(int i=0;i<digits;i++)
        {
            int randomDigit=r.nextInt(10);
            output=output+""+randomDigit;
        }
        return output;
    }
}
