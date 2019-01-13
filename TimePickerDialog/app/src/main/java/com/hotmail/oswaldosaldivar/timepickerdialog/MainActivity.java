package com.hotmail.oswaldosaldivar.timepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boton;
    static final int DIALOG_ID =0;
    int hora_x;
    int minutos_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obtenerTiempoDialogo();
    }

    public void obtenerTiempoDialogo(){
        boton = (Button)findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID){
            return new TimePickerDialog(MainActivity.this,timePickerListener,hora_x,minutos_x,false);
        }
        return null;
    }

    protected  TimePickerDialog.OnTimeSetListener timePickerListener=
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hora_x = hourOfDay;
                    minutos_x = minute;
                    Toast.makeText(MainActivity.this,"La hora es: "+hora_x+ " : "+minutos_x,Toast.LENGTH_SHORT).show();
                }
            };


}
