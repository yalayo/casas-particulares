package cu.desoft.gtm.sigeml.comun.domain;

import java.util.List;

public class Modulo {
	private String nombre;
	private List<SubModulo> subModulos;
	
	public Modulo() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SubModulo> getSubModulos() {
		return subModulos;
	}

	public void setSubModulos(List<SubModulo> subModulos) {
		this.subModulos = subModulos;
	}
}
