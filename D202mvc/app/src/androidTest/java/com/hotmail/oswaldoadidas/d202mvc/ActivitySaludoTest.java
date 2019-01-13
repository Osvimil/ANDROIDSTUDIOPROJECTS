package com.hotmail.oswaldoadidas.d202mvc;

/**
 * Created by oswaldosaldivar on 13/04/16.
 */

import android.support.annotation.IdRes;

import android.test.ActivityInstrumentationTestCase2;

import android.test.TouchUtils;

import android.widget.EditText;

import android.widget.TextView;
public class ActivitySaludoTest extends ActivityInstrumentationTestCase2<ActivitySaludo>  {

    private static final String FALTA_EL_NOMBRE_1 = "Falta el nombre 1.";

    private static final String FALTA_EL_NOMBRE_2 = "Falta el nombre 2.";

    public ActivitySaludoTest() {

        super(ActivitySaludo.class);

    }

    @Override protected void setUp() throws Exception {

        super.setUp();

        getActivity();

    }

    public void testP1() {

        TouchUtils.clickView(this, getActivity().getBtnSaludar());

        assertEquals(FALTA_EL_NOMBRE_1, getTextoSalida());

    }

    public void testP2() {

        asignaTexto(R.id.txtNombre1, "Pedro");

        TouchUtils.clickView(this, getActivity().getBtnSaludar());

        assertEquals(FALTA_EL_NOMBRE_2, getTextoSalida());

    }

    public void testP3() {

        asignaTexto(R.id.txtNombre2, "Ana");

        TouchUtils.clickView(this, getActivity().getBtnSaludar());

        assertEquals(FALTA_EL_NOMBRE_1, getTextoSalida());

    }

    public void testP4() throws Exception {

        asignaTexto(R.id.txtNombre1, "Pedro");

        asignaTexto(R.id.txtNombre2, "Ana");

        TouchUtils.clickView(this, getActivity().getBtnSaludar());

        assertEquals("Saludos a Pedro y a Ana.", getTextoSalida());

    }

    public void testP5() throws Exception {

        asignaTexto(R.id.txtNombre2, "Pepe");

        asignaTexto(R.id.txtNombre1, "Cuca");

        TouchUtils.clickView(this, getActivity().getBtnSaludar());

        assertEquals("Saludos a Cuca y a Pepe.", getTextoSalida());

    }

    private void asignaTexto(@IdRes int idEditText, String s) {

        final EditText editText = (EditText) getActivity().busca(idEditText);

        getInstrumentation().runOnMainSync(new Runnable() {

            @Override

            public void run() {

                editText.requestFocus();

            }

        });

        getInstrumentation().waitForIdleSync();

        getInstrumentation().sendStringSync(s);

        getInstrumentation().waitForIdleSync();
    }
    private String getTextoSalida() {

        final TextView lblSalida = getActivity().getLblSalida();

        return lblSalida.getText().toString();

    }
}
