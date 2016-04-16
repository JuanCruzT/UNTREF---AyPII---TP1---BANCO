package clases.operatoria;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import clases.clientes.*;
import clases.cuentas.*;
import excepciones.*;

public class OperatoriaBancaria implements GestionDeClientes, GestionDeCuentas,
		OperacionesPorVentanilla {

	private Set<Cliente> listadoDeClientes = new HashSet<Cliente>();
	private Set<Cuenta> listadoDeCuentas = new HashSet<Cuenta>();
	private Double cotizacionDolar;

	public Cliente altaPersonaFisica(String nombre, Long cuit,
			Domicilio domicilio, Long telefono, Documento tipoDeDocumento,
			Long numeroDeDocumento, EstadoCivil estadoCivil, String profesion,
			String conyuge) {

		Cliente cliente = null;
		try {
			  cliente = new PersonaFisica(nombre, cuit, domicilio, telefono,
					tipoDeDocumento, numeroDeDocumento, estadoCivil, profesion,
					conyuge);
			listadoDeClientes.add(cliente);

		} catch (CuentaInvalida c) {
			System.out.println("No se puede crear la cuenta");
		}
		return cliente;
	}

	public Cliente altaPersonaJuridica(String nombre, Long cuit,
			Domicilio domicilio, Long telefono, Date fecha) {

		Cliente cliente = null;
		try {
			cliente = new PersonaJuridica(nombre, cuit, domicilio, telefono, fecha);
			listadoDeClientes.add(cliente);
		} catch (CuentaInvalida c) {
			System.out.println("No se puede crear la cuenta");
		}
		return cliente;
	}


	public void bajaCliente(Cliente cliente) {

		cliente.setActivo(false);
	}

	public void activarCliente(Cliente cliente) {

		cliente.setActivo(true);
	}

	public boolean aperturaCA(Set<PersonaFisica> personaFisica, Double saldo,
			Moneda nominacion, Double costoMantenimiento) {

	}

	public boolean aperturaCC(Set<Cliente> cliente, Double sobregiro,
			Double saldo) {

	}

	public void inhabilitarCuenta(Cuenta cuenta) {

	}

	public void habilitarCuenta(Cuenta cuenta) {

	}

	public void aperturaCE() {

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
