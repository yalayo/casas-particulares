package app.registro.reservaciones.domain;

import java.util.Date;

import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Factura extends EntidadPersistente {
	private String numero;
	private Date fecha;
	private Float montoEuro;
	private Float montoUsd;
	private Float montoCuc;
	
	public Factura() {
		
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getMontoEuro() {
		return montoEuro;
	}

	public void setMontoEuro(Float montoEuro) {
		this.montoEuro = montoEuro;
	}

	public Float getMontoUsd() {
		return montoUsd;
	}

	public void setMontoUsd(Float montoUsd) {
		this.montoUsd = montoUsd;
	}

	public Float getMontoCuc() {
		return montoCuc;
	}

	public void setMontoCuc(Float montoCuc) {
		this.montoCuc = montoCuc;
	}
	
	@Override
	public String toString() {				
		return numero;
	}
}
