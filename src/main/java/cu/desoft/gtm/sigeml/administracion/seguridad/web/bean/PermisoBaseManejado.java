package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import cu.desoft.gtm.sigeml.administracion.seguridad.service.PermisoService;
import cu.desoft.gtm.sigeml.core.jsf.bean.BaseBean;

public class PermisoBaseManejado extends BaseBean {
	private PermisoService permisoService;
	
	public PermisoBaseManejado() {
		super();
	}

	public PermisoService getPermisoService() {
		if(permisoService == null)
			permisoService = (PermisoService)getBeanValue("permisoService");
		
		return permisoService;
	}
}
