package net.rickamr.android.abc;

import static android.provider.BaseColumns._ID;
import static net.rickamr.android.abc.bd.ChismosoColumns.HORA_DEL_PAN;
import static net.rickamr.android.abc.bd.ChismosoColumns.IDOLO;
import static net.rickamr.android.abc.bd.ChismosoColumns.NACIMIENTO;
import static net.rickamr.android.abc.bd.ChismosoColumns.NOMBRE;
import static net.rickamr.android.abc.bd.ChismosoColumns.PROXIMA_CITA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.rickamr.android.abc.R;
import net.rickamr.android.abc.bd.ChismososDao;
import net.rickamr.android.iu.ProcesaError;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

@SuppressLint("SimpleDateFormat")
public class ChismosoActivity extends FragmentActivity {
	public static final String MODELO = "net.ramptors.android.abc.MODELO";
	private boolean modificando;
	private SimpleDateFormat fmtFecha = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat fmtHora = new SimpleDateFormat("HH:mm:ss");
	private SimpleDateFormat fmtFechaYHora = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	private ChismososDao dao;
	private Integer id;
	private EditText txtNombre;
	private EditText txtIdolo;
	private BotonDeFecha btnNacimiento;
	private BotonDeHora btnHoraDelPan;
	private BotonDeFecha btnProximaCitaFecha;
	private BotonDeHora btnProximaCitaHora;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chismoso);
		setupActionBar();
		dao = new ChismososDao(this);
		txtNombre = (EditText) findViewById(R.id.nombre);
		txtIdolo = (EditText) findViewById(R.id.idolo);
		btnNacimiento = (BotonDeFecha) findViewById(R.id.btnNacimiento);
		btnHoraDelPan = (BotonDeHora) findViewById(R.id.btnHoraDelPan);
		btnProximaCitaFecha = (BotonDeFecha) findViewById(R.id.btnProximaCitaFecha);
		btnProximaCitaHora = (BotonDeHora) findViewById(R.id.btnProximaCitaHora);
		final Intent intent = getIntent();
		final ContentValues modelo = intent.getParcelableExtra(MODELO);
		modificando = (modelo != null);
		if (modificando) {
			id = modelo.getAsInteger(_ID);
			muestra(modelo);
		}
	}

	/**
	 * Configura la barra de acciones {@link android.app.ActionBar}, si es que
	 * el API esta disponible.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.chismoso, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_guardar:
			guarda();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void muestra(ContentValues modelo) {
		try {
			final String nombre = modelo.getAsString(NOMBRE);
			if (modificando) {
				setTitle(nombre);
			}
			txtNombre.setText(nombre);
			txtIdolo.setText(modelo.getAsString(IDOLO));
			btnNacimiento.setFecha(fmtFecha, modelo.getAsString(NACIMIENTO));
			btnHoraDelPan.setHora(fmtHora, modelo.getAsString(HORA_DEL_PAN));
			final String sProximaCita = modelo.getAsString(PROXIMA_CITA);
			btnProximaCitaFecha.setFecha(fmtFechaYHora, sProximaCita);
			btnProximaCitaHora.setHora(fmtFechaYHora, sProximaCita);
		} catch (ParseException e) {
			ProcesaError.corto(this, e);
		}
	}

	private void guarda() {
		final ContentValues modelo = recuperaModelo();
		if (modificando) {
			modificaBd(modelo);
		} else {
			agregaBd(modelo);
		}
	}

	private ContentValues recuperaModelo() {
		final ContentValues modelo = new ContentValues();
		if (modificando) {
			modelo.put(_ID, id);
		}
		modelo.put(NOMBRE, txtNombre.getText().toString().trim());
		modelo.put(IDOLO, txtIdolo.getText().toString().trim());
		final Date nacimiento = btnNacimiento.getFecha();
		modelo.put(NACIMIENTO,
				nacimiento == null ? null : fmtFecha.format(nacimiento));
		final Date horaDelPan = btnHoraDelPan.getHora();
		modelo.put(HORA_DEL_PAN,
				horaDelPan == null ? null : fmtHora.format(horaDelPan));
		final Date proximaCita = btnProximaCitaFecha
				.getFechaYHora(btnProximaCitaHora);
		modelo.put(PROXIMA_CITA,
				proximaCita == null ? null : fmtFechaYHora.format(proximaCita));
		return modelo;
	}

	private void agregaBd(ContentValues modelo) {
		final ProgressDialog dialogo = ProgressDialog.show(this, null,
				getString(R.string.agregando));
		new AsyncTask<ContentValues, Void, Exception>() {
			@Override
			protected Exception doInBackground(ContentValues... params) {
				try {
					dao.agrega(params[0]);
					return null;
				} catch (Exception e) {
					return e;
				}
			}

			@Override
			protected void onPostExecute(Exception e) {
				cierraActividadYRegresa(dialogo, e);
			}
		}.execute(modelo);
	}

	private void modificaBd(ContentValues modelo) {
		final ProgressDialog dialogo = ProgressDialog.show(this, null,
				getString(R.string.guardando));
		new AsyncTask<ContentValues, Void, Exception>() {
			@Override
			protected Exception doInBackground(ContentValues... params) {
				try {
					dao.modifica(params[0]);
					return null;
				} catch (Exception e) {
					return e;
				}
			}

			@Override
			protected void onPostExecute(Exception e) {
				cierraActividadYRegresa(dialogo, e);
			}
		}.execute(modelo);
	}

	private void cierraActividadYRegresa(ProgressDialog dialogo, Exception e) {
		dialogo.dismiss();
		if (e == null) {
			setResult(RESULT_OK, new Intent());
			finish();
		} else {
			ProcesaError.largo(this, e);
		}
	}
}