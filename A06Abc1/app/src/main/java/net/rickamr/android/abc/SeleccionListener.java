package net.rickamr.android.abc;

import android.database.Cursor;
import android.view.MenuItem;

/**
 * Eventos generados al interactar con un menu de contextual conectado a una
 * ListView.
 */
public interface SeleccionListener {
	/**
	 * Se activa al hacer un click corto cuando no esta activo el menu
	 * contextual.
	 * 
	 *            indice de elemento seleccionado dentro de la lista.
	 */
	public void alSeleccionarElemento(Cursor cursor);

	/**
	 * Se activa cuando se selecciona un elemento de la lista con un clic largo
	 * y una accion del menu contextual.
	 * 
	 * @param item
	 *            accion seleccionada en el menu contextual.
	 * @return true si se ejecuta una accion; false en caso contrario.
	 */
	public boolean alSeleccionarAccion(MenuItem item, Cursor cursor);
}