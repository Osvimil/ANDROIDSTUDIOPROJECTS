package net.rickamr.android.abc;

import net.rickamr.android.abc.R;
import android.app.Activity;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

/**
 * Controla el menu contextual y la seleccion de elementos de un ListView.
 * 
 * @author Ricardo Armando Machorro Reyes
 */
public class SeleccionController implements ActionMode.Callback,
		OnItemLongClickListener, OnItemClickListener {
	/** Controla el menu contextual. */
	private ActionMode actionMode;
	private final Activity actividad;
	private final ListView listView;
	private final CursorAdapter adaptador;
	private final SeleccionListener oyente;

	public SeleccionController(ChismososActivity actividad, CursorAdapter adaptador) {
		this.actividad = actividad;
		this.listView = actividad.getListView();
		this.adaptador = adaptador;
		this.oyente = actividad;
		actividad.setListAdapter(adaptador);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listView.setOnItemLongClickListener(this);
		listView.setOnItemClickListener(this);
	}

	public void quitaSeleccion() {
		final int posicionSeleccionada = listView.getCheckedItemPosition();
		if (posicionSeleccionada != ListView.INVALID_POSITION) {
			listView.setItemChecked(posicionSeleccionada, false);
		}
	}

	public void termina() {
		quitaSeleccion();
		if (actionMode != null) {
			actionMode.finish();
		}
	}

	/**
	 * Evento click largo que lanza un menu contextual (Aqui se llama action
	 * mode.)
	 */
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		if (actionMode != null) {
			return false;
		} else {
			/*
			 * Se inicia el Menu contextual con los metodos que se definen mas
			 * adelante y se marca el elemento seleccionado con el que se
			 * origina el menu contextual.
			 */
			actionMode = actividad.startActionMode(this);
			listView.setItemChecked(position, true);
			return true;
		}
	}

	/*
	 * Se invoca al crear el menu contextual, como resultado de haber invocado
	 * startActionMode()
	 */
	@Override
	public boolean onCreateActionMode(ActionMode mode, Menu menu) {
		// Infla el menu contextual.
		final MenuInflater inflater = mode.getMenuInflater();
		inflater.inflate(R.menu.contextual, menu);
		return true;
	}

	/*
	 * Se invoca despues de mostrar el menu contextual. Siempre se ejecuta
	 * despues de onCreateActionMode, per se puede llamar multiples veces si el
	 * menu se invalida.
	 */
	@Override
	public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
		mode.setTitle(R.string.seleccionado_1);
		return false; // Devuelve false si no se hace nada.
	}

	// Se invoca cuando el usuario selecciona una accion del menu contextual.
	@Override
	public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
		final int posicion = listView.getCheckedItemPosition();
		final boolean resultado = oyente.alSeleccionarAccion(item,
				(Cursor) adaptador.getItem(posicion));
		return resultado;
	}

	/** Se llama cuando el usuario cierra el menu contextual. */
	@Override
	public void onDestroyActionMode(ActionMode mode) {
		actionMode = null; // Se libera la referencia al menu contextual.
		quitaSeleccion();
	}

	/** Se invoca al hacer un clic corto en algun elemento de la lista. */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if (actionMode != null) {
			listView.setItemChecked(position, true);
		} else {
			quitaSeleccion();
			oyente.alSeleccionarElemento((Cursor) adaptador.getItem(position));
		}
	}
}