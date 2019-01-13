package net.rickamr.android.abc;

import net.rickamr.android.abc.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class ConfirmaEliminacion extends DialogFragment {
	private OnClickListener oyenteAceptar;
	private OnClickListener oyenteCancelar;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final AlertDialog.Builder builder = new Builder(getActivity());
		// El titulo solo se pone para cuestiones importantes.
		builder.setTitle(R.string.confirma_eliminacion)
				.setMessage(R.string.perdera_datos)
				.setIcon(R.drawable.ic_importante)
				.setPositiveButton(android.R.string.yes, oyenteAceptar)
				.setNegativeButton(android.R.string.no, oyenteCancelar);
		return builder.create();
	}

	public static ConfirmaEliminacion muestra(Activity actividad,
			OnClickListener oyenteAceptar, OnClickListener oyenteCancelar) {
		final ConfirmaEliminacion dialogo = new ConfirmaEliminacion();
		dialogo.oyenteAceptar = oyenteAceptar;
		dialogo.oyenteCancelar = oyenteCancelar;
		dialogo.show(actividad.getFragmentManager(), "confirmaEliminacion");
		return dialogo;
	}
}