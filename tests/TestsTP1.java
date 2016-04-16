package tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import clases.*;

import org.junit.*;

import clases.clientes.*;
import clases.cuentas.*;
import clases.operatoria.*;
import excepciones.DomicilioInvalido;

public class TestsTP1 {

	Domicilio domicilio;
	OperatoriaBancaria operatoria;
	Date fecha;
	DateFormat formateador;

	@Before
	public void CrearOperatoria() throws DomicilioInvalido, ParseException {
		operatoria = new OperatoriaBancaria();
		domicilio = new Domicilio("Navarro", 117, 1608, "Devoto",
				"Buenos Aires");
		formateador = new SimpleDateFormat("ddMMyyyy");
		fecha = formateador.parse("16042014");
	}

	/*
	 * Crear domicilio
	 */

	@Test
	public void CrearDomicilioValido() throws DomicilioInvalido {
		Domicilio domicilio = new Domicilio("Navarro", 117, 1608, "Devoto",
				"Buenos Aires");

		Assert.assertEquals("Navarro", domicilio.getCalle());
	}

	@Test(expected = Exception.class)
	public void CrearDomicilioSinCalle() throws DomicilioInvalido {
		new Domicilio("", 117, 1608, "Devoto", "Buenos Aires");
	}

	@Test(expected = Exception.class)
	public void CrearDomicilioInvalido() throws DomicilioInvalido {
		new Domicilio("Navarro", -117, 1608, "Devoto", "Buenos Aires");
	}

	/*
	 * Crear personas fisicas
	 */
	@Test
	public void CrearPersonaFisicaValida() {

		Cliente personaFisicaValida = operatoria.altaPersonaFisica(
				"Lucas Martinez", 1234567890123L, domicilio, 45011234L,
				Documento.DNI, 37340483L, EstadoCivil.CASADO, "Ingeniero",
				"Delfina Nevado");

		Assert.assertNotNull(personaFisicaValida);
		Assert.assertEquals(37340483,
				personaFisicaValida.getNumeroDeDocumento());

	}

	@Test(expected = Exception.class)
	public void CrearPersonaFisicaInvalidaNombre() {

		operatoria.altaPersonaFisica(" ", 1234567890123L, domicilio, 45011234L,
				Documento.DNI, 37340483L, EstadoCivil.CASADO, "Ingeniero",
				"Delfina Nevado");

	}

	@Test(expected = Exception.class)
	public void CrearPersonaFisicaInvalidaDomicilio() {

		operatoria.altaPersonaFisica("Lucas Martinez", 1234567890123L, null,
				45011234L, Documento.DNI, 37340483L, EstadoCivil.CASADO,
				"Ingeniero", "Delfina Nevado");

	}

	@Test(expected = Exception.class)
	public void CrearPersonaFisicaInvalidaCUIT() {

		operatoria.altaPersonaFisica("Lucas Martinez", -1234567890123L,
				domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");
	}

	@Test(expected = Exception.class)
	public void CrearPersonaFisicaInvalidaTipoDocumento() {

		operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, null, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

	}

	@Test(expected = Exception.class)
	public void CrearPersonaFisicaInvalidaDNI() {

		operatoria.altaPersonaFisica("Lucas Martinez", 1234567890123L,
				domicilio, 45011234L, Documento.DNI, -37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

	}

	@Test(expected = Exception.class)
	public void CrearPersonaFisicaInvalidaCUITRepetido() {

		operatoria.altaPersonaFisica(
				"Lucas Martinez", 1234567890123L, domicilio, 45011234L,
				Documento.DNI, 37340483L, EstadoCivil.CASADO, "Ingeniero",
				"Delfina Nevado");

		operatoria.altaPersonaFisica(
				"Delfina Nevado", 1234567890123L, domicilio, 45011234L,
				Documento.DNI, 37171103L, EstadoCivil.CASADO, "Ingeniero",
				"Lucas Martinez");
	}

	/*
	 * Crear personas juridicas
	 */

	@Test
	public void CrearPersonaJuridicaValida() {

		Cliente personaJuridicaValido = operatoria.altaPersonaJuridica(
				"Lucas Martinez", 1234567890123L, domicilio, 45011234L,
				fecha);

		Assert.assertNotNull(personaJuridicaValido);

	}

	@Test
	public void CrearPersonaJuridicaInvalidaCUIT() {

		Cliente personaJuridicaInvalido = operatoria.altaPersonaJuridica(
				"Lucas Martinez", -1234567890123L, domicilio, 45011234L,
				fecha);

		/* chequeamos que el objeto sea null */
		Assert.assertNull(personaJuridicaInvalido);
	}

	@Test(expected = Error.class)
	public void CrearPersonaJuridicaInvalidaNombre() {

		Cliente personaJuridicaInvalido = operatoria.altaPersonaJuridica("",
				1234567890123L, domicilio, 45011234L, fecha);

	}

	/*
	 * Gestion de clientes
	 */
	@Test
	public void darDeBajaCliente() {

		Cliente delfina = operatoria.altaPersonaFisica("Delfina Nevado",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37171103L,
				EstadoCivil.CASADO, "Ingeniero", "Lucas Martinez");

		operatoria.bajaCliente(delfina);
		boolean clienteActivo = delfina.isActivo();
		Assert.assertFalse(clienteActivo);
	}

	@Test
	public void activarCliente() {

		Cliente delfina = operatoria.altaPersonaFisica("Delfina Nevado",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37171103L,
				EstadoCivil.CASADO, "Ingeniero", "Lucas Martinez");

		operatoria.bajaCliente(delfina);
		operatoria.activarCliente(delfina);
		boolean clienteActivo = delfina.isActivo();
		Assert.assertTrue(clienteActivo);
	}
	/*
	 * Gestion de cuentas
	 */

	@Test
	public void aperturaCajaDeAhorroValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 100, "pesos", 0);

		Assert.assertEquals(lucas, lucasCA.getCliente());
	}

