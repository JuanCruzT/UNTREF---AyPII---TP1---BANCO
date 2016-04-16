package clases.clientes;

import excepciones.CuentaInvalida;
import excepciones.DomicilioInvalido;

public class Domicilio {

	private String calle;
	private Integer numero;
	private Integer codigoPostal;
	private String localidad;
	private String provincia;
	
	public Domicilio(String calle, Integer numero, Integer codigoPostal, String localidad, String provincia) throws DomicilioInvalido {
		
		setCalle(calle);
		setNumero(numero);
		setCodigoPostal(codigoPostal);
		setLocalidad(localidad);
		setProvincia(provincia);
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) throws DomicilioInvalido {
		if(calle.equals("")){
			throw new DomicilioInvalido("La calle no puede ser vacía");
		}
		this.calle = calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero)throws DomicilioInvalido {
		if(numero <= 0){
			throw new DomicilioInvalido("El numero debe ser mayor a cero");
		}
		this.numero = numero;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) throws DomicilioInvalido {
		if(codigoPostal <= 0){
			throw new DomicilioInvalido("El codigo postal debe ser mayor a cero");
		}
		this.codigoPostal = codigoPostal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) throws DomicilioInvalido {
		if(localidad.equals("")){
			throw new DomicilioInvalido("La localidad no puede ser vacía");
		}
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) throws DomicilioInvalido {
		if(provincia.equals("")){
			throw new DomicilioInvalido("La provincia no puede ser vacía");
		}
		this.provincia = provincia;
	}
	
	public String toString(){
		
		return "• Calle: " + calle
				+ "\n• Numero: " + numero
				+ "\n• Codigo Postal: " + codigoPostal
				+ "\n• Localidad: " + localidad
				+ "\n• Provincia: " + provincia;
		
	}
	
	
}
