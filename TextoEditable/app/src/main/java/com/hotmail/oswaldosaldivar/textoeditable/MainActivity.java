package com.hotmail.oswaldosaldivar.textoeditable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText texteable;
    EditText onemore;
    EditText casabasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texteable = (EditText) findViewById(R.id.textel);
        onemore = (EditText) findViewById(R.id.magico);
        casabasa = (EditText) findViewById(R.id.neza);
        texteable.setText("changing the text");
        onemore.setText("changing the next text number two");
        casabasa.setText("changing the third text, je sui très intelligent");

    }
}
