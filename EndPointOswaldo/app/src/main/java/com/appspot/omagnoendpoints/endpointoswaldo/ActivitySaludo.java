package com.appspot.omagnoendpoints.endpointoswaldo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
public class ActivitySaludo extends AppCompatActivity {
    private FragmentSaludo fragment;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_frame);
// Obtiene una referencia al administrador de fragments.
        final FragmentManager fm = getSupportFragmentManager();
        fragment = (FragmentSaludo) fm.findFragmentById(R.id.frame);
        if (fragment == null) {
            fragment = new FragmentSaludo();
// Añade el fragment al ViewGroup con id frame.
            fm.beginTransaction().add(R.id.frame, fragment).commit();
        }
    }
    FragmentSaludo getFragment() {
        return fragment;
    }
}
