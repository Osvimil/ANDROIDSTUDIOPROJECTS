package com.hotmail.oswaldosaldivar.fragmentitis;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by oswaldosaldivar on 21/03/16.
 */
public class FragmentoB extends Fragment {

    View rootView;
    TextView output;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){

        rootView = inflater.inflate(R.layout.fragmentob,container,false);

        output = (TextView)rootView.findViewById(R.id.output);
        return  rootView;
    }

    public void recibir(String ms){
        output.setText(ms);


    }
}
