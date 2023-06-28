package cu.desoft.gtm.sigeml.administracion.seguridad.service.impl;

import java.util.List;

import cu.desoft.gtm.sigeml.administracion.seguridad.dao.PerfilDao;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.PerfilService;

public class PerfilServiceImpl implements PerfilService {
	private PerfilDao perfilDao;
	
	public PerfilServiceImpl() {
		
	}

	public PerfilDao getPerfilDao() {
		return perfilDao;
	}

	public void setPerfilDao(PerfilDao perfilDao) {
		this.perfilDao = perfilDao;
	}

	public void actualizarPerfil(Perfil perfil) {
		perfilDao.actualizar(perfil);
	}

	public void eliminarPerfil(Perfil perfil) throws Exception {
		perfilDao.eliminar(perfil);
	}

	public void incluirPerfil(Perfil perfil) {
		perfilDao.salvar(perfil);
	}

	public List<Perfil> listarPerfiles() {
		return (List<Perfil>)perfilDao.obtenerTodos(Perfil.class);
	}
}
