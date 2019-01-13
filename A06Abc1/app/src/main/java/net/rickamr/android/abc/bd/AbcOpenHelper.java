package net.rickamr.android.abc.bd;

import static android.provider.BaseColumns._ID;
import static net.rickamr.android.abc.bd.ChismosoColumns.HORA_DEL_PAN;
import static net.rickamr.android.abc.bd.ChismosoColumns.IDOLO;
import static net.rickamr.android.abc.bd.ChismosoColumns.NACIMIENTO;
import static net.rickamr.android.abc.bd.ChismosoColumns.NOMBRE;
import static net.rickamr.android.abc.bd.ChismosoColumns.PROXIMA_CITA;
import static net.rickamr.android.abc.bd.ChismosoColumns.TABLA;

import java.text.MessageFormat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AbcOpenHelper extends SQLiteOpenHelper {
	private static final int VERSION_BD = 1;
	private static final String NOMBRE_BD = "A06Abc_BD";

	public AbcOpenHelper(Context contexto) {
		super(contexto, NOMBRE_BD, null, VERSION_BD);
	}

	@Override
	public void onCreate(SQLiteDatabase bd) {
		/*
		 * Sqlite no maneja fechas. Se usa el tipo INTEGER para almacenarlas.
		 */
		final String consulta = MessageFormat
				.format("CREATE TABLE {0}({1} INTEGER PRIMARY KEY AUTOINCREMENT, "
						+ "{2} TEXT NOT NULL  CHECK(length({2}) > 0), "
						+ "{3} TEXT, "
						+ "{4} TEXT NOT NULL, "
						+ "{5} TEXT, "
						+ "{6} TEXT)",
				/* 0 */TABLA, /* 1 */_ID, /* 2 */NOMBRE, /* 3 */IDOLO, /* 4 */
						NACIMIENTO, /* 5 */HORA_DEL_PAN, /* 6 */PROXIMA_CITA);
		bd.execSQL(consulta);
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int versionAnterior,
			int nuevaVersion) {
	}
}