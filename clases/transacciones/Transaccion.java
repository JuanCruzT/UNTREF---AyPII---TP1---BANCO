package clases.transacciones;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import excepciones.MontoMenorA0;

public class Transaccion {

	static SimpleDateFormat formatoAImprimir = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private Date fecha;
	private Movimiento tipoDeMovimiento;
	private Double monto;
	private String motivo;
	private String observaciones;

	public Transaccion(Movimiento tipoDeMovimiento,
			Double monto, String motivo) throws ParseException, MontoMenorA0 {

		this.fecha = new Date();
		this.tipoDeMovimiento = tipoDeMovimiento;
		if (monto <= 0) {
			throw new MontoMenorA0(
					"El monto de una transacción tiene que ser mayor a 0 (cero)");
		}
		this.monto = monto;
		this.motivo = motivo;
		this.observaciones = "";

	}

	public Transaccion(Movimiento tipoDeMovimiento,
			Double monto, String motivo, String observaciones)
			throws ParseException, MontoMenorA0 {

		this.fecha = new Date();
		this.tipoDeMovimiento = tipoDeMovimiento;
		if (monto <= 0) {
			throw new MontoMenorA0(
					"El monto de una transacción tiene que ser mayor a 0 (cero)");
		}
		this.monto = monto;
		this.motivo = motivo;
		this.observaciones = observaciones;

	}

	public String toString() {

		return ("Fecha y Hora de la Transaccion: " + formatoAImprimir.format(this.fecha)
				+ "\nTipo de Movimiento: " + this.tipoDeMovimiento
				+ "\nMonto: " + this.monto 
				+ "\nMotivo: " + this.motivo
				+ "\nObservaciones: " + this.observaciones);
	}
}
