package cu.desoft.gtm.sigeml.administracion.seguridad.domain;

import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Permiso extends EntidadPersistente {
	private String nombre;
	private String descripcion;
	
	private boolean seleccionado;
	
	public Permiso() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// Esto es para la tabla del adicionar perfil. Arreglar luego.
	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}	
}
