package com.example.user.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button calculate;
    private TextView weight,height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = (Button)findViewById(R.id.button_cal);
        weight = (TextView)findViewById(R.id.editTextWeight);
        height = (TextView)findViewById(R.id.editTextHeight);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String heightC = height.getText().toString();
                String weightC = weight.getText().toString();

                Double height = Double.valueOf(heightC);
                Double weight = Double.valueOf(weightC);

                double bmi = weight / ((height/100) * (height/100));
                String resultBmi = String.format("%.2f",bmi);

                String getBmiText = getBmiState(bmi);

                Intent intent = new Intent(MainActivity.this, MainResultBmi.class);

                intent.putExtra("result",resultBmi);
                intent.putExtra("state",getBmiText);

                startActivity(intent);
            }
        });

    }

    private String getBmiState(double bmi){
        String str = "";
        if(bmi < 18.5){
            str = "น้ำหนักน้อยกว่าปกติ";
        }else if(bmi < 25){
            str = "น้ำหนักปกติ";
        }else if(bmi < 30){
            str = "น้ำหนักมากกว่าปกติ (ท้วม)";
        }else{
            str = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return str;
    }
}
