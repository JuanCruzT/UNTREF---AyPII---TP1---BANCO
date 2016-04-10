package clases.operatoria;

import clases.clientes.Cliente;
import clases.cuentas.Cuenta;

public interface OperacionesPorVentanilla {

	public boolean depositar(Cuenta cuenta, Double monto); 
	public boolean extraer(Cuenta cuenta, Cliente cliente, Double monto);

	public boolean transferir(Cuenta cuenta, Cuenta cuentaATransferir, Double monto);
	//public listarMovimientos(Cuenta cuenta);
	//public listarMovimientos(Cuenta, Int );
}
