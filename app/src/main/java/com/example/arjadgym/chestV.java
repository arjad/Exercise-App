package com.example.arjadgym;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.os.Bundle;

public class chestV extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_v);
        setTitle("Chest Workout At Home");

        VideoView videoView = findViewById(R.id.video_view);
        //set video path
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.chestvid;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        //media controllee that we see at the botom of video to play and pause
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}