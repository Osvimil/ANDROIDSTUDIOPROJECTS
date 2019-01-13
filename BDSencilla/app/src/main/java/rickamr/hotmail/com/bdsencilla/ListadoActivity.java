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

import android.annotation.TargetApi;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.MenuItem;

/**
 * Listado de conocidos. Cada elemento de la lista tiene 2 renglones: el primero
 * identifica al elemento y el segundo proporciona información adicional. Se usa
 * un layout predefinido por android, cuyo id es
 * <code>android.R.layout.simple_list_item_2</code>, con 2 renglones cuyos id
 * son <code>android.R.id.text1</code> para el primer renglón y
 * <code>android.R.id.text2</code> para el segundo renglón. Si se prefiere un
 * layout de un renglón, se puede usar el id
 * <code>android.R.layout.simple_list_item_1</code>, con el id
 * <code>android.R.id.text1</code> para el primer renglón.
 * 
 * @author Ricardo Armando Machorro Reyes.
 * 
 */
public class ListadoActivity extends ListActivity {
	/*
	 * Estos 2 arreglos conectan los datos del cursor con los elementos de la
	 * lista. Se corresponden por su orden. Así pues, ConocidoColumns.NOMBRE
	 * corresponde a android.R.id.text1 (primer renglón) y
	 * ConocidoColumns.TELEFONO a android.R.id.text2 (segundo renglón).
	 */
	private static final String[] COLUMNAS_MOSTRADAS = {
			ConocidoColumns.NOMBRE, ConocidoColumns.TELEFONO };
	private static final int[] RENGLONES_DE_ELEMENTO = { android.R.id.text1,
			android.R.id.text2 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Show the Up button in the action bar.
		setupActionBar();
		final ConocidosDao dao = new ConocidosDao(this);
		final Cursor cursor = dao.buscaRegistros();
		/*
		 * android.R.layout.simple_list_item_2 = Lista con elementos de 2
		 * renglones.
		 */
		final CursorAdapter adaptadorDeCursor = new SimpleCursorAdapter(this,
		/*
				 * 
				 */
		android.R.layout.simple_list_item_2, cursor, COLUMNAS_MOSTRADAS,
				RENGLONES_DE_ELEMENTO, 0);
		setListAdapter(adaptadorDeCursor);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
		//	getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
