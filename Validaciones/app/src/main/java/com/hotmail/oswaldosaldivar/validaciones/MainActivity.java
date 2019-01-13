package com.hotmail.oswaldosaldivar.validaciones;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout txtx;
    private TextInputLayout txtf;
    CoordinatorLayout coordinatorLayout;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtx = (TextInputLayout)findViewById(R.id.ilx);
        txtf = (TextInputLayout)findViewById(R.id.ily);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorlayout);
        calcular=(Button)findViewById(R.id.boton);

        calcular.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        txtx.setError(null); // SE AGREGA EL DÍA 26 DE FEBRERO
        txtf.setError(null); // SE AGREGA EL DÍA 26 DE FEBRERO
        boolean ok = true;
        double x = 0;
        try {
            x = leeDouble(txtx);
        } catch (NumberFormatException e) {
            ok = false;

        }

        double f = 0;
        try {
            f = leeDouble(txtf);
        } catch (NumberFormatException e) {
            ok = false;

        }

        if (ok) {
            double division = x - 2 * f;
            if (Math.abs(division) > 0.0005) {
                double a = (2 * x + f) / division;
                mensaje("a = " + a);


            } else {
                mensaje("combinacion incorrecta");

            }
        }
    }
    private void mensaje(String texto) {
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }

    public double leeDouble(TextInputLayout editText) throws NumberFormatException{
        try{
            return Double.parseDouble(editText.getEditText().toString().trim());

        }catch(NumberFormatException e){
            editText.setError("ERROR");
            throw e;

        }


    }

    }

