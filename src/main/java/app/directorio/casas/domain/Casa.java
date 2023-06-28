package app.directorio.casas.domain;

import java.util.List;
import app.directorio.datos.domain.Dato;
import app.directorio.personas.domain.Persona;
import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Casa extends EntidadPersistente {
	private String nombre;
	
	private Direccion direccion;
	private Persona duenho;
	private Persona administrador;
	private Persona beneficiado;
	private Persona cobrador;
	
	private List<Dato> datos;
	
	public Casa() {
		super();
	}
	
	public Casa(Integer id) {
		super(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Persona getDuenho() {
		return duenho;
	}

	public void setDuenho(Persona duenho) {
		this.duenho = duenho;
	}

	public Persona getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Persona administrador) {
		this.administrador = administrador;
	}

	public Persona getBeneficiado() {
		return beneficiado;
	}

	public void setBeneficiado(Persona beneficiado) {
		this.beneficiado = beneficiado;
	}

	public Persona getCobrador() {
		return cobrador;
	}

	public void setCobrador(Persona cobrador) {
		this.cobrador = cobrador;
	}

	public void setDatos(List<Dato> datos) {
		this.datos = datos;
	}

	public List<Dato> getDatos() {
		return datos;
	}
}
