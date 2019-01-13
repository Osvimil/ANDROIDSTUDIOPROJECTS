package com.hotmail.oswaldosaldivar.expiner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner girador;
    Button bon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        girador = (Spinner) findViewById(R.id.espiner);
        bon = (Button) findViewById(R.id.boton);
        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this,R.array.colores, android.R.layout.simple_spinner_item);
        girador.setAdapter(adaptador);

        bon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String items = girador.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "Color seleccionado: " + items, Toast.LENGTH_SHORT).show();

            }
        });

       

    }
}
