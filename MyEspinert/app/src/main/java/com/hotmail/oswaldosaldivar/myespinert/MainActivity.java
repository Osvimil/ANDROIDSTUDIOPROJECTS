package com.hotmail.oswaldosaldivar.myespinert;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout cordinator;
     private Spinner espiner;
     private Spinner otrospiner;
     private TextView seleccion;
     private  TextView opcion;
     private int suma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cordinator = (CoordinatorLayout) findViewById(R.id.coordinador);
        espiner = (Spinner) findViewById(R.id.espiner);
        otrospiner = (Spinner) findViewById(R.id.espiner2);
        seleccion = (TextView) findViewById(R.id.seleccion);

        final ArrayList<String> datos= new ArrayList<String>();

        final ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.motos,android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        espiner.setAdapter(adaptador);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);
        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        otrospiner.setAdapter(adaptador2);


        espiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccion.setText("seleccionado: "+parent.getSelectedItem().toString());
                String nuevodato = parent.getSelectedItem().toString().trim();

                if(nuevodato.length()>1){
                    switch(position){
                        case 1:
                            suma +=100;
                            break;

                        case 2:
                            suma+=200;
                            break;

                        case 3:
                            suma+=300;
                            break;

                        case 4:
                            suma+=400;
                            break;

                        case 5:
                            suma+=500;
                            break;

                        case 6:
                            suma+=600;
                            break;



                    }

                }
                Toast.makeText(MainActivity.this,"TOTAL A PAGAR: "+String.valueOf(suma),Toast.LENGTH_SHORT,this
                "TOTAL A PAGAR: "+String.valueOf(suma),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                seleccion.setText("");

            }
        });



    }
}
