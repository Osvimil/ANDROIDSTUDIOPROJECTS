package com.hotmail.oswaldosaldivar.timepickert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button boton;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrarTiempo();

    }

    public void mostrarTiempo(){
        boton = (Button)findViewById(R.id.boton);
        timePicker = (TimePicker)findViewById(R.id.time_picker);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"La hora es: "+timePicker.getCurrentHour()+" : "+ timePicker.getCurrentMinute(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
