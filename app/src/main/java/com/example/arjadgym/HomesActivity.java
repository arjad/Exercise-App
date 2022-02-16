package com.example.arjadgym;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomesActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        Button btnreg = (Button) findViewById(R.id.btnreg);

        btnlogin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent login_intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login_intent);
            }
        });
        btnreg.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent reg_intent = new Intent(getApplicationContext(), RegActivity.class);
                startActivity(reg_intent);
            }
        });

        ImageView button_notify = findViewById(R.id.splash_img);
        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Send the noti

            }
        });
    }

    //action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.reset:
                Toast.makeText(HomesActivity.this, "Reset APP", Toast.LENGTH_SHORT).show();

                return(true);
            case R.id.about:
                Intent i_about = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(i_about);
                return(true);
            case R.id.tips:
                Intent i_tips = new Intent(getApplicationContext(),TipsActivity.class);
                startActivity(i_tips);
                return(true);
            case R.id.notes:
                Intent i_notes = new Intent(getApplicationContext(),Notes.class);
                startActivity(i_notes);
                return(true);


            case R.id.feedback:
                Intent i_email = new Intent(Intent.ACTION_SEND);
                i_email.setType("text/plain");
                i_email.putExtra(Intent.EXTRA_EMAIL,new String[]{"arjadgohar14@gmail.com"});
                i_email.putExtra(Intent.EXTRA_SUBJECT,"Feedback from gym app");
                i_email.putExtra(Intent.EXTRA_TEXT,"this is my msg");
                startActivity(Intent.createChooser(i_email,"Choose App"));

                return(true);

            case R.id.exit:
                Toast.makeText(HomesActivity.this, "Stay Happy! Bye ", Toast.LENGTH_SHORT).show();
                finish();
                return(true);
        }
        return(super.onOptionsItemSelected(item));
    }
    //action bar ends


}