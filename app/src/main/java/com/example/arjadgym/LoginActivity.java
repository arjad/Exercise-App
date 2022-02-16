package com.example.arjadgym;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.String;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity
{
    private TextView textreg;
    //used in file handling reading
    static final int READ_BLOCK_SIZE = 100;

    //used in sql db
    DBHelper DB = new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Button login_btn;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText user= findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        String user_name = user.getText().toString();
        String pass_word = pass.getText().toString();

        TextView create = findViewById(R.id.createtext);
        create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent create_intent = new Intent(getApplicationContext(), RegActivity.class);
                startActivity(create_intent);
            }

        });

        Button loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
               if(user_name.equals("admin"))
               {
                   Intent ex_intent = new Intent(getApplicationContext(), ExerciseActivity.class);
                   startActivity(ex_intent);
               }
               else{
                   Toast.makeText(getBaseContext(), "Incorrect Creditentiasl",
                           Toast.LENGTH_SHORT).show();
               }
            }

        });

        //social icons
        ImageView fb = findViewById(R.id.fbicon);
        fb.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Uri u = Uri.parse("https://www.facebook.com/");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });
        ImageView insta = findViewById(R.id.instaicon);
        insta.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Uri u = Uri.parse("https://www.instagram.com/invites/contact/?i=1orzso15879yp&utm_content=4nzii6o");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });
        ImageView twiter = findViewById(R.id.twitericon);
        twiter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Uri u = Uri.parse("https://twitter.com/?lang=en");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });

    }


}