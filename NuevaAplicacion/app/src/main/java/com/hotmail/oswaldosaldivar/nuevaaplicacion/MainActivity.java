package com.hotmail.oswaldosaldivar.nuevaaplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView chela;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chela = (TextView) findViewById(R.id.textello);
        chela.setText("I love studying two languages");
    }
}
