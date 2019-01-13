package oswaldoadidas.hotmail.com.seleccionmuchos;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.EnumSet;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {

    enum Navegadores{
        Chrome,Firefox, Safari,Opera,Edge
    }
    private CheckBox[] navegadores;
    private TextView salida;
    private FloatingActionButton fabAceptar;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        salida = (TextView)findViewById(R.id.salida);
        navegadores = new CheckBox[]{
                (CheckBox)findViewById(R.id.chrome),
                (CheckBox)findViewById(R.id.firefox),
                (CheckBox)findViewById(R.id.opera),
                (CheckBox)findViewById(R.id.safari),
                (CheckBox)findViewById(R.id.edge)

        };
        for(CheckBox cb: navegadores){
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    procesa();
                }
            });

        }
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        fabAceptar = (FloatingActionButton) findViewById(R.id.fab);
        fabAceptar.setOnClickListener(this);

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
        if (id == R.id.action_procesar) {
            onClick(fabAceptar);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        final EnumSet<Navegadores> seleccion = EnumSet.noneOf(Navegadores.class);
        for(CheckBox cb: navegadores){
            if(cb.isChecked()){
                switch (cb.getId()){
                    case R.id.chrome:
                        seleccion.add(Navegadores.Chrome);
                        continue;
                    case R.id.firefox:
                        seleccion.add(Navegadores.Firefox);
                        continue;
                    case R.id.safari:
                        seleccion.add(Navegadores.Safari);
                        continue;
                    case R.id.opera:
                        seleccion.add(Navegadores.Opera);
                        continue;
                    case R.id.edge:
                        seleccion.add(Navegadores.Edge);
                        continue;

                }

            }

        }
        salida.setText(seleccion.toString());
        Snackbar.make(v,seleccion.size()==3? "Autorizado": "No autorizado",Snackbar.LENGTH_LONG).setAction("Seleccion unica",null).show();



    }
    public void procesa(){
        onClick(fabAceptar);
    }
}
