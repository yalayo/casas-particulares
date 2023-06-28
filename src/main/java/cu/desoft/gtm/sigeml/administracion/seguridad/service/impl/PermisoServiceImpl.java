package cu.desoft.gtm.sigeml.administracion.seguridad.service.impl;

import java.util.List;

import cu.desoft.gtm.sigeml.administracion.seguridad.dao.PermisoDao;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.PermisoService;

public class PermisoServiceImpl implements PermisoService {
	private PermisoDao permisoDao;
	
	public PermisoServiceImpl() {
		
	}

	public PermisoDao getPermisoDao() {
		return permisoDao;
	}

	public void setPermisoDao(PermisoDao permisoDao) {
		this.permisoDao = permisoDao;
	}

	public void actualizarPermiso(Permiso permiso) {
		permisoDao.actualizar(permiso);
	}

	public void eliminarPermiso(Permiso permiso) throws Exception {
		permisoDao.eliminar(permiso);
	}

	public void incluirPermiso(Permiso permiso) {
		permisoDao.salvar(permiso);
	}

	public List<Permiso> listarPermisos() {
		return (List<Permiso>)permisoDao.obtenerTodos(Permiso.class);
	}

}
