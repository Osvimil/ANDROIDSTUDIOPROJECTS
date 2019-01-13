package net.rickamr.android.iu;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

public class SeleccionaFecha extends DialogFragment {
	private Calendar fecha;
	private OnDateSetListener onDateSetListener;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new DatePickerDialog(getActivity(), onDateSetListener,
				fecha.get(YEAR), fecha.get(MONTH), fecha.get(DAY_OF_MONTH));
	}

	public static void muestra(FragmentActivity actividad, Calendar fecha,
			OnDateSetListener onDateSetListener) {
		final SeleccionaFecha dialogo = new SeleccionaFecha();
		dialogo.fecha = fecha;
		dialogo.onDateSetListener = onDateSetListener;
		dialogo.show(actividad.getSupportFragmentManager(), "seleccionaFecha");
	}
}