package com.hotmail.oswaldosaldivar.listillas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listo;
    String[] valores = new String[]{"America","Pumas","Guadalajara","Toluca","Cruz Azul","Tecos","San Luis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listo = (ListView) findViewById(R.id.liston);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,valores);
        listo.setAdapter(adaptador);

        listo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Posicion: "+position,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
