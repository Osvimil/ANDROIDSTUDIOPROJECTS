package com.hotmail.oswaldosaldivar.snackbar;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Botonele();

    }

    public void Botonele(){

        boton = (FloatingActionButton)findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Snackbar snackbar= Snackbar.make(v, "This is a snackbar", Snackbar.LENGTH_SHORT);
                View view = snackbar.getView();

                view.setBackgroundColor(Color.CYAN);
                snackbar.show();
            }
        });


    }

}
