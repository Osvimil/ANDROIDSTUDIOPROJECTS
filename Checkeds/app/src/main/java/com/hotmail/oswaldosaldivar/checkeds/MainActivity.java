package com.hotmail.oswaldosaldivar.checkeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton;
    CheckBox amarillo,rojo,verde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amarillo = (CheckBox) findViewById(R.id.uno);
        rojo = (CheckBox) findViewById(R.id.dos);
        verde = (CheckBox) findViewById(R.id.tres);
        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        StringBuffer resultado = new StringBuffer();
        resultado.append(" Amarillo: ").append(amarillo.isChecked());
        resultado.append(" Rojo: ").append(rojo.isChecked());
        resultado.append(" Verde: ").append(verde.isChecked());

        Toast.makeText(MainActivity.this,resultado.toString(),Toast.LENGTH_LONG).show();

    }
}
