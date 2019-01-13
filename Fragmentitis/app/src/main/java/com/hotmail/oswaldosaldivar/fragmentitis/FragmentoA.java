package com.hotmail.oswaldosaldivar.fragmentitis;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by oswaldosaldivar on 21/03/16.
 */
public class FragmentoA extends Fragment implements View.OnClickListener {


    View rootView;
    EditText editText;
    Button button;
    EnviarMensaje em;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstance){

        rootView = inflater.inflate(R.layout.fragmentoa,container,false);

        editText = (EditText)rootView.findViewById(R.id.input);
        button = (Button)rootView.findViewById(R.id.boton);

        button.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {

        String dato = editText.getText().toString();
        em.enviarDato(dato);

    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        em = (EnviarMensaje)activity;


    }
}
