package com.example.arjadgym;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegActivity<DB> extends AppCompatActivity
{
    private static final String TAG = "RegActivity";
    EditText username, email, pass;
    Button signup, view;
    ImageView cam;
    DBHelper DB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //take input in var
        signup = findViewById(R.id.loginbtn);
        view = findViewById(R.id.view);
        cam = findViewById(R.id.cam);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);

        //signup btn
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //get user typed details
                String usernametxt = username.getText().toString();
                String emailtxt = email.getText().toString();
                String passtxt = pass.getText().toString();

                if(android.util.Patterns.EMAIL_ADDRESS.matcher(emailtxt).matches() &&
                        emailtxt != null && !"".equals(emailtxt) &&
                        passtxt != null && !"".equals(passtxt) &&
                        usernametxt != null && !"".equals(usernametxt) &&
                        !usernametxt.matches("[0123456789?.{}()!@#$%^&*/=+-,]*"))
                {

                    //insert in db
                    Boolean i = DB.insertuserdata(usernametxt, emailtxt, passtxt);
                    if (i == true)
                        Toast.makeText(RegActivity.this, "Successfully SINGUP", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(RegActivity.this, "SIGN UP Error!!!", Toast.LENGTH_SHORT).show();

                    Intent exercise_intent = new Intent(getApplicationContext(), ExerciseActivity.class);
                    startActivity(exercise_intent);
                }
                else{
                    Toast.makeText(RegActivity.this, "Wrong creditentials", Toast.LENGTH_SHORT).show();

                }
            }
        });


        //see all data
        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //get user typed details
                String usernametxt = username.getText().toString();
                String emailtxt = email.getText().toString();
                String passtxt = pass.getText().toString();

                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(RegActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("username :"+res.getString(0)+"\n");
                    buffer.append("email :"+res.getString(1)+"\n");
                    buffer.append("pass :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder a = new AlertDialog.Builder(RegActivity.this);
                a.setCancelable(true);
                a.setTitle("All users");
                a.setMessage(buffer.toString());
                a.show();
            }
        });

        //camera
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //access camera
                Intent cam = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cam,100);

            }
        });
    }
}