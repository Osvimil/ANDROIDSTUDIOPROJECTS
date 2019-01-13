package net.rickamr.android.iu;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;

public class SeleccionaHora extends DialogFragment {
	private Calendar hora;
	private OnTimeSetListener onTimeSetListener;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new TimePickerDialog(getActivity(), onTimeSetListener,
				hora.get(HOUR_OF_DAY), hora.get(MINUTE),
				DateFormat.is24HourFormat(getActivity()));
	}

	public static void muestra(FragmentActivity actividad, Calendar hora,
			OnTimeSetListener onTimeSetListener) {
		final SeleccionaHora dialogo = new SeleccionaHora();
		dialogo.hora = hora;
		dialogo.onTimeSetListener = onTimeSetListener;
		dialogo.show(actividad.getSupportFragmentManager(), "seleccionaHora");
	}
}