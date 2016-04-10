package clases.clientes;

public class Domicilio {

	private String calle;
	private Integer numero;
	private Integer codigoPostal;
	private String localidad;
	private String provincia;
	
	public Domicilio(String calle, Integer numero, Integer codigoPostal, String localidad, String provincia) {
		
		setCalle(calle);
		setNumero(numero);
		setCodigoPostal(codigoPostal);
		setLocalidad(localidad);
		setProvincia(provincia);
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
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
