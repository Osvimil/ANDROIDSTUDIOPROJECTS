package com.appspot.oswaldopsendpoints.practicaactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    public void abrirA(View view){
        startActivity(new Intent(this,ActividadA.class));
    }
}
