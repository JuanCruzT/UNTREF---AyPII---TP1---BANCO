package clases.clientes;

import clases.cuentas.*;
import excepciones.CuentaInvalida;


public class PersonaFisica extends Cliente {

	private Documento tipoDeDocumento;
	private Long numeroDeDocumento;
	private EstadoCivil estadoCivil;
	private String profesion;
	private String conyuge = "";

	public PersonaFisica(String nombre, Long cuit, Domicilio domicilio,
			Long telefono, Documento tipoDeDocumento,
			Long numeroDeDocumento, EstadoCivil estadoCivil, String profesion,
			String conyuge) throws CuentaInvalida {

		super(nombre, cuit, domicilio, telefono);

		this.setTipoDeDocumento(tipoDeDocumento);
		this.setNumeroDeDocumento(numeroDeDocumento);
		this.setEstadoCivil(estadoCivil);
		this.setProfesion(profesion);
		this.setConyuge(conyuge);

	}

	public Documento getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public void setTipoDeDocumento(Documento tipoDeDocumento2) {
		this.tipoDeDocumento = tipoDeDocumento2;
	}

	public Long getNumeroDeDocumento() {
		return numeroDeDocumento;
	}

	public void setNumeroDeDocumento(Long numeroDeDocumento) throws CuentaInvalida {
		if(numeroDeDocumento <= 0){
			throw new CuentaInvalida("El numero de documento no puede ser negativo");
		}
		this.numeroDeDocumento = numeroDeDocumento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getConyuge() {
		return conyuge;
	}

	public void setConyuge(String conyuge) {
		this.conyuge = conyuge;
	}

	@Override
	public boolean agregarCuenta(Cuenta cuenta) throws CuentaInvalida {
		
		if (cuenta == null) {
			throw new CuentaInvalida("La cuenta no es valida");

		}

		if (!getCuentasAsociadas().add(cuenta)) {

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
				+ "\nDocumento: " + tipoDeDocumento + " " + numeroDeDocumento
				+ "\nEstado civil: " + estadoCivil
				+ "\nProfesion: " + profesion
				+ "\nConyuge: " + conyuge;
				
			
	}
}
