package com.example.chapterx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.zip.Inflater;

import static java.lang.System.exit;

public class NavActivity extends AppCompatActivity {

    ImageView curView = null;
    private int countPair =0;
    final int[] drawable = new int[]{R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,
            R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,
            R.drawable.pic8};
    Button btnSubmit;
    int[] pos={0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
    int currentPos=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nlvl);

        btnSubmit = (Button)findViewById(R.id.submit);

        GridView gridView= (GridView) findViewById(R.id.gridView);
        ImageAdapter imageAdapter= new ImageAdapter(NavActivity.this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(currentPos<1){
                    currentPos = i;
                    curView=(ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[i]]);

                }
                else{
                    if(currentPos==i){
                        ((ImageView)view).setImageResource(R.drawable.hidden);

                    }
                    else if(pos[currentPos]!=pos[i]){
                        curView.setImageResource(R.drawable.hidden);
                        Toast.makeText(getApplicationContext(),"Not a Match :(",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        ((ImageView)view).setImageResource(drawable[pos[i]]);
                        currentPos++;


                        if(countPair==0){
                            Toast.makeText(getApplicationContext(), "Congratulations!!", Toast.LENGTH_SHORT).show();
                        }
                        
                    }
                    currentPos=-1;
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}