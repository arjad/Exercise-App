package com.example.arjadgym;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class BmiActivity extends AppCompatActivity
{
    private static final String TAG = "tags";
    private EditText height;
    private EditText weight;
    private TextView result;

    //var
    private EditText weightKgEditText, heightCmEditText;
    private Button calculateButton;
    RelativeLayout mmale,mfemale;
    String typerofuser="0";


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);

        //check gender
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);
        mmale.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typerofuser="Male";
            }
        });
        mfemale.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typerofuser="Female";
            }
        });

    }

    public void calculateBMI(View v)
    {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr))
        {
            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);

            if(heightValue > 100 && heightValue < 240 && weightValue < 200)
            {
                float heightdiv = heightValue/100;

                float bmi = weightValue / (heightValue * heightdiv);
                displayBMI(bmi);
            }
            else{
                Toast.makeText(BmiActivity.this, "wrong height or weight ", Toast.LENGTH_SHORT).show();
            }
        }
        else if(heightStr.matches("[a-zA-Z.?/=+-,]*") || weightStr.matches("[a-zA-Z.?/=+-,]*") )
        {
            Toast.makeText(BmiActivity.this, "special char detected", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(BmiActivity.this, "Enter Input ", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayBMI(float bmi)
    {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "R.string.very_severely_underweight";
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "severely_underweight";
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "underweight";
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = "normal";
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "overweight";
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = "obese_class_i";
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = "obese_class_ii";
        } else {
            bmiLabel ="obese_class_iii";
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}