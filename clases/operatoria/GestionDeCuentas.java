package clases.operatoria;

import java.util.Set;

import clases.clientes.*;
import clases.cuentas.Cuenta;

public interface GestionDeCuentas {

	public boolean aperturaCA(Set<PersonaFisica> personaFisica, Double saldo, Moneda nominacion, Double costoMantenimiento);

	public boolean aperturaCC(Set<Cliente> cliente, Double sobregiro, Double saldo);
	
	public void inhabilitarCuenta(Cuenta cuenta);
	
	public void habilitarCuenta(Cuenta cuenta);
	
	public void aperturaCE();
	
}
