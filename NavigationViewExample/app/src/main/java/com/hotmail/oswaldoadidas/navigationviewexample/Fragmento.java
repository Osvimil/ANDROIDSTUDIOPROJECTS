package com.hotmail.oswaldoadidas.navigationviewexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by oswaldosaldivar on 02/05/16.
 */
public class Fragmento extends Fragment {

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragmento,container,false);
        return v;
    }

}
