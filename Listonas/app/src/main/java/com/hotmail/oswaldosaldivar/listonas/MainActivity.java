package com.hotmail.oswaldosaldivar.listonas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listas;
    String[] cadenas = {"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listas = (ListView)findViewById(R.id.listillas);
        ArrayAdapter<String> arreglo = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,cadenas);
        listas.setAdapter(arreglo);

        listas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),"El valor es: "+view.toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
