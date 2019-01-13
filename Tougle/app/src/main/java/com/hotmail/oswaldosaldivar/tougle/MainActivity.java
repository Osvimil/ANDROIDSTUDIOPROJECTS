package com.hotmail.oswaldosaldivar.tougle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tougle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tougle = (ToggleButton)findViewById(R.id.toogle);
        tougle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"TRUE",Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(MainActivity.this,"FALSE",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
