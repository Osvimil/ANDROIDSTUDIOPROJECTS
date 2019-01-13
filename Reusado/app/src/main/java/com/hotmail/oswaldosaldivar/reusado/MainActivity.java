package com.hotmail.oswaldosaldivar.reusado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView uno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uno = (TextView) findViewById(R.id.texto);
        uno.setText("Texto numero dos cambiado");
    }
}
