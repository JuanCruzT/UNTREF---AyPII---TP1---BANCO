package clases.operatoria;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import clases.clientes.Cliente;
import clases.clientes.Documento;
import clases.clientes.Domicilio;
import clases.clientes.EstadoCivil;
import clases.clientes.PersonaFisica;
import clases.clientes.PersonaJuridica;
import clases.cuentas.Cuenta;

public class OperatoriaBancaria implements GestionDeClientes, GestionDeCuentas,
		OperacionesPorVentanilla {

	private Set<Cliente> listadoDeClientes = new HashSet<Cliente>();
	private Set<Cuenta> listadoDeCuentas = new HashSet<Cuenta>();
	private Double cotizacionDolar;

	public Cliente altaPersonaFisica(String nombre, Long cuit, Domicilio domicilio,
			Long telefono, Documento tipoDeDocumento,
			Long numeroDeDocumento, EstadoCivil estadoCivil, String profesion,
			String conyuge) {

		return new PersonaFisica(nombre, cuit, domicilio, telefono, tipoDeDocumento,
				numeroDeDocumento, estadoCivil, profesion, conyuge);

	}

	public Cliente altaPersonaJuridica(String nombre, Long cuit, Domicilio domicilio,
			Long telefono, Date fecha) {
		
		return new PersonaJuridica(nombre, cuit, domicilio, telefono, fecha);

	}

	public void bajaCliente(Cliente cliente) {

	}

	public void activarCliente(Cliente cliente) {

	}
	
	public boolean aperturaCA(PersonaFisica [] personaFisica, Double saldo, String nominacion, Double costoMantenimiento){
		
	}

	public boolean aperturaCC(Cliente [] cliente, Double sobregiro, Double saldo){
		
	}
	
	public void inhabilitarCuenta(Cuenta cuenta){
		
	}
	
	public void habilitarCuenta(Cuenta cuenta){
		
	}
	
	public void aperturaCE(){
		
	}

	public boolean depositar(Cuenta cuenta, Double monto) {

		return false;
	}

	public boolean extraer(Cuenta cuenta, Cliente cliente, Double monto) {

		return false;
	}

	public boolean transferir(Cuenta cuenta, Cuenta cuentaATransferir,
			Double monto) {

		return false;
	}

	public void listarMovimientos(Cuenta cuenta) {

	}

	public void listarMovimientos() {

	}

	public Set<Cliente> getListadoDeClientes() {
		return listadoDeClientes;
	}

	public Set<Cuenta> getListadoDeCuentas() {
		return listadoDeCuentas;
	}

	public Double getCotizacionDolar() {
		return cotizacionDolar;
	}

	public void setCotizacionDolar(Double cotizacionDolar) {
		this.cotizacionDolar = cotizacionDolar;
	}


}
