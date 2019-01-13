package com.hotmail.oswaldosaldivar.bundleo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton =(Button) findViewById(R.id.boton);

        boton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intento = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intento);

    }
}
