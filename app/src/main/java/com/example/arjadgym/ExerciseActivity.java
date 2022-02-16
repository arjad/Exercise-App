package com.example.arjadgym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ExerciseActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        setTitle("All Exercises");
        //custom alert dialog
        findViewById(R.id.train).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CreateCustomDialog();
            }
        });
        //go to bmi
        Button bmi_btn = findViewById(R.id.bmititle);
        bmi_btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent bmi_intent = new Intent(getApplicationContext(), BmiActivity.class);
                startActivity(bmi_intent);
            }
        });

        //go to chest video
        TextView chestbtn = findViewById(R.id.chestbtn_vid);
        chestbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent chestv_intent = new Intent(getApplicationContext(), chestV.class);
                startActivity(chestv_intent);
            }
        });

        //go to bicep video
        TextView bicepsbtn = findViewById(R.id.bicepbtn_vid);
        bicepsbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent bicepv_intent = new Intent(getApplicationContext(), bicepV.class);
                startActivity(bicepv_intent);
            }
        });
        //go to shoulder video
        TextView shoulderbtn = findViewById(R.id.fitthreetitle);
        shoulderbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent shoulderv_intent = new Intent(getApplicationContext(), shoulderV.class);
                startActivity(shoulderv_intent);
            }
        });
        //go to legs video
        TextView legsbtn = findViewById(R.id.fitfourtitle);
        legsbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent legsv_intent = new Intent(getApplicationContext(), legsV.class);
                startActivity(legsv_intent);
            }
        });
        //go to cardio video
        TextView cardiobtn = findViewById(R.id.fitfourtitles);
        cardiobtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent cardiov_intent = new Intent(getApplicationContext(), CardioV.class);
                startActivity(cardiov_intent);
            }
        });
    }


    //custom alert box
    private void CreateCustomDialog()
    {
        AlertDialog.Builder b = new AlertDialog.Builder(this);

        View v = LayoutInflater.from(this).inflate(R.layout.custom_alert, null);
        TextView tv = v.findViewById(R.id.textView);
        TextView tv2 = v.findViewById(R.id.textView2);

        tv.setText("Working");
        tv2.setText("Our personal trainers will be online within some weeks");

        b.setView(v);
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = b.create();
        ad.show();
    }
}