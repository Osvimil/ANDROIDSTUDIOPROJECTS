package com.hotmail.oswaldosaldivar.fechanac;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final Locale LOCALE = new Locale("es","MX");
    private static final SimpleDateFormat fmtFecha = new SimpleDateFormat("dd/MM/yyyy",LOCALE);
    private static final SimpleDateFormat fmtHora = new SimpleDateFormat("HH:mm",LOCALE);

    private EditText txtNombre;
    private TextView salidaNombre;

    private EditText txtFecha;
    private TextView salidaFecha;

    private EditText txtHora;
    private TextView salidaHora;

    private TimePicker tpTimePicker;
    private TextView salidaTimePicker;

   private FloatingActionButton fabAceptar;
    private CoordinatorLayout coordinatorLayout;
    private boolean error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        salidaNombre = (TextView)findViewById(R.id.salidaNombre);

        txtFecha = (EditText)findViewById(R.id.FechaYHoraNombre);
        salidaFecha = (TextView)findViewById(R.id.salidaFechaYHoraNombre);

        txtHora = (EditText)findViewById(R.id.hora);
        salidaHora = (TextView)findViewById(R.id.salidaHora);

        tpTimePicker = (TimePicker)findViewById(R.id.timePicker);
        salidaTimePicker = (TextView)findViewById(R.id.salidaTimePicker);

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinador);

        fabAceptar = (FloatingActionButton)findViewById(R.id.fabAcpetar);
        fabAceptar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        error = false;
        final String valor = leeCadena(txtNombre);
        salidaNombre.setText(valor);

        final Date ahora = new Date();
        final Date fechaNac = lee(txtFecha,salidaFecha,fmtFecha,"FECHA INCORRECTA");

        if (fechaNac !=null && fechaNac.compareTo(ahora)>=0){

            txtFecha.setError("ERROR EN LA FECHA");
        }

        final Date hora = lee(txtHora,salidaHora,fmtHora,"HORA INCORRECTA");
        final Calendar timePicker = Calendar.getInstance();
        timePicker.set(Calendar.HOUR_OF_DAY,tpTimePicker.getCurrentHour());
        timePicker.set(Calendar.MINUTE,tpTimePicker.getCurrentMinute());
        salidaTimePicker.setText(fmtHora.format(timePicker.getTime()));

        if(!error){
            Snackbar.make(coordinatorLayout,"NOMBRE: "+valor + "FECHANAC: "+fmtFecha.format(fechaNac)+"HORA:"+fmtHora.format(hora),Snackbar.LENGTH_LONG).show();

        }

    }

    private Date lee(EditText editText, TextView salida, SimpleDateFormat fmt, String mensajeDeError) {

        try{
            Date fecha = leeDate(editText,fmt,mensajeDeError);
            salida.setText(fmt.format(fecha));
            return fecha;

        }catch(ParseException e){
            salida.setText("");
            return null;


        }
    }

    private Date leeDate(EditText editText, SimpleDateFormat fmt, String mensajeDeError) throws ParseException{
        try{

            final String valor = editText.getText().toString().trim();
            return fmt.parse(valor);

        }catch(ParseException e){
            editText.setError(mensajeDeError);
            throw e;

        }

    }

    private String leeCadena(EditText texto) {

        final String s = texto.getText().toString().trim();
        if(s.length()==0){
            error=true;
            texto.setError("FALTA EL VALOR AMIGO");

        }else{

            texto.setError(null);
        }

        return s;
    }
}
