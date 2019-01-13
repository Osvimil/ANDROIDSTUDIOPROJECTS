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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.text.MessageFormat;

public class ConocidosOpenHelper extends SQLiteOpenHelper {
	private static final int VERSION_BD = 1;
	private static final String NOMBRE_BD = "BDSencilla";

	public ConocidosOpenHelper(Context contexto) {
		super(contexto, NOMBRE_BD, null, VERSION_BD);
	}

	@Override
	public void onCreate(SQLiteDatabase bd) {
		/*
		 * Para que algunas clases de Android funcionen, la llave primaria debe
		 * llamarse _id.
		 */
		final String consulta = MessageFormat
				.format("CREATE TABLE {0}({1} INTEGER AUTO_INCREMENT PRIMARY KEY, "
						+ "{2} TEXT NOT NULL CHECK(length({2}) > 0), "
						+ "{3} TEXT NOT NULL CHECK(length({3}) > 0))",
				/* 0 */ConocidoColumns.TABLA, /* 1 */BaseColumns._ID,
				/* 2 */ConocidoColumns.NOMBRE, /* 3 */ConocidoColumns.TELEFONO);
		bd.execSQL(consulta);
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int versionAnterior,
                          int nuevaVersion) {
	}
}