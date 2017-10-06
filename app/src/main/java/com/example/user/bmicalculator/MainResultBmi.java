package com.example.user.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;
public class MainResultBmi extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bmi);

        Intent intent = getIntent();
        Double bmi = intent.getDoubleExtra("result",0);
        String text = intent.getStringExtra("state");

        TextView textData = (TextView)findViewById(R.id.text_result_bmi);
        textData.setText("ค่า BMI ที่ได้คือ "+bmi+"\n\nอยู่ในเกณฑ์ : "+text);

    }
}
