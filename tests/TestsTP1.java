package tests;

import clases.*;

import org.junit.*;

import clases.clientes.*;
import clases.cuentas.*;
import clases.operatoria.*;

public class TestsTP1 {

	Domicilio domicilio;
	OperatoriaBancaria operatoria;

	@Before
	public void CrearOperatoria() {
		operatoria = new OperatoriaBancaria();
		domicilio = new Domicilio("Navarro", 117, 1608, "Devoto",
				"Buenos Aires");
	}

	/*
	 * Crear domicilio
	 */

	@Test
	public void CrearDomicilioValido() {
		Domicilio domicilio = new Domicilio("Navarro", 117, 1608, "Devoto",
				"Buenos Aires");

		Assert.assertEquals("Navarro", domicilio.getCalle());
	}

	@Test(expected = Error.class)
	public void CrearDomicilioSinCalle() {
		Domicilio domicilioInvalido = new Domicilio("", 117, 1608, "Devoto",
				"Buenos Aires");
	}

	@Test(expected = Error.class)
	public void CrearDomicilioInvalido() {
		Domicilio domicilioInvalido = new Domicilio("Navarro", -117, 1608,
				"Devoto", "Buenos Aires");
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

	@Test(expected = Error.class)
	public void CrearPersonaFisicaInvalidaNombre() {

		operatoria.altaPersonaFisica(" ", 1234567890123L, domicilio, 45011234L,
				Documento.DNI, 37340483L, EstadoCivil.CASADO, "Ingeniero",
				"Delfina Nevado");

	}

	@Test(expected = Error.class)
	public void CrearPersonaFisicaInvalidaDomicilio() {

		Cliente personaFisicaInvalida = operatoria.altaPersonaFisica(
				"Lucas Martinez", 1234567890123, "", "DNI", 37340483, "Casado",
				"Ingeniero", 45011234, "Delfina Nevado");

	}

	@Test(expected = Error.class)
	public void CrearPersonaFisicaInvalidaCUIT() {

		operatoria.altaPersonaFisica(
				"Lucas Martinez", -1234567890123L, domicilio, 45011234L,
				Documento.DNI, 37340483L, EstadoCivil.CASADO, "Ingeniero",
				"Delfina Nevado");

	}

	@Test(expected = Error.class)
	public void CrearPersonaFisicaInvalidaTipoDocumento() {

		Cliente personaFisicaInvalida = operatoria
				.altaPeraltaPersonaFisicasonaFisica("Lucas Martinez",
						1234567890123, domicilio, 45011234, "", 37340483,
						"Casado", "Ingeniero", "Delfina Nevado");

	}

	@Test(expected = Error.class)
	public void CrearPersonaFisicaInvalidaDNI() {

		operatoria.altaPersonaFisica(
				"Lucas Martinez", 1234567890123L, domicilio, 45011234L,
				Documento.DNI, -37340483L, EstadoCivil.CASADO, "Ingeniero",
				"Delfina Nevado");

	}

	@Test
	public void CrearPersonaFisicaInvalidaCUITRepetido() {

		Cliente personaFisicaInvalida1 = operatoria.altaPersonaFisica(
				"Lucas Martinez", 1234567890123, domicilio, 45011234, "DNI",
				37340483, "Casado", "Ingeniero", "Delfina Nevado");

		Cliente personaFisicaInvalida2 = operatoria.altaPersonaFisica(
				"Delfina Nevado", 1234567890123, domicilio, 45011234, "DNI",
				37171103, "Casado", "Ingeniero", "Lucas Martinez");

		Assert.assertFalse(personaFisicaInvalida1.getCuit() == personaFisicaInvalida2
				.getCuit());
	}

	@Test
	public void CrearPersonaFisicaYaCreada() {

		Cliente clienteInvalido1 = operatoria.altaPersonaFisica(
				"Lucas Martinez", 1234567890123, domicilio, 45011234, "DNI",
				37340483, "Casado", "Ingeniero", "Delfina Nevado");

		Cliente clienteInvalido2 = operatoria.altaPersonaFisica(
				"Lucas Martinez", 1234567890123, domicilio, 45011234, "DNI",
				37171103, "Casado", "Ingeniero", "Lucas Martinez");

		/*
		 * comprobamos que no se instancien dos objetos iguales
		 * (clienteInvalido2.getNumeroDeDocumento() deberia devolver null)
		 */
		Assert.assertFlase(clienteInvalido1.getNumeroDeDocumento(),
				clienteInvalido2.getNumeroDeDocumento);
		Assert.assertNull(clienteInvalido2);
	}

	/*
	 * Crear personas juridicas
	 */

	@Test
	public void CrearPersonaJuridicaValida() {

		Cliente personaJuridicaValido = operatoria.altaPersonaJuridica(
				"Lucas Martinez", 1234567890123, domicilio, 45011234, 16042014);

		Assert.assertNotNull(personaJuridicaValido);

	}

	@Test
	public void CrearPersonaJuridicaInvalidaCUIT() {

		Cliente personaJuridicaInvalido = operatoria
				.altaPersonaJuridica("Lucas Martinez", -1234567890123,
						domicilio, 45011234, 16042014);

		/* chequeamos que el objeto sea null */
		Assert.assertNull(personaJuridicaInvalido);
	}

	@Test(expected = Error.class)
	public void CrearPersonaJuridicaInvalidaNombre() {

		Cliente personaJuridicaInvalido = operatoria.altaPersonaJuridica("",
				1234567890123, domicilio, 45011234, 16042014);

	}

	@Test
	public void CrearPersonaJuridicaInvalidaFecha() {

		Cliente personaJuridicaInvalido = operatoria
				.altaPersonaJuridica("Lucas Martinez", 1234567890123,
						domicilio, 45011234, 999999999);

		/* chequeamos que el objeto sea null */
		Assert.assertNull(personaJuridicaInvalido);
	}

	/*
	 * Gestion de clientes
	 */
	@Test
	public void darDeBajaCliente() {

		Cliente delfina = operatoria.altaPersonaFisica("Delfina Nevado",
				1234567890123, domicilio, 45011234, "DNI", 37171103, "Casado",
				"Ingeniero", "Lucas Martinez");

		operatoria.bajaCliente(delfina);
		clienteActivo = delfina.getActivo();
		Assert.assertFalse(clienteActivo);
	}

	@Test
	public void activarCliente() {

		Cliente delfina = operatoria.altaPersonaFisica("Delfina Nevado",
				1234567890123, domicilio, 45011234, "DNI", 37171103, "Casado",
				"Ingeniero", "Lucas Martinez");

		operatoria.bajaCliente(delfina);
		operatoria.activarCliente(delfina);
		clienteActivo = delfina.getActivo();
		Assert.assertTrue(clienteActivo);
	}

	/*
	 * Gestion de cuentas
	 */

	@Test
	public void aperturaCajaDeAhorroValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 100, "pesos", 0);

