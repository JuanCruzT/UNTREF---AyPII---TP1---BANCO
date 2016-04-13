package clases.operatoria;

import clases.clientes.*;
import clases.cuentas.Cuenta;

public interface GestionDeCuentas {

	public boolean aperturaCA(PersonaFisica [] personaFisica, Double saldo, String nominacion, Double costoMantenimiento);

	public boolean aperturaCC(Cliente [] cliente, Double sobregiro, Double saldo);
	
	public void inhabilitarCuenta(Cuenta cuenta);
	
	public void habilitarCuenta(Cuenta cuenta);
	
	public void aperturaCE();
	
}
