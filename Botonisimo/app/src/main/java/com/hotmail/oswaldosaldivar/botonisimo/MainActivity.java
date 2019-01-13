package com.hotmail.oswaldosaldivar.botonisimo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText editar1;
    TextView texto1;
    Button botonel1;
    Button botonel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editar1 = (EditText) findViewById(R.id.editillo);
        texto1 = (TextView) findViewById(R.id.textillo);
        botonel1 = (Button) findViewById(R.id.boton1);
        botonel2 = (Button) findViewById(R.id.boton2);

        botonel1.setOnClickListener(this);
        botonel2.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton1:
                String dato = editar1.getText().toString();
                texto1.setText(dato);
                break;

            case R.id.boton2:
                texto1.setText("el otro pues");
                break;


        }
    }
}
