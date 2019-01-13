package com.hotmail.oswaldosaldivar.mediaplayyer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button iniciar,parar;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = (Button)findViewById(R.id.iniciar);
        parar = (Button)findViewById(R.id.parar);
        mp= MediaPlayer.create(this,R.raw.ecoute);

        iniciar.setOnClickListener(this);
        parar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.iniciar:

                play();

                break;

            case R.id.parar:

                stop();

                break;

        }

    }

    private void play(){
        mp.start();


    }

    private  void stop(){
        mp.stop();


    }
}
