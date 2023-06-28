package cu.desoft.gtm.sigeml.administracion.seguridad.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cu.desoft.gtm.sigeml.comun.domain.Acceso;
import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;
import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;

public class Usuario extends EntidadPersistente {
	private String usuario;
	private String password;
	private String lastPassword;
	private String preguntaSeguridad;
	private String respuestaSeguridad;
	private Date   fechaCreacion;
	private Date   ultimaLoginDate;
	private Date   lastPasswordChagedate;
	private Date   ultimaBlokFecha;
	private Integer intentosFallosAutenticacion; 
	private Integer intentosFallosRespuesta;
	private Nomenclador estado;
	
	private Set<Acceso> accesos;
	
	private Set<Perfil> perfiles; // TODO Mapear
	private Set<Permiso> permisos;
	
	public Usuario() {
		
	}
	
	public List<Permiso> obtenerPermisos() {
		List<Permiso> lista = new ArrayList<Permiso>();
		
		for(Perfil p:perfiles) {
			lista.addAll(p.getPermisos());
		}
		
		return lista;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastPassword() {
		return lastPassword;
	}

	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}

	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}

	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

	public String getRespuestaSeguridad() {
		return respuestaSeguridad;
	}

	public void setRespuestaSeguridad(String respuestaSeguridad) {
		this.respuestaSeguridad = respuestaSeguridad;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getUltimaLoginDate() {
		return ultimaLoginDate;
	}

	public void setUltimaLoginDate(Date ultimaLoginDate) {
		this.ultimaLoginDate = ultimaLoginDate;
	}

	public Date getLastPasswordChagedate() {
		return lastPasswordChagedate;
	}

	public void setLastPasswordChagedate(Date lastPasswordChagedate) {
		this.lastPasswordChagedate = lastPasswordChagedate;
	}

	public Date getUltimaBlokFecha() {
		return ultimaBlokFecha;
	}

	public void setUltimaBlokFecha(Date ultimaBlokFecha) {
		this.ultimaBlokFecha = ultimaBlokFecha;
	}

	public Integer getIntentosFallosAutenticacion() {
		return intentosFallosAutenticacion;
	}

	public void setIntentosFallosAutenticacion(Integer intentosFallosAutenticacion) {
		this.intentosFallosAutenticacion = intentosFallosAutenticacion;
	}

	public Integer getIntentosFallosRespuesta() {
		return intentosFallosRespuesta;
	}

	public void setIntentosFallosRespuesta(Integer intentosFallosRespuesta) {
		this.intentosFallosRespuesta = intentosFallosRespuesta;
	}

	public Set<Acceso> getAccesos() {
		return accesos;
	}

	public void setAccesos(Set<Acceso> accesos) {
		this.accesos = accesos;
	}

	public Set<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	public Nomenclador getEstado() {
		return estado;
	}

	public void setEstado(Nomenclador estado) {
		this.estado = estado;
	}
}
