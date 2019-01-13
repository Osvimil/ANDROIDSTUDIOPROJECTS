package com.hotmail.oswaldosaldivar.podervibrar;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.boton)Button boton;

    @OnClick (R.id.boton)

    public void click(View view){
        Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        if(vibrator.hasVibrator()){
            Log.v("Podemos vibrar","si");
            Toast.makeText(this,"Si se pudo",Toast.LENGTH_SHORT).show();

        }else{
            Log.v("Podemos vibrar","no");

        }


    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
