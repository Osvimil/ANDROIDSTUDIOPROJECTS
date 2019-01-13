package com.hotmail.oswaldosaldivar.autocompletar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auto = (AutoCompleteTextView)findViewById(R.id.auto);

        String[] meses = getResources().getStringArray(R.array.mesess);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,meses);
        auto.setAdapter(adapter);


    }
}
