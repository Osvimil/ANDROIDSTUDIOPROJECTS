package com.hotmail.oswaldosaldivar.vibracion;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button)findViewById(R.id.boton);

        final Vibrator vibrator = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long[] patron= {200,100,300,100,250,286,340};
                vibrator.vibrate(patron,0);

                // cuando es 0 se reproduce infinitamente
                // cuando es -1 tiene recorrido de principio a fin


            }
        });
    }
}
