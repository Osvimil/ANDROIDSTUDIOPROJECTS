package oswaldoadidas.hotmail.com.spinnersabritas;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
//import java.util.function.ToLongBiFunction;

public class ScrollingActivity extends AppCompatActivity {
    private TextView lblSeleccionPais;
    private Spinner cmbOpciones;
    private int precio;
    private ImageView pais;
    private CoordinatorLayout coordinatorLayout;
    private FloatingActionButton fab;
    private static final Locale LOCALE = Locale.US;
    private static final NumberFormat fmtMoneda = NumberFormat.getCurrencyInstance(LOCALE);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        lblSeleccionPais = (TextView)findViewById(R.id.seleccionPais);
        cmbOpciones = (Spinner)findViewById(R.id.cmbOpciones);
        pais = (ImageView)findViewById(R.id.pais);

        final ArrayList<String> datos = new ArrayList<String>();

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.valores_array,android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);
        cmbOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lblSeleccionPais.setText("Seleccion de pais");
                
                String nuevoDato = parent.getSelectedItem().toString().trim();


                switch(position){
                    case 0:
                        precio = 1000;
                        pais.setImageResource(R.drawable.ic_pan_tool_black_24dp);
                        break;
                    case 1:
                        precio = 2000;
                        pais.setImageResource(R.drawable.ic_open_in_browser_black_24dp);
                        break;
                    case 2:
                        precio = 3000;
                        pais.setImageResource(R.drawable.ic_gavel_black_24dp);
                        break;
                    case 3:
                        precio = 4000;
                        pais.setImageResource(R.drawable.ic_g_translate_black_24dp);
                        break;
                    case 4:
                        precio = 5000;
                        pais.setImageResource(R.drawable.ic_fingerprint_black_24dp);
                        break;

                }
                datos.add(nuevoDato);
                Snackbar.make(coordinatorLayout,"Precio"+fmtMoneda.format(precio),Snackbar.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lblSeleccionPais.setText("");


            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout, "Precio"+fmtMoneda.format(precio),Snackbar.LENGTH_LONG).show();

            }
        });
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
}
