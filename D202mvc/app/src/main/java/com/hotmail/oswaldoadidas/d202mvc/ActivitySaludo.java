package com.hotmail.oswaldoadidas.d202mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;

import android.support.annotation.IdRes;

import android.support.annotation.NonNull;

import android.support.annotation.StringRes;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

public class ActivitySaludo extends AppCompatActivity {

    private static final String VIEW_NO_ENCONTRADA = "View no encontrada en el archivo xml.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_saludo);

        final Button btnSaludar = getBtnSaludar();

        btnSaludar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                clicEnSaludar();

            }

        });
    }

    @NonNull Button getBtnSaludar() {

        return (Button) busca(R.id.btnSaludar);

    }

    @NonNull TextView getLblSalida() {

        return (TextView) busca(R.id.lblSalida);

    }

    @NonNull View busca(@IdRes int idView) {

        final View view = findViewById(idView);

        if (view == null) {

            throw new NullPointerException(VIEW_NO_ENCONTRADA);

        } else {

            return view;

        }

    }

    public void clicEnSaludar() {

        try {

            final String nombre1 = recuperaTexto(R.id.txtNombre1);

            final String nombre2 = recuperaTexto(R.id.txtNombre2);

            final Nombres modelo = new Nombres(nombre1, nombre2);

            final String saludo = saluda(modelo);

            muestraRespuesta(saludo);

        } catch (ExceptionFaltaNombre exceptionFaltaNombre) {

            muestraRespuesta(exceptionFaltaNombre.getLocalizedMessage());

        }

    }

    @NonNull private String saluda(@NonNull Nombres modelo)

            throws ExceptionFaltaNombre {

        valida(modelo.getNombre1(), R.string.falta_el_nombre_1);

        valida(modelo.getNombre2(), R.string.falta_el_nombre_2);

        return construyeSaludo(modelo);

    }

    @NonNull private String recuperaTexto(@IdRes int idEditText) {

        final EditText editText = (EditText) busca(idEditText);

        return editText.getText().toString();

    }

    private void valida(@NonNull String nombre, @StringRes int idMensajeDeError)

            throws ExceptionFaltaNombre {

        if (nombre.isEmpty()) {

            throw new ExceptionFaltaNombre(getString(idMensajeDeError));

        }

    }

    @NonNull private String construyeSaludo(@NonNull Nombres modelo) {

        return getString(R.string.formato_del_saludo, modelo.getNombre1(),

                modelo.getNombre2());

    }

    private void muestraRespuesta(@NonNull String respuesta) {

        final TextView lblSalida = getLblSalida();

        lblSalida.setText(respuesta);
    }
}
