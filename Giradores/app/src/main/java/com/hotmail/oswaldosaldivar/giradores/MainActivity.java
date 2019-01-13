package com.hotmail.oswaldosaldivar.giradores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner girador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        girador = (Spinner) findViewById(R.id.spinner);
        List listilla = new ArrayList();
        listilla.add("Francia");
        listilla.add("Italia");
        listilla.add("Alemania");
        listilla.add("España");
        listilla.add("Portugal");
        listilla.add("Holanda");

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,listilla);
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        girador.setAdapter(adaptador);


       girador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this,"Posicion: "+String.valueOf(girador.getSelectedItem()),Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


    }
}
