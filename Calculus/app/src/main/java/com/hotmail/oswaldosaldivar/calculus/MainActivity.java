package com.hotmail.oswaldosaldivar.calculus;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout txtx;
    private TextInputLayout txtf;
    private Button boton;
    CoordinatorLayout cordinador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtx = (TextInputLayout) findViewById(R.id.textoinput1);
        txtf = (TextInputLayout) findViewById(R.id.textoinput2);
        boton = (Button) findViewById(R.id.boton);
        cordinador = (CoordinatorLayout) findViewById(R.id.coordinador);

        boton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        calcula();

    }

    public  void calcula(){
        txtx.setError(null);
        txtf.setError(null);
        boolean okay = true;

        double x=0;
        try{
            x= leeDoble(txtx);


        }catch(NumberFormatException e){
            okay= false;

        }

        double f=0;
        try{
            f = leeDoble(txtf);

        }catch(NumberFormatException e){
            okay=false;

        }
        if(okay){

            final double divisor = x-2*f;
            if(Math.abs(divisor)>0.0005){
                double a = (2*x+f)/divisor;
                mensaje("a = "+a);
            }else{

                mensaje("combinacion incorrecta");
            }
        }

    }

    private void mensaje(String strang) {
        Snackbar.make(cordinador,strang,Snackbar.LENGTH_LONG).show();
    }

    private double leeDoble(final TextInputLayout editText)
        throws NumberFormatException{
            try{
            return Double.parseDouble(editText.getEditText().getText().toString().trim());

            }catch(NumberFormatException e){
                editText.setError("valor incorrecto");
                throw e;

            }

        }


}
