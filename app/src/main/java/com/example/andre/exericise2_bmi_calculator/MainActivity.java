package com.example.andre.exericise2_bmi_calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

    // Shared Preferences
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    weight = (EditText) findViewById(R.id.edtweit);
    height = (EditText) findViewById(R.id.edthit);
    resView = (TextView) findViewById(R.id.resultTextView);
    btn = (Button) findViewById(R.id.calcBtn);

    mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    // mPreferences = getSharedPreferences("com.example.exericise2_bmi_calculator", Context.MODE_PRIVATE);
    mEditor = mPreferences.edit();
        String weightValue = mPreferences.getString(getString(R.string.weightinput), "");
        String heightValue = mPreferences.getString(getString(R.string.heightinput), "");
        weight.setText(weightValue);
        height.setText(heightValue);





    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // when button clicked, process the calculation
            calcuBMI();
/*
            // btn clicked, stored inputInfo
            String wt = weight.getText().toString();
            String ht = height.getText().toString();
            mEditor.putString(getString(R.string.weightinput));

*/

        }


    });





 }
/*

    // SharedPreference
    private void checkSharedPreferences(){
        String weightValue = mPreferences.getString(getString(R.string.weightinput), "");
        String heightValue = mPreferences.getString(getString(R.string.heightinput), "");
        weight.setText(weightValue);
        height.setText(heightValue);

    }//
*/
    // BMI Calculation
    private void calcuBMI(){

        float w, h, res;

        w = Float.parseFloat(weight.getText().toString())/100;
        h = Float.parseFloat(height.getText().toString());
        res = w / (h * h);
        resView.setText(" " + res);

        String normal = getResources().getString(R.string.normal);
        String uweight = getResources().getString(R.string.uweight);
        String oweight = getResources().getString(R.string.oweight);

        if(res <= 18.8){
            Toast.makeText(getApplicationContext(), uweight, Toast.LENGTH_LONG).show();

        } else if((res >= 18.8) && (res < 25)){
            Toast.makeText(getApplicationContext(), normal, Toast.LENGTH_LONG).show();

        }else if(res > 25){
            Toast.makeText(getApplicationContext(), oweight, Toast.LENGTH_LONG).show();
        }

    }


    }



