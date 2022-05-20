package com.ekd.random_number;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Play extends AppCompatActivity {

    TextView  countClick, scoreCount;
    Button btn, randomBtn1, randomBtn2;
    int count  = 0, countMyClick = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        randomBtn1 = findViewById(R.id.randomText1);
        btn = findViewById(R.id.button);
        randomBtn2 = findViewById(R.id.randomText2);
        countClick = findViewById(R.id.countClick);
        scoreCount = findViewById(R.id.scoreCount);
        Random rand1 = new Random();



        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                for(int i =0 ; i <= 5; i++){
                    try{
                        
                        int val = rand1.nextInt(51-1)+1;
                        int val2 = rand1.nextInt(51-1)+1;

                        randomBtn1.setText(Integer.toString(val));
                        randomBtn2.setText(Integer.toString(val2));

                        randomBtn1.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              Calculate1(val, val2, scoreCount);
                          }
                      });

                        randomBtn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Calculate2(val, val2, scoreCount);
                            }
                        });

                    }catch(Exception e){
                        countClick.setText("Game's over");
                    }
                }
                countMyClick++;
                countClick.setText(Integer.toString(countMyClick));

            }
        });


    }
    @SuppressLint("SetTextI18n")
    public void Calculate1(int num1, int num2, TextView scoreCount){
        if(num1 > num2){
            count+=5;
            scoreCount.setText(Integer.toString(count));
            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
        }else if(num1 < num2){
            count-=3;
            scoreCount.setText(Integer.toString(count));
            Toast.makeText(getApplicationContext(), "Wrong, try again.", Toast.LENGTH_LONG).show();
        }
        else{
            scoreCount.setText(Integer.toString(count));
            Toast.makeText(getApplicationContext(), "Sorry, the two values are the same.", Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("SetTextI18n")
    public void Calculate2(int num1, int num2, TextView scoreCount){
        if(num1 < num2){
            count+=5;
            scoreCount.setText(Integer.toString(count));
            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
        }else if(num1 > num2){
            count-=3;
            scoreCount.setText(Integer.toString(count));
            Toast.makeText(getApplicationContext(), "Wrong, try again.", Toast.LENGTH_LONG).show();
        }else{
            scoreCount.setText(Integer.toString(count));
            Toast.makeText(getApplicationContext(), "Sorry, the two values are the same.", Toast.LENGTH_LONG).show();
        }
    }


}

