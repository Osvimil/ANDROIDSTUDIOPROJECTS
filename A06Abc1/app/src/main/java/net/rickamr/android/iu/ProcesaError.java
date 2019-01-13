package net.rickamr.android.iu;

import android.content.Context;
import android.util.Log;

public class ProcesaError {
	public static void corto(Context context, Exception ex) {
		Log.e(context.getClass().getName(), "", ex);
		Mensaje.corto(context, ex.getLocalizedMessage());
	}

	public static void largo(Context context, Exception ex) {
		Log.e(context.getClass().getName(), "", ex);
		Mensaje.largo(context, ex.getLocalizedMessage());
	}
}