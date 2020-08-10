package com.example.chapterx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DinActivity1 extends AppCompatActivity {
    ImageView questionimage,optiona,optionb,optionc;
    RadioButton a,b,c;
    TextView tv_question,countdown_tv;
    Button next;
    RadioGroup rd;
    CountDownTimer countDownTimer;

    private static final  long Initialtime=30000;
    private long timeleft=Initialtime;

    int[] questionsimg={R.drawable.question,R.drawable.question2,R.drawable.question3,R.drawable.question4};
    int[] optiona_imgs={R.drawable.optiona,R.drawable.optiona2,R.drawable.optiona3,R.drawable.optiona4};
    int[] optionb_imgs={R.drawable.optionb,R.drawable.optionb2,R.drawable.optionb3,R.drawable.optionb4};
    int[] optionc_imgs={R.drawable.optioncans,R.drawable.optionc2,R.drawable.optionc3,R.drawable.optionc4};

    String[] question={"1.Which of the following block can be inscribed in the image below?","2.How many squares are there in the image below?",
            "3.Find the correct answer","4.Which of these views are possible when the Figure given below is viewed from top?"};

    int i=0;
    int j=0;
    static int score=0;
    //int buttonpressed=0;

    public static int getScore()
    {
        return score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dlvl1);
        questionimage=findViewById(R.id.questionimage);
        optiona=findViewById(R.id.option_a_img);
        optionb=findViewById(R.id.option_b_img);
        optionc=findViewById(R.id.option_c_img);
        countdown_tv=findViewById(R.id.tv_timer);

        rd=findViewById(R.id.rd);
        a=findViewById(R.id.a);
        b=findViewById(R.id.b);
        c=findViewById(R.id.c);
        next=findViewById(R.id.next);
        tv_question=findViewById(R.id.question_tv);

        updatequestion();
        starttimer();
        updatetimer();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkanswer();
                i+=1;
                if(i==optiona_imgs.length)
                {
                    setContentView(R.layout.dinlvlques);
                    Button next = (Button)findViewById(R.id.dlvlnext);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DinActivity1.this,DinActivity2.class);
                            startActivity(intent);
                        }
                    });

                }

                if (i==optiona_imgs.length)
                {
                    Toast.makeText(getApplicationContext(),""+score,Toast.LENGTH_SHORT).show();

                }
                if (i<optiona_imgs.length) {
                    if (i==(optiona_imgs.length)-1)
                        next.setText("SUBMIT");
                    updatequestion();
                    rd.clearCheck();
                    countDownTimer.cancel();
                    resettimer();
                    starttimer();
                }



            }
        });



    }
    public  void updatequestion()
    {
       if (i<=optiona_imgs.length)
       {
           questionimage.setImageResource(questionsimg[i]);


           optiona.setImageResource(optiona_imgs[i]);
           optionb.setImageResource(optionb_imgs[i]);
           optionc.setImageResource(optionc_imgs[i]);
           tv_question.setText(question[i]);
       }

    }
    public int checkanswer()
    {

        if (i==0)
        {
            if (c.isChecked())
            {
                score+=1;
            }
        }
        else if(i==1)
        {
            if (a.isChecked())
            {
                score+=1;
            }
        }
        else if (i==2)
        {
            if(c.isChecked())
            {
                score+=1;
            }
        }
        else if (i==3)
        {
            if (a.isChecked())
            {
                score+=1;
            }
        }

        return score;
    }
    public void starttimer()
    {
        countDownTimer=new CountDownTimer(timeleft,1) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleft=millisUntilFinished;
                updatetimer();
            }

            @Override
            public void onFinish() {
                checkanswer();
                i+=1;
                if (i<optiona_imgs.length) {
                    updatequestion();
                    rd.clearCheck();
                    resettimer();
                   // starttimer();

                }

            }
        }.start();
    }
    public void updatetimer()
    {
        int seconds=(int)timeleft/1000;
        String timelefttext="00:";
        if (seconds<10)timelefttext+=0;
        timelefttext+=seconds;
        countdown_tv.setText(timelefttext);

    }
    public void resettimer()
    {
        timeleft=Initialtime;
        updatetimer();
        //starttimer();
    }

}
