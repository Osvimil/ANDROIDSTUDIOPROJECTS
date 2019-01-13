package com.hotmail.oswaldosaldivar.camara;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton;
    Camera camara;
    boolean bandera=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button)findViewById(R.id.boton_luz);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(!bandera){
            camara = Camera.open();
            Camera.Parameters parametros = camara.getParameters();
            parametros.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camara.setParameters(parametros);
            camara.startPreview();
            bandera=true;
        }else{
            camara.stopPreview();
            camara.release();
            bandera=false;

        }


    }
}
