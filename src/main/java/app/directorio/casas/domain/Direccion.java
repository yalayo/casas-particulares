package app.directorio.casas.domain;

import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Direccion extends EntidadPersistente {
	private String calle;
	private String edificio;
	private String apartamento;
	private String entreCalles;
	private String barrio;
	private String reparto;
	private String ciudad;
	private String municipio;
	private String provincia;
	
	public Direccion() {
		
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getEntreCalles() {
		return entreCalles;
	}

	public void setEntreCalles(String entreCalles) {
		this.entreCalles = entreCalles;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		String direccion = "";
		
		direccion = direccion + calle;
		
		if(edificio != null)
			direccion = direccion + " Edificio " + edificio;
		
		if(apartamento != null)
			direccion = direccion + " Apartamento " + apartamento;
		
		direccion = direccion + ". " + ciudad;
		
		return direccion;
	}
}
