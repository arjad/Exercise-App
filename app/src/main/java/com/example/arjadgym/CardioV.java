package com.example.arjadgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class CardioV extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_v);

        setTitle("Cardio At Home");

        TextView fat = findViewById(R.id.fat);
        fat.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "To Youtube", Toast.LENGTH_SHORT).show();
                Uri u = Uri.parse("https://www.youtube.com/watch?v=gC_L9qAHVJ8");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });
        TextView male = findViewById(R.id.male);
        male.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "To Youtube", Toast.LENGTH_SHORT).show();
                Uri u = Uri.parse("https://www.youtube.com/watch?v=GL1C6FCCKnQ");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });
        TextView female = findViewById(R.id.female);
        female.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "To Youtube", Toast.LENGTH_SHORT).show();
                Uri u = Uri.parse("https://www.youtube.com/watch?v=f4ploouAfWI");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });
        TextView athelete = findViewById(R.id.Athete);
        athelete.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "To Youtube", Toast.LENGTH_SHORT).show();
                Uri u = Uri.parse("https://www.youtube.com/watch?v=tp-uaIGn7EY");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });
        TextView kid = findViewById(R.id.kid);
        kid.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "To Youtube", Toast.LENGTH_SHORT).show();
                Uri u = Uri.parse("https://www.youtube.com/watch?v=L_A_HjHZxfI");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });
    }
}