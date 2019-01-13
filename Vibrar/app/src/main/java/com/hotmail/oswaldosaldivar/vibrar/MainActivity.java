package com.hotmail.oswaldosaldivar.vibrar;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button)findViewById(R.id.vibrar);
        boton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.vibrar:
                Vibrator vibrator = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(600);
                break;
        }

    }
}
