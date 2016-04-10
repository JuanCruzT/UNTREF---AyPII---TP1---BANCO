package clases.clientes;
import java.util.Date;

public class PersonaJuridica extends Cliente {

	private Date fecha;

	public PersonaJuridica(String nombre, Integer cuit, String  domicilio,
			Integer telefono, String fecha) {

	
		super(nombre, cuit, domicilio, telefono);
		this.setFecha(fecha);

	}

	public Integer getFecha() {
		return fecha;
	}

	public void setFecha(Integer fecha) {
		this.fecha = fecha;
	}
}
