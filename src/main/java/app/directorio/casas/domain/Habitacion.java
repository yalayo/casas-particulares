package app.directorio.casas.domain;

import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Habitacion extends EntidadPersistente {
	private String codigo;
	
	public Habitacion() {
		
	}
	
	public Habitacion(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
