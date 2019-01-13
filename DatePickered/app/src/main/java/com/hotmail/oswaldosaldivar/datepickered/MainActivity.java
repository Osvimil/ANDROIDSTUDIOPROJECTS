package com.hotmail.oswaldosaldivar.datepickered;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    TextView textView;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker)findViewById(R.id.datepicker);
        textView = (TextView)findViewById(R.id.texto);
        boton = (Button)findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(String.valueOf(datePicker.getDayOfMonth()+"-"+
                        String.valueOf(datePicker.getMonth()+"-"+
                        String.valueOf(datePicker.getYear())
                        )
                ));

            }
        });


    }
}
