package oswaldoadidas.hotmail.com.saludo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout textInputLayout;
    private CoordinatorLayout coordinatorLayout;
    private String faltaValor;
    private FloatingActionButton floatingActionButton;
    private static final int tiempo_limite = 1500;
    private static long pressionRegreso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        faltaValor = getString(R.string.faltaValor);
        textInputLayout = (TextInputLayout) findViewById(R.id.ilNombre);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fabSaludar);
        floatingActionButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EditText txtNombre = textInputLayout.getEditText();
        String nombre = txtNombre.getText().toString().trim();
        Snackbar.make(coordinatorLayout,getString(R.string.saludo,nombre),Snackbar.LENGTH_LONG).show();

    }
    @Override
    public void onBackPressed(){
        if(tiempo_limite + pressionRegreso > System.currentTimeMillis()){
            super.onBackPressed();

        }else{
            Snackbar.make(coordinatorLayout,"Presiona otra para salir",Snackbar.LENGTH_LONG).show();

        }

    }
}
