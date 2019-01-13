/* COPYRIGHT 2016 M. EN C. RICARDO ARMANDO MACHORRO REYES.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License. */
package rickamr.hotmail.com.textos;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
/*
 * MANEJO DE LOS COMPONENTES DE TEXTO EN ANDROID 6.0 MARSHMALLOW USANDO TAMBIEN
 * MATERIAL DESIGN
 *
 * */

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{
    private TextInputLayout ilUsuario;
    private TextInputLayout ctrlNombre;
    private TextInputLayout ctrlSecreto;
    private TextInputLayout ctrlEmail;
    private TextInputLayout ctrlTeléfono;
    private TextInputLayout ctrlUrl;
    private FloatingActionButton fabAceptar;
    private CoordinatorLayout coordinatorLayout;
    private TextInputLayout ctrlNavegador;
    private TextInputLayout ctrlDireccion;
    private TextInputLayout ctrlVerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ilUsuario = (TextInputLayout) findViewById(R.id.ilUsuario);
        ctrlNombre = (TextInputLayout) findViewById(R.id.ilNombre);
        ctrlSecreto = (TextInputLayout) findViewById(R.id.ilSecreto);
        ctrlEmail = (TextInputLayout) findViewById(R.id.ilEmail);
        ctrlTeléfono = (TextInputLayout) findViewById(R.id.ilTeléfono);
        ctrlDireccion = (TextInputLayout) findViewById(R.id.ilDirección);
        ctrlVerso = (TextInputLayout) findViewById(R.id.ilVerso);
        ctrlNavegador = (TextInputLayout) findViewById(R.id.ilNavegador);
        // Añade las opciones de autocompletar al cuadro de navegadores.
        final String[] navegadores =
                getResources().getStringArray(R.array.navegadores_array);
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, navegadores);
        ((AutoCompleteTextView)
                ctrlNavegador.getEditText()).setAdapter(adapter);
        ctrlUrl = (TextInputLayout) findViewById(R.id.ilUrl);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        fabAceptar = (FloatingActionButton) findViewById(R.id.fabAceptar);
        fabAceptar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if (id == R.id.action_limpiar) {
            limpiar();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void limpiar() {
        ilUsuario.getEditText().setText(""); ;
        ctrlNombre.getEditText().setText("");
        ctrlSecreto.getEditText().setText("");
        ctrlEmail.getEditText().setText("");
        ctrlTeléfono.getEditText().setText("");
        ctrlNavegador.getEditText().setText("");
        ctrlUrl.getEditText().setText("");
        ctrlDireccion.getEditText().setText("");
        ctrlVerso.getEditText().setText("");
    }

    @Override
    public void onClick(View v) {
        final String nombre = ctrlNombre.getEditText().getText().toString().trim();
        ctrlNombre.getEditText().setText(getString(R.string.hola, nombre));
        lee(ilUsuario, "[A-Za-z0-9]{4,16}");
        lee(ctrlEmail, "[a-z0-9!#$%&'*+/=?^_`{|}~-]+"
                + "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
                + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+"
                + "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        lee(ctrlUrl, "^(https?|ftp|file)://" +
                "[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        lee(ctrlTeléfono, "\\d{8,14}");
    }
    private void lee(TextInputLayout ctrlView, String expresiónRegular) {
        final String valor = ctrlView.getEditText().getText().toString().trim();
        if (valor.matches(expresiónRegular)) {
            ctrlView.setError(null);
        } else {
            ctrlView.setError(getString(R.string.valor_incorrecto));
        }
    }

}
