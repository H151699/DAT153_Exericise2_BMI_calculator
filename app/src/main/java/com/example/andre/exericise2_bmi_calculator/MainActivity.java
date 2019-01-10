package com.example.andre.exericise2_bmi_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    private EditText weight, height;
    private TextView resView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    weight = (EditText) findViewById(R.id.edtweit);
    height = (EditText) findViewById(R.id.edthit);
    resView = (TextView) findViewById(R.id.resultTextView);
    btn = (Button) findViewById(R.id.calcBtn);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // when button clicked, process the calculation
            calcuBMI();

        }
    });



    }

    // BMI Calculation
    private void calcuBMI(){

        float w, h, res;

        w = Float.parseFloat(weight.getText().toString())/100;
        h = Float.parseFloat(height.getText().toString());
        res = w / (h * h);
        resView.setText(" " + res);



        if(res <= 18.8){
            Toast.makeText(getApplicationContext(), "You are under weight", Toast.LENGTH_LONG).show();

        } else if((res >= 18.8) && (res < 25)){
            Toast.makeText(getApplicationContext(), "You are Normal", Toast.LENGTH_LONG).show();

        }else if(res > 25){
            Toast.makeText(getApplicationContext(), "You are OverWeight", Toast.LENGTH_LONG).show();
        }

    }

/*
    public void calcuBMI(View v){

       String weightStr = weight.getText().toString();
       String heightStr = height.getText().toString();


       if(weightStr != null && !"".equals(weightStr)
               && heightStr != null && !"".equals(heightStr)){


           float wValue = Float.parseFloat(weightStr);
           float hValue = Float.parseFloat(heightStr) / 100;



           float res = wValue / (hValue * hValue);


       }


*/
    }



