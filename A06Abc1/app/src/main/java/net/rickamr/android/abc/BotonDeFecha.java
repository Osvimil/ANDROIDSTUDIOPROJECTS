package net.rickamr.android.abc;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import net.rickamr.android.iu.SeleccionaFecha;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;

/**
 * Controla la seleccion de fechas mediante un cuadro de dialogo.
 * 
 * @author Ricardo Armando Machorro Reyes
 */
public class BotonDeFecha extends TextView implements OnClickListener,
		OnDateSetListener {
	private DateFormat fmtFecha;
	private Calendar fecha;
	private FragmentActivity actividad;

	public BotonDeFecha(Context context) {
		super(context);
		inicializa(context);
	}

	public BotonDeFecha(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		inicializa(context);
	}

	public BotonDeFecha(Context context, AttributeSet attrs) {
		super(context, attrs);
		inicializa(context);
	}

	public Date getFecha() {
		return fecha == null ? null : fecha.getTime();
	}

	public Date getFechaYHora(BotonDeHora boton) {
		final Calendar hora = boton.getCalendario();
		if (fecha == null || hora == null) {
			return null;
		} else {
			final Calendar fechaYHora = (Calendar) fecha.clone();
			fechaYHora.set(HOUR_OF_DAY, hora.get(HOUR_OF_DAY));
			fechaYHora.set(MINUTE, hora.get(MINUTE));
			return fechaYHora.getTime();
		}
	}

	public void setFecha(DateFormat fmt, String texto) throws ParseException {
		if (texto == null) {
			setFecha(null);
		} else {
			setFecha(fmt.parse(texto));
		}
	}

	public void setFecha(Date fecha) {
		if (fecha == null) {
			this.fecha = null;
		} else {
			if (this.fecha == null) {
				this.fecha = Calendar.getInstance();
			}
			this.fecha.setTime(fecha);
		}
		muestraFecha();
	}

	protected void inicializa(Context context) {
		if (!isInEditMode()) {
			fmtFecha = android.text.format.DateFormat.getDateFormat(context);
		}
		if (context instanceof FragmentActivity) {
			actividad = (FragmentActivity) context;
		}
		if (actividad != null && !isInEditMode()) {
			setOnClickListener(this);
		}
	}

	protected void muestraFecha() {
		if (fecha == null) {
			setText(getHint());
		} else {
			setText(fmtFecha.format(fecha.getTime()));
		}
	}

	@Override
	public void onClick(View v) {
		final Calendar f = fecha == null ? Calendar.getInstance() : fecha;
		SeleccionaFecha.muestra(actividad, f, this);
	}

	@Override
	public void onDateSet(DatePicker vista, int anho, int mes, int dia) {
		if (fecha == null) {
			fecha = Calendar.getInstance();
		}
		fecha.set(YEAR, anho);
		fecha.set(MONTH, mes);
		fecha.set(DAY_OF_MONTH, dia);
		muestraFecha();
	}
}