package clases.operatoria;

import java.util.Date;

import clases.clientes.Cliente;
import clases.clientes.Documento;
import clases.clientes.Domicilio;
import clases.clientes.EstadoCivil;

public interface GestionDeClientes {

	public Cliente altaPersonaFisica(String nombre, Long cuit, Domicilio domicilio,
			Long telefono, Documento tipoDeDocumento,
			Long numeroDeDocumento, EstadoCivil estadoCivil, String profesion,
			String conyuge);
	
	public Cliente altaPersonaJuridica(String nombre, Long cuit, Domicilio domicilio,
			Long telefono, Date fecha);
	
	public void bajaCliente (Cliente cliente);
		
	
	public void activarCliente (Cliente cliente);


		
	

	

}