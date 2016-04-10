package clases.operatoria;

import clases.clientes.Cliente;
import clases.clientes.Domicilio;
import clases.clientes.PersonaFisica;
import clases.cuentas.Cuenta;

public class OperatoriaBancaria implements GestionDeClientes,
		OperacionesPorVentanilla {

	private Cliente[] listadoDeClientes;
	private Cuenta[] listadoDeCuentas;
	private Double deDolaresAPesos;
	private Double dePesosADolares;

	public void altaPersonaFisica(String nombre, Integer cuit,
			String domicilio, Integer telefono, String tipoDeDocumento,
			Integer numeroDeDocumento, String estadoCivil, String profesion,
			String conyuge) {

		new PersonaFisica(nombre, cuit, domicilio, telefono, tipoDeDocumento,
				numeroDeDocumento, estadoCivil, profesion, conyuge);

	}

	public void altaPersonaJuridica(String nombre, Integer cuit,
			Domicilio domicilio, Integer telefono, Integer fecha) {

	}

	public void bajaCliente(Cliente cliente) {

	}

	public void activarCliente(Cliente cliente) {

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

	public Cliente[] getListadoDeClientes() {
		return listadoDeClientes;
	}

	public void setListadoDeClientes(Cliente[] listadoDeClientes) {
		this.listadoDeClientes = listadoDeClientes;
	}

	public Cuenta[] getListadoDeCuentas() {
		return listadoDeCuentas;
	}

	public void setListadoDeCuentas(Cuenta[] listadoDeCuentas) {
		this.listadoDeCuentas = listadoDeCuentas;
	}

	public Double getDeDolaresAPesos() {
		return deDolaresAPesos;
	}

	public void setDeDolaresAPesos(Double deDolaresAPesos) {
		this.deDolaresAPesos = deDolaresAPesos;
	}

	public Double getDePesosADolares() {
		return dePesosADolares;
	}

	public void setDePesosADolares(Double dePesosADolares) {
		this.dePesosADolares = dePesosADolares;
	}

}
