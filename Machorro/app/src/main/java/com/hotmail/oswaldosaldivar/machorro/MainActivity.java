package com.hotmail.oswaldosaldivar.machorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView view1 = (TextView)view;
        Toast.makeText(getApplicationContext(),"seleccionaste: "+((TextView) view).getText(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    enum Celebridad{
        ARTISTA1,ARTISTA2,ARTISTA3,ARTISTA4,ARTISTA5,ARTISTA6,ARTISTA7;
    }

    private CheckBox[] celebridades;
    private TextView salida;
    //CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salida = (TextView)findViewById(R.id.salida);

        celebridades = new CheckBox[]{
                (CheckBox) findViewById(R.id.artista1),
                (CheckBox) findViewById(R.id.artista2),
                (CheckBox) findViewById(R.id.artista3),
                (CheckBox) findViewById(R.id.artista4),
                (CheckBox) findViewById(R.id.artista5),
                (CheckBox) findViewById(R.id.artista6),
                (CheckBox) findViewById(R.id.artista7),
        };




    }


}
