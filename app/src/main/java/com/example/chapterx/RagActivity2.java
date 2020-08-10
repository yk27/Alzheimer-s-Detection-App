package com.example.chapterx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RagActivity2 extends AppCompatActivity {
    Button btn1,btn2,btn3;
    ImageView img;
    List<colouritem> list;
    Random r;
    int turn=1;
    static int score=0;

    public static int getScore()
    {
        return score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rlvl2);
        img=(ImageView)findViewById(R.id.img);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        list=new ArrayList<>();
        r=new Random();

        for(int i=0;i<new database().answers.length;i++){
            list.add(new colouritem(new database().answers[i],new database().flags[i]));   //Inserting elements into list
        }

        Collections.shuffle(list);                                                           //Shuffle the order
        newquestions(turn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(RagActivity2.this, "Correct!", Toast.LENGTH_LONG).show();
                    score+=1;
                    if(turn<list.size()){
                        turn++;
                        newquestions(turn);

                    }else{
                        Toast.makeText(RagActivity2.this, "Your game is finished and your score is "+score/2+".", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RagActivity2.this, MainActivity.class);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(RagActivity2.this, "Wrong", Toast.LENGTH_LONG).show();
                    Toast.makeText(RagActivity2.this, "You lost the game and your score is "+score/2+" .", Toast.LENGTH_LONG).show();
                    //finish();
                    Intent intent = new Intent(RagActivity2.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(RagActivity2.this, "Correct!", Toast.LENGTH_LONG).show();
                    score+=1;
                    if(turn<list.size()){
                        turn++;
                        newquestions(turn);

                    }else{
                        Toast.makeText(RagActivity2.this, "Your game is finished and your score is "+score/2+".", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RagActivity2.this, MainActivity.class);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(RagActivity2.this, "Wrong", Toast.LENGTH_LONG).show();
                    Toast.makeText(RagActivity2.this, "You lost the game and your score is "+score/2+" .", Toast.LENGTH_LONG).show();
                    //finish();
                    Intent intent = new Intent(RagActivity2.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(RagActivity2.this, "Correct!", Toast.LENGTH_LONG).show();
                    score+=1;
                    if(turn<list.size()){
                        turn++;
                        newquestions(turn);

                    }else{
                        Toast.makeText(RagActivity2.this, "Your game is finished and your score is "+score/2+".", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RagActivity2.this, MainActivity.class);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(RagActivity2.this, "Wrong", Toast.LENGTH_LONG).show();
                    Toast.makeText(RagActivity2.this, "You lost the game and your score is "+score/2+" .", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RagActivity2.this, MainActivity.class);
                    startActivity(intent);
                    //finish();
                }

            }
        });
    }

    private void newquestions(int number){
        img.setImageResource(list.get(number-1).getImage());                //To set immage on screen
        int correct_answer=r.nextInt(3)+1;                          //Decides to place the crt option
        int firstbtn=number-1;
        int secondbtn;
        int thirdbtn;

        switch(correct_answer){
            case 1:
                btn1.setText(list.get(firstbtn).getName());
                do{
                    secondbtn=r.nextInt(list.size());
                }while (secondbtn==firstbtn);


                do{
                    thirdbtn=r.nextInt(list.size());
                }while (thirdbtn==firstbtn||thirdbtn==secondbtn);
                btn2.setText(list.get(secondbtn).getName());

                btn3.setText(list.get(thirdbtn).getName());


                break;

            case 2:
                btn2.setText(list.get(firstbtn).getName());
                do{
                    secondbtn=r.nextInt(list.size());
                }while (secondbtn==firstbtn);


                do{
                    thirdbtn=r.nextInt(list.size());
                }while (thirdbtn==firstbtn||thirdbtn==secondbtn);
                btn1.setText(list.get(secondbtn).getName());

                btn3.setText(list.get(thirdbtn).getName());


                break;
            case 3:
                btn3.setText(list.get(firstbtn).getName());
                do{
                    secondbtn=r.nextInt(list.size());
                }while (secondbtn==firstbtn);


                do{
                    thirdbtn=r.nextInt(list.size());
                }while (thirdbtn==firstbtn||thirdbtn==secondbtn);
                btn2.setText(list.get(secondbtn).getName());

                btn1.setText(list.get(thirdbtn).getName());

                break;
        }
    }

}
