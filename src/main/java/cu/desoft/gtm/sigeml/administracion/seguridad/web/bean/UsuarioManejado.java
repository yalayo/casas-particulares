package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.event.ActionEvent;

import org.springframework.dao.DataIntegrityViolationException;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;

public class UsuarioManejado extends UsuarioBaseManejado {
	private String idUsuario;
	private String contrasenna;
	private String confirmacion;
	private String preguntaSeguridad;
	private String respuestaSeguridad;
	private boolean habilitada;
	
	private List<Perfil> perfiles;
	
	public UsuarioManejado() {
		super();
		
		this.habilitada = true;
	}
	
	private Set<Perfil> obtenerPerfilesSeleccionados() {
		Set<Perfil> devolver = new HashSet<Perfil>();
		
		for(int i = 0; i < perfiles.size(); i ++) {
			Perfil perfil = perfiles.get(i);
		
			if(perfil.isSeleccionado())
				devolver.add(perfil);
		}
		
		return devolver;
	}
	
	/* Revisar luego que tan bien funciona el metodo "contains" del Set o si hay que redefinir el equals de la clase permiso*/
	private Set<Permiso> obtenerPermisosSeleccionados() {
		Set<Permiso> devolver = new HashSet<Permiso>();
		
		for(int i = 0; i < perfiles.size(); i ++) {
			Perfil perfil = perfiles.get(i);
		
			Set<Permiso> perms = perfil.getPermisos();
			
			for (Iterator<Permiso> it = perms.iterator(); it.hasNext();) {
				Permiso per = (Permiso) it.next();
				
				if(!devolver.contains(per))
					devolver.add(per);
			}
		}
		
		return devolver;
	}
	
	public void incluir(ActionEvent e) {
		try {
			if(contrasenna.equals(confirmacion)) {
				Usuario usuario = new Usuario();
			
				usuario.setUsuario(idUsuario);
				usuario.setPassword(contrasenna);
				usuario.setPreguntaSeguridad(preguntaSeguridad);
				usuario.setRespuestaSeguridad(respuestaSeguridad);
			    usuario.setFechaCreacion(new Date());
				
				/*Nomenclador estado = new Nomenclador();
				estado.setId(10);
				usuario.setEstado(estado);*/
				
				usuario.setPerfiles(obtenerPerfilesSeleccionados());
				usuario.setPermisos(obtenerPermisosSeleccionados());
			
				getUsuarioService().incluirUsuario(usuario);	
				adicionarMensajeInformacion("El usuario fue adicionado al sistema con exito");
				removeBeanSession("listarUsuarioManejado");
				removeBeanSession("usuarioManejado");
				getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarUsuario.jsp");
			
			}
			
			else
				adicionarMensajeError("La confirmacion no coincide. Por favor rectifique los datos.");
		}
		
		catch(DataIntegrityViolationException ex) {
			adicionarMensajeError("Ya existe el usuario. Por favor rectifique los datos.");
		}
		
		catch(Exception ex) {	
			adicionarMensajeError(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public void cancelar(ActionEvent e){
		retornarUrlAnterior();
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
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

	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}

	public List<Perfil> getPerfiles() {
		if(perfiles == null)
			perfiles = getPerfilService().listarPerfiles();
		
		return perfiles;
	}
}