		Assert.assertEquals(lucas, lucasCA.getCliente());
	}

	@Test(expected = Error.class)
	public void aperturaCajaDeAhorroInvalidaMonto() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, -700, "pesos", 0);

	}

	@Test(expected = Error.class)
	public void aperturaCajaDeAhorroInvalidaPersonaJuridica() {

		Cliente lucas = operatoria.altaPersonaJuridica("Lucas Martinez",
				1234567890123, domicilio, 45011234, 16042014);

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

	}

	@Test
	public void aperturaCuentaCorrienteValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCC = operatoria.aperturaCC(lucas, 100, 1);

		Assert.assertEquals(lucas, lucasCC.getCliente());
	}

	@Test
	public void inhabilitarCuentaValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

		operatoria.inhabilitarCuenta(lucasCA);

		boolean estaInhabilitada = lucasCA.getActivo();

		Assert.assertFasle(estaInhabilitada);
	}

	@Test
	public void habilitarCuentaInhabilitada() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

		operatoria.inhabilitarCuenta(lucasCA);
		operatoria.habilitarCuenta(lucasCA);

		boolean estaHabilitada = lucas.getActivo();

		Assert.assertTrue(estaHabilitada);
	}

	/*
	 * Operaciones por ventanilla
	 */

	@Test
	public void depositarValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

		boolean seDeposito = operatoria.depositar(lucas, 100);

		Assert.assertTrue(seDeposito);
	}

	@Test(expected = Error.class)
	public void depositarInvalidaMontoNegativo() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 700, "pesos", 0);

		boolean seDeposito = operatoria.depositar(lucas, -100);

	}

	@Test
	public void extraccionValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		operatoria.depositar(lucas, 100);
		boolean extraccionExitosa = operatoria.extraer(lucasCA, lucas, 500);

		Assert.assertTrue(extraccionExitosa);
	}

	@Test
	public void extraccionMontoInvalido() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		operatoria.depositar(lucas, 100);
		boolean extraccionExitosa = operatoria.extraer(lucasCA, lucas, 999999);

		Assert.assertFalse(extraccionExitosa);
	}

	@Test
	public void despositarMontoInvalido() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		operatoria.depositar(lucas, -100);
		boolean extraccionExitosa = operatoria.extraer(lucasCA, lucas, 500);

		Assert.assertFalse(extraccionExitosa);
	}

	@Test
	public void tranferenciaValida() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);
		Cuenta lucasCC = operatoria.aperturaCC(lucas, 100, 1);

		boolean transferenciaExitosa = operatoria.extraer(lucasCA, lucasCC,
				1000);

		Assert.assertTrue(transferenciaExitosa);
	}

	@Test
	public void tranferenciaMontoInvalido() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);
		Cuenta lucasCC = operatoria.aperturaCC(lucas, 100, 1);

		boolean transferenciaExitosa = operatoria.extraer(lucasCA, lucasCC,
				-1000);

		Assert.assertFalse(transferenciaExitosa);
	}

	@Test
	public void tranferenciaCuentaInvalido() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		boolean transferenciaExitosa = operatoria.extraer(lucasCA, null, 500);

		Assert.assertFalse(transferenciaExitosa);
	}

	@Test
	public void listarMovimientosVacios() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);

		Transacciones[] t = getListarMovimientos(lucasCA);

		Assert.assertEquals(0, t.length());
	}

	@Test
	public void listarMovimientosCuentaNula() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Transacciones[] t = getListarMovimientos(null);

		Assert.assertNull(t);
	}

	@Test
	public void listarMovimientosCuenta() {

		Cliente lucas = operatoria.altaPersonaFisica("Lucas Martinez",
				1234567890123, domicilio, 45011234, "DNI", 37340483, "Casado",
				"Ingeniero", "Delfina Nevado");

		Cuenta lucasCA = operatoria.aperturaCA(lucas, 1000, "pesos", 0);
		operatoria.depositar(lucas, 100);
		operatoria.extraer(lucas, 100);
		operatoria.depositar(lucas, 50);

		Transacciones[] t = getListarMovimientos(lucasCA);

		Assert.assertEquals(3, t.length(), 0.01);
	}

}
