package com.hotmail.oswaldosaldivar.tostadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button bonito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bonito = (Button) findViewById(R.id.btn);

        bonito.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn:

                Toast.makeText(getApplicationContext(),"Soy una tostadora",Toast.LENGTH_SHORT).show();
                break;


        }

    }
}
