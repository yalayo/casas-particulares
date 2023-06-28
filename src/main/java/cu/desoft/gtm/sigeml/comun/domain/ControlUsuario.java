package cu.desoft.gtm.sigeml.comun.domain;

import java.util.Date;

public class ControlUsuario extends EntidadPersistente {
	private Date fechaAccion;
	private String lugarAccion;
	private String observacion;
	
	private Nomenclador accion;
	private Nomenclador tipoAccion;
	//private Usuario usuario;
	
	public ControlUsuario() {
		super();	
	}

	public Date getFechaAccion() {
		return fechaAccion;
	}

	public void setFechaAccion(Date fechaAccion) {
		this.fechaAccion = fechaAccion;
	}

	public String getLugarAccion() {
		return lugarAccion;
	}

	public void setLugarAccion(String lugarAccion) {
		this.lugarAccion = lugarAccion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Nomenclador getAccion() {
		return accion;
	}

	public void setAccion(Nomenclador accion) {
		this.accion = accion;
	}

	public Nomenclador getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(Nomenclador tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	/*public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/
}
