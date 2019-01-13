package oswaldoadidas.hotmail.com.mitexto;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout ilUsuario;
    private TextInputLayout ctrlNombre;
    private FloatingActionButton fabAceptar;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ilUsuario = (TextInputLayout)findViewById(R.id.ilUsuario);
        ctrlNombre = (TextInputLayout)findViewById(R.id.ilNombre);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAceptar);


        /*
        fabAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nombre = ctrlNombre.getEditText().toString().trim();
                ctrlNombre.getEditText().setText("Hola {nombre}");
                ctrlNombre.getEditText().setText(getString((R.string.hola,nombre)));

            }
        });
        //fab.setOnClickListener(this);


/*
        fabAceptar = (FloatingActionButton) findViewById(R.id.fabAceptar);
        fabAceptar.setOnClickListener(this);

        FloatingActionButton fabAceptar = (FloatingActionButton) findViewById(R.id.fabAceptar);
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
        final String nombre = ctrlNombre.getEditText().getText().toString().trim();
        ctrlNombre.getEditText().setText(getString(R.string.hola,nombre));
        lee(ilUsuario,"[A-Za-z0-9](4.16)");

    }


    private void lee(TextInputLayout ctrlView, String expresionRegular) {
        final String valor = ctrlView.getEditText().getText().toString().trim();
        if(valor.matches(expresionRegular)){
            ctrlView.setError(null);

        }else{
            ctrlView.setError((getString(R.string.valor_incorrecto)));
        }

    }


}
