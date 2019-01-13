package com.hotmail.oswaldosaldivar.trabajador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView no_empleado, nombre_empleado,dias_trabajados,sueldo_diario,sueldo_total,fecha_pago;
    EditText empleado,nombre,d_trabajados,s_diario,s_total;
    Button calcular_fecha,calcular_salario;
    DatePicker fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcular_fecha = (Button)findViewById(R.id.boton);
        calcular_fecha.setOnClickListener(this);

        calcular_salario = (Button)findViewById(R.id.calcular);
        calcular_salario.setOnClickListener(this);

        empleado = (EditText)findViewById(R.id.no_empleado);
        nombre=(EditText)findViewById(R.id.nombre_empleado);
        d_trabajados = (EditText)findViewById(R.id.dias_trabajados);
        s_diario = (EditText)findViewById(R.id.sueldo_diario);
        s_total = (EditText)findViewById(R.id.sueldo_final);
        fecha = (DatePicker)findViewById(R.id.fecha);
        fecha_pago = (TextView)findViewById(R.id.fecha_mostrar);
        sueldo_total = (TextView)findViewById(R.id.sueldo_total);
    }

    @Override
    public void onClick(View v) {



        switch(v.getId()){

            case R.id.boton:
                fecha_pago.setText(String.valueOf(fecha.getDayOfMonth()+"-"+
                        String.valueOf(fecha.getMonth()+"-"+
                                        String.valueOf(fecha.getYear())
                        )));
                break;

            case R.id.calcular:
                try{

                }catch (Exception e){
                    String x = d_trabajados.getText().toString().trim();
                    String y = s_diario.getText().toString().trim();

                    int calculo = Integer.parseInt(x) + Integer.parseInt(y);

                   sueldo_total.setText(String.valueOf(calculo));
                }
                break;
        }



    }
}
