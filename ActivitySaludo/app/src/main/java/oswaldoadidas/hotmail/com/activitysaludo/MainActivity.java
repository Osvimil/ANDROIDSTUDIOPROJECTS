package oswaldoadidas.hotmail.com.activitysaludo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout ilNombre1;
    private TextInputLayout ilNombre2;
    private CoordinatorLayout coordinatorLayout;
    private  String faltaElValor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        faltaElValor = getString(R.string.falta_el_valor);
        setContentView(R.layout.activity_main);
        ilNombre1 = (TextInputLayout) findViewById(R.id.nombre1);
        ilNombre2 = (TextInputLayout) findViewById(R.id.nombre2);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatoLayout);
        final FloatingActionButton fabSaludar = (FloatingActionButton) findViewById(R.id.fabSaludar);



    }

    @Override
    public void onClick(View v) {
        ilNombre1.setError(null);
        ilNombre2.setError(null);
        final String nombre1 = lee(ilNombre1);
        final String nombre2 = lee(ilNombre2);
        boolean error = valida(nombre1,false,ilNombre1);
         error = valida(nombre2,error,ilNombre2);
        if(!error){
            Snackbar.make(coordinatorLayout, getString(R.string.saludo,nombre1,nombre2),Snackbar.LENGTH_LONG).show();

        }

    }

    private boolean valida(String texto,boolean error,TextInputLayout il){
        try{
            validaTexto(texto);
        }catch(Exception e){
            il.setError(e.getLocalizedMessage());
            error = true;
        }
        return error;


    }
    @NonNull
    private String lee(TextInputLayout il){
        final EditText campo = il.getEditText();
        return campo == null ? "": campo.getText().toString().trim();

    }
    private void validaTexto(@NonNull String texto) throws Exception{
        if(texto.length()==0){
            throw  new Exception(faltaElValor);

        }
    }
}
