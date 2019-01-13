package com.hotmail.oswaldosaldivar.pequenasuma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText sum1,sum2,res;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sum1= (EditText)findViewById(R.id.suma1);
        sum2= (EditText)findViewById(R.id.suma2);
        res= (EditText)findViewById(R.id.resultado);
        calcular = (Button)findViewById(R.id.resultadin);

        calcular.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.resultado:
                String x = sum1.getText().toString().trim();
                String y = sum2.getText().toString().trim();

                int calculo = Integer.parseInt(x) + Integer.parseInt(y);
                calcular.setText(calculo);
                break;


        }

    }
}
