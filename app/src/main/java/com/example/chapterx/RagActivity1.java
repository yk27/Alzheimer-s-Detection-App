package com.example.chapterx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RagActivity1 extends AppCompatActivity {
  Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
  static int score=0;
  int flag[]= new int[10];
  TextView ans;

  public static int getScore()
  {
      return score;
  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rlvl1);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button) findViewById (R.id.b2);
        b3=(Button) findViewById (R.id.b3);
        b4=(Button) findViewById (R.id.b4);
        b5=(Button) findViewById (R.id.b5);
        b6=(Button) findViewById (R.id.b6);
        b7=(Button) findViewById (R.id.b7);
        b8=(Button) findViewById (R.id.b8);
        b9=(Button) findViewById (R.id.b9);
        b10=(Button) findViewById (R.id.b10);
        b11=(Button) findViewById(R.id.b11);
        //ans=(TextView)findViewById(R.id.ans);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[0]=1;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[0]=2;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[1]=1;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[1]=2;
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[2]=1;
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[2]=2;
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[3]=1;
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[3]=2;
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[4]=1;
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[4]=2;
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    for (int i : flag) {
                        if (i == 2) {
                            score += 1;
                        }

                    }
                    //ans.setText("Score"+score);
                Toast.makeText(RagActivity1.this, "Your score is " + score + ".", Toast.LENGTH_LONG).show();
                    setContentView(R.layout.raglvlques);
                    Button next = (Button)findViewById(R.id.lvlnext);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RagActivity1.this, RagActivity2.class);
                            startActivity(intent);
                        }
                    });


            }
        });

    }

}
