package com.hotmail.oswaldosaldivar.cicloactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    protected void onStart(){
        super.onStart();
        Log.d("onStart", "Entre");
    }
    protected  void onResume(){
        super.onResume();
        Log.d("onResume", "Entre");
    }
    protected void onPause(){
        super.onPause();
        Log.d("onPausa", "Entre");
    }

    protected void onStop(){
        super.onStop();
        Log.d("onStop","Entre");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("onDestroy","Entre");
    }

}
