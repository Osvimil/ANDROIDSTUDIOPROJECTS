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
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ConocidosDao {
	private final SQLiteDatabase db;

	public ConocidosDao(Context contexto) {
		final ConocidosOpenHelper openHelper = new ConocidosOpenHelper(contexto);
		db = openHelper.getWritableDatabase();
	}

	public void agrega(ContentValues modelo) {
		db.insertOrThrow(ConocidoColumns.TABLA, null, modelo);
	}

	private static final String[] COLUMNAS_QUE_DEVUELVE = {
			ConocidoColumns._ID, ConocidoColumns.NOMBRE,
			ConocidoColumns.TELEFONO };

	public Cursor buscaRegistros() {
		return db.query(ConocidoColumns.TABLA, // Tabla de la consulta.
				COLUMNAS_QUE_DEVUELVE,
				// Clausula WHERE con simbolos de interrogación como parámetros.
				null,
				// valores de los parámetros de la clausula WHERE.
				null,
				// clausula GROUP BY
				null,
				// clausula HAVING
				null,
				// clausula ORDER BY
				ConocidoColumns.NOMBRE);
	}
}