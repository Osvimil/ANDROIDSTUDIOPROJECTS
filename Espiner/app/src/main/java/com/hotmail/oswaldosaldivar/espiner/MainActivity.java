package com.hotmail.oswaldosaldivar.espiner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner espiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        espiner = (Spinner) findViewById(R.id.spinner);
        List lista = new ArrayList();
        lista.add("MORADO");
        lista.add("AZUL");
        lista.add("ROJO");
        lista.add("VERDE");
        lista.add("AMARILLO");
        lista.add("NEGRO");
        lista.add("BLANCO");
        lista.add("NARANJA");

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        espiner.setAdapter(adaptador);

        espiner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Posicion :"+String.valueOf(espiner.getSelectedItem()),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
