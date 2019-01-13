package com.hotmail.oswaldosaldivar.butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    TextView textViewA;
    @Bind(R.id.textoB) TextView textViewB;
    @Bind(R.id.boton) Button boton;
    @Bind(R.id.botona)Button boton1;
    @Bind(R.id.botonb) Button boton2;

    @OnClick({R.id.boton,R.id.botona,R.id.botonb})
    public void clicker(){
        Toast.makeText(this,"con butter knife",Toast.LENGTH_SHORT).show();
        textViewB.setText("texto butter knife");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        textViewA = (TextView)findViewById(R.id.textoA);
        textViewA.setText("DE TEXTO A A TEXTO C");

        textViewB.setText("DE TEXTO B A TEXTO D");


    }
}
