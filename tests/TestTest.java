package tests;

import org.junit.Test;

import clases.clientes.Domicilio;
import excepciones.DomicilioInvalido;

public class TestTest {

	@Test(expected = Exception.class)
	public void CrearDomicilioSinCalle() throws DomicilioInvalido {
		new Domicilio("", 117, 1608, "Devoto",
				"Buenos Aires");
	}
}
