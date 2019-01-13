package net.rickamr.android.abc.bd;

import static android.provider.BaseColumns._ID;
import static net.rickamr.android.abc.bd.ChismosoColumns.HORA_DEL_PAN;
import static net.rickamr.android.abc.bd.ChismosoColumns.IDOLO;
import static net.rickamr.android.abc.bd.ChismosoColumns.NACIMIENTO;
import static net.rickamr.android.abc.bd.ChismosoColumns.NOMBRE;
import static net.rickamr.android.abc.bd.ChismosoColumns.PROXIMA_CITA;
import static net.rickamr.android.abc.bd.ChismosoColumns.TABLA;

import java.text.MessageFormat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ChismososDao {
	private final SQLiteDatabase db;

	public ChismososDao(Context contexto) {
		final AbcOpenHelper openHelper = new AbcOpenHelper(contexto);
		db = openHelper.getWritableDatabase();
	}

	private static final String[] COLUMNAS_QUE_DEVUELVE = { _ID, NOMBRE, IDOLO,
			NACIMIENTO, HORA_DEL_PAN, PROXIMA_CITA };

	public Cursor buscaRegistros() {
		return db.query(TABLA, COLUMNAS_QUE_DEVUELVE, null, null, null, null,
				NOMBRE);
	}

	public void agrega(ContentValues modelo) {
		db.insertOrThrow(TABLA, null, modelo);
	}

	public void modifica(ContentValues modelo) {
		db.replace(TABLA, null, modelo);
	}

	private static final String CLAUSULA_WHERE = MessageFormat.format(
			"{0} = ?", _ID);

	public void elimina(Object id) {
		final String[] argumentos = { String.valueOf(id) };
		db.delete(TABLA, CLAUSULA_WHERE, argumentos);
	}
}