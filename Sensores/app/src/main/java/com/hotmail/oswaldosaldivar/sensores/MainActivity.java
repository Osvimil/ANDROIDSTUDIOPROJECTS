package com.hotmail.oswaldosaldivar.sensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    LinearLayout linel;
    SensorManager sm;
    Sensor sensor;
    TextView textel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linel = (LinearLayout) findViewById(R.id.lineal);
        textel = (TextView) findViewById(R.id.tele);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor= sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String texto = String.valueOf(event.values[0]);
        textel.setText(texto);

        float valor= Float.parseFloat(texto);
        if(valor==0){
            linel.setBackgroundColor(Color.BLUE);

        }else{
            linel.setBackgroundColor(Color.CYAN);

        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
