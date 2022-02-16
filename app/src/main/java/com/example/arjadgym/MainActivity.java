package com.example.arjadgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SplashScreen;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ImageView i;
        TextView tv;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = findViewById(R.id.splash_img);
        tv = findViewById(R.id.textView);

        i.animate().translationY(850).setDuration(1000).setStartDelay(2000);
        tv.animate().translationY(-1750).setDuration(1000).setStartDelay(2000);

        new Handler().postDelayed(new Runnable()
        {
            @Override public void run()
            {
                Intent i = new Intent(MainActivity.this, HomesActivity.class); startActivity(i);
                finish();
            }
        }, 4000);


    }
}