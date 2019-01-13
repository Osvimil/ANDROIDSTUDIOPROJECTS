package net.rickamr.android.abc;

import static android.provider.BaseColumns._ID;
import static net.rickamr.android.abc.bd.ChismosoColumns.HORA_DEL_PAN;
import static net.rickamr.android.abc.bd.ChismosoColumns.IDOLO;
import static net.rickamr.android.abc.bd.ChismosoColumns.NACIMIENTO;
import static net.rickamr.android.abc.bd.ChismosoColumns.NOMBRE;
import static net.rickamr.android.abc.bd.ChismosoColumns.PROXIMA_CITA;
import net.rickamr.android.abc.R;
import net.rickamr.android.abc.bd.ChismososDao;
import net.rickamr.android.iu.Mensaje;
import net.rickamr.android.iu.ProcesaError;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;

public class ChismososActivity extends ListActivity implements
		SeleccionListener {
	public static final int RESULTADO = 1;
	private int id;
	private ChismososDao dao;
	private SimpleCursorAdapter adaptador;
	private SeleccionController seleccionController;
	private static final String[] COLUMNAS_MOSTRADAS = new String[] { NOMBRE,
			NACIMIENTO };
	private static final int[] RENGLONES_DE_ELEMENTO = { android.R.id.text1,
			android.R.id.text2 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chismosos);
		dao = new ChismososDao(this);

		/*
		 * Crea un adaptador con un cursor nulo que se cambia al terminar de
		 * cargar los datos. El id del layout es para una lista de 2 renglones
		 * que marca la seleccion. Si se desa de 1 renglon se puede usar
		 * android.R.layout.simple_list_item_activated_1. Para versiones de
		 * android menores de 11, se puede usar
		 * android.R.layout.simple_list_item_single_choice, que es de 1 renglon.
		 */
		adaptador = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_activated_2, null,
				COLUMNAS_MOSTRADAS, RENGLONES_DE_ELEMENTO, 0);
		seleccionController = new SeleccionController(this, adaptador);
		actualiza();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.chismosos, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_agregar:
			agrega();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * Se ejecuta una accion del menu contextual para el elemento de la
	 * posicion. Se selecciona con un clic largo.
	 */
	@Override
	public boolean alSeleccionarAccion(MenuItem item, Cursor cursor) {
		switch (item.getItemId()) {
		case R.id.action_editar:
			alSeleccionarElemento(cursor);
			return true;
		case R.id.action_eliminar:
			confirmaEliminacion(cursor);
			return true;
		default:
			return false;
		}
	}

	/**
	 * Evento al seleccionar un objeto con un clic corto.
	 */
	@Override
	public void alSeleccionarElemento(Cursor cursor) {
		final ContentValues modelo = new ContentValues();
		modelo.put(_ID, cursor.getInt(cursor.getColumnIndex(_ID)));
		modelo.put(NOMBRE, cursor.getString(cursor.getColumnIndex(NOMBRE)));
		modelo.put(IDOLO, cursor.getString(cursor.getColumnIndex(IDOLO)));
		modelo.put(NACIMIENTO,
				cursor.getString(cursor.getColumnIndex(NACIMIENTO)));
		modelo.put(HORA_DEL_PAN,
				cursor.getString(cursor.getColumnIndex(HORA_DEL_PAN)));
		modelo.put(PROXIMA_CITA,
				cursor.getString(cursor.getColumnIndex(PROXIMA_CITA)));
		final Intent meta = new Intent(this, ChismosoActivity.class);
		meta.putExtra(ChismosoActivity.MODELO, modelo);
		seleccionController.termina();
		startActivityForResult(meta, RESULTADO);
	}

	/**
	 * Se invoca al terminar una actividad que se inicia desde esta clase.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == RESULTADO && resultCode == Activity.RESULT_OK) {
			actualiza();
			Mensaje.corto(this, R.string.chismoso_guardado);
		}
	}

	private void agrega() {
		final Intent meta = new Intent(this, ChismosoActivity.class);
		startActivityForResult(meta, RESULTADO);
	}

	private final DialogInterface.OnClickListener oyenteAceptar = new OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			seleccionController.termina();
			elimina();
		}
	};
	private final DialogInterface.OnClickListener oyenteCancelar = new OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			seleccionController.termina();
		}
	};

	private void confirmaEliminacion(Cursor cursor) {
		id = cursor.getInt(cursor.getColumnIndex(_ID));
		ConfirmaEliminacion.muestra(this, oyenteAceptar, oyenteCancelar);
	}

	private void elimina() {
		/*
		 * El ProgressDialog pone una animacion que indica la ejecucion de una
		 * tarea larga y evita el uso de los componentes graficos, hasta que
		 * termine la AsyncTask.
		 */
		final ProgressDialog dialogo = ProgressDialog.show(this, null,
				getString(R.string.eliminando));
		/*
		 * La AsyncTask permite ejecutar una tarea larga en segundo plano sin
		 * trabar la aplicacion.
		 */
		new AsyncTask<Integer, Void, Exception>() {
			/**
			 * Esta parte se ejecuta en un hilo aparte y permite que funcione la
			 * interfaz grafica
			 */
			@Override
			protected Exception doInBackground(Integer... params) {
				try {
					dao.elimina(params[0]);
					return null;
				} catch (Exception e) {
					return e;
				}
			}

			/**
			 * Este metodo se ejecuta en el hilo de la interfaz grafica. En este
			 * hilo se muestran los resultados que se muestran al usuario.
			 */
			@Override
			protected void onPostExecute(Exception result) {
				dialogo.dismiss();
				if (result == null) {
					actualiza();
					Mensaje.corto(ChismososActivity.this,
							R.string.chismoso_eliminado);
				} else {
					ProcesaError.corto(ChismososActivity.this, result);
				}
			}
		}.execute(id);
	}

	private void actualiza() {
		adaptador.swapCursor(null);
		final ProgressDialog dialogo = ProgressDialog.show(this, null,
				getString(R.string.actualizando));
		new AsyncTask<Void, Void, Cursor>() {
			private Exception e;

			@Override
			protected Cursor doInBackground(Void... params) {
				try {
					return dao.buscaRegistros();
				} catch (Exception e) {
					this.e = e;
					return null;
				}
			}

			@Override
			protected void onPostExecute(Cursor result) {
				dialogo.dismiss();
				if (e == null) {
					adaptador.swapCursor(result);
				} else {
					ProcesaError.corto(ChismososActivity.this, e);
				}
			}
		}.execute();
	}
}