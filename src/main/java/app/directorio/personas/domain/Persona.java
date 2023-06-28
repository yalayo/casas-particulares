package app.directorio.personas.domain;

import app.directorio.casas.domain.Direccion;
import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Persona extends EntidadPersistente {
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String carnetIdentidad;
	private String sexo;
	private String telefono;
	private String celular;
	private String correos;
	
	private Direccion direccion;
	
	public Persona() {
		
	}
	
	public String getNombreCompleto() {
		return nombre + " " + primerApellido + " " + segundoApellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCarnetIdentidad() {
		return carnetIdentidad;
	}

	public void setCarnetIdentidad(String carnetIdentidad) {
		this.carnetIdentidad = carnetIdentidad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreos() {
		return correos;
	}

	public void setCorreos(String correos) {
		this.correos = correos;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return nombre + " " + primerApellido + " " + segundoApellido;
	}
}
