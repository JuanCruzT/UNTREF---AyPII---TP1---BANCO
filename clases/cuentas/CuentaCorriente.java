package clases.cuentas;
import java.util.HashSet;
import java.util.Set;

import excepciones.CuentaInvalida;

public class CuentaCorriente extends Cuenta {
  
  private final Set<Cliente> clientes = new HashSet<Cliente>;
  private Double sobregiro;
  public final Double comision;

  public CuentaCorriente(Integer cbu, Double saldo, Set<Cliente> clientes, Double sobregiro, 
                      Double comision) throws CuentaInvalida {
      super(cbu, saldo);
      
      this.clientes = clientes;
     
      if(sobergiro >= 0){
        this.sobregiro = sobegiro;
      }else{
        throw new CuentaInvalida("El sobregiro debe ser mayor o igual a 0";
      }
      
      if(comision >= 0){
        this.comision = comision;
      }else{
        throw new CuentaInvalida("La comision debe ser mayor o igual a 0";
      }
  }
  
  @Override
	public boolean acreditar(Double monto) throws CuentaInvalida {
		  try{
		    setSaldo(monto);
		  }catch{
		    throw new CuentaInvalida("El saldo no pudo ser actualizado");
		  }
	
	  return true;
	}
	
	@Override
	public boolean debitar(Double monto) throws CuentaInvalida {
		  try{
		    setSaldo(getSaldo - monto);
		  }catch{
		    throw new CuentaInvalida("El saldo no pudo ser actualizado");
		  }
	
	  return true;
	}

  public void setSobregiro(Double sobregiro){
     if(sobergiro >= 0){
        this.sobregiro = sobegiro;
      }else{
        throw new CuentaInvalida("El sobregiro debe ser mayor o igual a 0";
      }
  }
  
  public Double getSobregiro(){
    return this.sobregiro; 
  }
  
  

}
