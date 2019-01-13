package com.hotmail.oswaldosaldivar.linterna;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton_prender, boton_apagar;
    Camera camaron;
    boolean bandera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton_prender = (Button)findViewById(R.id.boton_encender);
        boton_apagar = (Button)findViewById(R.id.boton_apagar);
        boton_prender.setOnClickListener(this);
        boton_apagar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(!bandera){
            switch (v.getId()){
                case R.id.boton_encender:
                    camaron = Camera.open();
                    Camera.Parameters parametros = camaron.getParameters();
                    parametros.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camaron.setParameters(parametros);
                    bandera=true;
                    break;

                case R.id.boton_apagar:
                    camaron.stopPreview();
                    camaron.release();
                    //bandera=false;
                    break;

            }
        }else{
            bandera=false;
        }


    }
}
