package com.hotmail.oswaldosaldivar.betweenactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView texto;
    EditText editar;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.texto);
        editar = (EditText) findViewById(R.id.editar);
        boton= (Button) findViewById(R.id.boton);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.boton:
                Intent intentar = new Intent(this,AnotherActivity.class);
                String dato = editar.getText().toString();
                intentar.putExtra("DATO",dato);
                startActivity(intentar);
                break;


        }

    }
}
