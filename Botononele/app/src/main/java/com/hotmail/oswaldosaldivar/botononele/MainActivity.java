package com.hotmail.oswaldosaldivar.botononele;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    TextView texton;
    EditText editon;
    Button botonel;
    Button botonec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texton = (TextView) findViewById(R.id.texto1);
        editon= (EditText) findViewById(R.id.edito1);
        botonel = (Button) findViewById(R.id.boton1);
        botonec = (Button) findViewById(R.id.boton2);

        botonel.setOnClickListener(this);
        botonec.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton1:
                String dato = editon.getText().toString();
                texton.setText(dato);
                break;

            case R.id.boton2:
                texton.setText("viva el IPN y UPIICSA");

                break;


        }

    }
}
