package net.rickamr.android.iu;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;
import android.content.Context;
import android.widget.Toast;

/**
 * Despliega mensajes (Toasts) conuna duracion fija.
 * 
 * @author Ricardo Armando Machorro Reyes
 */
public class Mensaje {
	public static void corto(Context context, String mensaje) {
		Toast.makeText(context, mensaje, LENGTH_SHORT).show();
	}

	public static void corto(Context context, int id) {
		Toast.makeText(context, id, LENGTH_SHORT).show();
	}

	public static void largo(Context context, String mensaje) {
		Toast.makeText(context, mensaje, LENGTH_LONG).show();
	}

	public static void largo(Context context, int id) {
		Toast.makeText(context, id, LENGTH_LONG).show();
	}
}