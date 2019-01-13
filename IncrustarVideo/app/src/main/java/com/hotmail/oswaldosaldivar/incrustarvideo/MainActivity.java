package com.hotmail.oswaldosaldivar.incrustarvideo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView =(VideoView)findViewById(R.id.video);

        String path = "android.resource://"+getPackageName()+"/"+R.raw.natural;

        videoView.setMediaController(new MediaController(this));

        videoView.setVideoURI(Uri.parse(path));
        videoView.requestFocus();
        videoView.start();

    }
}
