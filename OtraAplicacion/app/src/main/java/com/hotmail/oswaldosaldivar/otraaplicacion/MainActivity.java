package com.hotmail.oswaldosaldivar.otraaplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mejor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mejor = (TextView) findViewById(R.id.textillo1);
        mejor.setText("One more time, text has been modified");
    }
}