	@Test(expected = Exception.class)
	public void aperturaCajaDeAhorroInvalidaMonto() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, -700, "pesos", 0);

	}

	@Test(expected = Exception.class)
	public void aperturaCajaDeAhorroInvalidaPersonaJuridica() {

		Cliente lucas = operatoria.altaPersonaJuridica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, 16042014);

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

	}

	@Test
	public void aperturaCuentaCorrienteValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCC = operatoria.aperturaCC(lucas, 100, 1);

		Assert.assertEquals(lucas, lucasCC.getCliente());
	}

	@Test
	public void inhabilitarCuentaValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

		operatoria.inhabilitarCuenta(lucasCA);

		boolean estaInhabilitada = lucasCA.isActivo();

		Assert.assertFasle(estaInhabilitada);
	}

	@Test
	public void habilitarCuentaInhabilitada() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

		operatoria.inhabilitarCuenta(lucasCA);
		operatoria.habilitarCuenta(lucasCA);

		boolean estaHabilitada = lucas.isActivo();

		Assert.assertTrue(estaHabilitada);
	}

	/*
	 * Operaciones por ventanilla
	 */

	@Test
	public void depositarValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

		boolean seDeposito = operatoria.depositar(lucas, 100);

		Assert.assertTrue(seDeposito);
	}

	@Test(expected = Exception.class)
	public void depositarInvalidaMontoNegativo() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

		boolean seDeposito = operatoria.depositar(lucas, -100);

	}

	@Test
	public void extraccionValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		operatoria.depositar(lucas, 100);
		boolean extraccionExitosa = operatoria.extraer(lucasCA, lucas, 500);

		Assert.assertTrue(extraccionExitosa);
	}

	@Test
	public void extraccionMontoInvalido() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		operatoria.depositar(lucas, 100);
		boolean extraccionExitosa = operatoria.extraer(lucasCA, lucas, 999999);

		Assert.assertFalse(extraccionExitosa);
	}

	@Test
	public void despositarMontoInvalido() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		operatoria.depositar(lucas, -100);
		boolean extraccionExitosa = operatoria.extraer(lucasCA, lucas, 500);

		Assert.assertFalse(extraccionExitosa);
	}

	@Test
	public void tranferenciaValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);
		Cuenta lucasCC = operatoria.aperturaCC(lucas, 100, 1);

		boolean transferenciaExitosa = operatoria.extraer(lucasCA, lucasCC,
				1000);

		Assert.assertTrue(transferenciaExitosa);
	}

	@Test
	public void tranferenciaMontoInvalido() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);
		Cuenta lucasCC = operatoria.aperturaCC(lucas, 100, 1);

		boolean transferenciaExitosa = operatoria.extraer(lucasCA, lucasCC,
				-1000);

		Assert.assertFalse(transferenciaExitosa);
	}

	@Test
	public void tranferenciaCuentaInvalido() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		boolean transferenciaExitosa = operatoria.extraer(lucasCA, null, 500);

		Assert.assertFalse(transferenciaExitosa);
	}

	@Test
	public void listarMovimientosVacios() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		Transacciones[] t = getListarMovimientos(lucasCA);

		Assert.assertEquals(0, t.length());
	}

	@Test
	public void listarMovimientosCuentaNula() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Transacciones[] t = getListarMovimientos(null);

		Assert.assertNull(t);
	}

	@Test
	public void listarMovimientosCuenta() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123L, domicilio, 45011234L, Documento.DNI, 37340483L,
				EstadoCivil.CASADO, "Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);
		operatoria.depositar(lucas, 100);
		operatoria.extraer(lucas, 100);
		operatoria.depositar(lucas, 50);

		Transacciones[] t = getListarMovimientos(lucasCA);

		Assert.assertEquals(3, t.length(), 0.01);
	}
}