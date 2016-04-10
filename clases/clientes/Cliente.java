package clases.clientes;

import java.util.HashSet;
import java.util.Set;

import clases.cuentas.Cuenta;

public abstract class Cliente {

	private String nombre;
	private Long cuit;
	private Domicilio  domicilio ;
	private Long telefono;
	private boolean activo = true;
	private Set<Cuenta> cuentasAsociadas = new HashSet<Cuenta>();

	public Cliente(String nombre, Long cuit, Domicilio domicilio,
			Long telefono) {

		this.setNombre(nombre);
		this.setCuit(cuit);
		this.setDomicilio(domicilio);
		this.setTelefono(telefono);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		
			this.nombre = nombre;
		
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Cuenta> getCuentasAsociadas() {
		return cuentasAsociadas;
	}

	public abstract boolean agregarCuenta(Cuenta cuenta);
	
	public String toString(){
		
		return "Nombre: " + nombre
				+ "\nCUIT: " + cuit
				+ "\nDomicilio: \n" + domicilio
				+ "\nTelefono: " + telefono
				+ "\nActivo: " + activo
				+ "\nCuentas asociadas: " + cuentasAsociadas;
	}
	
	public boolean equals(Cliente o){
		
		return (this.cuit == o.cuit);
	}
}
