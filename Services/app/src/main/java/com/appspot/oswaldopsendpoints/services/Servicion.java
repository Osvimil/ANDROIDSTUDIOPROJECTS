package com.appspot.oswaldopsendpoints.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by oswaldosaldivar on 11/04/16.
 */
public class Servicion extends Service {

    public void onCreate(){
        super.onCreate();
    }


    public int onStartCommand(Intent intent,int flag,int startId){

        Toast.makeText(Servicion.this,"Servicio comenzado",Toast.LENGTH_LONG).show();
        return START_STICKY;

    }

    public void onDestroy(){

        Toast.makeText(Servicion.this,"Servicio detenido",Toast.LENGTH_LONG).show();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
