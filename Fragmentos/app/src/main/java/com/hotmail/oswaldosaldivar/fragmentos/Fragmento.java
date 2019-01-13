package com.hotmail.oswaldosaldivar.fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by oswaldosaldivar on 21/03/16.
 */
public class Fragmento extends Fragment {

    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){

        rootView = inflater.inflate(R.layout.fragmentacion,container,false);

        return  rootView;
    }
}
