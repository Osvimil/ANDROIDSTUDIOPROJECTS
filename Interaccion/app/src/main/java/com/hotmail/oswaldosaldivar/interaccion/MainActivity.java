package com.hotmail.oswaldosaldivar.interaccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView texto;
    ImageView imagen;
    Button boton1, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.uno);
        imagen = (ImageView) findViewById(R.id.imagen);
        boton1 = (Button) findViewById(R.id.btn1);
        boton2 = (Button) findViewById(R.id.btn2);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btn1:
                texto.setText("yo soy el texto");
                break;

            case R.id.btn2:
                imagen.setImageResource(R.drawable.pop);
                break;


        }

    }
}
