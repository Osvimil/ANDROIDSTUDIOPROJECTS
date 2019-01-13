package com.hotmail.oswaldosaldivar.material;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texton1;
    TextView texton2;
    EditText edit1;
    EditText edit2;
    Button boton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texton1 = (TextView) findViewById(R.id.texto1);
        texton2 = (TextView) findViewById(R.id.texto2);
        edit1 = (EditText) findViewById(R.id.editar1);
        edit2 = (EditText) findViewById(R.id.editar2);
        boton = (Button) findViewById(R.id.boton1);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


    }
}
