package com.hotmail.oswaldosaldivar.actividadesandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText texton;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button) findViewById(R.id.boton);
        texton = (EditText) findViewById(R.id.texs);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.boton:
                Intent intento = new Intent(MainActivity.this,SecondActivity.class);
                String dato = texton.getText().toString();
                intento.putExtra("DATO",dato);
                startActivity(intento);
                break;


        }

    }
}
