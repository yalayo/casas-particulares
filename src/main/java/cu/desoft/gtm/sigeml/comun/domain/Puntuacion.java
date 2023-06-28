package cu.desoft.gtm.sigeml.comun.domain;

public class Puntuacion extends EntidadPersistente {
	private Integer puntos;
	private Nomenclador tipoPuntuacion;
	
	public Puntuacion() {
		
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Nomenclador getTipoPuntuacion() {
		return tipoPuntuacion;
	}

	public void setTipoPuntuacion(Nomenclador tipoPuntuacion) {
		this.tipoPuntuacion = tipoPuntuacion;
	}
}
