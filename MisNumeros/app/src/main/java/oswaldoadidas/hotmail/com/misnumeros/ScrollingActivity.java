package oswaldoadidas.hotmail.com.misnumeros;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ScrollingActivity extends AppCompatActivity implements  View.OnClickListener {
    private static final Locale LOCALE = Locale.US;
    private static  final NumberFormat fmtEntero = NumberFormat.getIntegerInstance();
    private static final DecimalFormat fmtNumero= new DecimalFormat("#,##0.00",new DecimalFormatSymbols(LOCALE));
    private static final NumberFormat ftmMoneda = NumberFormat.getCurrencyInstance(LOCALE);
    private RatingBar rbRating;
    private TextView salidaRating;
    private EditText txtNumeroSecreto;
    private TextView salidaNumeroSecreto;
    private EditText txtNumeroConFormato;
    private TextView salidaPrecio;
    private FloatingActionButton fabAceptar;
    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rbRating = (RatingBar)findViewById(R.id.rating);
        salidaRating=(TextView)findViewById(R.id.salidaRating);
        txtNumeroSecreto = (EditText)findViewById(R.id.numeroSecreto);
        salidaNumeroSecreto=(TextView)findViewById(R.id.salidaNumeroSecreto);
        txtNumeroConFormato=(EditText)findViewById(R.id.numeroConFormato);
        salidaPrecio=(TextView)findViewById(R.id.salidaPrecio);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        fabAceptar=(FloatingActionButton)findViewById(R.id.fabAceptar);
        fabAceptar.setOnClickListener(this);
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        final int rating = rbRating.getProgress();
        salidaRating.setText(String.valueOf(rating));
        lee(txtNumeroSecreto,salidaNumeroSecreto,fmtEntero);
        try{
            final Number numeroConFormato = leeNumber(txtNumeroConFormato,fmtNumero);
            txtNumeroConFormato.setText(fmtNumero.format(numeroConFormato));
            final BigDecimal precio = new BigDecimal(
                    numeroConFormato.intValue()).multiply(BigDecimal.valueOf(1034.12));
            salidaPrecio.setText(ftmMoneda.format(precio));

        }catch(ParseException e){
            salidaPrecio.setText("");

        }
    }

    private Number lee(EditText editText, TextView salida, NumberFormat fmt)  {
        try{
            Number numero = leeNumber(editText,fmt);
            salida.setText(fmt.format(numero));
            return numero;

        }catch(ParseException e){
            salida.setText("");
            return null;


        }

    }

    private Number leeNumber(final EditText editText,final NumberFormat fmt) throws ParseException {
        try{
            final String valor = editText.getText().toString().trim();
            return fmt.parse(valor);

        }catch(ParseException e){
            editText.setError("Numero incorrecto");
            throw  e;

        }
    }
}
