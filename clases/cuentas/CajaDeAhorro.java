package clases.cuentas;

public class CajaDeAhorro extends Cuenta {
  
  private final Set<PersonasFisicas> clientes = new HashSet<PersonasFisicas>;
  private String nominacion;
  public final Double costoMantenimiento;
  private Double tasaDeInteres;
  
  public CajaDeAhorro(Integer cbu, Double saldo, Set<PersonasFisicas> clientes, String nominacion, 
                      Double costoMantenimiento, Double tasaDeInteres) throws CuentaInvalida {
      super(cbu, saldo);
      
      this.clientes = clientes;
      this.nomicaciones = nominacion;
      
      if(costoMantenimiento >= 0){
        this.costoMantenimiento = costoMantenimiento;
      }else{
        throw new CuentaInvalida("El costo de mantenimiento debe ser mayor o igual a 0";
      }
      
      if(tasaDeInteres >= 0){
        this.tasaDeInteresa = tasaDeInteres;
      }else{
        throw new CuentaInvalida("La tasa de interes debe ser mayor o igual a 0";
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

  public void setNominacion(String nominacion){
    this.nominacion = nominacion; 
  }
  
  public String getNominacion(){
    return this.nominacion; 
  }
  
  public String toString(){
  		return "Nominacion: " + this.nominacion
  				+ "\nTasa de Interes: " + this.tasaDeInteres;
	}
	
	public Boolean equals(CajaDeAhorro o){
		return (this.nominacion == o.nominacion);
	}
  
}
