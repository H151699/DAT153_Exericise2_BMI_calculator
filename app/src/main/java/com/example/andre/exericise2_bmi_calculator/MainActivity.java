package com.example.andre.exericise2_bmi_calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    private EditText weight, height;
    private TextView resView;
    private CheckBox checkBox;
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
    checkBox = (CheckBox) findViewById(R.id.checkbx);
    btn = (Button) findViewById(R.id.calcBtn);

    mPreferences = PreferenceManager.getDefaultSharedPreferences(this); // declare "db"
    // mPreferences = getSharedPreferences("com.example.exericise2_bmi_calculator", Context.MODE_PRIVATE);
    mEditor = mPreferences.edit(); // tool to put userinput into "db"
    checkSharedPreferences();



    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            /**
             *  when button clicked, process the calculation
             */
            calcuBMI();

            // save the checkbox preference
            if(checkBox.isChecked()){

                //set a checkbox when the app starts
                mEditor.putString(getString(R.string.checkbox), "True");
                mEditor.commit();

                // save the user input
                String sWeight = weight.getText().toString();
                mEditor.putString(getString(R.string.weight), sWeight);
                mEditor.commit();

                String sHight = height.getText().toString();
                mEditor.putString(getString(R.string.hight), sHight);
                mEditor.commit();

            }else{


                mEditor.putString(getString(R.string.checkbox), "False");
                mEditor.commit();

                mEditor.putString(getString(R.string.weight), "");
                mEditor.commit();


                mEditor.putString(getString(R.string.hight), "");
                mEditor.commit();

            }


        }


    });





 }
    // Check SharedPreference and set  them accordingly

    private void checkSharedPreferences(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String weightValue = mPreferences.getString(getString(R.string.weight), "");
        String heightValue = mPreferences.getString(getString(R.string.hight), "");

        // save value to the textField
        weight.setText(weightValue);
        height.setText(heightValue);

        // set check box. true set check box, false uncheck box
        if(checkbox.equals("True")){
            checkBox.setChecked(true);

        }else{
            checkBox.setChecked(false);
        }


    }//





    // BMI Calculation
    private void calcuBMI(){

        float w, h, res;

        w = Float.parseFloat(weight.getText().toString());
        h = Float.parseFloat(height.getText().toString())/100;
        res = w / (h * h);
        resView.setText(""+ res);

        String normal = getResources().getString(R.string.normal);
        String uweight = getResources().getString(R.string.uweight);
        String oweight = getResources().getString(R.string.oweight);

        if(res <= 18.8){

            Toast toast= Toast.makeText(getApplicationContext(), uweight, Toast.LENGTH_LONG);
            View v = toast.getView();

            // Change bg color
            v.setBackgroundResource(R.drawable.toast_drawable2);
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 250);
            toast.show();

        } else if((res >= 18.8) && (res < 25)){
            Toast t = Toast.makeText(getApplicationContext(), normal, Toast.LENGTH_LONG);
            View v = t.getView();

            // Change bg color
            v.setBackgroundResource(R.drawable.toast_drawable);
            t.setGravity(Gravity.CENTER_HORIZONTAL, 0, 250);
            t.show();


        }else if(res > 25){
            Toast tst = Toast.makeText(getApplicationContext(), oweight, Toast.LENGTH_LONG);
            View v = tst.getView();

            // Change bg color
            v.setBackgroundResource(R.drawable.toast_drawable3);
            tst.setGravity(Gravity.CENTER_HORIZONTAL, 0, 250);
            tst.show();
        }

    }


    }



