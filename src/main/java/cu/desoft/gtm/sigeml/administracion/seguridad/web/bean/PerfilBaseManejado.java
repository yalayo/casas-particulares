package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import cu.desoft.gtm.sigeml.administracion.seguridad.service.PerfilService;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.PermisoService;
import cu.desoft.gtm.sigeml.core.jsf.bean.BaseBean;

public class PerfilBaseManejado extends BaseBean {
	private PerfilService perfilService;
	private PermisoService permisoService;
	
	public PerfilBaseManejado() {
		super();
	}

	public PerfilService getPerfilService() {
		if(perfilService == null)
			perfilService = (PerfilService)getBeanValue("perfilService");
		
		return perfilService;
	}
	
	public PermisoService getPermisoService() {
		if(permisoService == null)
			permisoService = (PermisoService)getBeanValue("permisoService");
		
		return permisoService;
	}
}
