package cu.desoft.gtm.sigeml.comun.domain;

import java.util.List;

public class SubModulo {
	private String nombre;
	private List<Funcionalidad> funcionalidades;
	
	public SubModulo() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Funcionalidad> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidad> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
}
