package cu.desoft.gtm.sigeml.comun.domain;

public class Acceso extends EntidadPersistente {
	private String nivel;
	private String descripcion;
	
	private Nomenclador estado;
	private Nomenclador tipo;
	
	public Acceso(){
		super();
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Nomenclador getEstado() {
		return estado;
	}

	public void setEstado(Nomenclador estado) {
		this.estado = estado;
	}

	public Nomenclador getTipo() {
		return tipo;
	}

	public void setTipo(Nomenclador tipo) {
		this.tipo = tipo;
	}

}
