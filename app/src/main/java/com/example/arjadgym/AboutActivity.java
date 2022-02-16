package com.example.arjadgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setTitle("About Our App");

        TextView app = findViewById(R.id.apps);
        app.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(AboutActivity.this, "more apps", Toast.LENGTH_SHORT).show();
            }
        });

        //address
        TextView add = findViewById(R.id.addtxt);
        add.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Uri u = Uri.parse("https://www.google.com/maps/place/PUCIT-New+Campus+(New+Building)/@31.4804833,74.2630103,17z/data=!4m5!3m4!1s0x391903ccac08143b:0x9b0637753efd261e!8m2!3d31.4805905!4d74.2653682");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });
        ImageView i = findViewById(R.id.mapimg);
        i.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Uri u = Uri.parse("https://www.google.com/maps/place/PUCIT-New+Campus+(New+Building)/@31.4804833,74.2630103,17z/data=!4m5!3m4!1s0x391903ccac08143b:0x9b0637753efd261e!8m2!3d31.4805905!4d74.2653682");
                startActivity(new Intent(Intent.ACTION_VIEW, u));
            }
        });

        //call
        TextView call = findViewById(R.id.calltxt);
        call.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(AboutActivity.this, "callling", Toast.LENGTH_SHORT).show();
                DialCall();
            }
        });

        //address
        TextView not = findViewById(R.id.notitxt);
        not.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i_noti = new Intent(getApplicationContext(),notification.class);
                startActivity(i_noti);
            }
        });
    }
    //on create ended


    //getpermissions manually
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    DialCall();
                } else {
                    Log.d("TAG", "Sorry!!! Permission Not Granted");
                }
                break;

            default:
                break;
        }
    }


    //dial call
    public void DialCall() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    Integer.parseInt("123"));
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:03024466257")));
        }
    }
}