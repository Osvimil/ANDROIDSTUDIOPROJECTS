package com.hotmail.oswaldosaldivar.tostan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text1;
    TextView text2;
    TextView text3;
    Button boton1;
    Button boton2;
    Button boton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.uno);
        text2 = (TextView) findViewById(R.id.dos);
        text3 = (TextView) findViewById(R.id.tres);
        boton1 = (Button) findViewById(R.id.one);
        boton2 = (Button) findViewById(R.id.two);
        boton3 = (Button) findViewById(R.id.three);

        text1.setText("el primero cambiado");
        text2.setText("el segundo cambiado");
        text3.setText("el tercero cambiado");

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.one:
                Toast.makeText(getApplicationContext(),"TOAST NUMERO 1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.two:
                Toast.makeText(getApplicationContext(),"TOAST NUMERO 2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.three:
                Toast.makeText(getApplicationContext(),"TOAST NUMERO 3",Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
