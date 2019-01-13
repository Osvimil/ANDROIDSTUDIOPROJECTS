package net.rickamr.android.abc;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import net.rickamr.android.iu.SeleccionaHora;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Controla la selección de horas mediante un cuadro de dialogo.
 * 
 * @author Ricardo Armando Machorro Reyes
 */
public class BotonDeHora extends TextView implements OnClickListener,
		OnTimeSetListener {
	private DateFormat fmtHora;
	private Calendar hora;
	private FragmentActivity actividad;

	public BotonDeHora(Context context) {
		super(context);
		inicializa(context);
	}

	public BotonDeHora(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		inicializa(context);
	}

	public BotonDeHora(Context context, AttributeSet attrs) {
		super(context, attrs);
		inicializa(context);
	}

	public Date getHora() {
		return hora == null ? null : hora.getTime();
	}

	public void setHora(DateFormat fmt, String texto) throws ParseException {
		if (texto == null) {
			setHora(null);
		} else {
			setHora(fmt.parse(texto));
		}
	}

	public void setHora(Date hora) {
		if (hora == null) {
			this.hora = null;
		} else {
			if (this.hora == null) {
				this.hora = Calendar.getInstance();
			}
			this.hora.setTime(hora);
		}
		muestraHora();
	}

	Calendar getCalendario() {
		return hora;
	}

	protected void inicializa(Context context) {
		fmtHora = android.text.format.DateFormat.getTimeFormat(context);
		if (context instanceof FragmentActivity) {
			actividad = (FragmentActivity) context;
		}
		if (actividad != null && !isInEditMode()) {
			setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		final Calendar h = hora == null ? Calendar.getInstance() : hora;
		SeleccionaHora.muestra(actividad, h, this);
	}

	protected void muestraHora() {
		if (hora == null) {
			setText(getHint());
		} else {
			setText(fmtHora.format(hora.getTime()));
		}
	}

	@Override
	public void onTimeSet(TimePicker vista, int horas, int minutos) {
		if (hora == null) {
			hora = Calendar.getInstance();
		}
		hora.set(HOUR_OF_DAY, horas);
		hora.set(MINUTE, minutos);
		muestraHora();
	}
}