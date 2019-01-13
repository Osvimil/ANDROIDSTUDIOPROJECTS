/* COPYRIGHT 2016 M. EN C. RICARDO ARMANDO MACHORRO REYES.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License. */

package com.hotmail.rickamr.validacion;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
 * MANEJO DE LOS COMPONENTES EN ANDROID 6.0 MARSHMALLOW
  * PARA VALIDAR DATOS DE ENTRADA USANDO TAMBIEN MATERIAL DESIGN
 *
 * */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextInputLayout txtX;
    private TextInputLayout txtF;
    private Button btnCalcular;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtX = (TextInputLayout) findViewById(R.id.ilX);
        txtF = (TextInputLayout) findViewById(R.id.ilF);
        coordinatorLayout=(CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        calcula();
    }

    public void calcula() {
        txtX.setError(null);
        txtF.setError(null);
        boolean ok = true;
        double x = 0;
        try {
            x = leeDouble(txtX);
        } catch (NumberFormatException e) {
            ok = false;
        }
        double f = 0;
        try {
            f = leeDouble(txtF);
        } catch (NumberFormatException e) {
            ok = false;
        }
        if (ok) {
            final double divisor = x - 2 * f;
            if (Math.abs(divisor) > 0.0005) {
                double a = (2 * x + f) / divisor;
                mensaje("a = " + a);
            } else {
                mensaje("Combinacion incorrecta.");
            }
        }
    }

    /**
     * Lee el texto de un EditText y lo convierte en un double.
     *
     * @param editText
     *            cuadro de texto.
     * @return el valor capturado en el cuadro de texto.
     * @throws NumberFormatException
     *             si el valor introducido no es un numero o el campo esta en
     *             blanco.
     */
    private double leeDouble(final TextInputLayout editText)
            throws NumberFormatException {
        try {
            return Double.parseDouble(editText.getEditText().getText().toString().trim());
        } catch (NumberFormatException e) {
            editText.setError("Valor incorrecto.");
            throw e;
        }
    }

    private void mensaje(String texto) {

        //Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        Snackbar
                .make(coordinatorLayout, texto,
                        Snackbar.LENGTH_LONG).show();

    }

}
