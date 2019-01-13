/*  Copyright 2017 Ricardo Armando Machorro Reyes
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * ctrlConocidos file except in compliance with the License. You may obtain a copy of the
 * License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License. */

package rickamr.hotmail.com.bdsencilla;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {
    private ConocidosDao dao;
    private EditText txtNombre;
    private EditText txtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dao = new ConocidosDao(this);
        txtNombre = (EditText) findViewById(R.id.nombre);
        txtTelefono = (EditText) findViewById(R.id.telefono);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listado();
                Snackbar.make(view, "Conexión A La Base De Datos", Snackbar.LENGTH_LONG)
                      .setAction("Base De Datos", null).show();

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
        switch (item.getItemId()) {
            case R.id.action_agregar:
                agrega();
                return true; // Indica que se ejecuta una acción
            case R.id.action_listado:
                listado();
                return true;
            default:
                // Indica que no se procesa la opción.
                return super.onOptionsItemSelected(item);
        }
    }
    public void agrega() {
        try {
            final ContentValues modelo = new ContentValues();
            final String nombre = txtNombre.getText().toString().trim();
            final String telefono = txtTelefono.getText().toString().trim();
            modelo.put(ConocidoColumns.NOMBRE, nombre);
            modelo.put(ConocidoColumns.TELEFONO, telefono);
            dao.agrega(modelo);
            listado();
        } catch (SQLiteConstraintException e) {
            Toast.makeText(this, R.string.datos_incorrectos, Toast.LENGTH_SHORT)
                    .show();
        } catch (Exception e) {
            Log.e(getClass().getName(), "Error al agregar", e);
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void listado() {
        startActivity(new Intent(this, ListadoActivity.class));
    }

}
