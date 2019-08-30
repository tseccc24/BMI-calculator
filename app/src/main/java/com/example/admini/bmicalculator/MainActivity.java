package com.example.admini.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText heightEditText;
    private EditText weightEditText;
    private Button calculateBtn;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        calculateBtn = findViewById(R.id.calculateBtn);
        resultTextView = findViewById(R.id.resultTextView);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height = Double.parseDouble(heightEditText.getText().toString());
                double weight = Double.parseDouble(weightEditText.getText().toString());
                height = height/100;
                double result = (double)weight/Math.pow(height, 2);
                String label = null;
                if(result<16){
                    label = "Severe Thinness";
                }else if(result >=16 && result <17){
                    label = "Moderate Thinness";
                }else if(result>=17 && result<18.5){
                    label = "Mild Thinness";
                }else if(result>=18.5 && result<25){
                    label = "Normal";
                }else if(result>=25 && result<30){
                    label = "Overweight";
                }else if(result>=30 && result<35){
                    label = "Obese Class I";
                }else if(result>=35 && result<40){
                    label = "Obese Class II";
                }else if(result>=40){
                    label = "Obese Class III";
                }
                String  value = String.valueOf(result);
                resultTextView.setText(value+"\n"+label);
                resultTextView.setVisibility(View.VISIBLE);
            }
        });
    }
}
