package cu.desoft.gtm.sigeml.administracion.seguridad.domain;

import java.util.Set;

import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Perfil extends EntidadPersistente {
	private String nombre;	
	
	private Set<Permiso> permisos;
	
	private boolean seleccionado;
	
	public Perfil() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	// Esto es para la tabla del adicionar perfil. Arreglar luego.
	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
}
