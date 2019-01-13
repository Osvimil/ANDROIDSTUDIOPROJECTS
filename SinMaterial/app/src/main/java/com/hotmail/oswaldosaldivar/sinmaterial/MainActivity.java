package com.hotmail.oswaldosaldivar.sinmaterial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView uno;
    TextView dos;
    EditText edit1;
    EditText edit2;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uno = (TextView) findViewById(R.id.textuno);
        dos = (TextView) findViewById(R.id.textodos);
        edit1 = (EditText) findViewById(R.id.ediuno);
        edit2= (EditText) findViewById(R.id.editdos);
        boton = (Button) findViewById(R.id.btn);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn:
                Toast.makeText(getApplicationContext(),"No has presionado nada",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
