package com.example.arjadgym;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class bicepV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicep_v);

        setTitle("Biceps Workout");

        VideoView videoView = findViewById(R.id.video_view);
        //set video path
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.biceps;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        //media controllee that we see at the botom of video to play and pause
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}