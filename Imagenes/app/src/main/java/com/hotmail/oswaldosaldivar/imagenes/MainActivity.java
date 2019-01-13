package com.hotmail.oswaldosaldivar.imagenes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iman = (ImageView) findViewById(R.id.imagenon);
        iman.clearColorFilter();
    }
}
