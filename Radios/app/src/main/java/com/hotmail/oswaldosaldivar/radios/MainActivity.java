package com.hotmail.oswaldosaldivar.radios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radios= (RadioGroup) findViewById(R.id.radios);

        radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.uno){
                    Toast.makeText(getApplicationContext(),"UNO",Toast.LENGTH_SHORT).show();
                }
                else if(checkedId == R.id.dos){
                    Toast.makeText(getApplicationContext(),"DOS",Toast.LENGTH_SHORT).show();
                }
                else if(checkedId == R.id.tres){
                    Toast.makeText(getApplicationContext(),"TRES",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
