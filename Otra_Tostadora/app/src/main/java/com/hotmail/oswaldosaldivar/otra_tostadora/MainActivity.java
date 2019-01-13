package com.hotmail.oswaldosaldivar.otra_tostadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botonis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonis = (Button) findViewById(R.id.boton);

        botonis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.boton:
                Toast.makeText(getApplicationContext(),"GRACIAS POR PRESIONAR",Toast.LENGTH_SHORT).show();
                break;


        }

    }
}
