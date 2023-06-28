package cu.desoft.gtm.sigeml.administracion.seguridad.service.impl;

import java.util.List;

import org.acegisecurity.Authentication;

import app.comun.service.impl.ApplicationServiceImpl;
import app.directorio.comun.util.ApplicationUtil;

import cu.desoft.gtm.sigeml.administracion.seguridad.dao.UsuarioDao;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.UsuarioService;

public class UsuarioServiceImpl extends ApplicationServiceImpl implements UsuarioService {
	private UsuarioDao usuarioDao;
	
	public UsuarioServiceImpl() {
		
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public void incluirUsuario(Usuario usuario) {
		usuarioDao.salvar(usuario);
	}
	
	public void actualizarUsuario(Usuario usuario) {
		usuarioDao.actualizar(usuario);
	}
	
	public void eliminarUsuario(Usuario usuario) throws Exception {
		usuarioDao.eliminar(usuario);
	}

	public List<Usuario> listarUsuarios() {
		return (List<Usuario>)usuarioDao.obtenerTodos(Usuario.class);
	}
	
	public String obtenerUsuarioAutenticado() {		
		
		try {
			Authentication autenticacion = ApplicationUtil.getAuthentication();
			return autenticacion.getName();			
		} 
		
		catch (Exception e) {
			e.printStackTrace();			
		}
		
		return null;
	}
	
	public List<Permiso> obtenerPermisosUsuarioAutenticado() {
		return ApplicationUtil.obtenerPermisosUsuario();
	}
}
