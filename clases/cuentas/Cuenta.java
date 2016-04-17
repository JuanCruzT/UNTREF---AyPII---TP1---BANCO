package clases.cuentas;

import java.util.HashSet;
import java.util.Set;

import excepciones.CuentaInvalida;

public class Cuenta {

  	private Integer cbu;
	private Double saldo;
	private Boolean activa;
	private Set<Transaccion> movimientos = new HashSet<Transaccion>();

	
	public Cuenta(Integer cbu, Double saldo) throws CuentaInvalida {

		this.setCbu(cbu);
		this.setSaldo(saldo);
		this.setActivo(true);
	
	}
	
	public abstract Boolean acreditar(Double monto) throws CuentaInvalida;
	public abstract Boolean debitar(Double monto) throws CuentaInvalida;
	public abstract boolean agregarMovimiento(Transaccion transaccion) throws CuentaInvalida;
	
	public Set<Transacciones> getMovimientos() {
		return movimientos;
	}

	public void setCbu(Integer cbu){
	  if(cbu >= 0){
	    this.cbu = cbu;
	  }
	}
	
	public Integer getCbu(){
	  return this.cbu;
	}
	
	public void setSaldo(Double saldo){
	  if(saldo >= 0){
	    this.saldo = saldo;
	  }
	}
	
	public Double getSaldo(){
	  return this.saldo;
	}
	
	public void setActiva(Boolean estado){
	  	if(this.activa == estado){
			throw new CuentaInvalida("L cuenta ya se encuentra en el estado ingresado");
		}else{
		   this.activa = estado;
		}
	}
	
	public Boolean getActiva(){
	  return this.activa;
	}
	
	
	public String toString(){
		
		return "CBU: " + this.cbu
				+ "\nSaldo: " + this.saldo
				+ "\nEstado: \n" + this.activa;
	}
	
	public Boolean equals(Cuenta o){
		return (this.cbu == o.cbu);
	}
	
}
