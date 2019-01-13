package com.hotmail.oswaldosaldivar.autocompletar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton;
    TextView texto;
    AutoCompleteTextView autos;

    String [] estados = {"durango","distrito","chiapas","chihuahua","colima","campeche","guanajuato"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.boton);
        texto = (TextView) findViewById(R.id.texto);
        autos = (AutoCompleteTextView) findViewById(R.id.auto);

        boton.setOnClickListener(this);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,estados);
        autos.setThreshold(1);
        autos.setAdapter(adaptador);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton:
                String cambio = autos.getText().toString();
                texto.setText(cambio);
                break;


        }

    }
}
