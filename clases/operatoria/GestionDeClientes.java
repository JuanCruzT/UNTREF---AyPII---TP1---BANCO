package clases.operatoria;

import clases.clientes.Cliente;

public interface GestionDeClientes {

	public void altaPersonaFisica (String nombre, Integer cuit, String domicilio,
			Integer telefono, String tipoDeDocumento,
			Integer numeroDeDocumento, String estadoCivil, String profesion,
			String conyuge);
	
	public void altaPersonaJuridica (String nombre, Integer cuit, String domicilio,
			Integer telefono, Integer fecha);
	
	public void bajaCliente (Cliente cliente);
		
	
	public void activarCliente (Cliente cliente);


		
	

	

}