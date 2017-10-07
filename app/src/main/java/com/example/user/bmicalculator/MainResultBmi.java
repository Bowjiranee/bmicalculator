package com.example.user.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainResultBmi extends AppCompatActivity{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bmi);

        Bundle bundle = getIntent().getExtras();
        String bmi = bundle.getString("result");
        String text = bundle.getString("state");

        TextView textData = (TextView)findViewById(R.id.text_result_bmi);
        textData.setText("ค่า BMI ที่ได้คือ "+bmi+"\n\nอยู่ในเกณฑ์ : "+text);

        button = (Button)findViewById(R.id.button_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
