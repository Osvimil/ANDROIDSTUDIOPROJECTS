package com.hotmail.oswaldosaldivar.fragmentitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements EnviarMensaje {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void enviarDato(String mensaje) {
        FragmentoB fragmento = (FragmentoB)getFragmentManager().findFragmentById(R.id.fragmentoB);
        fragmento.recibir(mensaje);

    }
}
