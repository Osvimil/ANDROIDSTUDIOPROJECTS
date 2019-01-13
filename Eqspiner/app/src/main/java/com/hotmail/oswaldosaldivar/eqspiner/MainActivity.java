package com.hotmail.oswaldosaldivar.eqspiner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner espiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        espiner = (Spinner) findViewById(R.id.spiner);

        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this,R.array.materias,android.R.layout.simple_spinner_item);
        espiner.setAdapter(adaptador);
        espiner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView mytexto = (TextView)view;
        Toast.makeText(this,"Haz seleccinado: "+mytexto.getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
