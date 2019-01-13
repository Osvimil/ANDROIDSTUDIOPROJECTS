package com.hotmail.oswaldosaldivar.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botn = (Button) findViewById(R.id.boton);

        botn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton:
                Intent intento = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intento);
                break;


        }

    }
}
