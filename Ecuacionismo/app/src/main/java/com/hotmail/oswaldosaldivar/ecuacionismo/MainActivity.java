package com.hotmail.oswaldosaldivar.ecuacionismo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout txty;
    private  TextInputLayout txtz;
    private Button boton;
    CoordinatorLayout cordinator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txty = (TextInputLayout)findViewById(R.id.textinput1);
        txtz = (TextInputLayout) findViewById(R.id.textinput2);
        boton = (Button) findViewById(R.id.boton);
        cordinator = (CoordinatorLayout) findViewById(R.id.cordinador);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        calcular();

    }

    private void calcular() {

        txty.setError(null);
        txtz.setError(null);
        boolean validador=true;

        double y=0;
        try{
            y=leerDoble(txty);
        }catch(NumberFormatException e){
            validador = false;
        }

        double z=0;
        try{
            z=leerDoble(txtz);
        }catch(NumberFormatException e){
            validador = false;
        }
        if(validador){
             double divisor = y*y-z;
            if(Math.abs(divisor)>0.0005){
                double x =(y-3*z)/divisor;
                mensaje("X = " + x );

            }else{
                mensaje("La combination c'est très mal");

            }

        }
    }

    private void mensaje(String cadenilla) {

        Snackbar.make(cordinator,cadenilla,Snackbar.LENGTH_LONG).show();
    }

    private double leerDoble(final TextInputLayout editText)
    throws NumberFormatException{

        try{
            return Double.parseDouble(editText.getEditText().getText().toString().trim());
        }catch(NumberFormatException e){
            editText.setError(" il y a beaocoup d'error");
            throw e;


        }
    }
}
