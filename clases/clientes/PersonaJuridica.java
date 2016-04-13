package clases.clientes;

import java.util.Date;

import clases.cuentas.*;
import excepciones.*;

public class PersonaJuridica extends Cliente {

	private Date fecha;

	public PersonaJuridica(String nombre, Long cuit, Domicilio domicilio,
			Long telefono, Date fecha) {

		super(nombre, cuit, domicilio, telefono);
		this.fecha = fecha;

	}

	public Date getFecha() {
		return fecha;
	}

	@Override
	public boolean agregarCuenta(Cuenta cuentaCorriente) throws CuentaInvalida {

		if (cuentaCorriente == null || cuentaCorriente instanceof CajaDeAhorro) {
			throw new CuentaInvalida("La cuenta no es valida");

		}

		if (!getCuentasAsociadas().add(cuentaCorriente)) {

			throw new CuentaInvalida("La cuenta ya está asociada al cliente");
		}

		/*
		 * else { getCuentasAsociadas().add(cuentaCorriente); }
		 */

		return true;
	}
	
	public String toString(){
		
		return  "Activo: " + isActivo()
				+ "\nNombre: " + getNombre()
				+ "\nCuit: " + getCuit()
				+ "\nDomicilio: " + getDomicilio()
				+ "\nTelefono: " + getTelefono()
				+ "\nFecha del contrato social: " + fecha;
				
			
	}

}
