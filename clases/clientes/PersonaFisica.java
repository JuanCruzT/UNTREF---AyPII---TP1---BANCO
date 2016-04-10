package clases.clientes;

import clases.cuentas.Cuenta;


public class PersonaFisica extends Cliente {

	private Documento tipoDeDocumento;
	private Long numeroDeDocumento;
	private EstadoCivil estadoCivil;
	private String profesion;
	private String conyuge;

	public PersonaFisica(String nombre, Long cuit, Domicilio domicilio,
			Long telefono, Documento tipoDeDocumento,
			Long numeroDeDocumento, EstadoCivil estadoCivil, String profesion,
			String conyuge) {

		super(nombre, cuit, domicilio, telefono);

		this.setTipoDeDocumento(tipoDeDocumento);
		this.setNumeroDeDocumento(numeroDeDocumento);
		this.setEstadoCivil(estadoCivil);
		this.setProfesion(profesion);
		this.setConyuge(conyuge);

	}

	public Documento getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public void setTipoDeDocumento(Documento tipoDeDocumento2) {
		this.tipoDeDocumento = tipoDeDocumento2;
	}

	public Long getNumeroDeDocumento() {
		return numeroDeDocumento;
	}

	public void setNumeroDeDocumento(Long numeroDeDocumento) {
		this.numeroDeDocumento = numeroDeDocumento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getConyuge() {
		return conyuge;
	}

	public void setConyuge(String conyuge) {
		this.conyuge = conyuge;
	}

	@Override
	public boolean agregarCuenta(Cuenta cuenta) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}
}
