package app.registro.productos.domain;

import java.util.Date;

import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Producto extends EntidadPersistente {
	private String nombre;
	private String codigo;
	private Integer cantidadDias;
	private Date fechaInicio;
	private Date fechaFin;
	
	public Producto() {
		//fechaInicio = new Date();
		//fechaFin = new Date();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(Integer cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
}
